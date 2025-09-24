import java.math.BigInteger;
import java.util.Scanner;

public class tongGiaiThua {
    public static BigInteger factorialSum(int n){
        BigInteger sum = BigInteger.ZERO;
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i<=n;i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
            sum = sum.add(factorial);            
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorialSum(n));
        sc.close();
    }
}
