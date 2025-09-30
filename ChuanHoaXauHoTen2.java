import java.util.Scanner;

public class ChuanHoaXauHoTen2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int j=0;j<t;j++){
            String[] input = sc.nextLine().trim().split("\\s+");
            String lastName = input[0].toUpperCase();
            String res = "";
            for (int i=1;i<input.length;i++){
               res += input[i].substring(0,1).toUpperCase() + input[i].substring(1).toLowerCase() +" ";
            }
            System.out.println(res.trim()+", " + lastName);
        }
        sc.close();
    }
}
