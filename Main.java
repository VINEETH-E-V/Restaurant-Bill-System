
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        admin Admin = new admin();
        Scanner input = new Scanner(System.in);
        boolean exit=true;
        boolean exitAdmin=true;
        boolean exitBill=true;
        String password = "1234567890";
        do {
            System.out.println("\nEnter ID for access \n1.Admin\n2.Staff\n3.exit");
            int accessID = input.nextInt();
            switch (accessID){
                case 1:
                    System.out.println("\nEnter password\n");
                    String passwordInput = input.next();
                    do{
                        if (passwordInput.equals(password)) {
                            System.out.println("\nEnter Choice\n1.Add item\n2.Delete item\n3.sales report\n4.logout");
                            int ch = input.nextInt();
                            switch (ch) {
                                case 1 -> Admin.addMenu();
                                case 2 -> Admin.removeMenu();
                                case 3 -> Admin.salesReport();
                                case 4 -> exitAdmin = false;
                            }
                        } else {
                            System.out.println("\nInvalid password\n");
                            exitAdmin = false;
                        }
                    }while(exitAdmin);
                    break;
                case 2:
                    System.out.println("\n1.Takeaway\n2.Dine-in");
                    int takeaway=input.nextInt();
                    if (takeaway==1 || takeaway==2) {
                        do {
                            System.out.println("\n1.Display Menu\n2.Add item to order\n3.Delete item from order\n4.View Orders\n5.Generate Bill");
                            System.out.println("\nEnter choice : ");
                            int userChoice = input.nextInt();
                            switch (userChoice) {
                                case 1 -> Admin.displayMenu();
                                case 2 -> {
                                    System.out.println("\nEnter the index of items to order :");
                                    int index = input.nextInt();

                                            Admin.order(index);



                                }
                                case 3 -> {
                                    System.out.println("\nEnter the index of item to remove :");
                                    int removeIndex = input.nextInt();
                                    if (removeIndex >= 0 && removeIndex <= Admin.menu.size()+1) {
                                        Admin.removeOrder(removeIndex);
                                    } else {
                                        System.out.println("Invalid index");
                                    }
                                }
                                case 4 -> {
                                    Admin.viewBill();
                                }
                                case 5 -> {
                                    Admin.Bill(takeaway);
                                    exitBill = false;
                                }
                                default -> System.out.println("\nInvalid Choice");
                            }
                        } while (exitBill);
                    }else{
                        System.out.println("Invalid Choice");
                    }
                    exitBill=true;
                    break;
                case 3:
                    exit=false;
                    break;
                default:
                System.out.println("\nInvalid access");
            }
        }while(exit);
    }
}