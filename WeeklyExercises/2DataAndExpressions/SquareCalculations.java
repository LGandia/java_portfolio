import java.util.Scanner;

public class SquareCalculations
{
    public static void main(String[] args) {
        int side, perimeter, area;
        Scanner scan = new Scanner(System.in);

        // get three values from user
        System.out.println("Please enter length of the side of a square and " +
                "I will calculate the perimeter and area of the square");

        side = scan.nextInt();
        perimeter = side * 4;
        area = side*side;
        System.out.println("The perimeter of the square is "+perimeter+" and the area is "+area);
    }
}
