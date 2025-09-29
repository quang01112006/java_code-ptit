import java.util.Scanner;

public class SoDep3 {
    public static boolean isPalindromic(String s){
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);}


    public static boolean isPrime(int x){
        if (x<2) return false;
        for (int i=2; i<=Math.sqrt(x);i++){
            if(x%i==0) return false;
        }
        return true;
    }
    public static boolean isAllPrime(String s){
        for (char c: s.toCharArray()){
            if(!isPrime(c-'0')){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<t;i++){
            String s = sc.nextLine();
            if(isAllPrime(s)&&isPalindromic(s)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
    

