import java.util.Arrays;
import javafx.scene.paint.Color;

public class Player {
    /*
        Declaration of variables
     */
    boolean PlayerWon;
    String playerName;
    String userCode;
    int CodeLength;
    int ColorLength;
    String EndPegs;
    String[] maxColors = {"R","B","Y","G","O","P","V","T",""};
    Color circleColors[] = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.HOTPINK, Color.PURPLE, Color.TURQUOISE, Color.BLACK};
    Color pegColors[] = {Color.BLACK, Color.WHITE, Color.RED};
    Color FXcolors[];
    String[] colors;
    int PlayerPlayTimes; // number of times the player has played the game
    int AIPlayTimes;
    int tries;
    int seconds;
    boolean usingTimer;

    /**
     * @param name
     * @function Set up the player class
     */
    public Player(String name) {
        playerName = name;
        CodeLength = 4;
        ColorLength = 6;
        PlayerPlayTimes = 0;
        AIPlayTimes = 0;
        tries = 0;
        seconds = 0; // DEBUG
        usingTimer = false;
        String[] EndPegPatterns= {"","B","BB","BBB","BBBB","BBBBB","BBBBBB","BBBBBBB","BBBBBBBB"};
        EndPegs = EndPegPatterns[CodeLength];
        colors = Arrays.copyOfRange(maxColors, 0, ColorLength);
        FXcolors = Arrays.copyOfRange(circleColors, 0, ColorLength);
    }

    /**
     * @function Play again function
     * @param type
     */
    public void playAgain(String type) {
        if(type.equals("Player")) {
            PlayerPlayTimes++;
        }
        if(type.equals("AI")) {
            AIPlayTimes++;
        }
    }

    /**
     * @function keeps track of seconds for timer
     * @param seconds
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * @function keeps track of the number of times the player played
     * @return the number of times played
     */
    public int getPlayerPlayTimes() {
        return PlayerPlayTimes;
    }

    /**
     * @function keeps track of the number of times the AI played
     * @return number of times played
     */
    public int getAIplayTimes() {
        return AIPlayTimes;
    }

    /**
     * @function Set the player name
     * @param name
     */
    public void setPlayerName(String name) {
        playerName = name;
    }

    /**
     * @function return the player's name
     * @return the player's name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @function Get the user's code
     * @return returns the code that the user guessed
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * @function return true/false if the player won/lost
     * @return boolean based on whether the player won or lose
     */
    public boolean win() {
        return PlayerWon;
    }

    /**
     * @function Set a random code for the user to guess
     * @param code
     */
    public void setCode(String code) {
        userCode = code;
    }

    /**
     * @function set code length
     * @param length
     */
    public void setCodeLength(int length) {
        CodeLength = length;
        String[] EndPegPatterns= {"","B","BB","BBB","BBBB","BBBBB","BBBBBB","BBBBBBB","BBBBBBBB"};
        EndPegs = EndPegPatterns[CodeLength];
    }

    /**
     * @functin get the length of the code
     * @return the code length
     */
    public int getCodeLength() {
        return CodeLength;
    }

    /**
     * @function Set the color length
     * @param length
     */
    public void setColorLength(int length) {
        ColorLength = length;
        colors = Arrays.copyOfRange(maxColors, 0, ColorLength);
        FXcolors = Arrays.copyOfRange(circleColors, 0, ColorLength);
    }

    /**
     * @function gets the number of colors avaliable to the player
     * @return th enumber of colors
     */
    public int getColorLength() {
        return ColorLength;
    }
}
