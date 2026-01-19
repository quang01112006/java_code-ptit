
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class QuanLyBanHang2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        HashMap<String, KhachHang> mapKH = new HashMap<>();
        while (N-- > 0) {
            String ten = sc.nextLine();
            String gioiTinh = sc.nextLine();
            String dob = sc.nextLine();
            String diaChi = sc.nextLine();
            KhachHang newKH = new KhachHang(ten, gioiTinh, dob, diaChi);
            mapKH.put(newKH.getMa(), newKH);

        }
        HashMap<String, MatHang> mapMH = new HashMap<>();
        int M = Integer.parseInt(sc.nextLine());
        while (M-- > 0) {
            String ten = sc.nextLine();
            String donVi = sc.nextLine();
            long giaMua = Long.parseLong(sc.nextLine());
            long giaBan = Long.parseLong(sc.nextLine());
            MatHang mh = new MatHang(ten, donVi, giaMua, giaBan);
            mapMH.put(mh.getMa(), mh);
        }
        int K = Integer.parseInt(sc.nextLine());
        ArrayList<HoaDon> list = new ArrayList<>();
        while (K-- > 0) {
            String[] parts = sc.nextLine().split("\\s+");
            String maKH = parts[0];
            String maMH = parts[1];
            long soLuong = Long.parseLong(parts[2]);
            list.add(new HoaDon(mapKH.get(maKH), mapMH.get(maMH), soLuong));

        }
        Collections.sort(list, (a, b) -> Long.compare(b.getLoiNhuan(), a.getLoiNhuan()));
        for (HoaDon hd : list) {
            System.out.println(hd);
        }
    }
}

class KhachHang {
    private static int cnt = 0;
    private String ma, ten, gioiTinh, dob, diaChi;

    public KhachHang(String ten, String gioiTinh, String dob, String diaChi) {
        this.ma = String.format("KH%03d", ++cnt);
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.dob = dob;
        this.diaChi = diaChi;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getMa() {
        return ma;
    }
}

class MatHang {
    private static int cnt = 0;
    private String ma, ten, donViTinh;
    private long giaMua, giaBan;

    public MatHang(String ten, String donViTinh, long giaMua, long giaBan) {
        this.ma = String.format("MH%03d", ++cnt);
        this.ten = ten;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getTen() {
        return ten;
    }

    public String getMa() {
        return ma;
    }

    public String getDonViTinh() {
        return donViTinh;

    }

    public long getMua() {
        return giaMua;
    }

    public long getBan() {
        return giaBan;
    }
}

class HoaDon {
    private static int cnt = 0;
    private String ma;
    private KhachHang kh;
    private MatHang mh;
    private long soLuong, thanhTien, loiNhuan;

    public HoaDon(KhachHang kh, MatHang mh, long soLuong) {
        this.ma = String.format("HD%03d", ++cnt);
        this.kh = kh;

        this.mh = mh;
        this.soLuong = soLuong;
        this.thanhTien = soLuong * mh.getBan();
        this.loiNhuan = thanhTien - (soLuong * mh.getMua());

    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %d %d", ma, kh.getTen(), kh.getDiaChi(), mh.getTen(),
                soLuong, thanhTien, loiNhuan);
    }

    public long getLoiNhuan() {
        return loiNhuan;
    }
}