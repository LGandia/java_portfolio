import java.util.Scanner;

class Person {
    String firstName;
    String lastName;
    String postalCode;

    Person(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + ", Last Name: " + lastName + ", Postal Code: " + postalCode;
    }
}

public class Postcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person[] persons = new Person[25];
        int count = 0;

        while (scanner.hasNextLine() && count < 25) {
            String[] input = scanner.nextLine().split("\t");
            if (input.length == 3) {
                persons[count++] = new Person(input[0], input[1], input[2]);
            } else {
                System.out.println("Invalid input. Please enter First Name, Last Name and Postal Code separated by tabs.");
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.println(persons[i]);
        }
    }
}
