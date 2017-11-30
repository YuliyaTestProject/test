import java.util.Scanner;
import java.util.regex.Pattern;

public class TicTacToe {

    private int size;
    private char[][] matrix;
    private String playerName;
    private Scanner scan = new Scanner(System.in);
    private char mark;
    private String userInput;
    private String[] coordinate;
    private int lastInputX, lastInputY;
    private String splitPattern = ",";
    private Pattern pattern = Pattern.compile("[012]{1},{1}[012]{1}");


    TicTacToe() {

        size = 3;
        matrix = new char[size][size];
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                matrix[i][j] = '.';
            }
        }

    }

    protected int getMatrixSize() {
        return matrix.length;
    }


    protected char getMatrixLastInput() {
        return matrix[lastInputX][lastInputY];
    }

    protected int getLastInputX() {
        return lastInputX;
    }

    protected int getLastInputY() {
        return lastInputY;
    }

    protected char getPlayerMark() {
        return mark;
    }

    protected void drawMatrix() {

        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
        }

    }

    protected boolean isCellEmpty() {

        if (matrix[lastInputX][lastInputY] == '.') {
            return true;
        }
else {
            System.out.println("Cell is not empty");
            return false;
        }

    }

    protected boolean isUserInputValid(String userInput) {

        this.userInput = userInput;
        if(pattern.matcher(userInput).matches()){
            return true;
        }
        else {
            System.out.println("Invalid character");
            return false;
        }

    }

    protected void inputAndSaveValue(String playerName) {

        this.playerName = playerName;

        do {
            System.out.println('\n' + "Enter coordinate for " + playerName + " in the following format 0,0. Allowed characters are '012'");
            setPlayerMark(playerName);
            userInput = scan.nextLine();
        }
        while (!isUserInputValid(userInput));
        saveUserInputAsCoordinate(userInput);


    }

    protected void setPlayerMark(String playerName) {

        this.playerName = playerName;
        mark = (playerName.equals("Player 1")) ? 'X' : 'O';

    }

    protected void saveUserInputAsCoordinate(String userInput) {

        this.userInput = userInput;

        coordinate = userInput.split(splitPattern);
        lastInputX = Integer.parseInt(coordinate[0]);
        lastInputY = Integer.parseInt(coordinate[1]);

    }

    protected void putMarkAtCoordinate(int lastInputX, int lastInputY, char mark) {

        this.mark = mark;
        this.lastInputX = lastInputX;
        this.lastInputY = lastInputY;
        matrix[lastInputX][lastInputY] = mark;

    }

    public void playGame() {

        drawMatrix();

        for (int i = 0; i < size * size; i++) {

            if (i >= 5 && isWinner(lastInputX, lastInputY)) {
                System.out.println("\n" + "Winner is " + playerName);
                break;

            } else {
                do {
                    inputAndSaveValue("Player " + i % 2);

                }
                while (!isCellEmpty());
                putMarkAtCoordinate(lastInputX, lastInputY, mark);
                drawMatrix();
            }
            if (i == size * size - 1) {
                System.out.println("\n" + "Draw!");
            }
        }

    }

    protected boolean isWinner(int lastInputX, int lastInputY) {

        this.lastInputX = lastInputX;
        this.lastInputY = lastInputY;

        return ((matrix[lastInputX][0] == matrix[lastInputX][1] && matrix[lastInputX][1] == matrix[lastInputX][2])
                || (matrix[0][lastInputY] == matrix[1][lastInputY] && matrix[1][lastInputY] == matrix[2][lastInputY]));
    }
}


