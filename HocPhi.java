import vn.edu.ptit.*;
import java.util.Scanner;
import view.InvoiceView;

public class HocPhi {
    
    public static void main(String[] args) {
        PaymentController pc = new PaymentController();
        //Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }


    // static class PaymentController{

    // }





}
