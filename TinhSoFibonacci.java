import java.util.Scanner;

public class TinhSoFibonacci {
    public static long findFibo(int n){
        long f1 = 1;
        long f2 = 1;
        long fn =0 ;
        if (n==1 || n == 2){
            return 1;
        }
        
        for (int i=3; i<=n;i++){
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            int n = sc.nextInt();
            System.out.println(findFibo(n));
        }
        sc.close();
    }
}
