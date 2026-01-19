import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachCaThi {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("CATHI.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<CaThi> list = new ArrayList<>();
        while (n-- > 0) {
            String ngayThi = sc.nextLine();
            String gioThi = sc.nextLine();
            String phongThi = sc.nextLine();
            list.add(new CaThi(ngayThi, gioThi, phongThi));
        }
        Collections.sort(list, (a, b) -> {
            if (a.getLichThi() != b.getLichThi()) {
                return a.getLichThi().compareTo(b.getLichThi());
            }
            return a.getMa().compareTo(b.getMa());
        });
        for (CaThi ct : list) {
            System.out.println(ct);
        }
        sc.close();
    }
}

class CaThi {
    private String ma, ngayThi, gioThi, phongThi;
    private static int CNT = 0;
    private LocalDateTime lichThi;

    public CaThi(String ngayThi, String gioThi, String phongThi) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.ngayThi = ngayThi;
        this.gioThi = gioThi;
        this.phongThi = phongThi;
        String ngayGio = ngayThi + " " + gioThi;
        this.lichThi = LocalDateTime.parse(ngayGio, f);
        this.ma = String.format("C%03d", ++CNT);

    }

    public LocalDateTime getLichThi() {
        return lichThi;
    }

    public String toString() {
        return ma + " " + ngayThi + " " + gioThi + " " + phongThi;
    }

    public String getMa() {
        return ma;
    }
}
