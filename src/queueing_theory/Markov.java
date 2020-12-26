
package queueing_theory;


public class Markov {

    double arrivingTime ; //  1/m
    double serviceTime  ;  //  1/L
    double arrivingRate ;
    double serviceRate  ;
    double Row1;     
                      // constractor case 1 
    public Markov(double arrivingTime, double serviceTime) {
        
        this.arrivingTime = arrivingTime ;
        this.serviceTime = serviceTime;
        arrivingRate = 1 / arrivingTime;
        serviceRate = 1 / serviceTime ;
        Row1 = arrivingRate / serviceRate;     //    row = Lamda / mu
    }
    
                                         //       M / M / 1    slaide 4
       
        public double calculat_P01 (){
               //P0=Math.round(1 - Row1);
         return 1 - Row1;
        }
    
        public double calculat_Pn1 (int numberOfCustomar){   //   Pn = (row)^n * (1-row)       or  Pn = (row)^n * P0
            
           // Pn=Math.round((Math.pow(Row1, numberOfCustomar)) *(calculat_P01()));
          return (Math.pow(Row1, numberOfCustomar)) *(calculat_P01()) ;
        }
    
        public double caculat_L1 (){         //   L =  ( Lamda ) / ( mu - Lamda )
           //  L=Math.round((arrivingRate) / ( serviceRate - arrivingRate));
         return (arrivingRate) / ( serviceRate - arrivingRate) ;
        }
    
        public double caculat_Lq1 (){       //     Lq = ( Lamda )^2 / mu ( mu - Lamda )
        
             double numerator = ( arrivingRate * arrivingRate );
             double denominator = (serviceRate)*(serviceRate - arrivingRate);
             //Lq=Math.round(numerator / denominator);
         return numerator / denominator ;
        }
    
        public double caculat_W1 (){       //     W = 1 / ( mu - Lamda )
           
             //W=Math.round((1) / (serviceRate - arrivingRate  ));
         return (1) / (serviceRate - arrivingRate  ) ;
        }
    
        public double caculat_Wq1 (){    //     Wq = (Lamda) / [ mu * (mu - Lamda) ] 
        
             double numerator = arrivingRate ;
             double denominator ;
             denominator = (serviceRate)*(serviceRate - arrivingRate);
            //Wq=Math.round(Wq);
         return numerator / denominator ;
        }
    
    
                                    //      M / M / 1 / K 
    
    int capacty;
    int k = capacty + 1;
    double Row2;
                                // constractor for case 2
    public Markov(double arrivingTime, double serviceTime ,int k) {
        
      this.arrivingTime = arrivingTime ;
      this.serviceTime  = serviceTime;
          arrivingRate = 1 / arrivingTime;
          serviceRate  = 1 / serviceTime ;
      this.k=k;
      this.Row2 = arrivingRate / serviceRate ;
    }
    
    
        public double calculat_P02 (){            //     P0 = tow Case
                                             
             if (Row2 != 1){                      // if Row !=1    P0 = (1-Row) / (1- Row^k+1) 
            double numerator = 1 - Row2 ;   
             double denominator = (1) - (Math.pow(Row2, (k+1)));
               
             return numerator/denominator;
           } else {                              // if Row =1    P0 = (1) / (k+1)
                 
           return 1 / (k+1); 
           }
        }
    
        public double calculat_Pn2 (int numberOfCustomar){   //   Pn = tow Case
            
             if (Row2 != 1){                     // if Row !=1    Pn = (Row^n)*(P0)

            return (Math.pow(Row2, numberOfCustomar))* (calculat_P02 ());
            } else {                                    // if Row =1    Pn = (P0)   
            
            return 1 / (k+1); 
            }
        }
    
        public double calculat_Pk (){           //   Pk = tow Case
            
             if (Row2 != 1){                     // if Row !=1    Pk = (Row^k)*(P0)
            
             return (Math.pow(Row2,k))* (calculat_P02 ());
           } else {                                    // if Row =1    Pk = (P0)   
           return 1 / (k+1); 
           }
        }
        
                                          
        public double caculat_L2 (){      //   L =

            if (Row2 != 1){               // if Row2 != 1    L = (1-(k+1)*Row2^k + k*Row2^k)/((1-Row2)*(1-Row^k+1))
             double part_1 =Math.pow(Row2 , k+1);
             double part_2 =Math.pow(Row2 , k);
             double numerator = 1 - ((k+1)* (part_2)) + ((k)*(part_1));
             double denominator = (1-Row2)*(1-part_1);
             
         return (Row2)*(numerator/denominator) ;
         } else {                              // if Row2=1  L = k/2
            
         return k / 2; 
           }
        }
        
        public double caculat_Lq2 (){        //   Lq = L - Row2(1-Pk) 
                                         
         return ( caculat_L2() ) - ( Row2 *(1 - calculat_Pk()) ) ;
        }
        
        public double caculat_W2 (){        //   W =  L / Lamda (1-Pk)
            double numerator = caculat_L2();
            double denominator = (arrivingRate) * (1 - calculat_Pk() );
         return numerator / denominator ;
        }
        
        public double caculat_Wq2 (){            //   Wq = W - (1 / mu) 
            
         return ( caculat_W2() )-(serviceTime) ;
        }
    
}
