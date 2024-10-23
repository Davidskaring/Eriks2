import javax.swing.*;
public class MoveValidator {

    public boolean makeMove(String[][] board, int row, int col, String symbol, JButton[][] buttons) {
        if (board[row][col].equals(" ")) {
            // Om platsen är tom, uppdatera brädet och knappen
            board[row][col] = symbol;
            buttons[row][col].setText(symbol);
            return true;  // Draget är giltigt och genomfört
        } else {
            // Ogiltigt drag
            JOptionPane.showMessageDialog(null, "Ogiltigt drag, välj en tom plats!");
            return false;
        }
    }

    public void makeMove() {
    }
}
