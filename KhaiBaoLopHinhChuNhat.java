import java.util.Scanner;

class Rectangle{
    private double width;
    private double height;
    private String color;

    public Rectangle(){
        width=1;
        height=1;
    }
    public Rectangle(double width, double height,String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public double getWidth(){
        return this.width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getHeight(){
        return this.height;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public String getColor(){
        return color.substring(0,1).toUpperCase()+color.substring(1).toLowerCase();
    }
    public void setColor(String color){
        this.color = color;
    }
    public double findArea(){
        return width*height;
    }
    public double findPerimeter(){
        return (width+height)*2;
    }
    @Override
    public String toString(){
        return String.format("%d %d %s", (int) findPerimeter(), (int) findArea(), getColor());
    }
}




public class KhaiBaoLopHinhChuNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double w = sc.nextDouble();
        double h = sc.nextDouble();
        String color = sc.nextLine().trim();
        if(w>0&&h>0){
            Rectangle rect = new Rectangle(w, h, color);
            System.out.println(rect);
        } else{
            System.out.println("INVALID");
        }
        sc.close();
    }
    
}
