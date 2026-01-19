import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BangTinhGioChuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soMon = Integer.parseInt(sc.nextLine());
        while (soMon-- > 0) {
            sc.nextLine();
        }
        ArrayList<GiangVien> list = new ArrayList<>();
        HashMap<String, GiangVien> map = new HashMap<>();
        int soGV = Integer.parseInt(sc.nextLine());
        while (soGV-- > 0) {
            String[] parts = sc.nextLine().split("\\s+", 2);
            String ma = parts[0];
            String ten = parts[1];
            GiangVien gv = new GiangVien(ma, ten);
            map.put(gv.getMa(), gv);
            list.add(gv);
        }
        int soLop = Integer.parseInt(sc.nextLine());
        while (soLop-- > 0) {
            String[] line = sc.nextLine().split("\\s+");
            GiangVien gv = map.get(line[0]);
            gv.addGio(Double.parseDouble(line[2]));
        }
        for (GiangVien gv : list) {
            System.out.println(gv);
        }

    }
}

class GiangVien {
    private String ma, ten;
    private double tongGio;

    public GiangVien(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        this.tongGio = 0;
    }

    public void addGio(double gio) {
        this.tongGio += gio;
    }

    @Override
    public String toString() {
        return ten + " " + String.format("%.2f", tongGio);
    }

    public String getMa() {
        return ma;
    }
}