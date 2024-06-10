package Activities;

public class Activity3 {
    public static void main(String[] args) {
        double seconds = 1000000000;
        double earthsecs = 31557600;
        double mercurysecs = 0.2408467;
        double venussecs = 0.61519726;
        double marssecs = 1.8808158;
        double jupitersecs = 11.862615;
        double saturnsecs = 29.447498;
        double uranussecs = 84.016846;
        double neptunesecs = 164.79132;

        System.out.println("Age on Earth:" + seconds / earthsecs);
        System.out.println("Age on Mercury:" + seconds / earthsecs / mercurysecs);
        System.out.println("Age on Venus:" + seconds / earthsecs / venussecs);
        System.out.println("Age on Mars:" + seconds / earthsecs / marssecs);
        System.out.println("Age on Jupiter:" + seconds / earthsecs / jupitersecs);
        System.out.println("Age on Saturn:" + seconds / earthsecs / saturnsecs);
        System.out.println("Age on Uranus:" + seconds / earthsecs / uranussecs);
        System.out.println("Age on Neptune:" + seconds / earthsecs / neptunesecs);


    }
}

