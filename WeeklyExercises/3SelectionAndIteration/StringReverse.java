import java.util.Scanner;

public class StringReverse{
    public static void main(String[] args){

        StringReverse O = new StringReverse();
        O.go();
    }
    public void go(){
        Scanner scan = new Scanner(System.in);

        String sentence;
        String reverse = "";

        System.out.print("Input the word(s) to be reversed: ");
        sentence = scan.nextLine();

        for (int i = sentence.length() - 1; i>0; i--){
            reverse += sentence.charAt(i);
        }
        System.out.println(sentence.length());
        System.out.println(reverse);
    }
}