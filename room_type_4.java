/** Se auto to domatio tha exoume auxisi tis timis kata 10% stis ektes kai ebdomes thesis tou pinaka
 * diathesimotitas. Diladi prota tha exoume ekptosi stin thesi 5 meta stin  thesi
 * 6 epita stin thesi 12 ktlp.(Xekiname apo ti thesi 5 giati o pinakas xekinaei apo ti
 * thesi 0)
 **/

public class room_type_4 extends room
{
  
    
 public double  pricing() { 
     
     
      double price_current_day = 0 ;
      double total_price = 0 ;
      int[] price_increase_days = {5,6,12,13,19,20,26,27};
      
   for(int i = 0 ; i< availability_table.length ; i++){
       if(availability_table[i] != null){
       Num_people = availability_table[i].getNum_people();
       double price_per_day = Num_people*price_per_person ;
      
        for(int y = 0 ; y < price_increase_days.length ; y++){
          if ( i == price_increase_days[y]){
              price_current_day = price_per_day + price_per_day * 0.1 ;
              break; 
              }else{ price_current_day = price_per_day ;}
            }
            total_price = total_price + price_current_day ;
      }
      
    }
    return total_price ;
   } 
 public boolean Cancel (int Reservation_num){
       return false ;
   }
}
