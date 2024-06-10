package Activities;
interface addable{
    int add(int num1,int num2);
}
public class Activity12 {
    public static void main(String[] args){
        addable ad1 = (num1, num2) -> (num1+num2);
        System.out.println(ad1.add(4332,2034));

        addable ad2 = (int num1, int num2)->{
            return (num1 + num2);
        };
        System.out.println(ad2.add(240,321));

    }
}
