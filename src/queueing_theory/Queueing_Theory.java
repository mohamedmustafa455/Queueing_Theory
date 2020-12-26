
package queueing_theory;

import java.util.Scanner;


public class Queueing_Theory {

    
    public static void main(String[] args) {
        //    queue qu= new queue();
        //  qu.setVisible(true);
   //   new home_page().setVisible(true);
 //Deterministic c1 = new Deterministic( 4 , 6 ,4 ,0);
     //  System.out.println("  ti  "+c1.calculat_ti1() ); // error
      //  System.out.println("    "+ c1.caculat_Wq2_With_K(2));
       
        //    Test Markov Case 1  M / M / 1
        Markov c2 = new Markov(0.5, 0.4166,5);
                System.out.println("   Row  = "+ c2.Row2);
        System.out.println("   P02  = "+ c2.calculat_P02 ());

        System.out.println("   Pk  = "+ c2.calculat_Pk ());
     // System.out.println("   Pn1  = "+ c2.calculat_Pn1 (4)); // need number of customar
        System.out.println("   L2  = "+ c2.caculat_L2());
        System.out.println("   Lq2 = "+ c2.caculat_Lq2());
        System.out.println("   W2   = "+ c2.caculat_W2());
        System.out.println("   Wq2  = "+ c2.caculat_Wq2());
    }
    
}
