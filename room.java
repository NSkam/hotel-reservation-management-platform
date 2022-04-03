public class room{

    public int room_id ; /** kodikos domatiou **/
    private int max_space = 6 ; /** megistos arithmos atomon **/
    protected kratisi[] availability_table = new kratisi[30] ;
    protected int price_per_person ;
    protected int Staying_days ;
    protected int Arrival ;
    protected int Num_people ;
    protected boolean check ;
    
  public boolean add_reservation(kratisi reservation){
      
      check = true ;
      Staying_days = reservation.getStaying_days();
      Num_people  = reservation.getNum_people();
      Arrival = reservation.getArrival();
      
   for (int i = 0 ; i < Staying_days  ; i++ ){
       
    if (availability_table[Arrival+i-1] == null && Num_people <= max_space){  
          }
    else {
        check = false ;
          }
       }
   if ( check == true ) { 
       
          reservation.SetRoom(this) ;
          
     for (int i=0 ; i < Staying_days  ; i++ ){
         
          availability_table[Arrival+i] = reservation ;  
          
         
           }
        }
   else{
      return check;
       }
       return check;
    }
    
  public double  pricing() { 
      
      double price_current_day ;
      double total_price = 0 ;
      
   for(int i = 0 ; i< availability_table.length ; i++){
      if(availability_table[i] != null){
       Num_people = availability_table[i].getNum_people();
       price_current_day = Num_people*price_per_person ;
       total_price = total_price + price_current_day ;
            }

      }
      return total_price ;
    }
  public boolean Cancel(int Reservation_num){
   for(int i = 0 ; i< availability_table.length; i++){
      if(availability_table[i].reservation_number == Reservation_num){
          availability_table[i] = null;
        }
    }
    return true;
   }
   public int Fullness(){
       
       int days_full=0;
       int days_percentage;
       
   for(int i = 0 ; i< availability_table.length; i++){
      if(availability_table[i] != null){
         days_full++ ; 
        }
    }
   days_percentage= (days_full/30)*100; 
   
   return days_percentage;
  }
  
  public int getMax_space(){
        return this.max_space;
   }
 }
