import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class TinhTienPhong {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        ArrayList<KhachHang> list = new ArrayList<>();
        int soKhachHang = Integer.parseInt(sc.nextLine());
        while (soKhachHang-- > 0) {
            String ten = sc.nextLine();
            String soPhong = sc.nextLine();
            String ngayNhan = sc.nextLine().trim();
            String ngayTra = sc.nextLine().trim();
            Long tienDichVu = Long.parseLong(sc.nextLine().trim());
            list.add(new KhachHang(ten, ngayNhan, ngayTra, soPhong, tienDichVu));
        }
        Collections.sort(list, (a, b) -> Long.compare(b.getTongTien(), a.getTongTien()));
        for (KhachHang kh : list) {
            System.out.println(kh);
        }
    }
}

class KhachHang {
    private static int COUNT = 0;
    private String ma;
    private String ten, ngayNhan, ngayTra, soPhong;
    private long tienDichVu, tongTien;
    private long soNgay, donGia;
    private int tang;

    public KhachHang(String ten, String ngayNhan, String ngayTra, String soPhong, long tienDichVu) {
        this.ten = chuanHoaTen(ten);
        this.soPhong = soPhong;
        COUNT++;
        this.ma = String.format("KH%02d", COUNT);
        this.tienDichVu = tienDichVu;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate d1 = LocalDate.parse(ngayNhan, f);
        LocalDate d2 = LocalDate.parse(ngayTra, f);
        this.soNgay = ChronoUnit.DAYS.between(d1, d2) + 1;
        this.tongTien = getDonGia() * soNgay + tienDichVu;
    }

    private long getDonGia() {
        char tang = soPhong.charAt(0);
        if (tang == '1')
            return 25;
        if (tang == '2')
            return 34;
        if (tang == '3')
            return 50;
        if (tang == '4')
            return 80;
        return 0;
    }

    private String chuanHoaTen(String ten) {
        String[] parts = ten.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            if (!p.isEmpty()) {
                sb.append(Character.toUpperCase(p.charAt(0))).append(p.substring(1)).append(" ");
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + soPhong + " " + soNgay + " " + tongTien;
    }

    public Long getTongTien() {
        return tongTien;
    }

}