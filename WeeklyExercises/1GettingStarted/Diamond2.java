public class Diamond2 {
    public static void main (String[] args) {
        String[] diamond = {"       *", "      ***", "     *****", "    *******"};

        for (String s : diamond) {
            System.out.println(s + " ");
        }
        //List looped backwards for symmetrical shape
        for (int i = diamond.length - 2; i >= 0; i--) {
            System.out.println(diamond[i] + " ");
        }
    }
}
