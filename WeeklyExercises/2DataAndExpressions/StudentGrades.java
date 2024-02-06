public class StudentGrades {
    public static void main (String[] args) {

        System.out.println("///////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println("==          Student Points          ==");
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\///////////////////");

        System.out.println("\nName           Lab     Bonus   Total");
        System.out.println("----           ---     -----   -----");

        final Object[][] grades = new String[5][];
        grades[0] = new String[] {"Walt", "50", "7","57"};

        for (final Object[] row : grades){
            System.out.format("%-15s%-9s%-8s%-9s%n", row);
        }
    }
}
