/**
 * The Reservation class represents a reservation within Hotel. 
 * It holds information such as guest name, room information, 
 * and dates relating to the user’s reservation.
 * @author Erin Gabrielle Chua
 * @author Andre Gabriel Llanes
 */
public class Reservation {
    
    private String roomName;
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private double total;

    /**
     * A Reservation is created when a Room name, guest name, check-in date, 
     * and check-out date is provided
     * @param roomName
     * @param guestName
     * @param checkInDate
     * @param checkOutDate
     */
    public Reservation (String roomName, String guestName, int checkInDate, int  checkOutDate){
        this.roomName = roomName;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    /** 
     * This method returns the name of the Room booked in Reservation
     * @return roomName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * This method returns the name of the guest 
     * @return guestName
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * This method returns the day of check-in for the Reservation
     * @return checkInDate
     */
    public int getCheckInDate(){
        return checkInDate;
    }

    /**
     * This method returns the day of check-out for the Reservation
     * @return checkOutDate
     */
    public int getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * This method returns the amount of nights stayed by the guest
     * @return total
     */
    public double getNightsStayed() {
        int days = checkOutDate - checkInDate;
        return days;
    }

    public void setTotal(double total){
        this.total = total;
    }

    public double getTotal(){
        return total;
    }

}