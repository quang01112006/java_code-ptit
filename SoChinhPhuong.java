import java.util.Scanner;

public class SoChinhPhuong {
    static boolean check(int n){
        int s = (int) Math.sqrt(n);
        return s*s==n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            int n = sc.nextInt();
            String res = check(n)?"YES":"NO";
            System.out.println(res);
        }
    }
}
