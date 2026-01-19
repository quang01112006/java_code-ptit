import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ChuanHoaVaSapXep {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        ArrayList<Ten> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].substring(0, 1).toUpperCase()
                        + words[i].substring(1).toLowerCase();
            }
            String ho = words[0];
            String ten = words[words.length - 1];
            StringBuilder demBuilder = new StringBuilder();
            for (int i = 1; i < words.length - 1; i++) {
                demBuilder.append(words[i]).append(" ");
            }
            String dem = demBuilder.toString().trim();
            list.add(new Ten(ho, dem, ten));
        }
        Collections.sort(list, (a, b) -> {
            if (!a.ten.equals(b.ten))
                return a.ten.compareTo(b.ten);
            if (!a.ho.equals(b.ho))
                return a.ho.compareTo(b.ho);
            return a.dem.compareTo(b.dem);
        });
        for (Ten t : list) {
            System.out.println(t);
        }
    }
}

class Ten {
    String ho, dem, ten;

    public Ten(String ho, String dem, String ten) {
        this.ho = ho;
        this.dem = dem;
        this.ten = ten;
    }

    @Override
    public String toString() {
        return ho + " " + dem + " " + ten;
    }
}
