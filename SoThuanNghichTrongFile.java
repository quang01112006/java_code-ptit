import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SoThuanNghichTrongFile {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
        ois1.close();
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
        ois2.close();
        int[] cnt1 = new int[1000001];
        int[] cnt2 = new int[1000001];
        for (Integer x : list1)
            cnt1[x]++;
        for (Integer x : list2)
            cnt2[x]++;
        int found = 0;
        for (int i = 100; i <= 999999; i++) {
            if (cnt1[i] > 0 && cnt2[i] > 0 && isValid(i)) {
                System.out.println(i + " " + (cnt1[i] + cnt2[i]));
                found++;
                if (found == 10)
                    break;
            }
        }

    }

    public static boolean isValid(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        if (len == 1 || len % 2 == 0)
            return false;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c % 2 == 0)
                return false;
        }
        int l = 0, r = len - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

}
