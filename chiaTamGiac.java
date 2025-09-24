import java.util.Scanner;

public class chiaTamGiac {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i =0; i<t; i++){
            int n = sc.nextInt();
            int h = sc.nextInt();
            for (int k=1; k<n; k++){
                double d = h * Math.sqrt((double) k/n);
                System.out.printf("%.6f", d);
                if (k!=(n-1)) {
                    System.out.print(" ");                    
                }
            }
            System.out.println("");
        }
         sc.close();
    }
}
