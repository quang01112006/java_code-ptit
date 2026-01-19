import java.util.Scanner;

class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point secondPoint) {
        double dx = this.x - secondPoint.x;
        double dy = this.y - secondPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class ChuViTamGiac {
    public static boolean isValidTriangle(Point p1, Point p2, Point p3) {
        double area = Math.abs(
            p1.getX() * (p2.getY() - p3.getY()) +
            p2.getX() * (p3.getY() - p1.getY()) +
            p3.getX() * (p1.getY() - p2.getY())
        ) / 2.0;
        return area > 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            double x1 = Double.parseDouble(arr[0]);
            double y1 = Double.parseDouble(arr[1]);
            double x2 = Double.parseDouble(arr[2]);
            double y2 = Double.parseDouble(arr[3]);
            double x3 = Double.parseDouble(arr[4]);
            double y3 = Double.parseDouble(arr[5]);

            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            Point p3 = new Point(x3, y3);

            if (!isValidTriangle(p1, p2, p3)) {
                System.out.println("INVALID");
            } else {
                double a = p1.distance(p2);
                double b = p2.distance(p3);
                double c = p3.distance(p1);
                double perimeter = a + b + c;
                double rounded = Math.round(perimeter * 1000.0) / 1000.0;
                System.out.printf(java.util.Locale.US, "%.3f\n", rounded);
            }
        }
    }
}