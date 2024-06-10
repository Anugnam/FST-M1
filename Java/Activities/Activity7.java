package Activities;
interface BicycleParts{
    public int gears = 0;
    public int speed = 0;
}
interface BicycleOperations{
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}
class BiCycle implements BicycleParts, BicycleOperations{
   public int gears;
   public int speed;
   public BiCycle(int gears, int speed){
       this.gears = gears;
       this.speed = speed;
   }
   public void applyBrake(int decrement){
       speed -= decrement;
       System.out.println("Current speed " + speed);
   }
   public void speedUp(int increment){
       speed += increment;
   }
   public String bicycleDesc(){
       return ("Number of gears are " + gears + "\n Speed is " + speed);
   }
}
class MountainBike extends BiCycle{
    public int seatHeight;
    public MountainBike(int gears, int speed, int startHeight){
        super(gears,speed);
        seatHeight = startHeight;
    }
    public void setHeight(int newValue){
        seatHeight = newValue;
    }
    public String bicycleDesc(){
        return (super.bicycleDesc() + "\n Seat height is " + seatHeight);
    }
}
public class Activity7 {
    public static void main(String[] args){
        MountainBike mb = new MountainBike(3,0,25);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);
    }
}
