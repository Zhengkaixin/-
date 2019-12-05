package milkshop;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TeaShop implements shop {
    ArrayList<Bubble> bubblesList;
    ArrayList<Cocount> cocountsList;

    TeaShop(){
        this.bubblesList= new ArrayList<Bubble>();
        this.cocountsList= new ArrayList<Cocount>();
    }
    public void getMilkMenu() {//配料单
        Ingredient[] ingredients = new Ingredient[2];
        ingredients[0] = new Bubble();
        ingredients[1] = new Cocount();
        ArrayList<String> IngredientsName = new ArrayList<String>();//储存配料的名字
        System.out.println("配料有:");
        for (int i = 0; i < ingredients.length; i++) {
             IngredientsName.add(ingredients[i].toString());
            //System.out.print((i + 1) + "." + "奶茶" + ":" + name + "MilkTea");
        }
        for(int i=0;i<IngredientsName.size();i++){
            System.out.println(IngredientsName.get(i).toString());
        }
    }
    public void addIngredient(Ingredient ingredient){//判断进货的是什么原料
       if(ingredient instanceof Bubble){
           this.bubblesAdd((Bubble) ingredient);
       }
       else if(ingredient instanceof Cocount){
           this.cocoutsAdd((Cocount)ingredient);
       }
    }               /* if(ingredient.equals(new Bubble())){
                        bubblesList.add((Bubble) ingredient);
                    }
                    else if(ingredient.equals(new Cocount())){
                        cocountsList.add((Cocount)ingredient);
                    }*/


    private void bubblesAdd(Bubble ingredient){
        bubblesList.add(ingredient);
    }


    private void cocoutsAdd(Cocount ingredient){
        cocountsList.add(ingredient);
    }


    public void soldMilkTea(MilkTea milktea, Calendar date) throws SoldOutException{
        for(int i=0;i<bubblesList.size();i++){//先删除过期的配料
            Bubble bubble=bubblesList.get(i);
            Calendar date_=bubble.getDate();
            if(date.getTimeInMillis()-date_.getTimeInMillis()>bubble.getExDate()*24*3600){
                bubblesList.remove(i);
            }
            else{
                break;
            }
        }
        for(int i=0;i<cocountsList.size();i++){
            Cocount cocount=cocountsList.get(i);
            Calendar date_=cocount.getDate();
            if(date.getTimeInMillis()-date_.getTimeInMillis()>cocount.getExDate()*24*3600){
                cocountsList.remove(i);
            }
            else{
                break;
            }
        }


        Ingredient Ingre=milktea.getIngredients();
        if(Ingre.toString().equals("bubble")){
            if(bubblesList.size()>=1){
                bubblesList.remove(0);
            }
            else {
                throw new SoldOutException();
            }
        }
        else if(Ingre.toString().equals("cocount")){
            if(cocountsList.size()>=1){
                cocountsList.remove(0);
            }
            else{
                throw new SoldOutException();
            }
        }
        System.out.println("你获得了"+milktea.getMilkName()+"奶茶");
    }
}
