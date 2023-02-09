public class Card {

    private int rank;
    private int suit;
    private boolean isFaceUp;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
        this.isFaceUp = true;

    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public boolean getIsFaceUp() {
        return isFaceUp;
    }

    public String toString() {
        String value = "";
        switch (rank) {
            case 1:
                value = "ACE";
                break;
            case 2:
                value = "TWO";
                break;
            case 3:
                value = "THREE";
                break;
            case 4:
                value = "FOUR";
                break;
            case 5:
                value = "FIVE";
                break;
            case 6:
                value = "SIX";
                break;
            case 7:
                value = "SEVEN";
                break;
            case 8:
                value = "EIGHT";
                break;
            case 9:
                value = "NINE";
                break;
            case 10:
                value = "TEN";
                break;
            case 11:
                value = "JACK";
                break;
            case 12:
                value = "QUEEN";
                break;
            case 13:
                value = "KING";
                break;
            default:
                break;
        }

        switch (suit) {
            case 1:
                value += " of HEARTS";
                break;
            case 2:
                value += " of CLUBS";
                break;
            case 3:
                value += " of DIAMONDS";
                break;
            case 4:
                value += " of SPADES";
                break;
            default:
                break;

        }
        return value;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }

    public int value() {
        if (rank >= 10) {
            return 10;
        } else
            return rank;
    }
}
