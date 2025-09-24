import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class helloFile {
    public static void main(String[] args ) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("Hello.txt"));
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(line);
        }
        sc.close();
    }
}
