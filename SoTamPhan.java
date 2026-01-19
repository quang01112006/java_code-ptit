import java.util.Scanner;

public class SoTamPhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            if (Check(a)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();

    }

    public static boolean Check(String num) {
        for (char c : num.toCharArray()) {
            if (c != '0' && c != '1' && c != '2') {
                return false;
            }

        }
        return true;
    }
}
