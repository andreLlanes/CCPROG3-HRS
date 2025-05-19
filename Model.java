import java.util.ArrayList;
import java.util.Scanner;
/**
 * The Main class handles the entire Hotel Reservation System (HRS). 
 * It provides a menu to create a hotel, view hotel information, manage 
 * hotels, and simulate bookings. The class takes in user input and edits 
 * the other classes related to the HRS accordingly.
 * @author Erin Gabrielle Chua
 * @author Andre Gabriel Llanes
 */
public class Model {

    private static ArrayList<Hotel> hotels = new ArrayList<Hotel>();
    private static double total = 0;
    private static Scanner scanner = new Scanner(System.in);

    public Model (){

    }

    /**
     * This method is the main menu of the HRS,
     * it is where users go to when starting and
     * ending actions in the HRS.
     */
    public void menu(){
        int choice = 0;
            
        System.out.println();
        System.out.println("-HOTEL RESERVATION SYSTEM-");
        System.out.println("[1] Create Hotel");
        System.out.println("[2] View Hotel");
        System.out.println("[3] Manage Hotel");
        System.out.println("[4] Simulate Booking");
        System.out.println();

        while (choice < 1 || choice > 4){
            System.out.print("Select option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if(choice < 1 && choice > 4)
                System.out.println("\nInvalid input");
        }
        
        switch(choice){
            case 1: createHotel();
                break;
            case 2: viewHotel();
                break;
            case 3: manageHotel();
                break;
            case 4: simulateBooking();
                break;
        }
    }

    /**
     * This method is a prompt that redirects user 
     * to menu() when the enter key is presssed 
     */
    public void returnPrompt(){
        System.out.println();
        System.out.print("Press ENTER to return to menu... ");
        scanner.nextLine();
        menu();
    }

    /**
     * This method allows the user to create a new instance of 
     * Hotel within the HRS and stores it inside a Hotel ArrayList. 
     * The method also checks if the new Hotel made by the user 
     * matches any other Hotels in the list.
     */
    public void createHotel(){
        String hotelName;
        boolean found = false;

        System.out.print("Enter a name for your hotel: ");
        hotelName = scanner.nextLine();

        Hotel newHotel = new Hotel(hotelName);
        
        if (hotels.isEmpty()){
            hotels.add(newHotel);
            System.out.println("Hotel named \"" + newHotel.getName() + "\" created.");
        }
        else {
            //Loop to find if hotel name is unique
            for (int i = 0; i < hotels.size(); i++){
                found = hotels.get(i).getName().toLowerCase().equals(hotelName.toLowerCase());
            }

            if (found){
                System.out.println("Name already taken.");
            }
            else {
                hotels.add(newHotel);
                System.out.println("Hotel named \"" + newHotel.getName() + "\" created.");
            }

        }
        returnPrompt();
    }

    /*
     * createHotel method for MVC architecture
     */
    public boolean createHotel(String hotelName) {
        boolean found = false;

        if (hotels.isEmpty()) {
            hotels.add(new Hotel(hotelName));
            System.out.println("Hotel named \"" + hotelName + "\" created.");
            return true;
        }
        else {
            for (int i = 0; i < hotels.size() && !found; i++) {
                if (hotels.get(i).getName().equalsIgnoreCase(hotelName)) {
                    found = true;
                }
            }

            if (found) {
                System.out.println("Name already taken.");
                return false;
            }
            else {
                hotels.add(new Hotel(hotelName));
                System.out.println("Hotel named \"" + hotelName + "\" created.");
                return true;
            }
        }
    }

    /**
     * This method allows user access to viewing the
     * low-level or high-level information of a
     * certain Hotel in the HRS
     */
    public void viewHotel(){
        int info;
        String temp;
        boolean found = false;
        Hotel hotel = null;

        if(hotels.isEmpty()){
            System.out.println("No hotels in the system");
            returnPrompt();
        }

        System.out.print("[ ");
        for (int i = 0; i < hotels.size(); i++) {
            System.out.print(hotels.get(i).getName() + ", ");
        }
        System.out.println("]");

        System.out.print("Choose hotel to view: ");
        temp = scanner.nextLine();

        //checking if hotel is already in the system (ArrayList)
        for (int i = 0; i < hotels.size() && found == false; i++){
            found = hotels.get(i).getName().toLowerCase().equals(temp.toLowerCase());
            if(found)
                hotel = hotels.get(i);
        }
            
        //condition if hotel is found or not found
        if (found){
            Scanner choice = new Scanner(System.in);
            System.out.println("[1] View high level information");
            System.out.println("[2] View low level information");
            System.out.println();
            System.out.print("Select option: ");
            info = choice.nextInt();

            switch (info) {
                case 1:
                    hotel.displayHighLevelInfo();
                    break;
                case 2:
                    hotel.displayLowLevelInfo();
                    returnPrompt();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        else 
            System.out.println("Hotel not found.");

        returnPrompt();
    }

    /**
     * This method allows the user to make edits to the contents 
     * of their selected Hotel. This includes the ability to choose 
     * from the following options: 
     * 
     * 1. Change the name of the selected hotel
     * 2. Add rooms in the selected hotel
     * 3. Remove rooms in the selected hotel
     * 4. Update the base price of rooms in the selected hotel
     * 5. Removing a reservation in the selected hotel
     * 6. Removing the selected hotel from the HRS
     */
    public void manageHotel(){
        int choice, i; 
        String hotelName;
        boolean found = false;
        Hotel hotel = null;

        if(hotels.isEmpty()){
            System.out.println("No hotels in the system");
            returnPrompt();
        }

        //printing hotel names
        System.out.println("HOTELS: ");
        System.out.print("[ ");
        for(i = 0; i < hotels.size(); i++){
            System.out.print(hotels.get(i).getName() + ", ");
        }
        System.out.println("]");

        System.out.print("Choose hotel to view: ");
        hotelName = scanner.nextLine();

        //finding if hotel exists in the system
        for (i = 0; i < hotels.size() && !found; i++){
            found = hotels.get(i).getName().toLowerCase().equals(hotelName.toLowerCase());
            if(found)
                hotel = hotels.get(i);
        }

        if(found == false){
            System.out.println("Hotel does not exist.");
            returnPrompt();
        }

        System.out.println();
        System.out.println("[1] Change hotel name");
        System.out.println("[2] Add rooms");
        System.out.println("[3] Remove rooms");
        System.out.println("[4] Update room base price");
        System.out.println("[5] Remove reservation");
        System.out.println("[6] Remove hotel");
        System.out.println("[7] Date price modifier");
        System.out.println();
        System.out.print("Select option: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice){

            case 1: //CHANGE NAME OF HOTEL 
                String newName;
                found = false;

                System.out.println();
                System.out.print("Input new name for hotel \"" + hotel.getName() + "\": ");
                newName = scanner.nextLine();

                //Finding if name matches any other name in the HRS
                for (i = 0; i < hotels.size() && !found; i++){
                    found = hotels.get(i).getName().toLowerCase().equals(newName.toLowerCase());
                }

                if (!found){
                    hotel.setHotelName(newName);
                    System.out.println("Hotel successfully renamed \"" + newName + "\".");
                }
                else {
                    System.out.println("Hotel name already taken.");
                }
                break;

            case 2: //ADD ROOMS
                int newRooms;

                if (hotel.getRooms().size() >= 50){
                    System.out.println("Maximum amount of rooms reached.");
                    returnPrompt();
                }

                System.out.println("Current number of rooms in hotel \"" + hotel.getName() + "\": " + hotel.getRooms().size());
                
                System.out.println("[1] Standard Room");
                System.out.println("[2] Deluxe Room");
                System.out.println("[3] Standard Room");
                System.out.print("Please enter the room type of room to be added:");
                choice = scanner.nextInt();

                System.out.print("Input new number of rooms for hotel \"" + hotel.getName() + "\": ");
                newRooms = scanner.nextInt();

                //Loop to determine if amount added is valid 
                while(newRooms > 50 - hotel.getRooms().size() || newRooms < 1){
                    System.out.println("Invalid amount");
                    System.out.print("Input new number of rooms for hotel " + hotel.getName() + ": ");
                    newRooms = scanner.nextInt();
                }

                hotel.addHotelRooms(newRooms, choice);
                System.out.println("New rooms successfully added.");
                break;

            case 3: //REMOVE ROOMS
                String roomRemove;
                found = false;

                System.out.print("[ ");
                for(i = 0; i < hotel.getRooms().size(); i++){
                    System.out.print(hotel.getRooms().get(i).getName() + "| ");
                    if(i%10 == 0 && i > 0)
                        System.out.println();
                }
                System.out.println("]");

                System.out.print("Input name of room to remove: ");
                roomRemove = scanner.nextLine();
                
                //Loop to check if room currently has a reservation 
                for(i = 0; i < hotel.getReservations().size() && !found; i++){
                    found = hotel.getReservations().get(i).getRoomName().toLowerCase().equals(roomRemove.toLowerCase());
                }
             
                //Condition to remove specific room 
                if(!found){
                    for(i = 0; i < hotel.getRooms().size(); i++){
                        if(hotel.getRooms().get(i).getName().equals(roomRemove)){
                            hotel.getRooms().remove(i);
                            System.out.println("Room successfully removed.");
                        }
                    }
                    
                }
                else {
                    System.out.println("Removal unsuccessful, room currently reserved.");
                }
                break;
                
            case 4: //UPDATE BASE PRICE
                double newBasePrice;

                //Condition to check if there are active reservations
                if (hotel.getReservations().isEmpty()){
                    System.out.println("Minimum base price is $100.");
                    System.out.print("Enter new base price for rooms in \"" + hotel.getName() + "\": ");
                    newBasePrice = scanner.nextDouble();

                    while(newBasePrice < 100){
                        System.out.println("Price must be at least $100, try again.");
                        System.out.print("Enter new base price for rooms: ");
                        newBasePrice = scanner.nextDouble();
                    }    
                        
                    for(i = 0; i < hotel.getRooms().size(); i++){
                        hotel.getRooms().get(i).setBasePrice(newBasePrice);
                    }
                    System.out.println("Base price successfully updated to " + newBasePrice);
                }
                else {
                    System.out.println("There must be no reservations across all rooms.");
                }
                break;
            case 5: //REMOVE RESERVATION
                found = false;
                String removeRoomReservation;

                if(hotel.getReservations().isEmpty()){
                    System.out.println("No current reservations at this time.");
                    returnPrompt();
                }

                System.out.print("[ ");
                for(i= 0; i < hotel.getReservations().size(); i++){
                    System.out.print(hotel.getReservations().get(i).getGuestName() + ", ");
                }
                System.out.println("]");

                System.out.print("Input the guest's name associated with the reservation you would like to remove: ");
                removeRoomReservation = scanner.nextLine();
                
                //Determining if a reservation has a matching guest name with inputted name
                for (i = 0; i < hotel.getReservations().size(); i++){
                    found = hotel.getReservations().get(i).getGuestName().toLowerCase().equals(removeRoomReservation.toLowerCase());
                    if (found){
                        hotel.getReservations().remove(i);
                        System.out.println("Reservation successfully removed.");
                    }
                }

                if(!found){
                    System.out.println("Reservation not found.");
                }
                break;

            case 6: //REMOVE HOTEL
                String name;
                int removeHotel;

                name = hotel.getName();
                System.out.println("Please enter [1] to confirm your deletion of hotel \"" + name + "\" ");
                System.out.println("To cancel action enter [0]");
                System.out.print("Input your chosen action: ");
                removeHotel = scanner.nextInt();

                while(removeHotel != 1 && removeHotel != 0){
                    System.out.println("\nInvalid input");
                    System.out.print("Input your chosen action: ");
                    removeHotel = scanner.nextInt();
                }
                if(removeHotel == 1){
                    hotels.remove(hotel);
                    System.out.println("Deletion of hotel \"" + name + "\" completed.");
                }

                break;

            case 7: //date price mod
                int startDate, endDate;
                double change;

                System.out.println("Choose start date for price editing: ");
                startDate = scanner.nextInt();

                System.out.println("Choose end date for price editing: ");
                endDate = scanner.nextInt();

                if(startDate > 0 && endDate < 31 && startDate < endDate){
                    for(i = startDate; i <= endDate; i++){

                        System.out.println("Input price change in percentage for January " + i + " to " + (i+1) + ": ");
                        change = scanner.nextDouble();
                        hotel.getDays().get(i).setPriceChange(change);
                    }
                }
                else{
                    System.out.println("Invalid input.");
                    returnPrompt();
                }
            
                System.out.println("Prices successfully updated.");

                break;
        }
        returnPrompt();
    }

    /*
     * METHODS FOR MANAGE HOTEL FUNCTION IN MVC ARCHITECTURE
     */
    public void changeHotelName(String name, int index){
        hotels.get(index).setHotelName(name);
    }

    public void addRooms(int index, int amount, String type){
        Hotel hotel = hotels.get(index);

        if(type.equals("STANDARD")){
            hotel.addHotelRooms(amount, 1);
        }
        else if(type.equals("DELUXE")){
            hotel.addHotelRooms(amount, 2);
        }
        else if(type.equals("EXECUTIVE")){
            hotel.addHotelRooms(amount, 3);
        }
    }

    public void removeRooms(int index, String roomName){
        Hotel hotel = hotels.get(index);
        boolean found = false;

        for(int i = 0; i < hotel.getReservations().size() && !found; i++){
            found = hotel.getReservations().get(i).getRoomName().equals(roomName);
        }
        
        //Condition to remove specific room
        if(!found){
            for(int i = 0; i < hotel.getRooms().size(); i++){
                if(hotel.getRooms().get(i).getName().equals(roomName)){
                    Room roomToRemove = hotel.getRooms().get(i);
                    hotel.getRooms().remove(i);
                    roomToRemove = null;
                    System.out.println("Room successfully removed.");
                }
            }
            
        }
    }

    public int updatePrice(int index, double newPrice){
        int error = 0;
        Hotel hotel = hotels.get(index);

        //Condition to check if there are active reservations
        if (hotel.getReservations().isEmpty()){

            if(newPrice < 100){
                error = 1;
                return error;
            }
                
            for(int i = 0; i < hotel.getRooms().size(); i++){
                hotel.getRooms().get(i).setBasePrice(newPrice);
            }
        }
        else {
            error = 2;
        }

        return error;
    }

    public void removeReservation(int index, String resName){
        boolean found = false;
        Hotel hotel = hotels.get(index);

            //Determining if a reservation has a matching guest name with inputted name
            for (int i = 0; i < hotel.getReservations().size() && !found; i++){
                String reservationName = hotel.getReservations().get(i).getGuestName() + "-" +hotel.getReservations().get(i).getRoomName();
                if (reservationName.equals(resName)){
                    Reservation resToRemove = hotel.getReservations().get(i);
                    hotel.getReservations().remove(i);
                    resToRemove = null;
                    found = true;
                }
            }
    }

    public void removeHotel(int index){
        Hotel hotelToRemove = hotels.get(index);
        hotels.remove(index);
        hotelToRemove = null;
    }

    public void datePriceMod(int index, int date, double change){
        Hotel hotel = hotels.get(index);

        hotel.getDays().get(date-1).setPriceChange(change);
                
        //System.out.println("Prices successfully updated.");
    }
    
    /***************************************************************************************************/

    /**
     * This method updates the Reservation class with 
     * the needed information and provides the user with 
     * the ability to make a Reservation to be stored in 
     * the selected Hotel.
     */
    public void simulateBooking(){
        String hotelChoice;
        Hotel hotel = null;
        boolean found = false;
        int checkInDate = 0;
        int checkOutDate = 0;

        if(hotels.isEmpty()){
            System.out.println("No hotels in the system");
            returnPrompt();
        }

        System.out.println("HOTELS: ");
        System.out.print("[ ");
        for (int i = 0; i < hotels.size(); i++) {
            System.out.print(hotels.get(i).getName() + ", ");
        }
        System.out.println("]");

        System.out.print("Choose hotel to book: ");
        hotelChoice = scanner.nextLine();

        for(int i = 0; i < hotels.size() && !found; i++){
            found = hotels.get(i).getName().toLowerCase().equals(hotelChoice.toLowerCase());
            if (found)
                hotel = hotels.get(i);
        }

        if (found){
            System.out.println("Hotel " + hotel.getName() + " chosen.");
            
            System.out.print("Name of guest: ");
            String guestName = scanner.nextLine();
            System.out.println();

            System.out.println("Hotel rooms of " + hotel.getName() + ": ");

            System.out.print("[ ");
            for(int i = 1; i <= hotel.getRooms().size(); i++){
                System.out.print(hotel.getRooms().get(i-1).getName()+ " | ");
                if(i%10 == 0 && i > 0)
                    System.out.println();
            }
            System.out.println("]");

            double standardPrice = 0;
            double deluxePrice = 0;
            double executivePrice = 0;
            double price = 0;

            for(int i = 0; i < hotel.getRooms().size(); i++){
                if(hotel.getRooms().get(i).getName().startsWith("S")){
                    standardPrice = hotel.getRooms().get(i).getBasePrice();
                    price = standardPrice;
                }
                else if(hotel.getRooms().get(i).getName().startsWith("D")){
                    deluxePrice = hotel.getRooms().get(i).getBasePrice();
                    price = deluxePrice;
                }
                else if(hotel.getRooms().get(i).getName().startsWith("E")){
                    executivePrice = hotel.getRooms().get(i).getBasePrice();
                    price = executivePrice;
                }
            }

            System.out.println("\nRooms that start with 'S' are standard rooms: PHP " + standardPrice);
            System.out.println("Rooms that start with 'D' are deluxe rooms: PHP " + deluxePrice);
            System.out.println("Rooms that start with 'E' are executive rooms: PHP " + executivePrice);

            System.out.print("\nWhich room would you like to book?: ");
            String roomReserve = scanner.nextLine();

            boolean match = false;
            for (int k = 0; k < hotel.getRooms().size(); k++) {
                if (hotel.getRooms().get(k).getName().equals(roomReserve)) {
                match = true;
                }
            }
            while (!match) {
                System.out.println("Invalid input, enter [exit] to return: ");
                roomReserve = scanner.nextLine();
                if (roomReserve.equals("exit")) {
                    menu();
                    return; 
                }
                // Re-check the match condition after updating roomReserve
                match = false;
                for (int k = 0; k < hotel.getRooms().size(); k++) {
                    if (hotel.getRooms().get(k).getName().equals(roomReserve)) {
                    match = true;
                    }
                }
            }

            System.out.print("Please provide a check-in date (DD format): ");
            checkInDate = scanner.nextInt(); 

            if (checkInDate < 1 || checkInDate >= 31){
                while (checkInDate < 1 || checkInDate >= 31){ 
                    System.out.println("Invalid date");
                    System.out.print("Please provide a check-in date (DD format): ");
                    checkInDate = scanner.nextInt();
                }
            }

            for (int j = 0; j < hotel.getReservations().size(); j++){
                if (hotel.getReservations().get(j).getRoomName().equals(roomReserve)){
                    while (hotel.getReservations().get(j).getCheckInDate() <= checkInDate && checkInDate < hotel.getReservations().get(j).getCheckOutDate()){
                        System.out.println("There is already a reservation booked on that date.");
                        System.out.print("Please provide a check-in date (DD format): ");
                        checkInDate = scanner.nextInt();
                    }
                }
            }

            System.out.print("Please provide a check-out date (DD format): ");
            checkOutDate = scanner.nextInt();
            
            
            while (checkOutDate <= 1 || checkOutDate <= checkInDate || checkOutDate > 31){
                if (checkOutDate <= 1){
                    System.out.println("You cannot check-out at the start of the month");
                }
                else if (checkOutDate <= checkInDate){
                    System.out.print("Check out date must be a date after check-in date at least a day apart");
                }
                else {
                    System.out.println("Check-out dates canno go beyond the 31st");
                }
                System.out.print("Please provide a check-out date (DD format): ");
                checkOutDate = scanner.nextInt();
            }

            //checking if a specific date price has been modified
            total = 0;
            for(int i = 0; i < checkOutDate-checkInDate; i++){
                total = total + price*hotel.getDays().get(i).getPriceChange();
            }

            System.out.println("Current total: PHP " + total);
            System.out.println("Would you like to input any discount codes? [Y/N]: ");
            String choice = scanner.nextLine();

            String code = "";

            if(choice.equals("Y")){

                while (!code.equals("I_WORK_HERE") || !code.equals("STAY4_GET1") || !code.equals("PAYDAY")){
                    System.out.println("Input discount code here: ");
                    code = scanner.nextLine();

                    switch(code){
                        case "I_WORK_HERE": 
                        total = total*0.9;
                        break;
            
                        case "STAY4_GET1": 
                        if(checkOutDate - checkInDate >= 5){
                            total = total-price;
                        }
                        else {
                            System.out.println("Reservation does not meet conditions for Discount code \"STAY4_GET1\"");
                        }
                        break;
            
                        case "PAYDAY":
                        if(checkInDate == 15 || checkInDate == 30){
                            total = total*0.93;
                        }
                        else{
                            System.out.println("Reservation does not meet conditions for Discount code \"PAYDAY\"");
                        }

                        break;
            
                        default: System.out.println("Invalid discount code.");
                    }
                }
                
            }

            hotel.getReservations().add(new Reservation(roomReserve, guestName, checkInDate, checkOutDate));
            System.out.println("Reservation made successfully for " + guestName + " from January " + checkInDate + " to January " + checkOutDate);
            System.out.println("Total price for booking is: PHP " + total);

            }
            else {
                System.out.println("Hotel "+ hotelChoice + "not found.");
            }
        
            returnPrompt();
    }

    /*
     * simulateBooking method for the MVC architecture
     */
    public int simulateBooking(String hotelChoice, String guestName, String roomReserve, int checkInDate, int checkOutDate, String discountCode) {
        /*corresponding int value refers to a certain error with user input
         * if errror = 0, no errrors with booking, successful
         * if error = 1, date invalid
         * if error = 2, matching to an existing reservation
         * if error = 3, invalid discount code
         * if error = 4, no guest name
         */
        
        Hotel hotel = null;
        total = 0;
        int error = 0;
        boolean found = false;

        for(int i = 0; i < hotels.size() && !found; i++){
            if(hotels.get(i).getName().equalsIgnoreCase(hotelChoice)){
                hotel = hotels.get(i);
                found = true;
            }
        }

        if (guestName.isBlank()){
            error = 4;
            return error;
        }

        double price = 0;
    
        for(int i = 0; !roomReserve.equals(hotel.getRooms().get(i).getName()); i++){
            if(hotel.getRooms().get(i).getName().startsWith("S")){
                price = hotel.getRooms().get(i).getBasePrice();
            }
            else if(hotel.getRooms().get(i).getName().startsWith("D")){
                price = hotel.getRooms().get(i).getBasePrice();
            }
            else if(hotel.getRooms().get(i).getName().startsWith("E")){
                price = hotel.getRooms().get(i).getBasePrice();
            }
        }
    
        if (checkInDate > checkOutDate || checkOutDate < 2) {
            error = 1;
            return error;
        }
    
        found = false;
        for (int i = 0; i < hotel.getReservations().size(); i++){
            Reservation temp = hotel.getReservations().get(i);
            if (temp.getRoomName().equals(roomReserve) && temp.getCheckInDate() <= checkInDate && checkInDate < temp.getCheckOutDate()){
                found = true;
            }
        }

        if (found){
            error = 2;
            return error;
        }
    
        for(int i = 0; i < checkOutDate-checkInDate; i++){
            total += price*hotel.getDays().get(i).getPriceChange();
        }
    
        
        if (discountCode.isBlank()){
            if(error  == 0){
                Reservation newReservation = new Reservation(roomReserve, guestName, checkInDate, checkOutDate);
                newReservation.setTotal(total);

                hotel.getReservations().add(newReservation);
            }
    
            return error;
        }

        switch (discountCode) {
            case "I_WORK_HERE":
                total *= 0.9;
                break;
    
            case "STAY4_GET1":
                if (checkOutDate - checkInDate >= 5) {
                    total -= price;
                } else {
                    error = 3;
                }
                break;
    
            case "PAYDAY":
                if (checkInDate == 15 || checkInDate == 30) {
                    total *= 0.93;
                } else {
                    error = 3;
                }
                break;
    
            default:
                error = 3;
                break;
        }

        if(error == 3){
            return error;
        }
    
        if(error == 0){
            Reservation newReservation = new Reservation(roomReserve, guestName, checkInDate, checkOutDate);
            newReservation.setTotal(total);
            hotel.getReservations().add(newReservation);
        }
    
        return error;
    }
    
    public double getReservationTotal(){
        return total;
    }

    public ArrayList<Hotel> getHotelList(){
        return hotels;
    }
}