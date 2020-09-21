import java.util.*;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static List<SignUp> users = new ArrayList<SignUp>();
    public static void main(String[] args) {
        System.out.println("==================");
        System.out.println("Welcome to Ferfelis Airlines Booking Assistant!".toUpperCase());
        System.out.println("==================");
        long adminPw = 1525;
        int options = 0;
        boolean opts = true;
        boolean running = true;
        boolean connect = false;
        while (running) {
            System.out.println("Choose Your Option\n1) Sign Up\n2) Sign In\n3) Print Users");
            while (opts) {
                try {
                    options = scanner.nextInt();
                    opts = false;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Option Try again");
                    scanner.next();
                }
            }
            switch (options) {
                case 1:
                    SignUp user = new SignUp();
                    if (users.size() == 0 || UserFind.getPosition(users, user.getPhoneNumber()) < 0) {
                        users.add(user);
                        System.out.println("Add Success");
                        System.out.println("Connection Established... Hello "+user.getFirstName().toUpperCase());
                        connect = true;
                        System.out.println("Book for a flight? ");
                        String checkFlight = scanner.next();
                        if (checkFlight.equalsIgnoreCase("Y")){
                            Tickets tickets = new Tickets();
                            user.setTicketsList(tickets);
                            user.print();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (users.size()>0) {
                        user = UserFind.getPosition(users);
                        if (user != null) {
                            connect = true;
                            System.out.println("Connection Established... Hello " + user.getFirstName().toUpperCase());
                            System.out.println("Book for a flight? ");
                            String checkFlight = scanner.next();
                            if (checkFlight.equalsIgnoreCase("Y")){
                                Tickets tickets = new Tickets();
                                user.setTicketsList(tickets);
                                user.print();
                                break;
                            }else {
                                break;
                            }
                        }
                    }
                    if (users.size()==0){
                        System.out.println("Empty List..");
                    }else {
                        System.out.println("Invalid User");
                    }
                    break;
                case 3:
                    System.out.println("==================");
                    System.out.println("Enter Admin Password: ");
                    long check = scanner.nextLong();
                    if (check == adminPw && users.size()>0) {

                        for (SignUp man : users) {
                            System.out.println(man.toString());
                            System.out.println("==================");
                        }
                        break;
                    }
                    if (users.size()==0){
                        System.out.println("Empty List..");
                    }else {
                        System.out.println("Access Denied!");
                    }
                    break;
            }
            System.out.println("Run again?");
            opts =true;
            running = scanner.nextBoolean();
            if (running){
                System.out.println("Disconnected..");
                connect = false;
            }
        }
    }
}

