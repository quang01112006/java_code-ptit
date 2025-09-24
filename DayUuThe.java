import java.util.Scanner;

public class DayUuThe {
    public static boolean check(int[] arr){
        int arrLength = arr.length;
        int even = countEven(arr);
        int odd = arrLength - even;
        for(int i=0;i<arrLength;i++){
            if (arrLength%2==0 && even>odd){
                return true;
            } else if (arrLength%2!=0 && even<odd){
                return true;
            }
        }
        return false;
    }
    public static int countEven(int[] arr){
        int cnt=0;
        for (int i=0; i<arr.length;i++){
            if (arr[i]%2==0){
                cnt+=1;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<t;i++){
            String[] input = sc.nextLine().split(" ");
            int[] arr = new int[input.length];
            for (int j=0;j<input.length;j++){
                arr[j]= Integer.parseInt(input[j]);
                
            }
            String res = check(arr)? "YES":"NO";
            System.out.println(res);

        }
        sc.close();
    }
}
