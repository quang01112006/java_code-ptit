import java.util.Scanner;

public class TongNSoNguyenDuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            long a = sc.nextLong();
            long sum = (a*(a+1))/2;
            System.out.println(sum);
        }
        sc.close();
    }
    
}
