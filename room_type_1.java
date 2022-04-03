public class room_type_1 extends room{
    
    public double price_per_day ;
    
    public double  pricing() { 
      
      double total_price = 0 ;
      
    for(int i= 0; i< availability_table.length; i++){
     if(availability_table[i]!=null){
         total_price = total_price + price_per_day ;
        }
     }
     return total_price;
   }
   
   public double getPrice_per_day(){
       return this.price_per_day ;
    }   
}