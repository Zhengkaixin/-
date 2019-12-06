package milkshop;
import java.util.Calendar;
import java.util.Date;

public abstract class Ingredient{
    protected String name;
    protected Calendar date;
    protected int ExDate;//

    Ingredient(){

    }

    Ingredient(String name,Calendar date,int ExDate){
        this.name=name;
        this.date=date;
        this.ExDate=ExDate;
    }


    @ Override
    public  String toString(){
        return name;
    }
}
