import java.util.Scanner;

public class ChuSo4vaChuSo7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] arr = input.toCharArray();
        int cnt = 0;
        for (char c : arr){
            if(c=='4'||c=='7') cnt++;
        }
        String res = (cnt==7 || cnt==4)?"YES":"NO";
        System.out.println(res);
        sc.close();
    }
}
