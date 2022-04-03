/** Se auto to domatio tha exoume ekptosi an ta atoma einai 3 (20%) kai akoma
 * kai akoma megaliteri ekptosi an ta atoma einai 4 kai panw(30%)
 */

public class room_type_5 extends room
{
    public double  pricing() { 
      
      double price_current_day ;
      double total_price = 0 ;
      
     for(int i = 0 ; i< availability_table.length ; i++){

      if(availability_table[i] != null){
       Num_people = availability_table[i].getNum_people();
        if(Num_people >= 3){
            
         price_current_day = Num_people * price_per_person - Num_people * price_per_person * 0.2;
         
         if(Num_people >= 4){
             
           price_current_day = Num_people * price_per_person - Num_people * price_per_person * 0.3;  
            
        }
       }else { price_current_day = Num_people*price_per_person ;}
       total_price = total_price + price_current_day ;
      }
      
    }
    return total_price ;
   }
   public boolean Cancel (int Reservation_num){
       return false ;
   }
}