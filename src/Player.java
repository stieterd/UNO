import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Player
{
    private boolean is_bot;
    private String username;

    private List<Card> heldCards;
    public Player(String alias, boolean is_bot)
    {
        this.username = alias;
        this.is_bot = is_bot;
    }

    public void setCards(List<Card> dealtCards){
        this.heldCards = dealtCards;
    }

    public void drawCard(Card card){
        heldCards.add(card);
    }

    public Card useCard(int i){
        return heldCards.remove(i);
    }

    public Card useCard(Card card){
        boolean x = heldCards.remove(card);
        return card;
    }

    public List<Card> getCardsByColor(Color col){
        List<Card> resultCards = new ArrayList<>();
        for (Card card : this.heldCards){
            if (col == card.getColor()){
                resultCards.add(card);
            }
        }
        return resultCards;
    }

    public List<Card> getCardsByNumber(int number){
        List<Card> resultCards = new ArrayList<>();
        for (Card card : this.heldCards){
            if (number == card.getNumber()){
                resultCards.add(card);
            }
        }
        return resultCards;
    }

    public Card play(Card previousCard, Game game){
        if (this.is_bot) {

            while (true) {
                if (this.getCardsByColor(previousCard.getColor()).size() != 0)
                    return this.getCardsByColor(previousCard.getColor()).get(0).play(previousCard, game);

                if (previousCard instanceof NumberCard && this.getCardsByNumber(previousCard.getNumber()).size() != 0)
                    return this.getCardsByNumber(previousCard.getNumber()).get(0).play(previousCard, game);

                else if (this.getCardsByColor(Color.BLACK).size() != 0)
                    return this.getCardsByColor(Color.BLACK).get(0).play(previousCard, game, game.getDeck().getRandomCardColor());

                else if (this.heldCards.size() == 0){
                    System.out.println("Bot " + this.username + " won!!");
                    exit(0);
                }

                else {
                    this.drawCard(game.getDeck().drawCard());
                }
            }
        }
        else{
            return null;
        }
    }

}
