package milkshop;

import java.util.*;

public class Main {
    public  static void main(String[] args) throws SoldOutException {
        System.out.println("西二奶茶店开业");

        Bubble bubble1=new Bubble("bubble",Calendar.getInstance(),7);
        Cocount cocount1=new Cocount("cocount",Calendar.getInstance(),5);

        TeaShop teaShop=new TeaShop();//创建奶茶店
        System.out.println("奶茶店进货");
        Calendar c = new GregorianCalendar();
        System.out.println("请输入生产日期：year month date hourOfDay minute second:");
       // c.set(2015, 8, 16, 12, 12, 12);

        int year,month,date,hourOfDay,minute,second;//自定义生产日期
        Scanner in_=new Scanner(System.in);
        year= in_.nextInt();
        month=in_.nextInt();
        date=in_.nextInt();
        hourOfDay= in_.nextInt();
        minute=in_.nextInt();
        second=in_.nextInt();
        c.set(year, month-1,date,hourOfDay,minute,second);
        int year_ = c.get(Calendar.YEAR);
        int month_ = c.get(Calendar.MONTH)+1;
        int day_ = c.get(Calendar.DATE);
        //int week_ = c.get(Calendar.DAY_OF_WEEK);
        Bubble bubble=new Bubble("bubble",c,7);
        Cocount cocount=new Cocount("cocount",c,5);
        for(int i=0;i<2;i++){
            teaShop.addIngredient(bubble);
            teaShop.addIngredient(cocount);
            /*teaShop.addIngredient(bubble1);
            teaShop.addIngredient(cocount1);*/
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
            if(IngreName.equals("Bubble"))milkTea.setIngredients(bubble);
            else if(IngreName.equals("Cocount"))milkTea.setIngredients(cocount);
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
