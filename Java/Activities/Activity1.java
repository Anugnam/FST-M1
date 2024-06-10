package Activities;

public class Activity1 {
    public static void main(String[] args){
        Car glanza = new Car();
        glanza.make = 2023;
        glanza.color = "Blue";
        glanza.transmission = "Automatic";

        glanza.displayCharacteristics();
        glanza.accelarate();
        glanza.brake();


    }
}
