import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TinhGioChuanChoTungGiangVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> mapMon = new HashMap<>();
        int soMon = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < soMon; i++) {

            String[] parts = sc.nextLine().trim().split(" ", 2);
            mapMon.put(parts[0], parts[1]);
        }

        HashMap<String, String> mapGV = new HashMap<>();
        int soGV = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < soGV; i++) {

            String[] parts = sc.nextLine().trim().split(" ", 2);
            mapGV.put(parts[0], parts[1]);
        }
        ArrayList<LopHocPhan> dsLop = new ArrayList<>();
        int soLop = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < soLop; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String maGV = parts[0];
            String maMon = parts[1];
            double gio = Double.parseDouble(parts[2]);
            dsLop.add(new LopHocPhan(maGV, maMon, gio));
        }

        String targetMaGV = sc.nextLine().trim();

        System.out.println("Giang vien: " + mapGV.get(targetMaGV));

        double tongGio = 0;
        for (LopHocPhan lop : dsLop) {
            if (lop.getMaGV().equals(targetMaGV)) {
                String tenMon = mapMon.get(lop.getMaMon());
                System.out.println(tenMon + " " + lop.getGioChuan());
                tongGio += lop.getGioChuan();
            }
        }

        System.out.printf("Tong: %.2f", tongGio);
    }
}

class LopHocPhan {
    private String maGV;
    private String maMon;
    private double gioChuan;

    public LopHocPhan(String maGV, String maMon, double gioChuan) {
        this.maGV = maGV;
        this.maMon = maMon;
        this.gioChuan = gioChuan;
    }

    public String getMaGV() {
        return maGV;
    }

    public String getMaMon() {
        return maMon;
    }

    public double getGioChuan() {
        return gioChuan;
    }
}
