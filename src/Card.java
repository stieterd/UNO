import java.awt.*;
import java.lang.reflect.Type;

public abstract class Card
{
    private Color color;
    private int number;
    private CardType cardType;


    public Card(Color color, CardType type, int number)
    {
        this.color = color;
        this.cardType = type;
        this.number = number;
    }

    public final CardType getType(){
        return this.cardType;
    }

    public final Color getColor()
    {
        return this.color;
    }

    public final int getNumber(){
        return this.number;
    }

    public Card play(Card previousCard, Game game){
        return this;
    }
    public Card play(Card previousCard, Game game, Color col){
        return this;
    }
}
