import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HotelGUI extends JFrame{


    //general variables
    private JButton btnBack;
    private JTextField hotelNameTextBox;

    //variables for main page
    private JButton btnCreate;
    private JButton btnView;
    private JButton btnManage;
    private JButton btnBook;

    //variables for create hotel page
    private JButton btnEnter;

    //variables for view hotel page
    private JButton btnLowLevel;
    private JButton btnHighLevel;
    private JButton btnDateInfo;
    private JButton btnRoomInfo;
    private JButton btnReservationInfo;

    //variables for manage hotel page
    private JButton btnFind;
    private JButton btnChangeName;
    private JButton btnAddRooms;
    private JButton btnRemoveRooms;
    private JButton btnUpdatePrice;
    private JButton btnRemoveRes;
    private JButton btnRemoveHotel;
    private JButton btnDateMod;
    private JButton btnChange;
    private JButton btnAdd;
    private JButton btnRemove1;
    private JButton btnRemove2;
    private JButton btnUpdate;
    private JButton btnChooseDays;
    private JButton btnModify;
    private JComboBox roomTypesBox;
    private JComboBox reservationsBox;
    private JTextField amountRooms;
    private JTextField newBasePriceText;
    private JTextField modifiedChange;

    //variables for book hotel page
    private JComboBox hotelBox;
    private JTextField guestNameTextBox;
    private JComboBox roomNameBox;
    private JComboBox checkInDateBox;
    private JComboBox checkOutDateBox;
    private JTextField discountTextBox;
    private JButton btnReserve;

    public HotelGUI (){
        super ("Hotel Reservation System");
        setLayout(null);
        setSize(800, 600);

        setVariables();
        frontPage();

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVariables(){
        // Initialize buttons
        btnBack = new JButton();
        btnBack.setIcon(new ImageIcon("BACKBUTTON.png"));
        btnBack.setBounds(10, 10, 50, 50);
        btnBack.setBorder(BorderFactory.createEmptyBorder());
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusable(false);

        hotelNameTextBox = new JTextField(30);

        //create hotel variables
        btnEnter = new JButton();
        btnEnter.setIcon(new ImageIcon("ENTERBUTTON.png"));
        btnEnter.setBorder(BorderFactory.createEmptyBorder());
        btnEnter.setContentAreaFilled(false);
        btnEnter.setFocusable(false);

        btnCreate = new JButton();
        btnView = new JButton();
        btnManage = new JButton();
        btnBook = new JButton();

        //view hotel variables
        btnLowLevel = new JButton("Low level info");
        btnHighLevel = new JButton("High level info");
        btnDateInfo = new JButton("Date information");
        btnRoomInfo = new JButton("Room information");
        btnReservationInfo = new JButton("Reservation information");

        //manage hotel variables
        btnFind = new JButton();
        btnFind.setIcon(new ImageIcon("ENTERBUTTON.png"));
        btnFind.setBorder(BorderFactory.createEmptyBorder());
        btnFind.setContentAreaFilled(false);
        btnFind.setFocusable(false);

        btnChangeName = new JButton("Change hotel name");
        btnAddRooms = new JButton("Add rooms");
        btnRemoveRooms = new JButton("Remove rooms");
        btnUpdatePrice = new JButton("Update room prices");
        btnRemoveRes = new JButton("Remove reservation");
        btnRemoveHotel = new JButton("Delete hotel");
        btnDateMod = new JButton("Date price modifier");

        //manage hotel variables: change hotel name
        btnChange = new JButton();
        btnChange.setIcon(new ImageIcon("ENTERBUTTON.png"));
        btnChange.setBorder(BorderFactory.createEmptyBorder());
        btnChange.setContentAreaFilled(false);
        btnChange.setFocusable(false);

        //manage hotel variables: add rooms
        btnAdd = new JButton();
        btnAdd.setIcon(new ImageIcon("ENTERBUTTON.png"));
        btnAdd.setBorder(BorderFactory.createEmptyBorder());
        btnAdd.setContentAreaFilled(false);
        btnAdd.setFocusable(false);

        String[] roomTypeArr = {"STANDARD", "DELUXE", "EXECUTIVE"};
        roomTypesBox = new JComboBox(roomTypeArr);

        amountRooms = new JTextField(10);

        //manage hotel variables: remove rooms
        btnRemove1 = new JButton();
        btnRemove1.setIcon(new ImageIcon("ENTERBUTTON.png"));
        btnRemove1.setBorder(BorderFactory.createEmptyBorder());
        btnRemove1.setContentAreaFilled(false);
        btnRemove1.setFocusable(false);

        //manage hotel variables: update base price
        btnUpdate = new JButton();
        btnUpdate.setIcon(new ImageIcon("ENTERBUTTON.png"));
        btnUpdate.setBorder(BorderFactory.createEmptyBorder());
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setFocusable(false);

        newBasePriceText = new JTextField(10);

        //manage hotel variables: remove reservation
        btnRemove2 = new JButton();
        btnRemove2.setIcon(new ImageIcon("ENTERBUTTON.png"));
        btnRemove2.setBorder(BorderFactory.createEmptyBorder());
        btnRemove2.setContentAreaFilled(false);
        btnRemove2.setFocusable(false);

        reservationsBox = new JComboBox();

        //manage hotel variables: remove reservation
        btnChooseDays = new JButton();
        btnChooseDays.setIcon(new ImageIcon("ENTERBUTTON.png"));
        btnChooseDays.setBorder(BorderFactory.createEmptyBorder());
        btnChooseDays.setContentAreaFilled(false);
        btnChooseDays.setFocusable(false);

        btnModify = new JButton();
        btnModify.setIcon(new ImageIcon("ENTERBUTTON.png"));
        btnModify.setBorder(BorderFactory.createEmptyBorder());
        btnModify.setContentAreaFilled(false);
        btnModify.setFocusable(false);

        modifiedChange = new JTextField(10);

        //book hotel variables
        guestNameTextBox = new JTextField(30);
        roomNameBox = new JComboBox();
        roomNameBox.setSize(75, 25);
        hotelBox = new JComboBox();
        hotelBox.setSize(75, 25);
        checkInDateBox = new JComboBox();
        checkInDateBox.setSize(75, 25);
        checkOutDateBox = new JComboBox();
        checkOutDateBox.setSize(75, 25);

        for(int i = 1; i <= 31; i++){
            checkInDateBox.addItem(i);
            checkOutDateBox.addItem(i);
        }
        
        discountTextBox = new JTextField(30);
        btnReserve = new JButton();
        btnReserve.setIcon(new ImageIcon("ENTERBUTTON.png"));
        btnReserve.setBorder(BorderFactory.createEmptyBorder());
        btnReserve.setContentAreaFilled(false);
        btnReserve.setFocusable(false);
    }

    public void frontPage(){

        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));
        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setSize(800, 600);

        this.add(backgroundLabel);
        
        JLabel titleLabel = new JLabel(new ImageIcon("TITLE.png"));
        titleLabel.setBounds(150, 50, 500, 300);

        backgroundLabel.add(titleLabel);

        btnCreate.setIcon(new ImageIcon("CREATEHOTELBUTTON.png"));
        btnCreate.setBounds(77, 380, 150, 100);
        btnCreate.setBorder(BorderFactory.createEmptyBorder());
        btnCreate.setContentAreaFilled(false);
        btnCreate.setFocusable(false);
        backgroundLabel.add(btnCreate);

        btnView.setIcon(new ImageIcon("VIEWHOTELBUTTON.png"));
        btnView.setBounds(237, 380, 150, 100);
        btnView.setBorder(BorderFactory.createEmptyBorder());
        btnView.setContentAreaFilled(false);
        btnView.setFocusable(false);
        backgroundLabel.add(btnView);

        btnManage.setIcon(new ImageIcon("MANAGEHOTELBUTTON.png"));
        btnManage.setBounds(397, 380, 150, 100);
        btnManage.setBorder(BorderFactory.createEmptyBorder());
        btnManage.setContentAreaFilled(false);
        btnManage.setFocusable(false);
        backgroundLabel.add(btnManage);

        btnBook.setIcon(new ImageIcon("BOOKHOTELBUTTON.png"));
        btnBook.setBounds(557, 380, 150, 100);
        btnBook.setBorder(BorderFactory.createEmptyBorder());
        btnBook.setContentAreaFilled(false);
        btnBook.setFocusable(false);
        backgroundLabel.add(btnBook);

        revalidate();
        repaint();
    }

    public void createHotelPage(ArrayList<String> hotelNames){

        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        this.add(backgroundLabel);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBounds(400, 200, 300, 120);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JPanel displayPanel = new JPanel();
        displayPanel.setBackground(Color.decode("#FAD6B8"));
        displayPanel.setBounds(100, 100, 250, 400);
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel prompt = new JLabel("Input Hotel Name Here");
        prompt.setForeground(Color.decode("#442023"));
        prompt.setFont(new Font("Arial",Font.BOLD,15));

        JLabel hotelsTitle = new JLabel("Hotels currently in system:");
        hotelsTitle.setForeground(Color.decode("#442023"));
        hotelsTitle.setFont(new Font("Arial",Font.BOLD,15));

        JTextArea hotels = new JTextArea("");
        hotels.setBackground(Color.decode("#FAD6B8"));
        hotels.setForeground(Color.decode("#442023"));
        hotels.setFont(new Font("Arial",Font.PLAIN,10));
        hotels.setColumns(25);
        hotels.setLineWrap(true);
        hotels.setEditable(false);

        if(hotelNames.isEmpty()){
            hotels.setText("No hotels currently in system.");
        }
        else {
            for(int i = 0; i < hotelNames.size(); i++){
                if (i == 0){
                    hotels.append(hotelNames.get(i));
                }
                else {
                    hotels.append(", " + hotelNames.get(i));
                }
            }
        }

        mainPanel.add(prompt);
        mainPanel.add(hotelNameTextBox);
        mainPanel.add(btnEnter);

        displayPanel.add(hotelsTitle);
        displayPanel.add(hotels);

        backgroundLabel.add(btnBack);
        backgroundLabel.add(mainPanel);
        backgroundLabel.add(displayPanel);

        if(!getHotelName().isBlank()){
            hotelBox.addItem(getHotelName());
        }

        refresh();
    }

    public void viewHotelPage(){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(225, 100, 350, 400);
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel prompt = new JLabel("Select hotel and which information to view");

        mainPanel.add(prompt);
        mainPanel.add(hotelBox);
        mainPanel.add(btnHighLevel);
        mainPanel.add(btnLowLevel);


        backgroundLabel.add(btnBack);
        backgroundLabel.add(mainPanel);

        this.add(backgroundLabel);

        refresh();
    }

    public void viewHighLevelInfoPage(String name, int roomAmnt, double total){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(225, 100, 350, 400);
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel info = new JLabel("<html>Hotel name : " + name + "<br/>Hotel's amount of rooms: " + roomAmnt + "<br/>Hotel total earnings: " + total +"<html");
        
        mainPanel.add(info);
        
        backgroundLabel.add(btnBack);
        backgroundLabel.add(mainPanel);

        this.add(backgroundLabel);

        refresh();

    }

    public void viewLowLevelInfoPage(){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBounds(400, 100, 300, 400);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JPanel displayPanel = new JPanel();
        displayPanel.setBackground(Color.decode("#FAD6B8"));
        displayPanel.setBounds(100, 100, 250, 400);
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        displayPanel.add(btnDateInfo);
        displayPanel.add(btnRoomInfo);
        displayPanel.add(btnReservationInfo);

        backgroundLabel.add(btnBack);
        backgroundLabel.add(mainPanel);
        backgroundLabel.add(displayPanel);

        this.add(backgroundLabel);

        refresh();
    }

    public void viewDateInfo(){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBounds(400, 100, 300, 400);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel info = new JLabel();

        JPanel displayPanel = new JPanel();
        displayPanel.setBackground(Color.decode("#FAD6B8"));
        displayPanel.setBounds(100, 100, 250, 400);
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        displayPanel.add(btnDateInfo);
        displayPanel.add(btnRoomInfo);
        displayPanel.add(btnReservationInfo);

        backgroundLabel.add(btnBack);
        backgroundLabel.add(mainPanel);
        backgroundLabel.add(displayPanel);

        this.add(backgroundLabel);

        refresh();
    }

    public void manageHotelPage1(){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        this.add(btnBack);

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setBounds(250, 100, 300, 200);

        JLabel prompt = new JLabel("Choose Hotel to Manage");
        prompt.setForeground(Color.decode("#442023"));
        prompt.setFont(new Font("Monserrat",Font.BOLD,20));

        mainPanel.add(prompt);
        mainPanel.add(hotelBox);
        mainPanel.add(btnFind);

        backgroundLabel.add(mainPanel);

        this.add(backgroundLabel);

        refresh();
    }

    public void manageHotelPage2(){

        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(225, 100, 350, 400);
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));
        
        mainPanel.add(btnChangeName);
        mainPanel.add(btnAddRooms);
        mainPanel.add(btnRemoveRooms);
        mainPanel.add(btnUpdatePrice);
        mainPanel.add(btnDateMod);
        mainPanel.add(btnRemoveRes);
        mainPanel.add(btnRemoveHotel);

        backgroundLabel.add(btnBack);
        backgroundLabel.add(mainPanel);

        this.add(backgroundLabel);

        refresh();

    }

    public void changeHotelNamePage(String oldName){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(225, 100, 350, 400);
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel oldNameLabel = new JLabel("<html>Current Hotel Name : " + oldName + "<br/><br/>Input new hotel name here:<html>");
        oldNameLabel.setForeground(Color.decode("#442023"));
        oldNameLabel.setFont(new Font("Monserrat",Font.BOLD,20));

        mainPanel.add(oldNameLabel);
        mainPanel.add(hotelNameTextBox);
        mainPanel.add(btnChange);

        backgroundLabel.add(btnBack);
        backgroundLabel.add(mainPanel);

        this.add(backgroundLabel);

        refresh();
    }

    public void addHotelRoomsPage(ArrayList<String> rooms){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(225, 100, 350, 400);
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel currRoomAmnt = new JLabel("<html>Current amount of rooms: " + rooms.size() + "<br/><br/>Current rooms in the hotel: <br/><html>");
        JLabel prompt = new JLabel("<html><br/>Input amount of rooms to be added:<html>");
        JLabel selection = new JLabel("<html><br/>Select the type of room to be added<html>");
        JTextArea roomNames = new JTextArea("");
        roomNames.setBackground(Color.decode("#FAD6B8"));
        roomNames.setForeground(Color.decode("#442023"));
        //roomNames.setFont(new Font("Arial",Font.PLAIN,10));
        roomNames.setColumns(25);
        roomNames.setLineWrap(true);
        roomNames.setEditable(false);

        if(rooms.isEmpty()){
            roomNames.setText("No hotels currently in system.");
        }
        else {
            for(int i = 0; i < rooms.size(); i++){
                if (i == 0){
                    roomNames.append(rooms.get(i));
                }
                else {
                    roomNames.append(", " + rooms.get(i));
                }
            }
        
        mainPanel.add(currRoomAmnt);
        mainPanel.add(roomNames);
        mainPanel.add(prompt);
        mainPanel.add(amountRooms);
        mainPanel.add(selection);
        mainPanel.add(roomTypesBox);
        mainPanel.add(btnAdd);

        backgroundLabel.add(btnBack);
        backgroundLabel.add(mainPanel);
        this.add(backgroundLabel);

        refresh();
        }
    }

    public void removeRoomsPage(ArrayList<String> rooms){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(225, 100, 350, 400);
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel currRoomAmnt = new JLabel("<html>Current amount of rooms: " + rooms.size() + "<br/><br/>Current rooms in the hotel: <br/><html>");
        JLabel prompt = new JLabel("<html><br/>Input the name of the room to be deleted:<html>");
        JTextArea roomNames = new JTextArea("");
        roomNames.setBackground(Color.decode("#FAD6B8"));
        roomNames.setForeground(Color.decode("#442023"));
        //roomNames.setFont(new Font("Arial",Font.PLAIN,10));
        roomNames.setColumns(25);
        roomNames.setLineWrap(true);
        roomNames.setEditable(false);

        if(rooms.isEmpty()){
            roomNames.setText("No rooms currently in this hotel.");
        }
        else {
            for(int i = 0; i < rooms.size(); i++){
                if (i == 0){
                    roomNames.append(rooms.get(i));
                }
                else {
                    roomNames.append(", " + rooms.get(i));
                }
        }

        roomNameBox.removeAllItems();
        for(int i = 0; i < rooms.size(); i++){
            roomNameBox.addItem(rooms.get(i));
        }
        
        mainPanel.add(currRoomAmnt);
        mainPanel.add(roomNames);
        mainPanel.add(prompt);
        mainPanel.add(roomNameBox);
        mainPanel.add(btnRemove1);

        backgroundLabel.add(btnBack);
        backgroundLabel.add(mainPanel);

        this.add(backgroundLabel);

        refresh();
        }
    }

    public void updateBasePricePage(double oldPriceS, double oldPriceD, double oldPriceE){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(225, 100, 350, 400);
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel currentPrice = new JLabel("<html>The current price for each rooms are:<br/><html>");
        JLabel standardPrice = new JLabel("<html>Standard: " + oldPriceS + "<br/><html");
        JLabel deluxePrice = new JLabel("<html>Deluxe: " + oldPriceD + "<br/><html");
        JLabel executivePrice = new JLabel("<html>Executive: " + oldPriceE + "<br/><html");
        JLabel prompt = new JLabel("<html><br/>Input new price for rooms here [New price >= PHP100]: <br/><html");

        mainPanel.add(currentPrice);
        mainPanel.add(standardPrice);
        mainPanel.add(deluxePrice);
        mainPanel.add(executivePrice);
        mainPanel.add(prompt);
        mainPanel.add(newBasePriceText);
        mainPanel.add(btnUpdate);

        backgroundLabel.add(btnBack);
        backgroundLabel.add(mainPanel);

        this.add(backgroundLabel);

        refresh();
    }

    public void removeReservationPage(ArrayList<String> reservations){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(225, 100, 350, 400);
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel prompt = new JLabel("<html>Please select the reservation to be removed:<br/><html>");

        reservationsBox.removeAllItems();
        for(int i = 0; i < reservations.size(); i++){
            reservationsBox.addItem(reservations.get(i));
        }

        mainPanel.add(reservationsBox);
        mainPanel.add(btnRemove2);

        backgroundLabel.add(mainPanel);
        backgroundLabel.add(btnBack);

        this.add(backgroundLabel);

        refresh();
    }

    public void dateModPage1(){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(225, 100, 350, 400);
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel prompt = new JLabel("<html>Choose the range of the dates to be modifed:<html>");
        JLabel startDate = new JLabel("<html><br/>Date start: <html>");
        JLabel endDate = new JLabel("<html>Date end: <br/><html>");

        mainPanel.add(prompt);
        mainPanel.add(startDate);
        mainPanel.add(checkInDateBox);
        mainPanel.add(endDate);
        mainPanel.add(checkOutDateBox);
        mainPanel.add(btnChooseDays);

        backgroundLabel.add(mainPanel);
        backgroundLabel.add(btnBack);

        this.add(backgroundLabel);

        refresh();
    }

    public void dateModPage2(int day){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(225, 100, 350, 400);
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel prompt = new JLabel("<html>Input change (in percentage) for days " + day + " - " + (day+1) + ": ");

        mainPanel.add(prompt);
        mainPanel.add(modifiedChange);
        mainPanel.add(btnModify);

        backgroundLabel.add(mainPanel);
        backgroundLabel.add(btnBack);

        this.add(backgroundLabel);

        refresh();
    }

    public void bookReservationPage(ArrayList<String> hotels, ArrayList<String> rooms){
        getContentPane().removeAll();
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        ImageIcon image = new ImageIcon("City.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setLayout(null);
        backgroundLabel.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(225, 100, 350, 400);
        mainPanel.setBackground(Color.decode("#FAD6B8"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#442023"), 5));

        JLabel hotelNameText = new JLabel("Hotel Name");
        hotelNameText.setForeground(Color.decode("#442023"));
        hotelNameText.setFont(new Font("Arial",Font.BOLD,15));

        JLabel guestNameText = new JLabel("Guest's Name");
        guestNameText.setForeground(Color.decode("#442023"));
        guestNameText.setFont(new Font("Arial",Font.BOLD,15));

        JLabel roomNameText = new JLabel("Room Name");
        roomNameText.setForeground(Color.decode("#442023"));
        roomNameText.setFont(new Font("Arial",Font.BOLD,15));

        JLabel checkInText = new JLabel("Check-In-Date");
        checkInText.setForeground(Color.decode("#442023"));
        checkInText.setFont(new Font("Arial",Font.BOLD,15));

        JLabel checkOutText = new JLabel("Check-Out-Date");
        checkOutText.setForeground(Color.decode("#442023"));
        checkOutText.setFont(new Font("Arial",Font.BOLD,15));

        JLabel discountText = new JLabel("Discount Code [If none, leave blank]");
        discountText.setForeground(Color.decode("#442023"));
        discountText.setFont(new Font("Arial",Font.BOLD,15));

        for(int i = 0; i < rooms.size(); i++){
            roomNameBox.addItem(rooms.get(i));
        }

        mainPanel.add(hotelNameText);
        mainPanel.add(hotelBox);

        mainPanel.add(guestNameText);
        mainPanel.add(guestNameTextBox);

        mainPanel.add(roomNameText);
        mainPanel.add(roomNameBox);

        mainPanel.add(checkInText);
        mainPanel.add(checkInDateBox);

        mainPanel.add(checkOutText);
        mainPanel.add(checkOutDateBox);

        mainPanel.add(discountText);
        mainPanel.add(discountTextBox);

        mainPanel.add(btnReserve);

        backgroundLabel.add(btnBack);
        backgroundLabel.add(mainPanel);

        this.add(backgroundLabel);

        refresh();
    }

    public void displayPopUp(String text){
        JOptionPane.showMessageDialog(this, text);
    }

    public int confirmationPopUp(String text){
        int choice = JOptionPane.showConfirmDialog(null, text, "Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return choice;
    }

    public void refresh(){
        revalidate();
        repaint();
    }

    /*  LISTENERS  */
    
    //front page listeners
    public void setFrontPageListener (ActionListener listener){
        btnCreate.addActionListener(listener);
        btnView.addActionListener(listener);
        btnManage.addActionListener(listener);
        btnBook.addActionListener(listener);
    }

    //create hotel listeners
    public void setCreateHotelListener (ActionListener listener){
        btnBack.addActionListener(listener);
        btnEnter.addActionListener(listener);
    }

    //view hotel listeners
    public void setViewHotelListener (ActionListener listener){
        btnBack.addActionListener(listener);
        btnLowLevel.addActionListener(listener);
        btnHighLevel.addActionListener(listener);
    }

    //manage hotel listeners
    public void setManageHotelListener (ActionListener listener){
        btnBack.addActionListener(listener);
        btnFind.addActionListener(listener);
        btnChangeName.addActionListener(listener);
        btnAddRooms.addActionListener(listener);
        btnRemoveRooms.addActionListener(listener);
        btnUpdatePrice.addActionListener(listener);
        btnRemoveRes.addActionListener(listener);
        btnRemoveHotel.addActionListener(listener);
        btnDateMod.addActionListener(listener);
        btnChange.addActionListener(listener);
        roomTypesBox.addActionListener(listener);
        btnAdd.addActionListener(listener);
        btnRemove1.addActionListener(listener);
        btnRemove2.addActionListener(listener);
        btnUpdate.addActionListener(listener);
        btnChooseDays.addActionListener(listener);
        btnModify.addActionListener(listener);
    }

    //book hotel listeners
    public void setBookHotelListener (ActionListener listener){
        btnBack.addActionListener(listener);
        btnReserve.addActionListener(listener);
        hotelBox.addActionListener(listener);
    }

    // for text fields and text areas

    public String getHotelName(){
        return hotelNameTextBox.getText();
    }

    public String getSelectedHotelName(){
        return (String)hotelBox.getSelectedItem();
    }

    public String getGuestName(){
        return guestNameTextBox.getText();
    }

    public String getRoomName(){
        return roomNameBox.getSelectedItem().toString();
    }

    public String getDiscountCode(){
        return discountTextBox.getText();
    }

    public int getCheckInDate(){
        return Integer.parseInt(checkInDateBox.getSelectedItem().toString());
    }

    public int getCheckOutDate(){
        return Integer.parseInt(checkOutDateBox.getSelectedItem().toString());
    }

    public String getRoomType(){
        return (String)roomTypesBox.getSelectedItem();
    }

    public int getRoomAmount(){
        return Integer.parseInt(amountRooms.getText());
    }

    public double getNewBasePrice(){
        return Double.parseDouble(newBasePriceText.getText());
    }

    public String getReservation(){
        return (String)reservationsBox.getSelectedItem();
    }

    public double getModifiedChange(){
        return Double.parseDouble(modifiedChange.getText());
    }

    public JButton getBtnCreate() { return btnCreate; }
    public JButton getBtnView() { return btnView; }
    public JButton getBtnManage() { return btnManage; }
    public JButton getBtnBook() { return btnBook; }
    public JButton getBtnBack() { return btnBack; }
    public JButton getBtnEnter() { return btnEnter; }
    public JButton getBtnFind() { return btnFind; }
    public JButton getBtnReserve() { return btnReserve; }
    public JButton getBtnChangeName() { return btnChangeName; }
    public JButton getBtnAddRooms() { return btnAddRooms; }
    public JButton getBtnRemoveRooms() { return btnRemoveRooms; }
    public JButton getBtnUpdatePrice() { return btnUpdatePrice; }
    public JButton getBtnDateMod() { return btnDateMod; }
    public JButton getBtnRemoveRes() { return btnRemoveRes; }
    public JButton getBtnRemoveHotel() { return btnRemoveHotel; }
    public JButton getBtnChange() { return btnChange; }
    public JButton getBtnAdd() { return btnAdd; }
    public JButton getBtnRemove1() { return btnRemove1; }
    public JButton getBtnRemove2() { return btnRemove2; }
    public JButton getBtnUpdate() { return btnUpdate; }
    public JButton getBtnChooseDays() { return btnChooseDays; }
    public JButton getBtnModify() { return btnModify; }
    public JButton getBtnLowLevel() { return btnLowLevel; }
    public JButton getBtnHighLevel() { return btnHighLevel; }
    public JButton getBtnDateInfo() { return btnDateInfo; }
    public JButton getBtnRoomInfo() { return btnRoomInfo; }
    public JButton getBtnReservationInfo() { return btnReservationInfo; }

    public JComboBox getHotelBox() { return hotelBox; }
    public JComboBox getRoomTypeBox() { return roomTypesBox; }
    public JComboBox getReservationsBox() { return reservationsBox; }

    public void resetHotelTextField() { this.hotelNameTextBox.setText(""); }

}