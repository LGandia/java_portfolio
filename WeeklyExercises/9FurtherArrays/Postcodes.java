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
        return "First Name: " + firstName + "\nLast Name: " + lastName + "\nPostal Code: " + postalCode +"\n";
    }
}

public class Postcodes {
    public static void main(String[] args) {
        System.out.println("Enter user in the following format {first name} tab {last name} tab {post code}. Leave blank to terminate program");
        Scanner scanner = new Scanner(System.in);
        Person[] persons = new Person[25];
        int count = 0;

        while (scanner.hasNextLine() && count < 25) {
            String[] input = scanner.nextLine().split("\t");
            if (input.length == 3) {
                System.out.println("Enter next user: ");
                persons[count++] = new Person(input[0], input[1], input[2]);
            } else if (input.length == 1) {
                break;
            }
            else {
                System.out.println("Invalid input. Please enter First Name, Last Name and Postal Code separated by tabs.");
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.println(persons[i]);
        }
    }
}
