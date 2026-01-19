import java.io.DataInputStream;
import java.io.FileInputStream;

public class SoKhacNhauTrongFile2 {
    public static void main(String[] args) throws Exception {
        DataInputStream dis = new DataInputStream(new FileInputStream("DATA.IN"));
        int[] arr = new int[1000];
        for (int i = 0; i < 100000; i++) {
            int n = dis.readInt();
            arr[n]++;
        }
        dis.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            if (arr[i] > 0) {
                sb.append(i).append(" ").append(arr[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
