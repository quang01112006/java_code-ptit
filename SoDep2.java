import java.util.Scanner;

public class SoDep2 {
    public static boolean isPalindromic(String s){
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }
    public static int digitSum(String s){
        int sum = 0;
        for (char c: s.toCharArray()){
            sum += c -'0';
        }
        return sum;
    }
    public static boolean startsAndEndsWith8(String s){
        return (s.charAt(0)=='8' && s.charAt(s.length()-1)=='8');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
         for (int i = 0; i<t; i++){
            String s = sc.nextLine();
            if (isPalindromic(s) && digitSum(s)%10==0 && startsAndEndsWith8(s)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
         }
         sc.close();
    }
}
