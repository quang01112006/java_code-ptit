import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SoNguyenTo2FileNhiPhan {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        int[] arr1 = new int[10000];
        ArrayList<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
        ois1.close();
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        int[] arr2 = new int[10000];
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
        ois2.close();
        for (Integer i : list1) {
            if (isPrime(i))
                arr1[i]++;
        }
        for (Integer i : list2) {
            if (isPrime(i))
                arr2[i]++;
        }
        for (int i = 2; i < 10000; i++) {
            if (arr1[i] > 0 && arr2[i] > 0) {
                System.out.println(i + " " + arr1[i] + " " + arr2[i]);
            }
        }
    }

    public static boolean isPrime(int x) {
        if (x < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
