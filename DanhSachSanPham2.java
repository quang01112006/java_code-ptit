import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachSanPham2 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int soSanPham = Integer.parseInt(sc.nextLine());
        ArrayList<SanPham> list = new ArrayList<>();
        while (soSanPham-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int gia = Integer.parseInt(sc.nextLine());
            int baoHanh = Integer.parseInt(sc.nextLine());
            list.add(new SanPham(ma, ten, gia, baoHanh));
        }
        Collections.sort(list, (a, b) -> {
            if (a.getGia() != b.getGia()) {
                return Integer.compare(b.getGia(), a.getGia());
            }
            return a.getMa().compareTo(b.getMa());
        });
        for (SanPham sp : list) {
            System.out.println(sp);
        }
        sc.close();
    }
}

class SanPham {
    private String ma, ten;
    private int gia, baoHanh;

    public SanPham(String ma, String ten, int gia, int baoHanh) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.baoHanh = baoHanh;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gia + " " + baoHanh;
    }

    public int getGia() {
        return gia;
    }

    public String getMa() {
        return ma;
    }

}
