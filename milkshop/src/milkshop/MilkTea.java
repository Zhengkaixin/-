package milkshop;

public class MilkTea {
    private String MilkName;
    private Ingredient ingredients;
    public void setMilkName(String MilkName){
        this.MilkName=MilkName;
    }
    public String getMilkName(){
        return this.MilkName;
    }
    public void setIngredients(Ingredient ingredients){
        this.ingredients=ingredients;
    }
    public Ingredient getIngredients(){
        return this.ingredients;
    }
}
