
import java.util.ArrayList;
import java.util.Scanner;

public class Orders {
    Scanner input = new Scanner(System.in);
    protected ArrayList<String> menu = new ArrayList<>();
    protected ArrayList<Integer> rate = new ArrayList<>();
    protected ArrayList<Integer> quantity = new ArrayList<>();
    protected ArrayList<Integer> totalQuantity = new ArrayList<>();
    private double temp=0;
    private double sum=0;
    int p=0;

    public Orders(){
        menu.add("Chicken Biryani");
        menu.add("Al Faham BBQ");
        menu.add("Beef Roast");
        menu.add("Gobi Manchurian");
        menu.add("Paneer Butter Masala");
        menu.add("Butter Naan");
        menu.add("Parotta");
        menu.add("Chapathi");
        rate.add(150);
        rate.add(170);
        rate.add(150);
        rate.add(115);
        rate.add(219);
        rate.add(55);
        rate.add(15);
        rate.add(12);
        for(int i=0;i<menu.size();i++){
            quantity.add(0);
            totalQuantity.add(0);
        }
    }


    public void displayMenu(){
        System.out.println("\n\tITEM"+"\t\t\t\tPrice");
        for(int i=0;i<menu.size();i++)
            System.out.println((i+1)+"."+menu.get(i)+"\t:\t"+rate.get(i));
    }

    public void order(int index){
        if (index >= 0 && index <= menu.size()) {
            System.out.println("\nenter the no of quantities of " + menu.get(index - 1));
            int q = input.nextInt();
            if(quantity.get(index-1)==0) {
                quantity.add(index - 1, q);
            }else{
                quantity.set(index - 1, q);
            }
        } else {
            System.out.println("Invalid index");
        }
    }

    public void removeOrder(int index){
            if(quantity.get(index-1)==0){
                System.out.println("Item not ordered");
            }else {
                quantity.set(index - 1, 0);
            }
    }
    public void viewBill(){
        System.out.println("___________________________");
        System.out.println("\nYour Orders are:\n");
        try {
            for (int i = 0; i < menu.size(); i++) {
                if (quantity.get(i) != 0) {
                    System.out.println(menu.get(i) + "  *  " + quantity.get(i) + " = " + quantity.get(i) * rate.get(i) + "rs");
                }
            }
            System.out.println("___________________________");
        }catch (Exception e){
            System.out.println("No orders yet!");
        }
    }
    public void Bill(int takeaway){
        System.out.println("___________________________");
        System.out.println("\nYour Orders are:\n");
        for(int i=0;i<menu.size();i++)
        {
            if(quantity.get(i)!=0) {
                temp+=quantity.get(i)*rate.get(i);
                sum=temp+(temp*0.05);
                System.out.println(menu.get(i)+"  *  "+quantity.get(i)+" = "+quantity.get(i)*rate.get(i)+"rs");

            }
        }

        for(int i=0;i<menu.size();i++){

            if (quantity.get(i) != 0) {

                    totalQuantity.set(i, (quantity.get(i)+totalQuantity.get(i)));
                    quantity.set(i, 0);

                }


        }
        if(takeaway==1 && temp!=0){
            System.out.println("Parcel Charge : 5rs");
            temp+=5;
            sum+=5;
            p+=5;
        }
        System.out.println("___________________________");
        System.out.println("total : "+temp+"rs");
        System.out.println("gst(5%) = "+(temp*0.05));
        System.out.println("___________________________");
        System.out.println("\nYour total bill = "+sum+"rs");
        System.out.println("___________________________");
        System.out.println("Thank you");
        temp=0;
        sum=0;
    }

}
