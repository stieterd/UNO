import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game
{
    private List<Player> players = new ArrayList<>();
    private int turn = 0;
    private Color currentColor;
    private Card previousCard;

    private Deck deck;

    /**
     * Constructor of the Game class. Should be called from the Menu class after all players
     * successfully connected to the Lobby.
     * @param players the players in the game (also bots).
     */
    public Game(List<Player> players)
    {
        this.deck = new Deck();
        this.players = players;

        for (Player player : this.players){
            player.setCards(deck.dealPlayerCards());
        }

        this.currentColor = this.deck.getRandomCardColor();

        this.playGame();

    }

    public void playGame(){
        while(true)
        {
            previousCard = this.players.get(this.turn).play(this.previousCard, this);
            nextTurn();
        }
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void nextTurn(){
        if(players.size()-1 == turn){
            this.turn = 0;
        }
        else{
            this.turn++;
        }
    }

}
