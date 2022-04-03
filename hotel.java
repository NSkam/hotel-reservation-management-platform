import java.util.List ;
import java.util.ArrayList ;

public class hotel
{
    private String hotel_name ;
    public List<room> room_list =  new ArrayList<room>() ;
    public List<kratisi> reservation_list = new ArrayList<kratisi> ();
  public void add_room (room RoomToAdd){
     room_list.add(RoomToAdd);
 }
  public room retrieve_room (int Room_id){
      room returned_room = null ;
   for( int i = 0 ; i < room_list.size() ; i++){
    if(Room_id == room_list.get(i).room_id){
     returned_room =  room_list.get(i) ;
     return returned_room ;
    } else{returned_room = null ;}
  }
  return returned_room ;
 }
 public kratisi rertieve_reservation (int Reservation_num){
     kratisi returned_reservation = null ;
   for(int i = 0 ; i< reservation_list.size() ; i++){
     if(Reservation_num == reservation_list.get(i).reservation_number){
       returned_reservation = reservation_list.get(i);
       return returned_reservation ;
    }else{ returned_reservation = null ;}     
  } 
  return returned_reservation ;
 }
  public boolean add_reserv_room( kratisi Reserv_to_add , int Room_id){
     
     room retrieved_room = retrieve_room(Room_id);
     boolean check_2 = retrieved_room.add_reservation(Reserv_to_add);
     
     if(check_2 == true){ 
         reservation_list.add(Reserv_to_add) ;
         System.out.println("The Reservation was successful") ;
         return true ;
        }else{
         System.out.println("The Reservation was unsuccessful");
         return false;
        }
 }
 public int add_reserv( kratisi reserv_add){
  for(int i = 0  ; i <  room_list.size() ; i++){
      int room_id = room_list.get(i).room_id ;
      room retrieved_room = retrieve_room(room_id);
      boolean check_3 = retrieved_room.add_reservation(reserv_add);
      if(check_3 == true){
          reservation_list.add(reserv_add) ;
          System.out.println("The Reservation was successful and was added to the room with ID: "+ room_id) ;
          return room_id ;
        
        } else {
        }
     }
     System.out.println("The Reservation was unsuccessful");
     return 0 ;
 }
 public void cancel_reservation(int reservation_num){
   kratisi reserv_to_cancel = rertieve_reservation (reservation_num);
   if(reserv_to_cancel == null){
       System.out.println("The reservation was not found");
    }else{
       reserv_to_cancel.roomid.Cancel(reservation_num) ; 
       reservation_list.remove(reserv_to_cancel);
      System.out.println("The reservation was successfully canceled");
    }
 }
 public double price_calculate(int room_id){
    room room_calculate = retrieve_room(room_id) ;
    double room_price = room_calculate.pricing() ;
    return room_price ;
   }
 public double price_calculate(){
     
     double room_price ;
     double total_room_price = 0 ;
     
  for(int i = 1 ; i < room_list.size()+1 ; i++){
      room room_calculate = retrieve_room(i);
      room_price = room_calculate.pricing() ;
      total_room_price = total_room_price + room_price ; 
  }
  return total_room_price ;
 }
 public void Room_plan(){
     System.out.println("Room    01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30");
     for(int i = 1 ; i < room_list.size()+1 ; i++){
      room room_calculate = retrieve_room(i);  
      System.out.printf(room_calculate.room_id + "\t");
     for ( int y = 0 ; y < 29 ; y++){
      if( room_calculate.availability_table[y] != null){
         System.out.printf("*  ");
        }else{
         System.out.printf("_  ");}
        }
     if( room_calculate.availability_table[29] != null){
         System.out.printf("*\n");
        }else{
         System.out.printf("_\n");}
  }
 }
}
