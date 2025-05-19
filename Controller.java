import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controller {
    private HotelGUI gui;
    private Model model;
    private ArrayList<String> hotelNames = new ArrayList<String>();
    private ArrayList<String> roomNames = new ArrayList<String>();
    private ArrayList<String> reservations = new ArrayList<String>();

    public  Controller (HotelGUI gui, Model model){
        this.gui = gui;
        this.model = model;

        setListeners();
    }

    private void setListeners() {
        this.gui.setFrontPageListener(new frontPageListener());
        this.gui.setCreateHotelListener(new createHotelListener());
        this.gui.setViewHotelListener(new viewHotelListener());
        this.gui.setManageHotelListener(new manageHotelListener());
        this.gui.setBookHotelListener(new bookHotelListener());
    }

    private void updateRoomList(String hotelName){
        roomNames.clear();
        boolean found = false;

        for(int i = 0; i < model.getHotelList().size() && !found; i++){
            Hotel hotel = model.getHotelList().get(i);
            String modelName = hotel.getName();

            if(hotelName.equals(modelName)){
                for(int j = 0; j < hotel.getRooms().size(); j++){
                    roomNames.add(hotel.getRooms().get(j).getName());
                }

                found = true;
            }
        }
    }

    private void updateReservationsList(String hotelName){
        reservations.clear();
        boolean found = false;

        for(int i = 0; i < model.getHotelList().size() && !found; i++){
            Hotel hotel = model.getHotelList().get(i);
            String modelName = hotel.getName();

            if(hotelName.equals(modelName)){
                for(int j = 0; j < hotel.getReservations().size(); j++){
                    reservations.add(hotel.getReservations().get(j).getGuestName() + "-" + hotel.getReservations().get(j).getRoomName());
                }

                found = true;
            }
        }
    }

    public class frontPageListener implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.getBtnCreate()) {
            System.out.println("Create button clicked");
            if(model.getHotelList().size() == 50){
                gui.displayPopUp("Maximum amount of hotels created.");
            }
            else{
                gui.createHotelPage(hotelNames);
            }
            
        }
        else if (e.getSource() == gui.getBtnView()) {
            System.out.println("View button clicked");
            gui.viewHotelPage();
        }
        else if (e.getSource() == gui.getBtnManage()) {
            System.out.println("Manage button clicked");
            if(model.getHotelList().isEmpty()){
                gui.displayPopUp("No hotels currently in the system.\nAdd hotels and try again.");
            }
            else{
                gui.manageHotelPage1();
            }
                        
        }
        else if (e.getSource() == gui.getBtnBook()) {
            System.out.println("Book button clicked");
            if(model.getHotelList().isEmpty()){
                gui.displayPopUp("No hotels currently in the system.\nAdd hotels and try again.");
            }
            else {
                gui.bookReservationPage(hotelNames, roomNames);
            }
        }

    }

}

    public class createHotelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == gui.getBtnBack()){
                System.out.println("back button pressed");
                gui.frontPage();
            }
            else if(e.getSource() == gui.getBtnEnter()){
                System.out.println("enter button pressed");
                String hotelName = gui.getHotelName();
                boolean status = model.createHotel(hotelName);

                if(status){
                    gui.displayPopUp("Hotel \"" + hotelName + "\" successfully created!");
                    hotelNames.add(hotelName);
                    gui.createHotelPage(hotelNames);
                }
                else if(!status){
                    gui.displayPopUp("Hotel named \"" + hotelName + "\" already taken, try again.");
                }

                gui.resetHotelTextField();
            }
        }
    
}

    public class viewHotelListener implements ActionListener{
        String name;
        int index = 0;
        boolean found = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed");
            if(e.getSource() == gui.getBtnBack()){
                gui.frontPage();
            }

            if(e.getSource() == gui.getBtnHighLevel()){
                name = gui.getSelectedHotelName();
                for(int i = 0; i < model.getHotelList().size()&&!found; i++){
                    if(name.equals(model.getHotelList().get(index).getName())){
                        index = i;
                        found = true;
                    }
                }
                int roomAmnt = model.getHotelList().get(index).getRooms().size();
                double total = model.getHotelList().get(index).totalEarnings();
                gui.viewHighLevelInfoPage(name, roomAmnt, total);
            }
            else if(e.getSource() == gui.getBtnLowLevel()){
                name = gui.getSelectedHotelName();

                for(int i = 0; i < model.getHotelList().size()&&!found; i++){
                    if(name.equals(model.getHotelList().get(index).getName())){
                        index = i;
                        found = true;
                    }
                }
                gui.viewLowLevelInfoPage();
            }
        }
        
    }

    public class manageHotelListener implements ActionListener{

        Hotel hotel = null;
        String name;
        int index = -1;
        int dayStart, dayEnd, currDay = 0;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed");
            if(e.getSource() == gui.getBtnBack()){
                gui.frontPage();
            }
            else if(e.getSource() == gui.getBtnFind()){
                String hotelName = gui.getSelectedHotelName();
                name = hotelName;
                boolean found = false;

                for(int i = 0; i < model.getHotelList().size() && !found; i++){
                    if(hotelName.equalsIgnoreCase(model.getHotelList().get(i).getName())){
                        index = i;
                        found = true;
                    }
                }
                
                if(found){
                    gui.manageHotelPage2();
                }

                gui.resetHotelTextField();
            }
            
            if(e.getSource() == gui.getBtnChangeName()){
                gui.changeHotelNamePage(name);
            }
            else if(e.getSource() == gui.getBtnAddRooms()){
                if(model.getHotelList().get(index).getRooms().size() >= 50){
                    gui.displayPopUp("Maximum amount of rooms currently in hotel.");
                }
                else{
                    updateRoomList(name);
                    gui.addHotelRoomsPage(roomNames);
                }
            }
            else if(e.getSource() == gui.getBtnRemoveRooms()){
                if(model.getHotelList().get(index).getRooms().isEmpty()){
                    gui.displayPopUp("No rooms in hotel");
                }
                else{
                    updateRoomList(name);
                    gui.removeRoomsPage(roomNames);
                }
            }
            else if(e.getSource() == gui.getBtnUpdatePrice()){
                double standardPrice = 0;
                double deluxePrice = 0;
                double executivePrice = 0;

                for(int i =0; i < model.getHotelList().get(index).getRooms().size(); i++){
                    if(model.getHotelList().get(index).getRooms().get(i).getName().charAt(0) == 'S'){
                        standardPrice = model.getHotelList().get(index).getRooms().get(i).getBasePrice();
                    }
                    else if(model.getHotelList().get(index).getRooms().get(i).getName().charAt(0) == 'D'){
                        deluxePrice = model.getHotelList().get(index).getRooms().get(i).getBasePrice();
                    }
                    else if(model.getHotelList().get(index).getRooms().get(i).getName().charAt(0) == 'E'){
                        executivePrice = model.getHotelList().get(index).getRooms().get(i).getBasePrice();
                    }
                }

                gui.updateBasePricePage(standardPrice, deluxePrice, executivePrice);
            }
            else if(e.getSource() == gui.getBtnRemoveRes()){
                if(model.getHotelList().get(index).getReservations().isEmpty()){
                    gui.displayPopUp("No existing reservations");
                }
                else {
                    updateReservationsList(name);
                    gui.removeReservationPage(reservations);
                }
            }
            else if(e.getSource() == gui.getBtnRemoveHotel()){
                int choice =gui.confirmationPopUp("Do you want to delete hotel " + name + "?");
        
                if (choice == JOptionPane.YES_OPTION) {
                    model.removeHotel(index);
                    hotelNames.remove(index);
                    gui.displayPopUp("Hotel " + name + " successfully deleted.");
                    gui.frontPage();
                }
                else if (choice == JOptionPane.NO_OPTION) {
                    
                }
            }
            else if(e.getSource() == gui.getBtnDateMod()){
                gui.dateModPage1();
            }
            
            if(e.getSource() == gui.getBtnChange()){
                String hotelName = gui.getHotelName();
                name = hotelName;

                model.changeHotelName(name, index);
                hotelNames.set(index, name);

                //for debugging
                for(int i = 0; i < model.getHotelList().size(); i++){
                    System.out.print(model.getHotelList().get(i).getName() + ", ");
                }

                gui.displayPopUp("Hotel name successfully changed.");
                gui.resetHotelTextField();
            }
            else if(e.getSource() == gui.getBtnAdd()){
                int amount = gui.getRoomAmount();
                String roomType = gui.getRoomType();

                model.addRooms(index, amount, roomType);

                //for debugging
                for (int i = 0; i < model.getHotelList().get(index).getRooms().size(); i++){
                    System.out.print(model.getHotelList().get(index).getRooms().get(i).getName() + ", ");
                }
                
                updateRoomList(name);
                gui.displayPopUp(amount + roomType.toLowerCase() + " rooms successfully made!");
                gui.addHotelRoomsPage(roomNames);

            }
            else if(e.getSource() == gui.getBtnRemove1()){
                String room = gui.getRoomName();

                model.removeRooms(index, room);

                //for debugging
                for (int i = 0; i < model.getHotelList().get(index).getRooms().size(); i++){
                    System.out.print(model.getHotelList().get(index).getRooms().get(i).getName() + ", ");
                }

                updateRoomList(name);
                gui.displayPopUp("Room " + room + " successfully removed.");
                gui.removeRoomsPage(roomNames);
            }
            else if(e.getSource() == gui.getBtnUpdate()){
                double standardPrice = 0;
                double deluxePrice = 0;
                double executivePrice = 0;
                double newBasePrice = gui.getNewBasePrice();

                int success = model.updatePrice(index, newBasePrice);
                

                switch (success) {
                    case 0:
                        gui.displayPopUp("Prices updated!");
                        
                        //debugging
                        for(int i =0; i < model.getHotelList().get(index).getRooms().size(); i++){
                            if(model.getHotelList().get(index).getRooms().get(i).getName().charAt(0) == 'S'){
                                standardPrice = model.getHotelList().get(index).getRooms().get(i).getBasePrice();
                            }
                            else if(model.getHotelList().get(index).getRooms().get(i).getName().charAt(0) == 'D'){
                                deluxePrice = model.getHotelList().get(index).getRooms().get(i).getBasePrice();
                            }
                            else if(model.getHotelList().get(index).getRooms().get(i).getName().charAt(0) == 'E'){
                                executivePrice = model.getHotelList().get(index).getRooms().get(i).getBasePrice();
                            }
                        }
                        gui.updateBasePricePage(standardPrice, deluxePrice, executivePrice);
                        break;
                    case 1: gui.displayPopUp("New price should be greater than PHP100.");
                        break;
                    case 2: gui.displayPopUp("There must be no reservations across all rooms.");
                        break;
                }
                
            }
            else if(e.getSource() == gui.getBtnRemove2()){
                String resName = gui.getReservation();

                model.removeReservation(index, resName);

                gui.displayPopUp("Reservation successfully removed!");
                updateReservationsList(name);
                gui.removeReservationPage(reservations);
            }
            else if(e.getSource() == gui.getBtnChooseDays()){
                dayStart = gui.getCheckInDate();
                dayEnd = gui.getCheckOutDate();

                for(int i = dayStart; i <= dayEnd; i++){
                    currDay = i;
                    gui.dateModPage2(i);
                }
            }
            else if(e.getSource() == gui.getBtnModify()){
                double change = gui.getModifiedChange();
                model.datePriceMod(index, currDay, change);
            }
        }
        
    }

    public class bookHotelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed");
            if(e.getSource() == gui.getBtnBack()){
                gui.frontPage();
            }
            else if(e.getSource() == gui.getBtnReserve()){
                String hotelName = gui.getSelectedHotelName();
                String guestName = gui.getGuestName();
                String roomName = gui.getRoomName();
                String discountCode = gui.getDiscountCode();
                int checkInDate = gui.getCheckInDate();
                int checkOutDate = gui.getCheckOutDate();

                int success = model.simulateBooking(hotelName, guestName, roomName, checkInDate, checkOutDate, discountCode);
                double total = model.getReservationTotal();

                switch(success){
                    case 0: gui.displayPopUp("Reservation for " + guestName + " successfully made!\nTotal for this reservation: " + total);
                            reservations.add(roomName + "-" + "guestName");
                        break;
                    case 1: gui.displayPopUp("Date invalid.");
                        break;
                    case 2: gui.displayPopUp("Conflicting reservations.");
                        break;
                    case 3: gui.displayPopUp("Discount code invalid.");
                        break;
                }
            }
            else if(e.getSource() == gui.getHotelBox()){
                updateRoomList(gui.getSelectedHotelName());
            }
        }
        
    }

}
