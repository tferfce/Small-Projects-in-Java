import java.util.List;
import java.util.Scanner;
//DELETE A USER FROM LIST
public class Delete {
    public static int deleteFromList(List<Mail> user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the position of the user you want to remove!");
        int position = scanner.nextInt();
        //HANDLING INVALID POSITION NUMBER
        try {
            System.out.println(user.get(position));
            System.out.println("======================");
            System.out.println("removed".toUpperCase());
            System.out.println("======================");
            user.remove(position);
            return position;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Invalid Position!");
            return -1;
        }
    }
}
