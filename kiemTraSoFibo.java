import java.math.BigInteger;
import java.util.Scanner;

public class kiemTraSoFibo {
    public static boolean perfectSquareCheck(BigInteger x){
        BigInteger left = BigInteger.ZERO;
        BigInteger right = x;
        while(left.compareTo(right)<=0){
            BigInteger mid = left.add(right).divide(BigInteger.valueOf(2));
            BigInteger n = mid.multiply(mid);
            if (n.compareTo(x)==0) return true;
            if (n.compareTo(x)<0) left = mid.add(BigInteger.ONE);
            else right = mid.subtract(BigInteger.ONE);
        }
        return false;
    }
    public static boolean fiboCheck(long a){
        BigInteger b = BigInteger.valueOf(a);
        BigInteger five = BigInteger.valueOf(5);
        return perfectSquareCheck(five.multiply(b).multiply(b).add(BigInteger.valueOf(4))) || perfectSquareCheck(five.multiply(b).multiply(b).subtract(BigInteger.valueOf(4)));
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++){
            long a = sc.nextLong();
            if(fiboCheck(a)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }

        }
        sc.close();
    }
}

