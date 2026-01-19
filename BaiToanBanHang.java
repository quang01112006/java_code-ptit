import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BaiToanBanHang {
    public static void main(String[] args) throws Exception {
        // Khách hàng
        Scanner scKH = new Scanner(new File("KH.in"));
        HashMap<String, KhachHang> mapKH = new HashMap<>();
        int n = Integer.parseInt(scKH.nextLine());
        while (n-- > 0) {
            String ten = scKH.nextLine();
            String gioiTinh = scKH.nextLine();
            String dob = scKH.nextLine();
            String diaChi = scKH.nextLine();
            KhachHang kh = new KhachHang(ten, gioiTinh, dob, diaChi);
            mapKH.put(kh.getMa(), kh);

        }
        // ======Mặt hàng====
        Scanner scMH = new Scanner(new File("MH.in"));
        int m = Integer.parseInt(scMH.nextLine());
        HashMap<String, MatHang> mapMH = new HashMap<>();
        while (m-- > 0) {
            String ten = scMH.nextLine();
            String donVi = scMH.nextLine();
            int giaMua = Integer.parseInt(scMH.nextLine());
            int giaBan = Integer.parseInt(scMH.nextLine());
            MatHang mh = new MatHang(ten, donVi, giaMua, giaBan);
            mapMH.put(mh.getMa(), mh);
        }
        // =====Hóa đơn====
        Scanner scHD = new Scanner(new File("HD.in"));
        ArrayList<HoaDon> list = new ArrayList<>();
        int k = Integer.parseInt(scHD.nextLine());
        while (k-- > 0) {
            String maKH = scHD.next();
            String maMH = scHD.next();
            int soLuong = scHD.nextInt();
            KhachHang khach = mapKH.get(maKH);
            MatHang hang = mapMH.get(maMH);
            list.add(new HoaDon(hang, khach, soLuong));
        }
        for (HoaDon hd : list) {
            System.out.println(hd);
        }

    }
}

class KhachHang {
    private String maKH, tenKH, dob, gioiTinh, diaChi;

    private static int cnt = 0;

    public KhachHang(String tenKH, String gioiTinh, String dob, String diaChi) {
        this.maKH = String.format("KH%03d", ++cnt);
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        // DateTimeFormatter f = DateTimeFormatter.ofPattern("d/M/yyyy");
        // this.dob = LocalDate.parse(dob, f);
        this.dob = dob;
        this.diaChi = diaChi;
    }

    public String getTen() {
        return tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getMa() {
        return maKH;
    }
}

class MatHang {
    private String maMH, tenMH, donViTinh;
    private int giaMua, giaBan;
    private static int cnt = 0;

    public MatHang(String tenMH, String donViTinh, int giaMua, int giaBan) {
        this.maMH = String.format("MH%03d", ++cnt);
        this.tenMH = tenMH;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getTen() {
        return tenMH;
    }

    public String getMa() {
        return maMH;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public int getGiaMua() {
        return giaMua;
    }

}

class HoaDon {
    private String maHD;
    private MatHang mh;
    private KhachHang kh;
    private int soLuong;
    private static int cnt = 0;

    public HoaDon(MatHang mh, KhachHang kh, int soLuong) {
        this.mh = mh;
        this.kh = kh;
        this.soLuong = soLuong;
        this.maHD = String.format("HD%03d", ++cnt);
    }

    private int getSoLuong() {
        return soLuong;
    }

    @Override
    public String toString() {
        long thanhTien = (long) (soLuong * mh.getGiaBan());
        return String.format("%s %s %s %s %s %d %d %d %d",
                maHD, kh.getTen(), kh.getDiaChi(), mh.getTen(), mh.getDonViTinh(),
                mh.getGiaMua(), mh.getGiaBan(), soLuong, thanhTien);
    }

}
