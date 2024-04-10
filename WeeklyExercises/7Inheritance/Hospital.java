abstract class HospitalEmployee{
    public int employeeID;
    public String employeeName;
    public String employeeDepartment;
    public String employeeWorkType;

    public HospitalEmployee(int employeeID, String employeeName, String employeeDepartment, String employeeWorkType) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeeWorkType = employeeWorkType;
    }
}
class Doctor extends HospitalEmployee{
    public String employeeDuties;
    public Doctor(int employeeID, String employeeName, String employeeDepartment, String employeeWorkType, String employeeDuties){

        super(employeeID, employeeName, employeeDepartment, employeeWorkType);
        this.employeeDuties = employeeDuties;
    }

    public void getDoctorDetails() {
        System.out.println("=================================");
        System.out.println("FirmVacation.Employee ID: "+this.employeeID);
        System.out.println("Name: "+this.employeeName);
        System.out.println("Department: "+this.employeeDepartment);
        System.out.println("Work: "+this.employeeWorkType);
        System.out.println("=================================");
    }
}
class Nurse extends HospitalEmployee{
    public String employeeDuties;
    public Nurse(int employeeID, String employeeName, String employeeDepartment, String employeeWorkType, String employeeDuties) {
        super(employeeID, employeeName, employeeDepartment, employeeWorkType);
        this.employeeDuties = employeeDuties;
    }

    public void getNurseDetails() {
        System.out.println("=================================");
        System.out.println("FirmVacation.Employee ID: "+this.employeeID);
        System.out.println("Name: "+this.employeeName);
        System.out.println("Department: "+this.employeeDepartment);
        System.out.println("Work: "+this.employeeWorkType);
        System.out.println("=================================");
    }
}

class Receptionist extends HospitalEmployee{
    public String employeeDuties;
    public Receptionist(int employeeID, String employeeName, String employeeDepartment, String employeeWorkType, String employeeDuties) {
        super(employeeID, employeeName, employeeDepartment, employeeWorkType);
        this.employeeDuties = employeeDuties;
    }

    public void getReceptionistDetails() {
        System.out.println("=================================");
        System.out.println("FirmVacation.Employee ID: "+this.employeeID);
        System.out.println("Name: "+this.employeeName);
        System.out.println("Department: "+this.employeeDepartment);
        System.out.println("Work: "+this.employeeWorkType);
        System.out.println("=================================");
    }
}
class Cleaner extends HospitalEmployee{
    public String employeeDuties;
    public Cleaner(int employeeID, String employeeName, String employeeDepartment, String employeeWorkType, String employeeDuties) {
        super(employeeID, employeeName, employeeDepartment, employeeWorkType);
        this.employeeDuties = employeeDuties;
    }

    public void getCleanerDetails() {
        System.out.println("=================================");
        System.out.println("FirmVacation.Employee ID: "+this.employeeID);
        System.out.println("Name: "+this.employeeName);
        System.out.println("Department: "+this.employeeDepartment);
        System.out.println("Work: "+this.employeeWorkType);
        System.out.println("=================================");
    }
}
class Hospital {
    public static void main (String[] args) {
        Doctor doctor = new Doctor(498984, "Dylan", "Medicine","Cardiologist","Work");
        doctor.getDoctorDetails();

        Nurse nurse = new Nurse(16156, "Dew", "Oncology","Blood sampling","Chemotherapy");
        nurse.getNurseDetails();

        Receptionist receptionist = new Receptionist(798948, "Casie", "Cafeteria","Client services","Ensure comfort");
        receptionist.getReceptionistDetails();

        Cleaner cleaner = new Cleaner(615615, "Janek", "Disinfection","Deep cleaning","Clean operating room");
        cleaner.getCleanerDetails();
    }
}


