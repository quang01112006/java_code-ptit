import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DemSoLanXuatHien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
       
        
       for (int i=1; i<=t;i++){
        int a = sc.nextInt();
         sc.nextLine();
        HashMap<String, Integer> freq = new LinkedHashMap<>();
        String[] input = sc.nextLine().split(" ");
        System.out.printf("Test %s:\n",i);
        for (int j=0; j<input.length;j++){
            freq.put(input[j], freq.getOrDefault(input[j], 0)+1);
        
        }
        for (Map.Entry<String, Integer> kq : freq.entrySet()){
            System.out.printf("%s xuat hien %d lan\n", kq.getKey(), kq.getValue());

        }

       }
       sc.close();
    }
}
