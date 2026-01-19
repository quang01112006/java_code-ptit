import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class SapXepMatHang {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        int soMatHang = Integer.parseInt(sc.nextLine());
        ArrayList<MatHang> list = new ArrayList<>();
        while (soMatHang-- > 0) {
            String ten = sc.nextLine();
            String nhom = sc.nextLine();
            double giaMua = Double.parseDouble(sc.nextLine());
            double giaBan = Double.parseDouble(sc.nextLine());
            list.add(new MatHang(ten, nhom, giaMua, giaBan));
        }
        Collections.sort(list, (a, b) -> Double.compare(b.getLoiNhuan(), a.getLoiNhuan()));
        sc.close();
        for (MatHang mh : list) {
            System.out.println(mh);
        }
    }
}

class MatHang {
    private static int COUNT = 0;

    private String ten, nhom, ma;
    private double giaMua, giaBan, loiNhuan;

    public MatHang(String ten, String nhom, double giaMua, double giaBan) {
        this.ten = ten;
        this.nhom = nhom;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        COUNT++;
        this.ma = String.format("MH%02d", COUNT);
        this.loiNhuan = getLoiNhuan();
    }

    public double getLoiNhuan() {
        return giaBan - giaMua;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + nhom + " " + String.format("%.2f", loiNhuan);
    }
}