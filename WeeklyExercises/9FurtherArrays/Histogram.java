import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        int[] frequency = new int[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integers between 1 and 100. Type 'end' to finish the input.");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number >= 1 && number <= 100) {
                    frequency[(number - 1) / 10]++;
                }
                else {
                    System.out.println("Invalid input. Please enter an integer between 1 and 100.");
                }
            }
            else if (scanner.hasNext("end")) {
                break;
            }
            else {
                System.out.println("Invalid input. Please enter an integer or 'end'.");
                scanner.next(); // discard the invalid input
            }
        }

        for (int i = 0; i < 10; i++) {
            int rangeStart = i * 10 + 1;
            int rangeEnd = (i + 1) * 10;
            if (rangeStart == 1){
                System.out.print(rangeStart + "-" + rangeEnd + "   | ");
            }
            else if (rangeStart == 91){
                System.out.print(rangeStart + "-" + rangeEnd + " | ");
            }
            else {
                System.out.print(rangeStart + "-" + rangeEnd + "  | ");
            }

            for (int j = 0; j < frequency[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
