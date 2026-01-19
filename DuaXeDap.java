import java.util.*;
public class DuaXeDap {
    static class CuaRo implements Comparable<CuaRo> {
        String ma = "", ten, donVi;
        long vanToc;
        double thoiGian;

        public CuaRo(String ten, String donVi, String gioDen) {
            this.ten = ten;
            this.donVi = donVi;
            for (String s : donVi.split("\\s+"))
                this.ma += s.charAt(0);
            for (String s : ten.split("\\s+"))
                this.ma += s.charAt(0);
            String[] t = gioDen.split(":");
            double h = Double.parseDouble(t[0]);
            double m = Double.parseDouble(t[1]);
            this.thoiGian = (h - 6) + m / 60.0;
            this.vanToc = Math.round(120 / this.thoiGian);
        }

        @Override
        public int compareTo(CuaRo o) {
            if (this.thoiGian < o.thoiGian)
                return -1;
            if (this.thoiGian > o.thoiGian)
                return 1;
            return 0;
        }
        @Override
        public String toString() {
            return ma + " " + ten + " " + donVi + " " + vanToc + " Km/h";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<CuaRo> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new CuaRo(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(list);
        for (CuaRo cr : list) {
            System.out.println(cr);
        }
        sc.close();
    }

}
