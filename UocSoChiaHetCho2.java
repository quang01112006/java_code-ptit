import java.util.Scanner;

public class UocSoChiaHetCho2 {
    public static int countDivisor(int n){
        int cnt=0;
        if (n%2!=0) return cnt;
        for (int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                int j = n/i;
                if(i%2==0) cnt++;
                if(j%2==0 && j!=i) cnt++;
            }
        }
        return cnt; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++){
            int n = sc.nextInt();
            System.out.println(countDivisor(n));
        }
        sc.close();
    }
    
}
