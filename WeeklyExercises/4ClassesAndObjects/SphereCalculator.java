import java.util.Scanner;
import java.lang.Math;
public class SphereCalculator {
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double radius = scan.nextDouble();
        double volume = (4*((double) 22 /7)*Math.pow(radius,3))/3;
        double surfaceArea = 4*((double) 22 /7)*Math.pow(radius,2);

        System.out.println("Your radius: "+radius);
        System.out.println("Your sphere volume: "+volume);
        System.out.println("Your surface area: "+surfaceArea);
    }

}
