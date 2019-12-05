package milkshop;

import java.util.*;

public class Main {
    public  static void main(String[] args) throws SoldOutException {
        System.out.println("西二奶茶店开业");

        Bubble bubble=new Bubble("bubble",Calendar.getInstance(),7);
        Cocount cocount=new Cocount("cocount",Calendar.getInstance(),5);

        TeaShop teaShop=new TeaShop();//创建奶茶店
        System.out.println("奶茶店进货");
        for(int i=0;i<2;i++){
            teaShop.addIngredient(bubble);
            teaShop.addIngredient(cocount);
        }
        teaShop.getMilkMenu();//获取配料单
        int flag=1;
        do{
            System.out.println("请输入需要什么奶茶");
            Scanner s=new Scanner(System.in);
            String name=s.next();
            MilkTea milkTea=new MilkTea();
            milkTea.setMilkName(name);
            System.out.println("需要什么配料");
            String IngreName=s.next();
            if(IngreName.equals("bubble"))milkTea.setIngredients(bubble);
            else if(IngreName.equals("cocount"))milkTea.setIngredients(cocount);
            else{
                throw new SoldOutException();
            }
            teaShop.soldMilkTea(milkTea,Calendar.getInstance());
            System.out.println("继续点奶茶，请输入1");
            System.out.println("否则请输入0");
            flag=s.nextInt();
        }
            while(flag==1);
        //卖奶茶
    }
}
