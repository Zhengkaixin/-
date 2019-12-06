package milkshop;

public class SoldOutException extends Exception{
    public SoldOutException(){
        super();
        System.out.println("sold out");
    }
}
