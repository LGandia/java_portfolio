public class Sphere {
<<<<<<< HEAD
        double diameter;
        double volume = (4*((double) 22 /7)*Math.pow((diameter/2),3))/3;
        double surfaceArea = 4*((double) 22 /7)*Math.pow((diameter/2),2);
}
=======
    private double diameter;

    // constructor method
    public Sphere(double diameter) {
        this.diameter = diameter;
    }

    // Diameter getter and setter methods.
    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    // methods
    public double calculateVolume() {
        double radius = diameter / 2;
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public double calculateSurfaceArea() {
        double radius = diameter / 2;
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Sphere with diameter " + diameter +
                ", surface area " + calculateSurfaceArea() +
                " and volume " + calculateVolume();
    }
}

class MultiSphere {
    public static void main(String[] args) {
        Sphere sphere1 = new Sphere(1.0);
        Sphere sphere2 = new Sphere(15.0);

        System.out.println(sphere1);
        System.out.println(sphere2);
    }
}
>>>>>>> 84f931bd5b4e38a9d4e19fe9579bbb87239cdf9a
