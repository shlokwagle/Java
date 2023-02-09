import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    int gameNumber;
    private ArrayList<Card> player;
    private ArrayList<Card> dealer;
    private Deck deck;
    int handValue;
    int dealerValue;
    Scanner input;

    public Game(int gameNumber) {

        this.gameNumber = gameNumber;
        deck = new Deck();
        player = new ArrayList<>();
        dealer = new ArrayList<>();
        handValue = 0;
        dealerValue = 0;
        input = new Scanner(System.in);
        startGame();

    }

    public void startGame() {
        setPlayerCards();
        setDealerCards();
        System.out.println("WELCOME TO BLACKJACK GAME #" + gameNumber + "\n");
        System.out.println("Player Hand of two cards:\n" + getPlayerCards());
        System.out.println("Dealer's 1st card: facedown");
        System.out.println("Dealer's 2nd card: " + dealer.get(1) + "\n");
        int i = 2;
        while (getHandValue() < 21) {
            System.out.print("Player, your hand value is " + getHandValue() + ". Would you like to hit or stay? ");
            String hitOrStay = input.next();

            if (hitOrStay.toLowerCase().equals("hit")) {
                addPlayerCard();
                if (dealerValue < 18 && getHandValue() < 21)
                    addDealerCard();
                System.out.println("Card added: " + player.get(i));
                i++;
            } else {
                if (dealerValue < 18 && getHandValue() <= 21) {
                    addDealerCard();
                }
                gameOver();
            }

        }
        gameOver();

    }

    public void setPlayerCards() {
        player.add(deck.deal());
        player.add(deck.deal());
    }

    public String getPlayerCards() {

        String playerCards = "";
        for (int i = 0; i < player.size(); i++) {
            playerCards += player.get(i) + "\n";
        }
        return playerCards;
    }

    public void setDealerCards() {
        dealer.add(deck.deal());
        dealer.add(deck.deal());
    }

    public String getDealerCards() {

        String dealerCards = "";
        for (int i = 0; i < dealer.size(); i++) {
            dealerCards += dealer.get(i) + "\n";
        }
        return dealerCards;
    }

    public int getHandValue() {
        int handValue = 0;
        for (int i = 0; i < player.size(); i++) {
            handValue += player.get(i).value();
        }
        return handValue;
    }

    public int getDealerValue() {
        int dealerValue = 0;
        for (int i = 0; i < dealer.size(); i++) {
            dealerValue += dealer.get(i).value();
        }
        return dealerValue;

    }

    public void addPlayerCard() {
        player.add(deck.deal());
    }

    public void addDealerCard() {
        dealer.add(deck.deal());
    }

    public void hit() {

    }

    public void playAgain(boolean playAgain) {
        if (playAgain = true) {
            gameNumber++;
        }
    }

    public void gameOver() {
        System.out.println("---------CARD PLAY OVER--------------");
        System.out.println("Player: With a hand value of " + getHandValue() + ", the cards in your hand are: \n"
                + getPlayerCards());
        System.out.println("Dealer: Hand value of " + getDealerValue() + " cards: \n"
                + getDealerCards());

        if (getHandValue() > 21) {
            System.out.println("you exceeded 21. You lose.");
        } else if (getHandValue() == getDealerValue()) {
            System.out.println("Player, you have tied with the dealer.");
        } else if (getDealerValue() > getHandValue() && getDealerValue() <= 21) {
            System.out.println("Dealer's hand value is closer to 21, Dealer wins!");
        } else {
            System.out.println("Player, your hand value is closer to 21, You win!");
        }

        System.out.print("Would you like to play another game? Enter yes to continue. ");
        String anotherGame = input.next();
        if (anotherGame.toLowerCase().equals("yes")) {
            System.out.println("\n\n\n\n");
            gameNumber++;
            Game newGame = new Game(gameNumber);

        } else {

            System.out.println("Goodbye! Come back soon!!");
            System.exit(0);
        }
    }
}
