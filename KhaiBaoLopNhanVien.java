import java.util.Scanner;

class NhanVien {
    private String maNV = "00001";
    private String hoten;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String maSoThue;
    private String ngayKyHopDong;

    public NhanVien(String hoten, String gioiTinh, String ngaySinh, String diaChi, String maSoThue,
            String ngayKyHopDong) {
        this.hoten = hoten;
        this.gioiTinh = gioiTinh;
        NgaySinh(ngaySinh);
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
        NgayKy(ngayKyHopDong);
    }

    public void NgaySinh(String ngaySinh) {
        String[] part = ngaySinh.split("/");
        if (part[0].length() == 1)
            part[0] = "0" + part[0];
        if (part[1].length() == 1)
            part[1] = "0" + part[1];
        this.ngaySinh = part[0] + "/" + part[1] + "/" + part[2];
    }

    public void NgayKy(String ngayKyHopDong) {
        String[] part = ngayKyHopDong.split("/");
        if (part[0].length() == 1)
            part[0] = "0" + part[0];
        if (part[1].length() == 1)
            part[1] = "0" + part[1];
        this.ngayKyHopDong = part[0] + "/" + part[1] + "/" + part[2];
    }

    public void showInfo() {
        System.out.printf("%s %s %s %s %s %s %s", maNV, hoten,gioiTinh, ngaySinh, diaChi, maSoThue, ngayKyHopDong);
    }
}

public class KhaiBaoLopNhanVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien nv = new NhanVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(),
                sc.nextLine());
        nv.showInfo();
    }
}
