import java.util.Scanner;



public class SoNguyenTo {
    public static boolean isPrime(int a){
    if (a<2) return false;
    if (a==2) return true;
    int lim = (int) Math.sqrt(a);
    for (int i=2;i<= lim;i++){
        if (a%i==0) return false;
    }
    return true;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            int a = sc.nextInt();
            if(isPrime(a)) System.out.println("YES");
            else System.out.println("NO");}
        sc.close();
        }
      
    }
