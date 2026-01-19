import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;

public class LoaiBoSoNguyen {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DATA.in"));
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                sc.next();
            } else {
                String s = sc.next();
                list.add(s);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String i : list) {
            sb.append(i).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
