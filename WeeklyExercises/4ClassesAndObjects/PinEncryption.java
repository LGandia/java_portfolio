import java.util.Scanner;
import java.util.Random;

public class PinEncryption {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter 4 digit number to encrypt: ");
        int pin = scan.nextInt();

        int number1 = random.nextInt(1000, 655336);
        int number2 = random.nextInt(1000, 655336);
    }
}