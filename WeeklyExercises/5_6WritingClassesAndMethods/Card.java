import java.util.Random;

public class Card {
    private String suit;
    private String faceValue;
    public Card(String suit, String faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(String faceValue) {
        this.faceValue = faceValue;
    }

    @Override
    public String toString() {
        return faceValue +" of "+suit;
    }
}
class Dealing{
    public static void main(String[] args) {

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] faceValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            String suitValue = suits[random.nextInt(suits.length)];
            String faceNum = faceValues[random.nextInt(faceValues.length)];

            Card card = new Card(suitValue, faceNum);
            System.out.println(card);
        }
    }
}