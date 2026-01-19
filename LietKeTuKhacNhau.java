import java.util.Scanner;
import java.util.TreeSet;
import java.io.File;

public class LietKeTuKhacNhau {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        TreeSet<String> ts = new TreeSet<>();
        while (sc.hasNextLine()) {
            String word = sc.next().toLowerCase();
            ts.add(word);
        }
        sc.close();
        for (String s : ts) {
            System.out.println(s);
        }

    }
}
