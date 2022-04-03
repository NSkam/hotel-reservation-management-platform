public class room_type_3 extends room
{
    public int min_people ;
    public int min_days ;
    int Max_space ;
    
    public boolean add_reservation(kratisi reservation){
      
        check = true ;
        Staying_days = reservation.getStaying_days();
        Num_people  = reservation.getNum_people();
        Arrival = reservation.getArrival();

        
        
     if(Staying_days >= min_days && Num_people >= min_days){
      for (int i = 0 ; i < Staying_days  ; i++ ){
       if (availability_table[Arrival+i-1] == null && Num_people <= Max_space){  
       }
       else {
        check = false ;
          }
       }
     }else{check = false ; }
     if ( check =true ) { 
      for (int i=0; i < Staying_days  ; i++ ){
         
         availability_table[Arrival+i] = reservation ;
             
         reservation.SetRoom(this);
         
         
           }
        }
     else{
      return check;
        }
      return check;
       }
    
}