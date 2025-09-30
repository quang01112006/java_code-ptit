import java.util.Scanner;

public class ChuanHoaXauHoTen1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<t;i++){
            String input = sc.nextLine().trim();
            String[] parts = input.split("\\s+");
            String res = "";
            for (String part: parts){
                res += part.substring(0,1).toUpperCase() + part.substring(1).toLowerCase() + " ";
            }
            System.out.println(res.trim());
        }
        sc.close();
    }
}
