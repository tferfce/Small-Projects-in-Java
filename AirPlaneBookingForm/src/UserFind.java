import java.util.List;
import java.util.Scanner;

public class UserFind {
    public static Scanner scanner = new Scanner(System.in);
    public static int getPosition (List<SignUp> list, long phoneNumber){
        for (int i=0; i<list.size(); i++){
            if (list.get(i).getPhoneNumber() == phoneNumber){
                System.out.println("User Already Exists");
                return i;
            }
        }
        return -1;
    }
    public static SignUp getPosition (List<SignUp> list){
        System.out.println("Enter Phone Number To Log In: ");
        long phoneNumber = scanner.nextLong();
        for (int i=0; i<list.size(); i++){
            if (list.get(i).getPhoneNumber() == phoneNumber){
                return list.get(i);
            }
        }
        return null;
    }
}
