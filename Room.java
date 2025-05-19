/**
 * The Room class represents a room within Hotel. 
 * It contains information about the room and the 
 * ability to change it’s base price
 * @author Erin Gabrielle Chua
 * @author Andre Gabriel Llanes
 */
public abstract class Room {
    
    private String name;
    protected double basePrice = 1299;

    /**
     * A Room is created by providing a name for Room
     * @param name The room's name
     */
    public Room (String name) {
        this.name = name;
    }
    
    /** 
     * This method returns the name of the Room
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * This method returns the base price of the Room
     * @return basePrice
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * This method allows for the setting/changing of the base price of the Room
     * @param basePrice
     */
    public void setBasePrice(double basePrice){
        this.basePrice = basePrice;
    }

}