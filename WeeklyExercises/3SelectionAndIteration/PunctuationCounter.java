import java.util.Scanner;

public class PunctuationCounter
{
    public static void main (String[] args)
    {
        PunctuationCounter O = new PunctuationCounter();
        O.go();
    }
    public void go()
    {
        int exclamation = 0;
        int comma = 0;
        int semicolon = 0;
        int period = 0;
        int interrogation = 0;
        int dash = 0;
        int slash = 0;
        int bslash = 0;
        int colon = 0;


        String sentence;

        Scanner scan = new Scanner(System.in);
        System.out.print("Input sentence: ");
        sentence = scan.nextLine();

        for (int i = sentence.length() - 1; i>=0; i--)
        {
            if (sentence.charAt(i) == '!') {exclamation++;}
            else if (sentence.charAt(i) == ',') {comma++;}
            else if (sentence.charAt(i) == ';') {semicolon++;}
            else if (sentence.charAt(i) == '.') {period++;}
            else if (sentence.charAt(i) == '?') {interrogation++;}
            else if (sentence.charAt(i) == '-') {dash++;}
            else if (sentence.charAt(i) == '/') {slash++;}
            else if (sentence.charAt(i) == '\"') {bslash++;}
            else if (sentence.charAt(i) == ':') {colon++;}
        }
        // Mary had a little lamb, her fleece was as white as snow, and everywhere Mary went, the lamb was sure to go. -that was a nice poem- the end.

        System.out.println("Punctuation"+"\t\t\t"+"Number");
        System.out.println("exclamation (!)" + exclamation);
        System.out.println("comma (,) = " + (comma));
        System.out.println("semicolon (;) = " + (semicolon));
        System.out.println("period (.) = " + period);
        System.out.println("interrogation (?) = " + (interrogation));
        System.out.println("dash (-) = " + (dash));
        System.out.println("slash (/) = " + (slash));
        System.out.println("backslash (\") = " + (bslash));
        System.out.println("colon (:) = " + (colon));
    }
}
