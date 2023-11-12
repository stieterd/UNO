import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private int selected_amount_of_players;
    private int joined_amount_of_players;

    List<Player> players = new ArrayList<>();

    boolean fill_empty_slots_with_bots;
    /**
     * TODO: 2 Buttons (Join and Create Game)
     * TODO: CreateGame: U have to select how many players. Needs fill with bots option
     */
    public Menu()
    {

    }

    private void create_lobby()
    {
        //setup lobby and wait for players and finally start the game

        start_new_game();
    }

    /**
     * Should create an array of players that participate in the game with bot players is_bot set to true;
     * SHOULD ONLY FILL THE REMAINING PLAYERS WITH BOTS IF SELECTED
     */
    private void start_new_game()
    {
        //TODO: ADD REAL CONNECTED PLAYERS TO THE LIST HERE

        //Fills up the empty player slots with new Bot players when "fill with bots" is enabled.
        if(joined_amount_of_players < selected_amount_of_players && fill_empty_slots_with_bots)
        {
            for(int i = 0; i < (selected_amount_of_players - joined_amount_of_players); i++)
            {
                players.add(new Player("Bot " + i, true));
            }
        }

        new Game(players);
    }

    private void join_existing_game()
    {

    }
}
