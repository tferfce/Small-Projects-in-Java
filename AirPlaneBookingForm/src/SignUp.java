import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class SignUp {
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private List<Tickets> ticketsList;
    private Scanner scanner = new Scanner(System.in);
    public SignUp() {
        System.out.println("Enter First Name");
        this.firstName = scanner.next();
        System.out.println("Enter Last Name");
        this.lastName = scanner.next();
        this.email = this.firstName+"_"+this.lastName+"@gmail.com";
        System.out.println("Email: "+this.email);

        System.out.println("Enter phone Number");
        boolean phoneN= true;
        while (phoneN) {
            try {
                this.phoneNumber = scanner.nextLong();
                if (CountDigits(this.phoneNumber)==10) {
                    phoneN = false;
                }else {
                    System.out.println("Invalid Phone number try again");
                    scanner.next();
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid Phone number try again");
                scanner.next();
            }
        }
        this.ticketsList = new ArrayList<Tickets>();
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }

    private long CountDigits(long number){
        String num = number+"";
        return num.length();
    }

    public void setTicketsList(Tickets tickets) {
        this.ticketsList.add(tickets);
    }

    public void print() {
        for (Tickets tick: this.ticketsList){
            System.out.println(tick.toString());
            System.out.println("==================");
        }
    }

    @Override
    public String toString() {
        return "Full Name: "+this.firstName.toUpperCase()+" "+this.lastName.toUpperCase()+"\nE-Mail: "+email+"\nPhone Number: "+phoneNumber;
    }

}
