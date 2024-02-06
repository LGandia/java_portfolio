import java.util.Scanner;

public class Fraction
{
    public static void main(String[] args) {
        int numerator, denominator;
        double decimal;

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        numerator = scan.nextInt();
        System.out.print("Enter denominator: ");
        denominator = scan.nextInt();

        decimal = (double) numerator /denominator;
        System.out.println("The fraction works out to be: "+decimal);

    }
}
