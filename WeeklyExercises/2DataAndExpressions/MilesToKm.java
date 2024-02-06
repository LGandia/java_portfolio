import java.util.Scanner;
public class MilesToKm
{
    public static void main(String[] args) {
        int miles;
        double kilometers;
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter miles and " +
                "I will convert them to kilometers");

        miles = scan.nextInt();
        kilometers = (double) miles * 1.60935;
        System.out.println("This converts to: "+ kilometers + "km");
    }
}
