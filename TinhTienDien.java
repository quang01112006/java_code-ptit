import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TinhTienDien {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        ArrayList<KhachHang> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String ten = sc.nextLine();
            String line = sc.nextLine();
            list.add(new KhachHang(ten, line));

        }
        Collections.sort(list, (a, b) -> Long.compare(b.getTongTien(), a.getTongTien()));
        for (KhachHang kh : list) {
            System.out.println(kh);
        }
    }
}

class KhachHang {
    private String ten, loaiHo, ma;
    private static int COUNT = 0;
    private long soDau, soCuoi, soDien, tienVuotDM, tienTrongDM, tongTien, VAT, dinhMuc;

    public KhachHang(String ten, String line) {
        this.ma = String.format("KH%02d", ++COUNT);
        this.ten = chuanHoaTen(ten);
        String[] parts = line.trim().split(" ");
        this.loaiHo = parts[0];
        this.soDau = Long.parseLong(parts[1]);
        this.soCuoi = Long.parseLong(parts[2]);
        this.soDien = soCuoi - soDau;
        this.dinhMuc = tinhDM();
        this.tienTrongDM = tinhTienTrongDM();
        this.tienVuotDM = tinhTienNgoaiDM();

        this.VAT = Math.round(tinhVAT());
        this.tongTien = tienTrongDM + tienVuotDM + VAT;

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

    private int tinhDM() {
        if (loaiHo.equals("A"))
            return 100;
        else if (loaiHo.equals("B"))
            return 500;
        else if (loaiHo.equals("C"))
            return 200;
        return 0;
    }

    private long tinhTienTrongDM() {
        if (soDien < dinhMuc) {
            return soDien * 450;
        }
        return dinhMuc * 450;
    }

    private long tinhTienNgoaiDM() {
        if (soDien > dinhMuc)
            return (soDien - dinhMuc) * 1000;
        return 0;
    }

    private double tinhVAT() {
        return 0.05 * tienVuotDM;
    }

    public Long getTongTien() {
        return tongTien;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + tienTrongDM + " " + tienVuotDM + " " + VAT+ " " + tongTien;
    }

}