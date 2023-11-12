import java.awt.*;

public class WildSpecialCard extends Card{
    public WildSpecialCard(CardType type) {
        super(Color.black, type, 0);
    }

    public Card play(Card previousCard, Game game, Color col) {
        return this;
    }
}
