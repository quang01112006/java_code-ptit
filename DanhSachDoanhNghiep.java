import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachDoanhNghiep {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DN.in"));
        int soDN = Integer.parseInt(sc.nextLine());
        ArrayList<DoanhNghiep> list = new ArrayList<>();
        for (int i = 0; i < soDN; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int soSV = Integer.parseInt(sc.nextLine());
            list.add(new DoanhNghiep(ma, ten, soSV));
        }
        Collections.sort(list, (a, b) -> a.getMa().compareTo(b.getMa()));
        for (DoanhNghiep dn : list) {
            System.out.println(dn);
        }
        sc.close();

    }
}

class DoanhNghiep {
    private String ma, ten;
    private int soSV;

    public DoanhNghiep(String ma, String ten, int soSV) {
        this.ma = ma;
        this.ten = ten;
        this.soSV = soSV;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + soSV;
    }

    public String getMa() {
        return ma;
    }

}
