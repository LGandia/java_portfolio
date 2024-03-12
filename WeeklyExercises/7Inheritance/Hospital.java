class Employee{
    public int employeeID;
    public String employeeName;
    public String employeeDepartment;
    public String employeeWorkType;

    public Employee(int employeeID, String employeeName, String employeeDepartment, String employeeWorkType) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeeWorkType = employeeWorkType;
    }
}
class Doctor extends Employee{
    public String employeeDuties;
    public Doctor(int employeeID, String employeeName, String employeeDepartment, String employeeWorkType, String employeeDuties){

        super(employeeID, employeeName, employeeDepartment, employeeWorkType);
        this.employeeDuties = employeeDuties;
    }

    public void getDoctorDetails() {
        System.out.println("Employee ID: "+this.employeeID);
        System.out.println("Name: "+this.employeeName);
        System.out.println("Department: "+this.employeeDepartment);
        System.out.println("Work: "+this.employeeWorkType);
    }
}
// class nurse extends employee{}
// class receptionist extends employee{}
// class cleaner extends employee{}
class Hospital {
    public static void main (String[] args) {
        Doctor doctor = new Doctor(498984, "Dylan", "Medicine","Cardiologist","Work");
        doctor.getDoctorDetails();
    }
}


