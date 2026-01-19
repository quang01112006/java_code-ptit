import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while (n-- > 0) {
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for (LoaiPhong tmp : ds) {
            System.out.println(tmp);
        }
    }
}

class LoaiPhong implements Comparable<LoaiPhong> {
    private String kyHieu, ten;
    private int donGia;
    private double phiPhucVu;

    public LoaiPhong(String line) {
        String[] s = line.split(" ");
        this.kyHieu = s[0];
        this.ten = s[1];
        this.donGia = Integer.parseInt(s[2]);
        this.phiPhucVu = Double.parseDouble(s[3]);

    }

    @Override
    public int compareTo(LoaiPhong other) {
        return this.ten.compareTo(other.ten);
    }

    @Override
    public String toString() {
        return kyHieu + " " + ten + " " + donGia + " " + phiPhucVu;
    }

}