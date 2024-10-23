import javax.swing.*;

public class Player {
    private final String symbol;
    private MoveValidator moveValidator;

    public Player(String symbol, MoveValidator moveValidator) {
        this.symbol = symbol;  // Till exempel, "X" eller "O"
        this.moveValidator = moveValidator;  // Spelaren använder MoveValidator för att göra drag
    }

    // Utför spelarens drag med hjälp av MoveValidator
    public boolean makeMove(String[][] board, int row, int col, JButton[][] buttons) {
        return moveValidator.makeMove(board, row, col, symbol, buttons);
    }

    // Returnerar spelarens symbol
    public String getSymbol() {
        return symbol;
    }
}