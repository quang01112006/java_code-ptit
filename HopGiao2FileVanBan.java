import java.util.*;

import java.io.*;

public class HopGiao2FileVanBan {

    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}

class WordSet {
    private TreeSet<String> data;

    public WordSet(String fileName) {
        this.data = new TreeSet<>();
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNext()) {
                this.data.add(sc.next().toLowerCase());S
            }
        } catch (FileNotFoundException e) {
        }
    }

    public String union(WordSet other) {
        TreeSet<String> res = new TreeSet<>(data);
        res.addAll(other.data);
        return format(res);
    }

    public String intersection(WordSet other) {
        TreeSet<String> res = new TreeSet<>(data);
        res.retainAll(other.data);
        return format(res);
    }

    private String format(TreeSet<String> set) {
        return String.join(" ", set);
    }
}