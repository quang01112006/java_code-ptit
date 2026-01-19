import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DiemTuyenSinh {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("THISINH.in"));
        ArrayList<ThiSinh> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String ten = sc.nextLine();
            double diemThi = Double.parseDouble(sc.nextLine());
            String danToc = sc.nextLine();
            String khuVuc = sc.nextLine();
            list.add(new ThiSinh(ten, diemThi, danToc, khuVuc));

        }
        Collections.sort(list, (a, b) -> {
            if (a.getDiem() != b.getDiem()) {
                return Double.compare(b.getDiem(), a.getDiem());
            }
            return a.getMa().compareTo(b.getMa());
        });
        for (ThiSinh ts : list) {
            System.out.println(ts);
        }
    }
}

class ThiSinh {
    private String ma, ten, danToc, khuVuc, trangThai;
    private static int COUNT = 0;
    private double diemThi, tongDiem, uuTien;

    public ThiSinh(String ten, double diemThi, String danToc, String khuVuc) {
        this.ten = chuanHoaTen(ten);
        this.ma = String.format("TS%02d", ++COUNT);
        this.diemThi = diemThi;
        this.danToc = danToc;
        this.khuVuc = khuVuc;
        this.uuTien = uuTienDanToc() + uuTienKhuVuc();
        this.tongDiem = diemThi + uuTien;
        this.trangThai = tongDiem >= 20.5 ? "Do" : "Truot";
    }

    private String chuanHoaTen(String ten) {
        String[] p = ten.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : p) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
            }

        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.1f", tongDiem) + " " + trangThai;
    }

    private double uuTienKhuVuc() {
        if (khuVuc.equals("1"))
            return 1.5;
        else if (khuVuc.equals("2"))
            return 1;
        else if (khuVuc.equals("3"))
            return 0;
        return 0;
    }

    private double uuTienDanToc() {
        if (danToc.equals("Kinh"))
            return 0;
        return 1.5;
    }

    public String getMa() {
        return ma;
    }

    public double getDiem() {
        return tongDiem;
    }

}