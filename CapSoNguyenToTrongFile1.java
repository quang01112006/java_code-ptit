import java.util.*;
import java.io.*;

public class CapSoNguyenToTrongFile1 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
        ois1.close();
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
        ois2.close();
        sieve();
        int[] cnt1 = new int[1000001];
        int[] cnt2 = new int[1000001];
        for (int x : list1)
            cnt1[x]++;
        for (int x : list2)
            cnt2[x]++;
        for (int n = 2; n <= 500000; n++) {
            int m = 1000000 - n;
            if (isPrime[n] && isPrime[m] && cnt1[n] > 0 && cnt2[m] > 0) {
                System.out.println(n + " " + m);
            }
        }
    }

    public static boolean[] isPrime = new boolean[1000001];

    public static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p <= 1000000; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= 1000000; i += p) {
                    isPrime[i] = false;
                }
            }
        }
    }
}
