import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SoKhacNhauTrongFile1 {
    public static void main(String[] args) {
        File f = new File("DATA.in");
        int[] numbers = new int[1000];
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                numbers[num]++;
            }
            sc.close();
            for (int i = 0; i < 1000; i++) {
                if (numbers[i] > 0) {
                    System.out.println(i + " " + numbers[i]);
                }
            }
        } catch (FileNotFoundException e) {
        }
        ;
    }
}
