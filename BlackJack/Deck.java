import java.util.ArrayList;
import java.util.*;

public class Deck {

    private ArrayList<Card> cardList;
    int top;

    public Deck() {
        cardList = new ArrayList<>();
        populate();
        shuffle();

    }

    public void populate() {
        top = 0;
        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                Card c = new Card(rank, suit);
                cardList.add(c);
            }
        }

    }

    public Card deal() {
        Card c = cardList.get(top);
        cardList.remove(top);
        return c;

    }

    public void shuffle() {
        Collections.shuffle(cardList);
    }

    public boolean isEmpty() {
        if (cardList.isEmpty())
            return true;
        else
            return false;
    }

}
