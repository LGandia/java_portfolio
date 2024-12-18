import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

import uk.ac.leedsbeckett.oop.OOPGraphics;

public class TurtleGraphics extends OOPGraphics{

    private static boolean saved = false;
    private static boolean loaded = false;
    private static String loadedName;
    private static final ArrayList<String> commandsList = new ArrayList<>();

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

        int countWords = command.split("\\s").length;
        String[] words = command.split("\\s");
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
                    setPenColour(Color.red);
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
                            System.out.println("load");
                            commandsList.clear();
                            showAbout = false;
                            setPenColour(Color.red);
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
                    break;
                case "green":
                    setPenColour(Color.green);
                    commandsList.add(command);
                    System.out.println(command);
                    break;
                case "red":
                    setPenColour(Color.red);
                    commandsList.add(command);
                    System.out.println(command);
                    break;
                case "white":
                    setPenColour(Color.white);
                    commandsList.add(command);
                    System.out.println(command);
                    break;
                case "blue":
                    setPenColour(Color.blue);
                    commandsList.add(command);
                    System.out.println(command);
                    break;

                case "turnleft", "turnright", "forward", "backward","square","triangle","pencolour":
                    JOptionPane.showMessageDialog(null,"Error. Please enter a parameter");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,"Invalid command");
            }
        }else if (countWords == 2){
            try {
                int amount = Integer.parseInt(words[1]);

                if (amount < 0){
                    JOptionPane.showMessageDialog(null,"Error. Please enter a positive number");
                } else if ((words[0].equals("forward") || words[0].equals("backward"))&& amount > 300) {
                    JOptionPane.showMessageDialog(null, "Error. Please enter a reasonable value between 0 and 300");
                } else if (amount > 360) {
                    JOptionPane.showMessageDialog(null, "Error. Please enter a reasonable value between 0 and 360");
                } else {
                    switch (words[0]) {
                        case "turnleft":
                            turnLeft(amount);
                            commandsList.add(command);
                            System.out.println(command);
                            break;
                        case "turnright":
                            turnRight(amount);
                            commandsList.add(command);
                            System.out.println(command);
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
                        case "triangle":
                            triangle(amount);
                            commandsList.add(command);
                            System.out.println(command);
                            saved = false;
                            break;
                        case "penwidth":
                            penwidth(amount);
                            commandsList.add(command);
                            System.out.println(command);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Invalid command");
                    }
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Not a valid number");
            }
        } else if (countWords == 4) {
            boolean validValues = false;
            for (int i = 1; i < words.length; i++) {
                int num = Integer.parseInt(words[i]);
                if (num < 0) {
                    JOptionPane.showMessageDialog(null, "Error. Please enter a positive values");
                    break;
                } else if (words[0].equals("pencolour") && num > 255) {
                    JOptionPane.showMessageDialog(null, "Error. Please enter a reasonable value between 0 and 255");
                    break;
                } else {
                    validValues = true;
                }
            }
            if (validValues) {
                int num1 = Integer.parseInt(words[1]);
                int num2 = Integer.parseInt(words[2]);
                int num3 = Integer.parseInt(words[3]);

                switch (words[0]){
                    case "pencolour":
                        pencolour(num1, num2, num3);
                        commandsList.add(command);
                        System.out.println(command);
                        saved = false;
                        break;
                    case "triangle":
                        if (num1 + num2 <= num3 || num1 + num3 <= num2 || num2 + num3 <= num1) {
                            JOptionPane.showMessageDialog(null,"The lengths given do not form a valid triangle");
                        }else {
                            triangle(num1, num2, num3);
                            commandsList.add(command);
                            System.out.println(command);
                            saved = false;
                            break;
                        }
                }
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

        drawLine(getPenColour(),x1,y1,x1,y2);
        drawLine(getPenColour(),x1,y1,x2,y1);
        drawLine(getPenColour(),x2,y1,x2,y2);
        drawLine(getPenColour(),x2,y2,x1,y2);
        repaint();
    }
    private void triangle(int len){
        int x1 = getxPos(), y1 = getyPos();
        int x2 = getxPos() + len;

        int x3 = x1 + len/2;
        int y3 = y1 + (int)Math.round(Math.sqrt(3) / 2 * len);

        drawLine(getPenColour(),x1,y1,x2,y1);
        drawLine(getPenColour(),x2,y1,x3,y3);
        drawLine(getPenColour(),x3,y3,x1,y1);

        repaint();
    }
    private void triangle(int len1, int len2, int len3){

        double angle3 = Math.acos((Math.pow(len1, 2) + Math.pow(len2, 2) - Math.pow(len3, 2)) / (2.0 * len1 * len2));

        int x1 = getxPos(), y1 = getyPos();
        int x2 = getxPos() + len1;

        int x3 = (int)(x1 + len2 * Math.cos(angle3));
        int y3 = (int)(y1 + len2 * Math.sin(angle3));

        drawLine(getPenColour(),x1,y1,x2, y1);
        drawLine(getPenColour(),x2,y1,x3,y3);
        drawLine(getPenColour(),x3,y3,x1,y1);
        repaint();
    }

    private void pencolour(int r, int g,int b){
        setPenColour(new Color(r,g,b));
    }
    private void penwidth(int width){
        if (width > 20){
            JOptionPane.showMessageDialog(null,"Please enter a number less than 20");
        } else if (width == 0) {
            JOptionPane.showMessageDialog(null,"Please enter a number greater than 0");
        }else {
            setStroke(width);
        }
    }
}