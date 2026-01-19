import java.util.*;
import java.io.*;

public class SoNguyenToLonNhatTrongFile {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> list = (ArrayList<Integer>) ois.readObject();
        sieve();
        int[] count = new int[1000001];
        for (int x : list) {
            if (isPrime[x]) {
                count[x]++;
            }
        }
        int a = 0;
        for (int i = 1000000; i >= 2; i--) {
            if (count[i] > 0) {
                System.out.println(i + " " + count[i]);
                a++;
            }
            if (a == 10)
                break;
        }

    }

    public static boolean[] isPrime = new boolean[1000001];

    public static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int p = i * i; p <= 1000000; p += i) {
                    isPrime[p] = false;
                }
            }
        }
    }
}
