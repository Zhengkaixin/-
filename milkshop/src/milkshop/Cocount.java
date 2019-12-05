package milkshop;

import java.util.Calendar;
import java.util.Date;

public class Cocount extends Ingredient {
    private String name;
    private Calendar date;
    private int ExDate;

    Cocount(){
        super();
        name="Cocount";
        ExDate=5;
    }
    Cocount(String name,Calendar date,int ExDate){
        super(name, date ,ExDate);
        this.name=name;
        this.date=date;
        this.ExDate=ExDate;
    }
    @ Override
    public  String toString(){
        return name;
    }
    public Calendar getDate(){
        return date;
    }
    public int getExDate(){
        return ExDate;
    }
}
