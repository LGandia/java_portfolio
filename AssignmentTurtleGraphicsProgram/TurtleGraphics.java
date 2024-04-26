import java.awt.FlowLayout;
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
        if (Objects.equals(command, "about")){
            about();
        }

    }
}
