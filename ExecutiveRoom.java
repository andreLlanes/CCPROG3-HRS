public class ExecutiveRoom extends Room {
    
    public ExecutiveRoom(String name){
        super(name);
    }

    @Override
    public double getBasePrice(){
        return super.getBasePrice()*1.35;
    }
}
