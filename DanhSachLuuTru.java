import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.text.SimpleDateFormat;

public class DanhSachLuuTru {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACH.in"));
        int soKhach = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> list = new ArrayList<>();
        for (int i = 0; i < soKhach; i++) {
            String ten = sc.nextLine();
            String maPhong = sc.nextLine();
            String ngayDen = sc.nextLine();
            String ngayDi = sc.nextLine();
            list.add(new KhachHang(ten, maPhong, ngayDen, ngayDi));
        }
        Collections.sort(list, (a, b) -> Long.compare(b.getNgay(), a.getNgay()));
        for (KhachHang kh : list) {
            System.out.println(kh);
        }
        sc.close();
    }

}

class KhachHang {
    private String ma, ten, maPhong;
    private static int id = 0;
    private long ngay;

    public KhachHang(String ten, String maPhong, String ngayDen, String ngayDi) throws Exception {
        id++;
        this.ten = ten;
        this.maPhong = maPhong;
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        long d1 = f.parse(ngayDen).getTime();
        long d2 = f.parse(ngayDi).getTime();
        this.ngay = (d2 - d1) / (24 * 60 * 60 * 1000);
        this.ma = String.format("KH%02d", id);

    }

    public long getNgay() {
        return ngay;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + maPhong + " " + ngay;
    }

}
