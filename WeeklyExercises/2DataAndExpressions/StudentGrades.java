public class StudentGrades {
    public static void main (String[] args)
    {
        StudentGrades O = new StudentGrades();
        O.go();
    }
    public void go() {

        System.out.println("///////////////////" +
                "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println("==          Student Points          ==");
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\" +
                "///////////////////");

        System.out.println("\nName           Lab     Bonus   Total");
        System.out.println("----           ---     -----   -----");

        //https://stackoverflow.com/questions/18672643/how-to-print-a-table-of-information-in-java
        final Object[][] grades = new String[5][];
        grades[0] = new String[]{"Walt", "70", "7", "77"};
        grades[1] = new String[]{"Jesse", "25", "3", "28"};
        grades[2] = new String[]{"Gus", "70", "30", "100"};
        grades[3] = new String[]{"Mike", "40", "10", "50"};
        grades[4] = new String[]{"Hank", "50", "7", "57"};

        for (final Object[] row : grades)
        {
            System.out.format("%-15s%-9s%-8s%-9s%n", row);
        }
    }
}
