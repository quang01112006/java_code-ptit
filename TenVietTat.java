import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TenVietTat {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        int N = Integer.parseInt(sc.nextLine());
        ArrayList<HoTen> list = new ArrayList<>();
        while (N-- > 0) {
            list.add(new HoTen(sc.nextLine()));
        }
        Collections.sort(list, (a, b) -> {
            if (a.ten() != b.ten()) {
                return a.ten().compareTo(b.ten());
            }
            return a.ho().compareTo(b.ho());
        });
        int M = Integer.parseInt(sc.nextLine());
        while (M-- > 0) {
            String pattern = sc.nextLine();
            for (HoTen ht : list) {
                if (isMatch(pattern, ht.viettat())) {
                    System.out.println(ht);
                }
            }
        }
    }

    public static boolean isMatch(String pattern, String ten) {
        if (pattern.length() != ten.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '*' && pattern.charAt(i) != ten.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}

class HoTen {
    private String ten, ho, vietTat, fullname;

    public HoTen(String s) {

        this.fullname = s;
        String[] parts = s.split("\\s+");
        this.ten = parts[parts.length - 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length - 1; i++) {
            sb.append(parts[i]).append(" ");
        }
        this.ho = sb.toString().trim();
        StringBuilder vt = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            vt.append(parts[i].charAt(0));
            if (i < parts.length - 1) {
                vt.append(".");
            }
        }
        this.vietTat = vt.toString();

    }

    public String ten() {
        return ten;
    }

    public String viettat() {
        return vietTat;
    }

    public String ho() {
        return ho;
    }

    @Override
    public String toString() {
        return fullname;
    }
}