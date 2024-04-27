import java.awt.FlowLayout;
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
        System.out.println(countWords);

        if (Objects.equals(command, "about")){
            about();
        }
        //else if (){}
        else if (countWords == 2){
            String[] words = command.split("\\s");
            System.out.println(Arrays.toString(words));

            try {
                int length = Integer.parseInt(words[1]);
            }catch (NumberFormatException e){
                System.out.println("Not a valid number");
            }
            switch (words[0]) {
                case "turnleft":
                    System.out.println("You want to turn left");
                    break;
                case "turnright":
                    System.out.println("You want to turn right");
                    break;
                case "forward":
                    System.out.println("You want to go forward");
                    break;
                case "backward":
                    System.out.println("You want to go backwards");
                    break;
            }
        }
        else{
            System.out.println("Please enter a valid command/unit");
        }
    }
}
