//********************************************************************
//  Firm.java       Java Foundations
//
//  Demonstrates polymorphism via inheritance.
//********************************************************************

public class Firm
{
    //-----------------------------------------------------------------
    //  Creates a staff of employees for a firm and pays them.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        Staff personnel = new Staff();

        personnel.payday();
        for (StaffMember member : personnel.staffList) {
            if (member instanceof Executive) {
                System.out.println("Executive gets 30 days of vacation.");
            } else if (member instanceof Employee) {
                System.out.println("Employee gets 25 days of vacation.");
            } else if (member instanceof Hourly) {
                System.out.println("Hourly employee gets 20 days of vacation.");
            } else {
                System.out.println("Volunteer does not get paid vacation.");
            }
        }
    }
}