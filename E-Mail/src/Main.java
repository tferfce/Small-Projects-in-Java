import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Mail> users = new ArrayList<Mail>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        boolean running=true;
        while (running) {
            System.out.println("Choose your actions\n1) Create user\n2) Delete User\n3) Print all users\n4) Update user\n5) Find user\n6) Exit");
            choice = scanner.nextInt();
            if (choice == 1) {
                Mail user = new Mail();
                users.add(user);
                System.out.println("Continue running? True/False");
                running = scanner.nextBoolean();
            } else if (choice == 2 && users.size() > 0) {
                Delete.deleteFromList(users);
                System.out.println("Continue running? True/False");
                running = scanner.nextBoolean();
            } else if (choice == 3 && users.size() > 0) {
                System.out.println("The list contains".toUpperCase());
                System.out.println("======================");
                for (int i = 0; i < users.size(); i++) {
                    System.out.println(users.get(i));
                    System.out.println("======================");
                }
                System.out.println("Continue running? True/False");
                running = scanner.nextBoolean();
            } else if (choice == 4 && users.size() > 0) {
                int position = UserFind.UserExists(users);
                if (position >= 0) {
                    System.out.println("Enter Updated user");
                    Mail user = new Mail();
                    users.set(position, user);
                } else {
                    System.out.println("Invalid Position!");
                }
            } else if (choice == 5 && users.size() > 0) {
               int position = UserFind.UserExists(users);
               if (position<0){
                   System.out.println("Invalid Position!");
               }
            } else if (choice == 6){
                running=false;
            }else {
                System.out.println("Either the list is empty or invalid Action!");
                System.out.println("Continue running? True/False");
                running = scanner.nextBoolean();
            }
        }
        scanner.close();
        System.out.println("Thanks for your Time!\n"+"Goodbye!".toUpperCase());
    }
}
