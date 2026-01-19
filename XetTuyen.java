import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class XetTuyen {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        ArrayList<ThiSinh> list = new ArrayList<>();
        int soThiSinh = Integer.parseInt(sc.nextLine());
        while (soThiSinh-- > 0) {
            String ten = sc.nextLine();
            String dob = sc.nextLine().trim();
            double lythuyet = Double.parseDouble(sc.nextLine());
            double thuchanh = Double.parseDouble(sc.nextLine());
            list.add(new ThiSinh(ten, dob, lythuyet, thuchanh));
        }
        for (ThiSinh ts : list) {
            System.out.println(ts);
        }
    }
}

class ThiSinh {
    private String ten, dob, ma, xepLoai;
    private double lythuyet, thuchanh, diemThuong = 0;
    private static int COUNT = 0;
    private long diemXepLoai;
    private int tuoi;

    public ThiSinh(String ten, String dob, double lythuyet, double thuchanh) {
        this.ma = String.format("PH%02d", ++COUNT);
        this.ten = chuanHoaTen(ten);
        this.lythuyet = lythuyet;
        this.thuchanh = thuchanh;
        this.diemThuong = diemThuong();
        this.diemXepLoai = Math.min(Math.round((lythuyet + thuchanh) / 2.0 + diemThuong), 10L);
        this.xepLoai = tinhXepLoai();
        this.dob = dob;
        this.tuoi = tinhTuoi(dob);

    }

    private int tinhTuoi(String dob) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("d/M/yyyy");
        int namSinh = LocalDate.parse(dob, f).getYear();
        // int namHienTai = LocalDate.now().getYear();
        // return namHienTai - namSinh;
        return 2021 - namSinh;
    }

    private String chuanHoaTen(String ten) {
        String[] parts = ten.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : parts) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
            }
        }
        return sb.toString().trim();
    }

    private double diemThuong() {
        if (lythuyet >= 8 && thuchanh >= 8)
            return diemThuong = 1;
        else if (lythuyet >= 7.5 && thuchanh >= 7.5)
            return diemThuong = 0.5;
        return 0;

    }

    private String tinhXepLoai() {
        if (diemXepLoai >= 9)
            return "Xuat sac";
        else if (diemXepLoai >= 8)
            return "Gioi";
        else if (diemXepLoai >= 7)
            return "Kha";
        else if (diemXepLoai >= 5)
            return "Trung binh";
        else
            return "Truot";
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + tuoi + " " + diemXepLoai + " " + xepLoai;
    }
}
