import java.io.File;
import java.util.Scanner;

public class DocFileVanBan {
    public static void main(String[] args) {
        File f = new File("DATA.in");
        // if (f.exists()) {
        //     System.out.println("File có tồn tại");
        // } else {
        //     System.out.println("File chưa có nhé");
        // }
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                System.out.println(s);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Lỗi");
        }

    }
}
