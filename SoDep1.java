import java.util.Scanner;

public class SoDep1 {
    public static boolean check(StringBuilder sb){
        for (char c: (sb.toString()).toCharArray()){
            int digit = c - '0';
            if (digit%2!=0) return false;
        }
        String original = sb.toString();
         String reverse = sb.reverse().toString();
         return original.equals(reverse);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<t;i++){
            StringBuilder sb = new StringBuilder(sc.nextLine());
            String res = check(sb)?"YES":"NO";
            System.out.println(res);
           

        }
        sc.close();
    }
}
