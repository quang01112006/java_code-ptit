import java.util.Scanner;

class SinhVien {
    private String maSV;
    private String hoTen;
    private String lop;
    private String ngaySinh;
    private float gpa;

    public SinhVien() {
        this.maSV = "";
        this.hoTen = "";
        this.lop = "";
        this.ngaySinh = "";
        this.gpa = 0;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setNgaySinh(String ngaySinh) {
        String[] part = ngaySinh.split("/");
        if (part[0].length() == 1)
            part[0] = "0" + part[0];
        if (part[1].length() == 1)
            part[1] = "0" + part[1];
        this.ngaySinh = part[0] + "/" + part[1] + "/" + part[2];
    }

    public void setGPA(float gpa) {
        this.gpa = gpa;
    }

    public void getInfo() {
        System.out.printf("B20DCCN001 %s %s %s %.2f\n", hoTen, lop, ngaySinh, gpa);
    }
}

public class KhaiBaoLopSinhVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinhVien sv1 = new SinhVien();
        sv1.setHoTen(sc.nextLine());
        sv1.setLop(sc.nextLine());
        sv1.setNgaySinh(sc.nextLine());
        sv1.setGPA(sc.nextFloat());
        sv1.getInfo();

    }

}
