import java.util.Scanner;

public class HinhChuNhat {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int perimeter = (a+b)*2;
        int area = a*b;
        if (a<=0 || b<=0) System.out.print(0);
        else System.out.print(perimeter + " " + area);
    }
}
