public class kratisi{ 
    
    /** dilonoume tis metablites tis klasis **/
    
    public String customer_name ; 
    public int reservation_number ;
    private int arrival , staying_days , num_people ;
    public room  roomid = null ;
    private static int counter = 1 ; /** einai 1 gia na exoume reservation_number>0 **/
    
    public kratisi(String customer_name , int arrival ,int staying_days ,int num_people){
        this.customer_name = customer_name ;  
        this.arrival = arrival ;
        this.staying_days = staying_days;
        this.num_people = num_people;
        this.reservation_number = counter ;
        this.counter ++ ;
      
    }
    public void  SetRoom(room RoomToSet) {
    
        this.roomid = RoomToSet ; 
    }
    
      public int getStaying_days() {
        return this.staying_days;
    }
      public int getArrival(){
        return this.arrival;
    }
       public int getNum_people(){
        return this.num_people;
    }
}
