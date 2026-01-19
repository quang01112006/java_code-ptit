import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class LietKeTheoThuTuXuatHien {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        ArrayList<String> list = (ArrayList<String>) ois.readObject();
        ois.close();
        HashSet<String> setBinary = new HashSet<>();
        for (String s : list) {
            String[] words = s.trim().toLowerCase().split("\\s+");
            for (String w : words) {
                setBinary.add(w);
            }
        }

        Scanner sc = new Scanner(new File("VANBAN.in"));
        LinkedHashSet<String> setVanBan = new LinkedHashSet<>();
        while (sc.hasNext()) {
            String word = sc.next().toLowerCase();
            if (setBinary.contains(word)) {
                setVanBan.add(word);
            }

        }
        sc.close();
        for(String s:setVanBan){
            System.out.println(s);
        }
    }
}
