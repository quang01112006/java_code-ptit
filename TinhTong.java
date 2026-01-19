import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TinhTong {
    public static void main(String[] args) {
        File f = new File("DATA.in");
        long sum = 0;
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String s = sc.next();
                try {
                    int num = Integer.parseInt(s);
                    sum += num;
                } catch (NumberFormatException e) {
                }

            }
            sc.close();
            System.out.println(sum);
        } catch (FileNotFoundException e) {
        }
        ;
    }
}
