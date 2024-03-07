import java.util.Scanner;
import java.lang.Math;
public class SphereCalculator {
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double radius = scan.nextDouble();
        double volume = (4.0/3.0)*Math.PI*Math.pow(radius,3);
        double surfaceArea = 4*Math.PI*Math.pow(radius,2);

        System.out.println("Your radius: "+radius);
        System.out.println("Your sphere volume: "+volume);
        System.out.println("Your surface area: "+surfaceArea);
    }

}
