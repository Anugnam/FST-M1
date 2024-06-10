package Activities;
class CustomException extends Exception{
    private String message;
    public CustomException(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
public class Activity8 {
    static void exceptionTest(String S) throws CustomException{
        if(S==null){
            throw new CustomException("String value is null");
        }
        else {
            System.out.println(S);
        }
    }
    public static void main(String[] args){
        try{
            Activity8.exceptionTest("Will print to console");
            Activity8.exceptionTest(null);
        }
        catch(CustomException cme){
            System.out.println("Inside catch block: " + cme.getMessage());
        }
    }
}
