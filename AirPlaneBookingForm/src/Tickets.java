import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Tickets {
    private String destination;
    private Date date;
    private LocalDate d;
    private int numberOfPeople;
    private String seatType;
    private Scanner scanner = new Scanner(System.in);

    public Tickets() {
        System.out.println("Enter Destination: ");
        this.destination = scanner.next();
        this.date = new Date();
        System.out.println("Enter Year: ");
        int year = scanner.nextInt();
        if (year<2020 && year>2022){
            year = 2020;
        }
        System.out.println("Enter Month By Number: ");
        int month = scanner.nextInt();
        if (month>12){
            month = 9;
        }
        System.out.println("Enter Day: ");
        int day = scanner.nextInt();
        if (day>30){
            day=30;
        }
        this.d = LocalDate.of(year,month,day);
        System.out.println("Enter number of people: ");
        this.numberOfPeople = scanner.nextInt();
        System.out.println("Enter type of seat:\nB) for business class\nR) for regular class");
        this.seatType = scanner.next();
        switch (seatType){
            case "B":
                this.seatType = "Business";
                break;
            default:
                this.seatType = "Regular";
                break;
        }
    }
    @Override
    public String toString() {
        return "Destination: "+this.destination+"\nDate of booking: "+date+"\nDate of Flight: "+d+"\nNumber Of Seats: "+numberOfPeople+"\nType of Seats: "+seatType;
    }
}
