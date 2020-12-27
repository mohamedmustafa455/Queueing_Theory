package queueing_theory;

public class M_M_C_K {

    double num_of_parellel_servers = 0;  // c:number of parellel servers

    double service_time , arrival_time ;     //        1/μ  ,   1/λ
    double service_rate, arrival_rate;

    int k;  // System capacity-1



    double r, p , po ;


    M_M_C_K(){

    }


    M_M_C_K num_of_parellel_servers(int n_o_p_s){
        this.num_of_parellel_servers =n_o_p_s;
        return this;
    }

    M_M_C_K service_time(double ser_t){
        this.service_time =ser_t;
        service_rate = 1/service_time;
        return this;
    }

    M_M_C_K arrival_time(double arr_t){
        this.arrival_time =arr_t;
        arrival_rate = 1/arrival_time;
        return this;
    }
    M_M_C_K k(int pk){
        this.k = pk;
        return this;
    }

    double calc_r(){
        return service_time/arrival_time;
    }

    void calc_p(){
        this.r = calc_r();
        this.p = r/num_of_parellel_servers;
    }

    double calc_po(){
        calc_p();
        if(p!=1){

            double first_term_result = 0;

            for(int i =0;i<=num_of_parellel_servers-1;i++){

                first_term_result +=(Math.pow(r,i)/vactorial(i));

            }

            return 1/(first_term_result
                    +(Math.pow(r,num_of_parellel_servers))
                    *((1-Math.pow(p,k-num_of_parellel_servers+1))
                    /(1-p)));

        }else if(p==1){

            double first_term_result = 0;

            for(int i =0;i<=num_of_parellel_servers-1;i++){

                first_term_result +=((Math.pow(r,i))/(vactorial(i)));

            }
            return 1/(first_term_result +
                    (Math.pow(r,num_of_parellel_servers)
                            /vactorial((int)num_of_parellel_servers))
                            *(k-num_of_parellel_servers+1));



        }else{
            //error
        }
        return 0;
    }

    double calc_pn(int n){
        if(n>=0 && n< num_of_parellel_servers){

            return ((Math.pow(r,n)/vactorial(n))*po);

        }else if(n>= num_of_parellel_servers &&n <k){

            return (Math.pow(r,n)
                    /(Math.pow(num_of_parellel_servers,n-num_of_parellel_servers)
                    *vactorial((int)num_of_parellel_servers)))*po;

        }else{
            // error
        }
        return 0;
    }


    double calc_Lq(){
        return (double)
                (((p*Math.pow(r,num_of_parellel_servers)*po)
                        /(vactorial((int)num_of_parellel_servers) *Math.pow(1-p,2)))
                        *(1-Math.pow(p,k-num_of_parellel_servers+1)
                        -((1-p)*(k-num_of_parellel_servers+1)*Math.pow(p,k-num_of_parellel_servers))));
    }


    double calc_l(){
        int last_term_result =0 ;

        for (int i =0 ; i<=num_of_parellel_servers-1;i++){
            last_term_result += ((num_of_parellel_servers-i)*(Math.pow(r,i)/vactorial(i)));
        }

        return (double) (calc_Lq() + num_of_parellel_servers - po*last_term_result);
    }

    double calc_wq(){
        return (calc_Lq()/(arrival_rate*(1-calc_pn(k))));
    }

    double calc_w(){
        return calc_l()/(arrival_rate*(1-calc_pn(k)));
    }

    int vactorial(int num){
        if (num  > 1) {
            return num*vactorial(num-1);
        }
        return 1;
    }

}
