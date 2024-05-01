import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

import uk.ac.leedsbeckett.oop.OOPGraphics;
public class TurtleGraphics extends OOPGraphics{
    public static boolean saved = false;
    public static boolean fileLoaded = false;
    public static ArrayList<String> commandsList = new ArrayList<>();
    public static void main(String[] args)
    {
        new TurtleGraphics();
    }
    public TurtleGraphics() {
        JFrame Screen = new JFrame();
        Screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Screen.setLayout(new FlowLayout());
        Screen.add(this);
        Screen.pack();
        Screen.setVisible(true);
        penDown();

        Screen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Screen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!saved) {
                    int confirm = JOptionPane.showConfirmDialog(Screen, "You have not saved your image. Are you sure you want to close this window?",
                            "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }else {
                        processCommand("save");
                    }

                }else {
                    int confirm = JOptionPane.showConfirmDialog(Screen, "Are you sure you want to close this window?",
                            "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            }
        });
    }

    public void processCommand(String command) {
        System.out.println(commandsList);
        int countWords = command.split("\\s").length;

        if (countWords == 1){
            switch (command) {
                case "about":
                    about();
                    saved = false;
                    commandsList.add(command);
                    System.out.println(command);
                    break;
                case "load":
                    System.out.println("load");
                    break;
                case "save":
                    System.out.println("save");
                    BufferedImage image = getBufferedImage();
                    String fileName = JOptionPane.showInputDialog(null,"Enter name to save: ");

                    try {
                        File imageFile = new File(fileName+".png");
                        File commandFile = new File(fileName+".txt");

                        while (imageFile.exists()|| commandFile.exists()){
                            int response = JOptionPane.showConfirmDialog(null, "The image file or command file " + fileName +
                                    " already exists. Do you want to overwrite it?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.YES_OPTION){
                                break;
                            }else {
                                fileName = JOptionPane.showInputDialog(null, "Please enter a new name: ");
                                imageFile = new File(fileName + ".png");
                                commandFile = new File(fileName+".txt");
                            }
                        }
                        ImageIO.write(image, "png", imageFile);

                        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(commandFile)))) {
                            for (String line : commandsList) {
                                out.println(line);
                            }
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null,"Unable to write file.");
                        }

                        JOptionPane.showMessageDialog(null,"Image and commands saved successfully.");
                        saved = true;
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,"Error: " + e);
                    }
                    break;
                case "reset":
                    reset();
                    commandsList.add(command);
                    System.out.println(command);
                    break;
                case "clear":
                    if(!saved){
                        int response = JOptionPane.showConfirmDialog(null, "You have not saved your image. " +
                                "Do you wish to reset without saving?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION){
                            commandsList.clear();
                            clear();
                            break;
                        }else {
                            processCommand("save");
                        }
                    }
                    break;

                case "penup":
                    penUp();
                    commandsList.add(command);
                    System.out.println(command);
                    break;
                case "pendown":
                    penDown();
                    commandsList.add(command);
                    System.out.println(command);
                    break;

                case "black":
                    setPenColour(Color.black);
                    commandsList.add(command);
                    System.out.println(command);
                    saved = false;
                    break;
                case "green":
                    setPenColour(Color.green);
                    commandsList.add(command);
                    saved = false;
                    break;
                case "red":
                    setPenColour(Color.red);
                    commandsList.add(command);
                    saved = false;
                    break;
                case "white":
                    setPenColour(Color.white);
                    commandsList.add(command);
                    saved = false;
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
                            commandsList.add(command);
                            System.out.println(command);
                            saved = false;
                            break;
                        case "turnright":
                            turnRight(amount);
                            commandsList.add(command);
                            System.out.println(command);
                            saved = false;
                            break;
                        case "forward":
                            forward(amount);
                            commandsList.add(command);
                            System.out.println(command);
                            saved = false;
                            break;
                        case "backward":
                            forward(-amount);
                            commandsList.add(command);
                            System.out.println(command);
                            saved = false;
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
