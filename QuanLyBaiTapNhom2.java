import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyBaiTapNhom2 {
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
        for (SinhVien sv : list) {
            sv.setTenBT(dsBaiTap[sv.getNhom() - 1]);
        }
        Collections.sort(list, (a, b) -> a.getMa().compareTo(b.getMa()));
        for (SinhVien sv : list) {
            System.out.println(sv);
        }
    }

}

class SinhVien {
    private String ten, ma, sdt, tenBT;
    private int nhom;

    public SinhVien(String ma, String ten, String sdt, int nhom) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.nhom = nhom;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + sdt + " " + nhom + " " + tenBT;
    }

    public void setTenBT(String tenBT) {
        this.tenBT = tenBT;
    }

    public int getNhom() {
        return nhom;
    }
}
