import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.io.File;

public class DanhSachMonHoc {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        ArrayList<MonHoc> list = new ArrayList<>();
        int soMon = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < soMon; i++) {
            String ma = sc.nextLine();
            String mon = sc.nextLine();
            int soTinChi = Integer.parseInt(sc.nextLine());
            list.add(new MonHoc(ma, mon, soTinChi));

        }
        Collections.sort(list, (a, b) -> a.getTen().compareTo(b.getTen()));
        for (MonHoc mh : list) {
            System.out.println(mh);
        }

    }

}

class MonHoc {
    private String ma, ten;
    private int soTinChi;

    public MonHoc(String ma, String ten, int soTinChi) {
        this.ma = ma;
        this.ten = ten;
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + soTinChi;
    }

    public String getTen() {
        return ten;
    }

}