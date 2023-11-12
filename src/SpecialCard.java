import java.awt.*;

public class SpecialCard extends Card{

    /**
     *
     * @param color determines the color of the card
     * @param type determines the type of the card
     */
    public SpecialCard(Color color, CardType type){
        super(color, type, 0);
    }

    @Override
    public Card play(Card previousCard, Game game) {
        switch(this.getType())
        {
            case BLOCK:
                break;
            case REVERSE:
                break;
            case PLUS_TWO:
                break;
        }
        return this;
    }
}
