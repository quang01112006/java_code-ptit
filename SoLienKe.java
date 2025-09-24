import java.util.Scanner;

public class SoLienKe {
    public static boolean check(String str){
       for (int i=0; i<str.length()-1;i++){
        int a = str.charAt(i)-'0';
        int b = str.charAt(i+1)-'0';
        if (Math.abs(a-b)!=1) return false;
       }
       return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<t;i++){
            String str = sc.nextLine();
            String res = check(str)?"YES":"NO";
            System.out.println(res);
            
        }
        sc.close();
    }
}
