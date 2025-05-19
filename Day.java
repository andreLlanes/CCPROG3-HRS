public class Day {
    int date;
    double change;

    public Day(int date, double change){
        this.date = date;
        this.change = change;
    }

    public void setPriceChange(double change){
        this.change = change/100;
    }

    public double getPriceChange(){
        return change;
    }
}
