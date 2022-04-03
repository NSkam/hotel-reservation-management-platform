public class room_type_2 extends room_type_1{
    
   public double discount_per_day ; 
   double price_per_day ;
   
   public double  pricing() { 
      int Counter = 0 ; /** counter gia tis meres**/
      double price_current_day = price_per_day;  
      double total_price = 0 ;
      
     for(int i= 0; i< availability_table.length; i++){
      if(availability_table[i]!=null){
        if(price_current_day >= price_per_day/2){
            price_current_day = price_per_day  - discount_per_day*Counter;
            Counter++;
        } 
        if( price_current_day <= price_per_day/2){
            price_current_day= price_per_day/2;
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
     
   