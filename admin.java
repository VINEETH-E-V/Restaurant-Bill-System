public class admin extends Orders{
    private int sumTotal=0;

    public void addMenu(){

                System.out.println("enter the item to add :");
                String str = input.next();
                menu.add(str);
                System.out.println("enter the price :");
                int price = input.nextInt();
                rate.add(price);
        for(int i=0;i<menu.size();i++){
            quantity.add(0);
            totalQuantity.add(0);
        }
    }

    public void removeMenu(){
        displayMenu();
        System.out.println("Enter the index of item to remove :");
        int rm= input.nextInt();
        menu.remove(rm-1);
        rate.remove(rm-1);
    }

    public void salesReport(){
        System.out.println("_________________________");
        System.out.println("Sales Report\n");
        System.out.println("\nITEM"+"\t\tQuantity"+"\t\tPrice");
        for(int i=0;i<menu.size();i++){
            System.out.println(menu.get(i)+"\t*\t\t"+totalQuantity.get(i)+"\t=\t\t"+totalQuantity.get(i)*rate.get(i)+"rs");
            sumTotal+= totalQuantity.get(i)*rate.get(i);
        }
        System.out.println("Total parcel charges : "+p+"rs");
        System.out.println("Total sale : "+sumTotal+"rs");
    }
}
