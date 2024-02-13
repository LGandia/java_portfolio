import java.util.Scanner;

public class PunctuationCounter
{
    public static void main (String[] args)
    {
        PunctuationCounter O = new PunctuationCounter();
        O.go();
        //https://www.javatpoint.com/program-to-count-all-punctuation-characters-in-the-string
    }
    public void go()
    {
        int counter = 0;
        String sentence;

        Scanner scan = new Scanner(System.in);
        System.out.print("Input sentence: ");
        sentence = scan.next();

    }
}
