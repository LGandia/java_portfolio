import java.util.Scanner;
import java.util.Random;

public class PinEncryption {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter 4 digit number to encrypt: ");
        int pin = scan.nextInt();
        String hexpin = Integer.toHexString(pin);

        int number1 = random.nextInt(1000, 655336);
        String hex1 = Integer.toHexString(number1);
        int number2 = random.nextInt(1000, 655336);
        String hex2 = Integer.toHexString(number2);
    }
}