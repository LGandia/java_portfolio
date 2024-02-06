public class Diamond2 {
    //----------------------------------------------------
    //  Prints a diamond shape.
    //----------------------------------------------------
    public static void main (String[] args) {
        String[] diamond = {"       *", "      ***", "     *****", "    *******"};

        for (int i = 0; i < diamond.length; i++) {
            System.out.println(diamond[i] + " ");
        }
        //List looped backwards for symmetrical shape
        for (int i = diamond.length - 2; i >= 0; i--) {
            System.out.println(diamond[i] + " ");
        }
    }
}
