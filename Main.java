import java.util.Random;
import java.util.Scanner; 


public class Main{
 
 public static int getArrivalDays(){
  int[] ArrivalDay = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};  
  Random rnd = new Random();
  int randomIndex  = rnd.nextInt(ArrivalDay.length);
  return ArrivalDay[randomIndex];
   }   
  public static int getStayingDays(){
  int[] StayingDays = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};    
  Random rnd = new  Random();
  int randomIndex = rnd.nextInt(StayingDays.length);
  return StayingDays[randomIndex];
 }
 public static int getNumberPeople(){   
  int[] NumberPeople = {1,2,3,4,5};
  Random rnd = new Random();
  int randomIndex = rnd.nextInt(NumberPeople.length);
  return NumberPeople[randomIndex];   
  }   
 public static String getNameString() {
  String STRINGCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
  StringBuilder name = new StringBuilder();
  Random rnd = new Random();
  while (name.length() < 18) { 
   int index = (int) (rnd.nextFloat() * STRINGCHARS.length());
   name.append(STRINGCHARS.charAt(index));
  }
  String nameStr = name.toString();
  return nameStr;
 }  
    
 public static void main(String args[]){

   hotel Hotel = new hotel();
   room_type_1 room_1 = new room_type_1() ;
   room_1.room_id = 1;
   room_1.price_per_day = 20 ;
   room_type_1 room_2 = new room_type_1() ;
   room_2.room_id = 2;
   room_2.price_per_day = 10 ;
   room_type_2 room_3 = new room_type_2() ;
   room_3.room_id = 3;
   room_3.discount_per_day = 5;
   room_3.price_per_day = 20 ;
   room_type_2 room_4 = new room_type_2() ;
   room_4.room_id = 4;
   room_4.discount_per_day = 10;
   room_4.price_per_day = 30;
   room_type_3 room_5 = new room_type_3() ;
   room_5.room_id = 5;
   room_5.min_people = 2;
   room_5.min_days = 2 ;
   room_5.price_per_person = 10;
   room_type_3 room_6 = new room_type_3() ;
   room_6.room_id = 6;
   room_6.min_people = 3;
   room_6.min_days = 3;
   room_6.price_per_person = 20 ;
   room_type_4 room_7 = new room_type_4() ;
   room_7.room_id = 7;
   room_7.price_per_person = 20 ;
   room_type_4 room_8 = new room_type_4() ;
   room_8.room_id = 8;
   room_8.price_per_person = 10;
   room_type_5 room_9 = new room_type_5() ;
   room_9.room_id = 9;
   room_9.price_per_person = 20;
   room_type_5 room_10 = new room_type_5() ;
   room_10.room_id = 10;
   room_10.price_per_person = 10 ;
   
   
   Hotel.add_room(room_1);
   Hotel.add_room(room_2);
   Hotel.add_room(room_3);
   Hotel.add_room(room_4);
   Hotel.add_room(room_5);
   Hotel.add_room(room_6);
   Hotel.add_room(room_7);
   Hotel.add_room(room_8);
   Hotel.add_room(room_9);
   Hotel.add_room(room_10);
   
 
   
   boolean main_counter  = true ;
   
   while(main_counter = true){
   int Day_of_Arrival = getArrivalDays();
   int Num_of_days_Staying = getStayingDays();
   if( Num_of_days_Staying + Day_of_Arrival <=30){
    kratisi RandomReserv = new kratisi(getNameString(),Day_of_Arrival,Num_of_days_Staying,getNumberPeople()) ;
    Hotel.add_reserv(RandomReserv);  
    if(Math.random() <=  0.25){
     Random rnd = new Random();
     int canceled_reserv_number = rnd.nextInt(Hotel.reservation_list.size());  
     Hotel.reservation_list.remove(Hotel.rertieve_reservation(canceled_reserv_number));
     System.out.println("A Reservation with ID "+ canceled_reserv_number+" was canceled\n");
    }
   
    Scanner User_input = new Scanner(System.in) ;
    System.out.println("Press 1 for next repetition\nPress 2 to add a reservation.\nPress 3 to cancel a reservation.\nPress 4 to show reservations.\nPress 5 to show rooms.\nPress 6 to show reservation plan.\nPress 7 to show income.\nPress 8 for shutdown\n");
    int Entered_Number = User_input.nextInt() ;
    
    if( Entered_Number == 1){}
    else if(Entered_Number == 2){
        
        System.out.println("Plese enter name:(max 18 characters)");
        String Name = User_input.next();
        System.out.println("Please enter day of arrival:");
        int Arrival =  User_input.nextInt() ;
        System.out.println("Please enter the number of Staying Days:");
        int StayingDays = User_input.nextInt();
        System.out.println("Please enter the number of people staying:(max number 6)");
        int NumberofPeople = User_input.nextInt();
        System.out.println("Do you want a specific room? (yes or no)");
        String check = User_input.next();
        String yes = "yes";
        String no = "no";
           
        kratisi reserv_add = new kratisi(Name,Arrival,StayingDays,NumberofPeople);
        if(yes.equals(check)){ 
             System.out.println("Please enter room id:");
             int RoomID = User_input.nextInt();
             Hotel.add_reserv_room(reserv_add = new kratisi(Name,Arrival,StayingDays,NumberofPeople), RoomID);
         }else if(no.equals(check)){Hotel.add_reserv(reserv_add);}
    }else if(Entered_Number == 3){
         System.out.println("Please enter the reservation ID");
         int ReservID = User_input.nextInt();
         Hotel.cancel_reservation(ReservID);
    }else if(Entered_Number == 4){
          System.out.println("Reservation ID\tCustomer Name\tRoom ID");
          for(int i = 0 ; i < Hotel.reservation_list.size(); i++){
          System.out.println( Hotel.reservation_list.get(i).reservation_number + "\t" +  Hotel.reservation_list.get(i).customer_name + "\t"+ Hotel.reservation_list.get(i).roomid.room_id);
        }
    }else if(Entered_Number == 5){
          System.out.println("Room ID\tFullness\tIncome");
          for(int i = 0 ; i < Hotel.room_list.size(); i++){
          System.out.println(Hotel.room_list.get(i).room_id+"\t" + Hotel.room_list.get(i).Fullness() +"\t"+Hotel.room_list.get(i).pricing());
        }
    }else if(Entered_Number == 6){
        Hotel.Room_plan();
    }else if(Entered_Number == 7){
        System.out.println("Do you want to see the income of a single room? (yes or no)");
        String check = User_input.next();
        String no = "no";
        String yes = "yes"; 
        if (no.equals(check)){System.out.println(Hotel.price_calculate());
        }else if(yes.equals(check)){ 
            System.out.println("Please enter room id:");
            int roomID = User_input.nextInt();
            System.out.println(Hotel.price_calculate(roomID));}
        
    }else if(Entered_Number == 8){
        break ;
    }else if(Entered_Number != 8 && Entered_Number !=7 && Entered_Number !=6 && Entered_Number !=5 && Entered_Number !=4 && Entered_Number !=3 && Entered_Number !=2 && Entered_Number !=1){
        System.out.println("Please Enter a valid Menu Number");
    }
   }
  }
 }
}
