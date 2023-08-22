import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private int currentPlayerGameId;
    private int totalPlayers;
    private int winnerGameId;
    private HashMap<Integer, Player> players;

    public void setPlayers(ArrayList<Player> players) {
        this.players = new HashMap<>();
        for(int i = 0 ; i < players.size() ; i++ ) {
            this.players.put(i, players.get(i));
        }
        this.totalPlayers = players.size();
        this.winnerGameId = -1;
    }

    public int getWinnerGameId() {
        return winnerGameId;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public int getCurrentPlayerGameId() {
        return currentPlayerGameId;
    }

    public void setCurrentPlayerGameId(int currentPlayerGameId) {
        this.currentPlayerGameId = currentPlayerGameId;
    }

    public void nextPlayerChance() {
        this.currentPlayerGameId = (this.currentPlayerGameId + 1)%this.totalPlayers;
    }

    public Player getPlayerForId(Integer gameId) {
        return this.players.get(gameId);
    }
}
