import java.util.Scanner;

public class CatDoi{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            String n = sc.next();
            String res ="";
            boolean invalid = false;
            for (int j=0; j<n.length();j++){
                char c = n.charAt(j);
                int digit = Character.getNumericValue(c);
                
                switch (digit){
                    case 1: res+=1;
                    break;
                    case 0:
                    case 8:
                    case 9:
                    res +=0;
                    break;
                    default: 
                    res = "INVALID";
                    invalid = true;
                    break;
                }
                if(invalid) break;
            }
            if(!invalid){
                res = res.replaceFirst("^0+", "");
                if(res.isEmpty()) res= "INVALID";

        }
        System.out.println(res);
        }

        
        
    }
}