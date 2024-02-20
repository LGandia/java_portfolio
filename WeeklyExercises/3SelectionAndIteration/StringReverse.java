import java.util.Scanner;

public class StringReverse{
    public static void main(String[] args){

        StringReverse O = new StringReverse();
        O.go();
    }
    public void go(){

        Scanner scan = new Scanner(System.in);

        String sentence;
        StringBuilder reverse = new StringBuilder();

        System.out.print("Input the word(s) to be reversed: ");
        sentence = scan.next();

        for (int i = sentence.length() - 1; i>0; i--){
            reverse.append(sentence.charAt(i));
        }
        System.out.println(reverse);
    }
}