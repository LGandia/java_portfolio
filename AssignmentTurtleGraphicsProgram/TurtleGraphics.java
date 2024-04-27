import java.awt.*;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.JFrame;
import uk.ac.leedsbeckett.oop.OOPGraphics;
public class TurtleGraphics extends OOPGraphics{
    public static void main(String[] args)
    {
        new TurtleGraphics();
    }
    public TurtleGraphics()
    {
        JFrame Screen = new JFrame();                            //create a frame to display the turtle panel on
        Screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Make sure the app exits when closed
        Screen.setLayout(new FlowLayout());                      //not strictly necessary
        Screen.add(this);                                        //"this" is this object that extends turtle graphics, so we are adding a turtle graphics panel to the frame
        Screen.pack();                                           //set the frame to a size we can see
        Screen.setVisible(true);                                 //now display it
    }

    public void processCommand(String command) {
        int countWords = command.split("\\s").length;

        if (countWords == 1){
            switch (command){
                case "about":
                    about();
                    break;
                case "penup":
                    penUp();
                    System.out.println("penup");
                    break;
                case "pendown":
                    penDown();
                    System.out.println("pendown");
                    break;

                case "black":
                    setPenColour(Color.black);
                    System.out.println("black");
                    break;
                case "green":
                    setPenColour(Color.green);
                    System.out.println("green");
                    break;
                case "red":
                    setPenColour(Color.red);
                    System.out.println("red");
                    break;
                case "white":
                    setPenColour(Color.white);
                    System.out.println("white");
                    break;

                case "reset":
                    reset();
                    System.out.println("reset");
                    break;
                case "clear":
                    System.out.println("clear");
                    clear();
                    break;

                case "turnleft", "turnright", "forward", "backward":
                    System.out.println("Please enter a parameter");
                    break;

                default:
                    System.out.println("Invalid command");
            }
        } else if (countWords == 2){
            String[] words = command.split("\\s");
            System.out.println(Arrays.toString(words));

            try {
                int amount = Integer.parseInt(words[1]);

                if (amount < 0){
                    System.out.println("Please enter a positive number");
                } else if (amount > 1000) {
                    System.out.println("Please enter a reasonable value");
                } else {
                    switch (words[0]) {
                        case "turnleft":
                            turnLeft(amount);
                            System.out.println("You want to turn left");
                            break;
                        case "turnright":
                            turnRight(amount);
                            System.out.println("You want to turn right");
                            break;
                        case "forward":
                            forward(amount);
                            break;
                        case "backward":
                            System.out.println("You want to go backwards");
                            break;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Not a valid number");
            }
        } else{
            System.out.println("Please enter a valid command");
        }
    }
}
