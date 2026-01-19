import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyBaiTapNhom1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> list = new ArrayList<>();
        int soSV = sc.nextInt();
        int soNhom = sc.nextInt();
        sc.nextLine();
        while (soSV-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String sdt = sc.nextLine();
            int nhom = Integer.parseInt(sc.nextLine());
            list.add(new SinhVien(ma, ten, sdt, nhom));
        }
        String[] dsBaiTap = new String[soNhom];
        for (int i = 0; i < soNhom; i++) {
            dsBaiTap[i] = sc.nextLine().trim();
        }
        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            int nhomQuery = Integer.parseInt(sc.nextLine());
            System.out.println("DANH SACH NHOM " + nhomQuery + ":");
            for (SinhVien sv : list) {
                if (sv.getNhom() == nhomQuery) {
                    System.out.println(sv);
                }
            }
            System.out.println("Bai tap dang ky: " + dsBaiTap[nhomQuery - 1]);
        }

    }
}

class SinhVien {
    private String ten, ma, sdt;
    private int nhom;

    public SinhVien(String ma, String ten, String sdt, int nhom) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.nhom = nhom;
    }

    public int getNhom() {
        return nhom;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + sdt;
    }

}