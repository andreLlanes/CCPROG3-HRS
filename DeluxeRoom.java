public class DeluxeRoom extends Room {
    
    public DeluxeRoom (String name){
        super(name);
    }

    @Override
    public double getBasePrice(){
        return super.getBasePrice()*1.2;
    }
}
