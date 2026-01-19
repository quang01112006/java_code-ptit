import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TinhDiemTrungBinh {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        ArrayList<SinhVien> list = new ArrayList<>();
        int soSV = Integer.parseInt(sc.nextLine());
        while (soSV-- > 0) {
            String ten = sc.nextLine();
            double mon1 = Double.parseDouble(sc.nextLine());
            double mon2 = Double.parseDouble(sc.nextLine());
            double mon3 = Double.parseDouble(sc.nextLine());
            list.add(new SinhVien(ten, mon1, mon2, mon3));
        }
        Collections.sort(list, (a, b) -> {
            if (a.getDiem() != b.getDiem()) {
                return Double.compare(b.getDiem(), a.getDiem());
            }
            return a.getMa().compareTo(b.getMa());
        });
        int rank = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                if (list.get(i).getDiem() < list.get(i - 1).getDiem()) {
                    rank = i + 1;
                }
            }
            list.get(i).setRank(rank);
        }
        for (SinhVien sv : list) {
            System.out.println(sv);
        }
    }
}

class SinhVien {
    private String ma, ten;
    private static int COUNT = 0;
    private double mon1, mon2, mon3, diemTB;
    private int rank;

    public SinhVien(String ten, double mon1, double mon2, double mon3) {
        this.ma = String.format("SV%02d", ++COUNT);
        this.ten = chuanHoaTen(ten);
        this.mon1 = mon1;
        this.mon2 = mon2;
        this.mon3 = mon3;
        this.diemTB = Math.round((mon1 * 3 + mon2 * 3 + mon3 * 2) / 8.0 * 100.0) / 100.0;
    }

    private String chuanHoaTen(String ten) {
        String[] parts = ten.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : parts) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getMa() {
        return ma;
    }

    public double getDiem() {
        return diemTB;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.2f",diemTB) + " " + rank;
    }

}