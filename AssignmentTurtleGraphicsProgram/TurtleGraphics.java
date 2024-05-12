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
    public static boolean loaded = false;
    public static String loadedName;
    public static ArrayList<String> commandsList = new ArrayList<>();
    private final JFrame Screen;

    public static void main(String[] args)
    {
        new TurtleGraphics();
    }
    public TurtleGraphics() {
        Screen = new JFrame();
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
                    File savedFile = new File(JOptionPane.showInputDialog(null,"Enter name of image you wish to load: "));
                    loadedName = String.valueOf(savedFile);
                    File imagePath = new File(loadedName +".png");
                    File commandPath = new File(loadedName+".txt");

                    if (imagePath.exists()) {
                        try {
                            BufferedImage loadedImage = ImageIO.read(new File(String.valueOf(imagePath)));
                            setBufferedImage(loadedImage);
                            loaded = true;
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null,"Unable to load image");
                            throw new RuntimeException(e);
                        }

                        try (BufferedReader br = new BufferedReader(new FileReader(commandPath))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                                processCommand(line);
                                commandsList.add(line);
                            }
                            JOptionPane.showMessageDialog(null, "Image and commands loaded successfully.");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"Image or command file does not exist.");
                    }
                    break;
                case "save":
                    System.out.println("save");
                    BufferedImage image = getBufferedImage();

                    if (loaded) {
                        int response = JOptionPane.showConfirmDialog(null, "Do you wish to overwrite" + loadedName + " and associated commands?",
                                "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            File imageFile = new File(loadedName+".png");
                            File commandFile = new File(loadedName+".txt");
                            try {
                                ImageIO.write(image, "png", imageFile);
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null,"Unable to load requested image");
                                throw new RuntimeException(e);
                            }

                            saving(commandFile);
                            break;
                        }
                    }
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

                        saving(commandFile);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,"Error: " + e);
                    }
                    break;
                case "reset":
                    reset();
                    penDown();
                    commandsList.add(command);
                    System.out.println(command);
                    break;
                case "clear":
                    if(!saved){
                        int response = JOptionPane.showConfirmDialog(null, "You have not saved your image. " +
                                "Do you wish to reset without saving?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION){
                            commandsList.clear();
                            showAbout = false;
                            reset();
                            clear();
                            break;
                        }else {
                            processCommand("save");
                        }
                    }else {
                        showAbout = false;
                        clear();
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

                case "turnleft", "turnright", "forward", "backward","square":
                    JOptionPane.showMessageDialog(null,"Error. Please enter a parameter");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,"Invalid command");
            }
        }else if (countWords == 2){
            String[] words = command.split("\\s");
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
                        case "square":
                            square(amount);
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

    private void saving(File commandFile) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(commandFile)))) {
            for (String line : commandsList) {
                out.println(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Unable to write file.");
        }

        JOptionPane.showMessageDialog(null,"Image and commands saved successfully.");
        saved = true;
    }
    private boolean showAbout = false;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (showAbout) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Laura Gandia", 150, 325);
        }
    }
    @Override
    public void about() {
        super.about();
        showAbout = true;
        repaint();
    }
    private void square(int len){
        int x1 = getxPos();
        int y1 = getyPos();

        int x2 = getxPos() + len;
        int y2 = getyPos() + len;

        int x3 = x2 + len;
        System.out.println(x3);
        int y3 = y2 + len;
        System.out.println(y3);

        drawLine(getPenColour(),x1,y1,x1,y2);
        drawLine(getPenColour(),x1,y1,x2,y1);
        drawLine(getPenColour(),x2,y1,x2,y2);
        drawLine(getPenColour(),x2,y2,x1,y2);
        repaint();
    }
}