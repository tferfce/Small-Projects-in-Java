import java.util.List;
import java.util.Scanner;

public class UserFind {
    public static int UserExists(List<Mail> user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter position");
        int position = scanner.nextInt();
        //HANDLING INVALID POSITION NUMBER
        try {
            System.out.println(user.get(position));
            System.out.println("======================");
            System.out.println("The User Found in position: "+position);
            System.out.println("======================");
            return position;

        }catch (IndexOutOfBoundsException e){
            return -1;
        }
    }
}
