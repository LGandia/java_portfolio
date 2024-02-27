class Sphere
{
    private double diameter;
    private final double volume;
    private final double surfaceArea;

    // constructor method
    public Sphere(double diameter, double volume, double surfaceArea) {
        this.diameter = diameter;
        this.volume = ((double) 4 /3)*( (double) 22 /7)*(diameter/2)*(diameter/2)*(diameter/2);
        this.surfaceArea = (double) (4 * (22/7))*diameter*diameter;
    }

    // Diameter getter and setter methods.
    public double getDiameter() {
        return diameter;
    }
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "diameter=" + diameter +
                ", volume=" + volume +
                ", surfaceArea=" + surfaceArea +
                '}';
    }
}



