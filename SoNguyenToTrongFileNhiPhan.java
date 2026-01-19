import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class SoNguyenToTrongFileNhiPhan {
    public static boolean[] isPrime = new boolean[10001];

    public static void locSoNguyenTo() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p <= 10000; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= 10000; i += p) {
                    isPrime[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        locSoNguyenTo();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        ArrayList<Integer> list = (ArrayList<Integer>) ois.readObject();
        ois.close();
        int[] arr = new int[10001];
        for (int x : list) {
            if (isPrime[x]) {
                arr[x]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= 10000; i++) {
            if (arr[i] > 0) {
                sb.append(i).append(" ").append(arr[i]).append("\n");
            }
        }
        System.out.print(sb);

    }
}
