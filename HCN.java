import java.util.Scanner;

public class HCN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        if(w<=0||h<=0){
            System.out.println(0);
        }
        else{
            System.out.println((w+h)*2 + " " + (w*h));
        }
        sc.close();
    }
}
