import java.util.Scanner;
import java.util.Arrays;

public class SapXepChon {
    public static void selectionSort(int[] arr){
        for (int i = 0; i<arr.length-1; i++){
           int minIdex = i;
           for(int j = i+1; j<arr.length; j++){
                if(arr[minIdex]>arr[j]){
                    minIdex = j;
                }
           }
           int temp = arr[i];
           arr[i]=arr[minIdex];
           arr[minIdex] = temp;
           System.out.print("Buoc " + (i+1) +": ");
           for(int a = 0; a<arr.length;a++){
                System.out.print(arr[a]);
                if(a<arr.length-1){
                    System.out.print(" ");
                }
           }
           System.out.println("");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        int[] num = new int[t];
        for (int i =0; i<t;i++){
            num[i] = Integer.parseInt(input[i]);
        }
        selectionSort(num);
    }
}
