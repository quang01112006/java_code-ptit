import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class XepLoai {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int soSV = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> list = new ArrayList<>();
        while (soSV-- > 0) {
            String ten = sc.nextLine();
            double luyentap = Double.parseDouble(sc.nextLine());
            double thuchanh = Double.parseDouble(sc.nextLine());
            double thi = Double.parseDouble(sc.nextLine());
            list.add(new SinhVien(ten, luyentap, thuchanh, thi));
        }
        Collections.sort(list, (a, b) -> Double.compare(b.getDiemTongKet(), a.getDiemTongKet()));
        for (SinhVien sv : list) {
            System.out.println(sv);
        }
        sc.close();
    }
}

class SinhVien {
    private String ma, ten, xepLoai;
    private double luyentap, thuchanh, thi, tongket;
    private static int COUNT = 0;

    public SinhVien(String ten, double luyentap, double thuchanh, double thi) {
        this.ma = String.format("SV%02d", ++COUNT);
        this.ten = chuanHoaTen(ten);
        this.luyentap = luyentap;
        this.thuchanh = thuchanh;
        this.thi = thi;
        this.tongket = (0.25 * luyentap + 0.35 * thuchanh + 0.4 * thi);
        this.xepLoai = tinhXepLoai();
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

    private String tinhXepLoai() {
        if (tongket >= 8)
            return "GIOI";
        else if (tongket >= 6.5)
            return "KHA";
        else if (tongket >= 5)
            return "TRUNG BINH";
        else
            return "KEM";

    }

    public double getDiemTongKet() {
        return tongket;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.2f", tongket) + " " + xepLoai;
    }
}