
import java.util.Scanner;

public class LietKeToHop1 {
    static boolean sinhToHop(int n, int k, int[] a) {
        int i;
        for (i = k - 1; i >= 0; i--) {
            if (a[i] < n - k + i + 1)
                break;
        }
        if (i < 0)
            return false;

        a[i]++;
        for (int j = i + 1; j < k; j++) {
            a[j] = a[j - 1] + 1;
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[k];
        int cnt = 0;
        for (int i = 0; i < k; i++)
            a[i] = i + 1;
        do {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
            cnt++;
        } while (sinhToHop(n, k, a));
        System.out.printf("Tong cong co %s to hop",cnt);
        sc.close();
    }
}
