import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

import uk.ac.leedsbeckett.oop.OOPGraphics;
public class TurtleGraphics extends OOPGraphics{
    public static void main(String[] args)
    {
        new TurtleGraphics();
    }
    public TurtleGraphics()
    {
        JFrame Screen = new JFrame();
        Screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Screen.setLayout(new FlowLayout());
        Screen.add(this);
        Screen.pack();
        Screen.setVisible(true);
        penDown();
    }

    public void processCommand(String command) {
        int countWords = command.split("\\s").length;
        boolean saved = false;

        if (countWords == 1){
            switch (command) {
                case "about":
                    about();
                    break;
                case "load":
                    System.out.println("load");
                    break;
                case "save":
                    System.out.println("save");
                    BufferedImage image = getBufferedImage();
                    String imageName = JOptionPane.showInputDialog(null,"Enter name to save: ");

                    try {
                        File outputfile = new File(imageName+".png");

                        while (outputfile.exists()){
                            int response = JOptionPane.showConfirmDialog(null, "The image file " + imageName +
                                    " already exists. Do you want to overwrite it?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            //JOptionPane.showMessageDialog(null,imageName + " already exists");
                            if (response == JOptionPane.YES_OPTION){
                                break;
                            }else {
                                imageName = JOptionPane.showInputDialog(null, "Please enter a new name: ");
                                outputfile = new File(imageName + ".png");
                            }
                        }
                        ImageIO.write(image, "png", outputfile);
                        JOptionPane.showMessageDialog(null,"Image saved successfully.");
                        saved = true;
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,"Error: " + e);
                    }
                    break;
                case "reset":
                    reset();
                    break;
                case "clear":
                    clear();
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

               case "turnleft", "turnright", "forward", "backward":
                   JOptionPane.showMessageDialog(null,"Error. Please enter a parameter");
                   break;

               default:
                   JOptionPane.showMessageDialog(null,"Invalid command");
            }
        }else if (countWords == 2){
            String[] words = command.split("\\s");
            System.out.println(Arrays.toString(words));

            try {
                int amount = Integer.parseInt(words[1]);

                if (amount < 0){
                    JOptionPane.showMessageDialog(null,"Error. Please enter a positive number");
                } else if (amount > 200) {
                    JOptionPane.showMessageDialog(null,"Error. Please enter a reasonable value between 0 and 200");
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
                            forward(-amount);
                            System.out.println("You want to go backwards");
                            break;
                        default:
                            System.out.println("Invalid command");
                    }
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Not a valid number");
            }
        } else{
            JOptionPane.showMessageDialog(null,"Please enter a valid command");
        }
    }
}
