import javax.swing.*;

public class MoveValidator {
    public boolean makeMove(String[] board, int position, String player) {
        // Kontrollera om positionen är giltig (tom)
        if (board[position].equals(" ")) {
            // Giltigt drag, uppdatera brädet med spelarens symbol (t.ex. "X" eller "O")
            board[position] = player;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ogiltigt drag! Försök igen.", "Fel", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void makeMove() {

    }
}
