import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UocSoNguyenToLonNhat {
    public static boolean isPrime(long n){
        if (n<2) return false;
        for (int i=2; i<=Math.sqrt(n);i++){
            if (n%i==0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i=0;i<t;i++){
            ArrayList<Long> primeList = new ArrayList<>();
            long n = sc.nextLong();
            for (long j=1; j<=Math.sqrt(n);j++){
                if(n%j==0){
                    if(isPrime(j)) primeList.add(j);
                    long other = n/j;
                    if(isPrime(other)) primeList.add(other);
                }
            }
            primeList.sort(Comparator.naturalOrder());
            System.out.println(primeList.get(primeList.size()-1));
        }
        sc.close();
    }
}
