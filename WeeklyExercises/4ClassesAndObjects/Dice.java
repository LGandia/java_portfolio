import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Dice
{

    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        List<Integer> rolls1 = new ArrayList<>();
        double total1 = 0;
        System.out.print("How many sides does die 1 have? ");
        int DieSide1 = scan.nextInt();

        List<Integer> rolls2 = new ArrayList<>();
        double total2 = 0;
        System.out.print("\nHow many sides does die 2 have? ");
        int DieSide2 = scan.nextInt();

        for (int i = 0; i<3; i++)
        {
            String position = null;

            rolls1.add(random.nextInt(1,DieSide1));
            rolls2.add(random.nextInt(1,DieSide2));

            total1 = total1+rolls1.get(i);
            total2 += rolls2.get(i);

            if (i == 0)
                position = "first";
            else if (i == 1)
                position = "second";
            else
                position = "third";

            System.out.println("Die 1 "+ position+ " roll = "+rolls1.get(i));
            System.out.println("Die 2 "+ position+ " roll = "+rolls2.get(i));
            if (i > 1)
            {
                System.out.printf("Die 1 rolled a total of " + total1 + " and rolled "
                        + String.format("%.2f",(total1 / 3)) + " on average.");
                System.out.printf("\nDie 2 rolled a total of " + total2 + " and rolled "
                        + String.format("%.2f",(total2 / 3)) + " on average.");
            }
        }

    }
}
