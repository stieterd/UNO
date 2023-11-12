import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.*;

public class Deck
{
    private List<Card> cardList = new ArrayList<Card>();
    private List<Color> cardColors = Arrays.asList(new Color[] {Color.red, Color.yellow, Color.blue, Color.green});

    /**
     * Constructor of the Deck class, puts all the cards in the arraylist cardList and
     * shuffles the cards in the deck
     *
     */
    public Deck(){
        // Initialize the deck of cards put it in the list cardList
        for (int i = 0; i < 4; i++) {
            cardList.add(new NumberCard(cardColors.get(i), CardType.NUMBER, 0));
            for (int z = 0; z < 2; z++) {
                for (int j = 0; j < 9; j++) {
                    cardList.add(new NumberCard(cardColors.get(i), CardType.NUMBER, j+1));
                }
            }
            for (int z = 0; z < 2; z++) {
                cardList.add(new SpecialCard(cardColors.get(i), CardType.PLUS_TWO));
            }
            for (int z = 0; z < 2; z++) {
                cardList.add(new SpecialCard(cardColors.get(i), CardType.REVERSE));
            }
            for (int z = 0; z < 2; z++){
                cardList.add(new SpecialCard(cardColors.get(i), CardType.BLOCK));
            }
        }

        for(int i = 0; i < 4; i++){
            cardList.add(new SpecialCard(Color.black, CardType.PICK_COLOR));
        }
        for(int i = 0; i < 4; i++){
            cardList.add(new SpecialCard(Color.black, CardType.PLUS_FOUR));
        }

        // Shuffles the cards in the deck
        this.deckShuffle();
    }

    /**
     * Shuffles the deck of cards
     */
    public void deckShuffle(){
        Collections.shuffle(cardList);
    }

    public Color getRandomCardColor(){
        List<Color> deckColors = this.getCardColors();
        Collections.shuffle(deckColors);
        return deckColors.get(0);
    }

    public List<Card> dealPlayerCards(){
        List<Card> dealtCards = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            dealtCards.add(this.drawCard());
        }
        return dealtCards;
    }

    /**
     * draws a card from the deck
     * @return a type Card that was returned from the deck
     */
    public Card drawCard(){
        return cardList.remove(0);
    }

    /**
     * Adds a card to the deck and shuffles the deck afterwards
     * @param card the card we want to add to our deck
     */
    public void addCard(Card card){
        this.cardList.add(card);
        this.deckShuffle();
    }

    public List<Color> getCardColors() {
        return new ArrayList<>(this.cardColors);
    }
}
