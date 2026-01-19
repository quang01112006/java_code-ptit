import java.io.File;
import java.util.Scanner;

public class ChuanHoaXauHoTenTrongFile {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DATA.in"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equals("END"))
                break;
            System.out.println(ChuanHoa(line));

        }
    }

    public static String ChuanHoa(String s) {
        String[] words = s.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
}
