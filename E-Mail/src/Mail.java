import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Mail {
    private String firstName;
    private String lastName;
    private long password;
    private String email;
    private int mailBoxCapacity;
    private String department;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

    //CONSTRUCTOR
    public Mail() {
        System.out.println("Enter your First Name: ");
        this.firstName = scanner.next();
        System.out.println("Enter your Last Name: ");
        this.lastName = scanner.next();
        this.password = random.nextInt(999999999);
        System.out.println("Your password generated randomly: " + this.password);
        System.out.println("Want to change password? Y/N");
        String changePW = scanner.next();
        boolean again = true;
        if (changePW.equalsIgnoreCase("y")) {
            System.out.println("Enter new password: ");
            //HANDLING INVALID PASSWORD
            while (again) {
                try {
                    this.password = scanner.nextLong();
                    setPassword(this.password);
                    again =false;
                } catch (InputMismatchException a) {
                    System.out.println("Invalid Password\nTry Again");
                    scanner.next();
                }
            }
        }
        System.out.println("Enter Department code\n1) Sales\n2) Development\n3) Accounting");
        int departmentCodes = scanner.nextInt();
        switch (departmentCodes) {
            case 1:
                this.department = "Sales";
                break;
            case 2:
                this.department = "Development";
                break;
            case 3:
                this.department = "Accounting";
                break;
            default:
                this.department = "";
        }
        this.email = firstName + "." + lastName + "@" + department + ".company.com";
        System.out.println("Enter mailbox capacity: ");
        int mailCap = scanner.nextInt();
        setMailBoxCapacity(mailCap);
    }
    //PASSWORD SETTER IF YOU SELECT IT
    private void setPassword(long password) {
        long pwDigits = CountDigits(password);
        if (pwDigits <= 9) {
            this.password = password;
        } else {
            System.out.println("Invalid Password! Old password remains the same!");
        }
    }
    private void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }
    private String getName() {
        return this.firstName.toUpperCase() + " " + this.lastName.toUpperCase();
    }
    private long CountDigits(long number) {
        String num = Long.toString(number);
        return num.length();
    }
    @Override
    public String toString() {
        String fullName = getName();
        return "Full Name: "+fullName+"\nEmail: "+email+"\nPassword: "+password+"\nMail Box Capacity: "+mailBoxCapacity+"MB\nTime Created: "+formatter.format(date);
    }
}
