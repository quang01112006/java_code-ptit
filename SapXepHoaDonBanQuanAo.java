import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class SapXepHoaDonBanQuanAo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, SanPham> mapSP = new HashMap<>();
        while (n-- > 0) {
            String ma = sc.nextLine().trim();
            String ten = sc.nextLine().trim();
            long g1 = Long.parseLong(sc.nextLine().trim());
            long g2 = Long.parseLong(sc.nextLine().trim());
            mapSP.put(ma, new SanPham(ma, ten, g1, g2));
        }
        int m = Integer.parseInt(sc.nextLine().trim());
        ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
        while (m-- > 0) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String ma = parts[0];
            long soLuong = Long.parseLong(parts[1]);
            String maLoai = ma.substring(0, 2);
            SanPham spFound = mapSP.get(maLoai);
            dsHoaDon.add(new HoaDon(ma, soLuong, spFound));

        }
       Collections.sort(dsHoaDon,(a,b)->Long.compare(b.getTongTien(), a.getTongTien()));
        for (HoaDon hd : dsHoaDon) {
            System.out.println(hd);
        }
        sc.close();
    }
}

    class SanPham {
        private String ma, ten;
        private long donGia1, donGia2;

        public SanPham(String ma, String ten, long donGia1, long donGia2) {
            this.ma = ma;
            this.ten = ten;
            this.donGia1 = donGia1;
            this.donGia2 = donGia2;
        }

        public String getMa() {
            return ma;
        }

        public long getGia1() {
            return donGia1;
        }

        public long getGia2() {
            return donGia2;
        }

        public String getTen() {
            return ten;
        }

    }

class HoaDon {
    private String ma;
    private SanPham sp;
    private static int cnt = 0;
    private long thanhTien, soLuong, giamGia;

    public HoaDon(String ma, long soLuong, SanPham sp) {
        this.sp = sp;
        this.soLuong = soLuong;
        this.ma = String.format("%s-%03d", ma, ++cnt);
        char loai = ma.charAt(2);
        long donGia = (loai == '1') ? sp.getGia1() : sp.getGia2();
        long truocGiamGia = donGia * soLuong;
        this.giamGia = tinhGiamGia(truocGiamGia);
        this.thanhTien = truocGiamGia - this.giamGia;

    }

    private long tinhGiamGia(long tong) {
        if (soLuong >= 150)
            return (long) (tong * 0.5);
        if (soLuong >= 100)
            return (long) (tong * 0.3);
        if (soLuong >= 50)
            return (long) (tong * 0.15);
        return 0;
    }

    @Override
    public String toString() {
        return ma + " " + sp.getTen() + " " + giamGia + " " + thanhTien;
    }

    public long getTongTien() {
        return thanhTien;
    }
}