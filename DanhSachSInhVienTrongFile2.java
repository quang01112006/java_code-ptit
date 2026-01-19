import java.util.Scanner;
import java.io.File;

class SinhVien {
    private String maSV, hoTen, ngaySinh, lop;
    private double gpa;

    public SinhVien(String hoTen, String ngaySinh, String lop, double gpa, int id) {
        this.maSV = String.format("B20DCCN%03d", id);
        this.hoTen = hoTen;
        this.ngaySinh = chuanHoa(ngaySinh);
        this.lop = lop;
        this.gpa = gpa;

    }

    private String chuanHoa(String ngaySinh) {
        String[] arr = ngaySinh.split("/");
        int d = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int y = Integer.parseInt(arr[2]);
        return String.format("%02d/%02d/%04d", d, m, y);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", maSV, hoTen, lop, ngaySinh, gpa);
    }
}

public class DanhSachSInhVienTrongFile2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("SV.in"));
        int soSinhVien = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < soSinhVien; i++) {

            String hoTen = sc.nextLine();
            String lop = sc.nextLine();
            String dob = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine());
            SinhVien sv = new SinhVien(hoTen, dob, lop, gpa, i+1);
            System.out.println(sv);
        }
        sc.close();
    }
}
