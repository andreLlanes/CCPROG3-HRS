import java.util.ArrayList;
import java.util.Scanner;
/**
 * The Hotel class represents a hotel within the Hotel Reservation System. 
 * It contains methods that allow for the user to manage its information, 
 * rooms, and reservations.
 * @author Erin Gabrielle Chua
 * @author Andre Gabriel Llanes
 */
public class Hotel {
    
    private String name;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    private static ArrayList<Day> days = new ArrayList<Day>();

    /**
     * A Hotel is created by providing a name for the Hotel. 
     * The constructor also automatically creates 30 rooms when 
     * a new Hotel is made.
     * @param name
     */
    public Hotel (String name){
        String temp;
        int i;
    
        this.name = name;
        
        //initialize 30 rooms, currently there will only be 10 of each type of room
        char character;

        //standard rooms, naming convention S1A, S1B, ...., S5J
        character = 'A';
        for (i = 0; i < 10; i++){
            temp = "S" + "1" + Character.toString(character);
            rooms.add(new StandardRoom(temp));
            character++;
        }

        //deluxe rooms, naming convention D1A, D1B, ...., D5J
        character = 'A';
        for (i = 0; i < 10; i++){
            temp = "D" + "2" + Character.toString(character);
            rooms.add(new DeluxeRoom(temp));
            character++;
        }

        //executive rooms, naming convention EX1A, EX1B, ...., EX5J
        character = 'A';
        for (i = 0; i < 10; i++){
            temp = "E" + "3" + Character.toString(character);
            rooms.add(new ExecutiveRoom(temp));
            character++;
        } 

        //initialize days
        for(i = 1; i <= 31; i++){
            days.add(new Day(i, 1));
        }
        
    }
    
    public Hotel() {
        int i, j;
        String temp;
    
        //initialize 30 rooms, currently there will only be 10 of each type of room
        char character;

        //standard rooms, naming convention S1A, S1B, ...., S5J
        character = 'A';
        for (i = 0; i < 10; i++){
            temp = "S" + "1" + Character.toString(character);
            rooms.add(new StandardRoom(temp));
            character++;
        }

        //deluxe rooms, naming convention D1A, D1B, ...., D5J
        character = 'A';
        for (i = 0; i < 10; i++){
            temp = "D" + "2" + Character.toString(character);
            rooms.add(new DeluxeRoom(temp));
            character++;
        }

        //executive rooms, naming convention EX1A, EX1B, ...., EX5J
        character = 'A';
        for (i = 0; i < 10; i++){
            temp = "E" + "3" + Character.toString(character);
            rooms.add(new ExecutiveRoom(temp));
            character++;
        } 

        //initialize days
        for(i = 1; i <= 31; i++){
            days.add(new Day(i, 1));
        }
    }

    /**
     * This method allows the user to change the name of Hotel.
     * @param name
     */
    public void setHotelName(String name){
        this.name = name;
    }

    /**
     * This method takes in a number of Rooms and creates new 
     * Rooms according to the provided amount, it also creates 
     * names for the Rooms then stores it accordingly in a Room 
     * ArrayList within Hotel.
     * @param roomsAdded
     */
    public void addHotelRooms(int roomsAdded, int choice) {
        String newRoomName;
        String lastRoomName = rooms.get(rooms.size() - 1).getName();
        
        int lastDigit = Character.getNumericValue(lastRoomName.charAt(1));
        char lastChar = lastRoomName.charAt(2);
        
        for (int i = 0; i < roomsAdded; i++) {
            if (lastChar == 'J') {
                lastChar = 'A';
                lastDigit++;
            } else {
                lastChar++;
            }
            
            switch(choice) {
                case 1: 
                    newRoomName = "S" + lastDigit + lastChar;
                    rooms.add(new StandardRoom(newRoomName));
                    break;
                case 2:
                    newRoomName = "D" + lastDigit + lastChar;
                    rooms.add(new DeluxeRoom(newRoomName));
                    break;
                case 3: 
                    newRoomName = "E" + lastDigit + lastChar;
                    rooms.add(new ExecutiveRoom(newRoomName));
                    break;
            }
        }
    }

    /**
     * This method returns the name of the Hotel
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns an ArrayList of Room, 
     * or Rooms present in the Hotel.
     * @return rooms
     */
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    
    /**
     * This method returns an ArrayList of Reservation, 
     * or Reservations present in the Hotel.
     * @return reservations
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    /**
     * This method returns an ArrayList of Day, 
     * or days with prices to be modified.
     * @return days
     */
    public ArrayList<Day> getDays(){
        return days;
    }

    /**
     * This method displays the high-level information of the Hotel
     */
    public void displayHighLevelInfo(){
        int i, j;
        double total = 0;

        if (!reservations.isEmpty()) {
            for(i = 0; i < reservations.size(); i++){
                total += reservations.get(i).getNightsStayed() * rooms.get(0).getBasePrice();
            }
        }

        System.out.println("Hotel name: " + name);
        System.out.println("Total number of rooms: " + rooms.size());
        System.out.println("Estimated total earnings: " + total);
    }

    /**
     * This method displays the low-level information of the Hotel
     */
    public void displayLowLevelInfo(){
        String roomChoice, reservationChoice;
        int choice, i, j, dateChoice;
        int roomsTaken = 0;
        boolean found = false;

        Scanner choiceScanner = new Scanner(System.in);
        System.out.println("[1] View rooms for a selected date");
        System.out.println("[2] View information about a room");
        System.out.println("[3] View information about a reservation");
        System.out.print("Select option: ");
        choice = choiceScanner.nextInt();

        switch(choice) {

        case 1: 
        int ctr = 0;

        Scanner dateScanner = new Scanner(System.in);
        System.out.print("Input the day to be viewed: ");
        dateChoice = dateScanner.nextInt();

        for (i = 0; i < reservations.size(); i++) {
            for (j = reservations.get(i).getCheckInDate(); j <= reservations.get(i).getCheckOutDate(); j++){
                if (dateChoice == j)
                    ctr++;
            }
        }

        System.out.println("ROOMS FOR JANUARY " + dateChoice + ":");
        System.out.println("Total number of available rooms: " + (rooms.size() - ctr));
        System.out.println("Total number of booked rooms: " + ctr);
        System.out.println();
        break;

        case 2:
        Room room = null;

        System.out.print("[ ");
        for(i = 1; i <= rooms.size(); i++){
            System.out.print(rooms.get(i-1).getName() + "| ");
            if(i%10 == 0 && i > 0)
                System.out.println();
        }
        System.out.println("]");

        Scanner roomScanner = new Scanner(System.in);
        System.out.print("Input the room name to be viewed: ");
        roomChoice = roomScanner.nextLine();

        for (i = 0; i < rooms.size() && !found; i++) {
            found = rooms.get(i).getName().equals(roomChoice);
            if(found)
                room = rooms.get(i);
        }

        if (found){
            System.out.println("ROOM INFO:");
            System.out.println("Room name:" + room.getName());
            System.out.println("Room price: " + room.getBasePrice());
            System.out.println("Days of room's availability in January: ");

            ArrayList<Integer> reserved = new ArrayList<Integer>();
            for(i = 0; i < reservations.size(); i++){ 
                if (reservations.get(i).getRoomName().equals(roomChoice)){
                    for(j = reservations.get(i).getCheckInDate(); j <= reservations.get(i).getCheckOutDate(); j++){
                        reserved.add(j);
                    }
                }
            }

            for(int day = 1; day <= 31; day++){
                if(!reserved.contains(day)){
                    System.out.print(day + ", ");
                }
            }

        }
        else
            System.out.println("Room not found.");

        System.out.println();
        break;

        case 3:
        Reservation reservation = null;

        Scanner reservationScanner = new Scanner(System.in);

        if (reservations.size() == 0){
            System.err.println("There are currently no reservations under hotel: "+ getName());
            return;
        } 
        else {
            for (i = 0; i < reservations.size(); i++){
                System.out.println(reservations.get(i).getGuestName());
            }
        }

        System.out.print("Input the guest's name: ");
        reservationChoice = reservationScanner.nextLine();

        found = false;
        for (i = 0; i < reservations.size() && !found; i++) {
            if (reservations.get(i).getGuestName().toLowerCase().equals(reservationChoice.toLowerCase())) {
                reservation = reservations.get(i);
                found = true;
            }
        }

    if (found){
        System.out.println("RESERVATION INFO:");
        System.out.println("Guest name:" + reservation.getGuestName());
        System.out.println("Room name: " + reservation.getRoomName());
        System.out.println();

        System.out.println("Check-in date: January " + reservation.getCheckInDate());
        System.out.println("Check-out date: January " + reservation.getCheckOutDate());
        System.out.println();

        System.out.println("Cost of room per night: " + rooms.get(0).getBasePrice());
        System.out.println("Total booking price: " + (reservation.getNightsStayed() * rooms.get(0).getBasePrice()));
        System.out.println();
        System.out.println("Breakdown of price per night: ");

        int daysBooked = reservation.getCheckOutDate() - reservation.getCheckInDate();
        for(j = 1; j <= daysBooked; j++){
            System.out.println("Day " + j + ": " + rooms.get(0).getBasePrice());
        }
    } else {
        System.out.println("Reservation not found.");
    }

    break;
        
        default:
            System.out.println("Invalid input.");
            break;
        }
        
    }
    
    public double totalEarnings(){
        double total = 0;

        for(int i = 0; i < reservations.size(); i++){
            total += reservations.get(i).getTotal();
        }

        return total;
    }
    
}