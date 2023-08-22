import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameService {
    private Scanner scanner;
    private ArrayList<Player> players;
    private HashMap<Integer,Integer> position;
    private HashMap<Integer, Integer> snakePosition;
    private HashMap<Integer, Integer> ladderPosition;
    public void addPlayer(Player player) {
        players.add(player);
        System.out.println("added Player :: " + player.getId());
    }
    public void start() {
        initialiseBoard();
        Game game = new Game();
        game.setPlayers(players);
        System.out.println("starting Game !!");
        while(game.getWinnerGameId() == -1) {
            int moves = DiceService.throwDice();
            int currPlayerGameId = game.getCurrentPlayerGameId();
            Player currPlayer = game.getPlayerForId(currPlayerGameId);
            int currPosition = currPlayer.getCurrPosition();
            if(currPosition + moves > 100 ) {
                System.out.println(currPlayer.getName() + " rolled a " + moves + " but can not move from " + currPosition);
                game.nextPlayerChance();
                continue;
            }
            int nextPosition = currPosition + moves;
            if(snakePosition.containsKey(nextPosition)) {
                nextPosition = snakePosition.get(nextPosition);
            }
            if(ladderPosition.containsKey(nextPosition)) {
                nextPosition = ladderPosition.get(nextPosition);
            }
            System.out.println(currPlayer.getName() + " rolled a " + moves + " and moves from " + currPosition + " to " +
                    nextPosition);
            currPlayer.setCurrPosition(nextPosition);
            if(currentPlayerWinner(currPlayer)) {
                System.out.println(currPlayer.getName() + " won !!!");
                break;
            }
            game.nextPlayerChance();
        }

    }
    private boolean currentPlayerWinner(Player player) {
        return player.getCurrPosition() == 100;
    }

    private void initializeSnakes() {
        int numSnakes = scanner.nextInt();
        for(int i = 0 ; i < numSnakes; i++ ) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            snakePosition.put(x,y);
        }
    }
    private void initializeLadder() {
        int numLadder = scanner.nextInt();
        for(int i = 0 ; i < numLadder; i++ ) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            ladderPosition.put(x,y);
        }
    }
    private void initialisePlayers() {
        int numPlayers = scanner.nextInt();
        for(int i = 0 ; i < numPlayers; i++ ) {
            String name = scanner.next();
            Player player = new Player();
            player.getBuilder().setId(i).setName(name);
            addPlayer(player);
        }
    }
    public void initialiseBoard() {
        players = new ArrayList<>();
        position = new HashMap<>();
        snakePosition = new HashMap<>();
        ladderPosition = new HashMap<>();
        scanner = new Scanner(System.in);

        initializeSnakes();
        initializeLadder();
        initialisePlayers();

        scanner.close();
    }

}