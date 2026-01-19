import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachTrungTuyen {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("THISINH.in"));
        ArrayList<ThiSinh> list = new ArrayList<>();
        int soThiSinh = Integer.parseInt(sc.nextLine());
        while (soThiSinh-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            double toan = Double.parseDouble(sc.nextLine());
            double ly = Double.parseDouble(sc.nextLine());
            double hoa = Double.parseDouble(sc.nextLine());
            list.add(new ThiSinh(ma, ten, toan, ly, hoa));

        }
        int chiTieu = Integer.parseInt(sc.nextLine());
        Collections.sort(list, (a, b) -> {
            if (a.getTongDiem() != b.getTongDiem()) {
                return Double.compare(b.getTongDiem(), a.getTongDiem());
            }
            return a.getMa().compareTo(b.getMa());
        });
        double diemChuan = 0;
        if (list.size() <= chiTieu) {
            diemChuan = list.get(list.size() - 1).getTongDiem();
        } else {
            diemChuan = list.get(chiTieu - 1).getTongDiem();
        }
        System.out.println(String.format("%.1f", diemChuan));
        for (ThiSinh ts : list) {
            if (ts.getTongDiem() < diemChuan) {
                System.out.println(ts + "TRUOT");
            } else {
                System.out.println(ts + "TRUNG TUYEN");
            }
        }

    }
}

class ThiSinh {
    private String ma, ten;
    private double toan, ly, hoa, tongDiem, uuTien;

    public ThiSinh(String ma, String ten, double toan, double ly, double hoa) {
        this.ma = ma;
        this.ten = chuanHoaTen(ten);
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.uuTien = tinhUuTien();
        this.tongDiem = 2 * toan + ly + hoa + uuTien;
    }

    private String chuanHoaTen(String ten) {
        String[] parts = ten.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            if (!p.isEmpty()) {
                sb.append(Character.toUpperCase(p.charAt(0))).append(p.substring(1)).append(" ");
            }
        }
        return sb.toString().trim();
    }

    private double tinhUuTien() {
        String ut = ma.substring(0, 3);
        if (ut.equals("KV1"))
            return uuTien = 0.5;
        else if (ut.equals("KV2"))
            return uuTien = 1.0;
        else if (ut.equals("KV3"))
            return uuTien = 2.5;
        return 0;
    }

    public double getTongDiem() {
        return tongDiem;
    }

    public String getMa() {
        return ma;
    }

    private String formatDiem(double d) {
        if (d == (int) d) {
            return String.format("%d", (int) d);
        }
        return String.format("%.1f", d);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + formatDiem(tinhUuTien()) + " " + formatDiem(tongDiem) + " ";
    }
}