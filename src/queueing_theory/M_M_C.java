package queueing_theory;

public class M_M_C {

    double num_of_parellel_servers = 0;  // c:number of parellel servers

    double service_time , arrival_time ;     //        1/μ  ,   1/λ
    double service_rate, arrival_rate;



    double r, p , po ;



    M_M_C(){

    }


    M_M_C num_of_parellel_servers(int n_o_p_s){
        this.num_of_parellel_servers =n_o_p_s;
        return this;
    }

    M_M_C service_time(double ser_t){
        this.service_time =ser_t;
        service_rate = 1/service_time;
        return this;
    }

    M_M_C arrival_time(double arr_t){
        this.arrival_time =arr_t;
        arrival_rate = 1/arrival_time;
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
        if(p<1){

            double first_term_result = 0;

            for(int i =0;i<=num_of_parellel_servers-1;i++){

                first_term_result +=(Math.pow(r,i)/vactorial(i));

            }

            return 1/(first_term_result
                    +(num_of_parellel_servers *Math.pow(r,num_of_parellel_servers)
                    /vactorial((int)num_of_parellel_servers) *(num_of_parellel_servers-r)));
        }else if(p>=1){

            double first_term_result = 0;

            for(int i =0;i<=num_of_parellel_servers-1;i++){

                first_term_result +=(1/vactorial(i))*(Math.pow((service_time/arrival_time),i));

            }
            return 1/(first_term_result +
                    ((((1/vactorial((int)num_of_parellel_servers))
                            *(Math.pow((service_time/arrival_time),num_of_parellel_servers)))
                            *((num_of_parellel_servers*service_rate)/(num_of_parellel_servers*service_rate-arrival_rate)))));



        }else{
            //error
        }
        return 0;
    }

    double calc_pn(int n){
        if(n>=0 && n< num_of_parellel_servers){

            return ((Math.pow(arrival_rate,n)/vactorial(n)*Math.pow(service_rate,n))*po);

        }else if(n>= num_of_parellel_servers){

            return ((Math.pow(arrival_rate,n)
                    /Math.pow(num_of_parellel_servers,n-num_of_parellel_servers)
                    *vactorial((int)num_of_parellel_servers)
                    *Math.pow(service_rate,n)*po));

        }else{
            // error
        }
        return 0;
    }


    double calc_Lq(){
        return (double)
                ((Math.pow(r,num_of_parellel_servers+1) /num_of_parellel_servers)
                        /(vactorial((int)num_of_parellel_servers)
                        *Math.pow((1-(r/num_of_parellel_servers)),2)))*po;
    }


    double calc_l(){
        return (double) (calc_Lq()+(service_time/ arrival_time));
    }

    double calc_wq(){
        return calc_Lq()*arrival_time;
    }

    double calc_w(){
        return calc_wq()+service_time;
    }

    int vactorial(int num){
        if (num  > 1) {
         return num*vactorial(num-1);
        }
        return 1;
    }

}
