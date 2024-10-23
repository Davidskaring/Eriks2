import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard3x3 extends JFrame implements IGameBoard {
    private String[][] board;
    private final int SIZE = 3;  // Storleken på brädet är alltid 3x3
    private JButton[][] buttons;

    public GameBoard3x3() {
        this.setTitle("Tic Tac Toe - 3 i rad");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(SIZE, SIZE)); // Skapar ett 3x3-rutnät för knappar

        buttons = new JButton[SIZE][SIZE];
        boardSize(); // Initierar brädet

        // Initierar knapparna och lägger till ActionListeners
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                buttons[row][col] = new JButton(" ");
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 40));
                final int r = row;
                final int c = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (board[r][c].equals(" ")) {
                            updateBoard(r, c, "X");  // Exempel: placera "X" på brädet
                            buttons[r][c].setText("X");  // Uppdatera knappens text
                        } else {
                            JOptionPane.showMessageDialog(null, "Ogiltigt drag, välj en tom plats!");
                        }
                    }
                });
                this.add(buttons[row][col]); // Lägger till knappen i GUI
            }
        }

        this.setVisible(true);
    }

    @Override
    public void boardSize() {
        // Initierar ett 3x3-bräde
        board = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = " ";  // Alla positioner börjar som tomma
            }
        }
    }

    // Uppdaterar brädet med spelarens symbol på en specifik rad och kolumn
    public void updateBoard(int row, int col, String symbol) {
        board[row][col] = symbol;
    }

    // Återställer en specifik plats på brädet (sätter den till tom)
    public void resetMove(int row, int col) {
        board[row][col] = " ";
        buttons[row][col].setText(" "); // Återställer även knappen i GUI
    }

    // Returnerar den aktuella spelbrädet som en 2D-array
    public String[][] getBoard() {
        return board;
    }

    public int getBoardSize() {
        return SIZE;
    }

}