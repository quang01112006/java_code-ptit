import java.util.ArrayList;
import java.util.Scanner;

public class XuLiVanBan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> s = new ArrayList<>();

        while (sc.hasNext()) {
            String word = sc.next();
            if (word.endsWith("!") || word.endsWith(".") || word.endsWith("?")) {
                word = word.substring(0, word.length() - 1);
                s.add(word);
                String line = String.join(" ", s);
                line = line.toLowerCase();
                if (line.length() > 0) {
                    line = Character.toUpperCase(line.charAt(0)) + line.substring(1);
                }
                System.out.println(line);
                s.clear();
            } else {
                s.add(word);
            }
        }

        sc.close();
    }
}
