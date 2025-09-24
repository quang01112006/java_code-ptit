import java.util.Arrays;
import java.util.Scanner;

public class MangDoiXung {
    public static boolean doiXung(String[] arr){
        String[] reverse = arr.clone();
        for(int i=0,j=reverse.length-1; i<j;i++,j--){
            String temp = reverse[i];
            reverse[i]= reverse[j];
            reverse[j]=temp;
        }

        return Arrays.equals(arr, reverse);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i =0; i<t; i++){
            int n = sc.nextInt();
            sc.nextLine();
            String[] arr = sc.nextLine().split(" ");
           
            if (doiXung(arr)) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
