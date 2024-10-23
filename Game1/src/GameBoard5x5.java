import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard5x5 extends JFrame implements IGameBoard {
    private String[][] board;
    private final int SIZE = 5;  // Storleken på brädet är alltid 3x3
    private JButton[][] buttons;
    private Player playerX, playerO;  // Två spelare
    private Player currentPlayer;  // Spårar vilken spelare som är aktuell
    private MoveValidator moveValidator;

    public GameBoard5x5() {
        this.setTitle("Tic Tac Toe - 5 i rad");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(SIZE, SIZE)); // Skapar ett 3x3-rutnät för knappar

        buttons = new JButton[SIZE][SIZE];
        boardSize(); // Initierar brädet

        moveValidator = new MoveValidator();  // Skapar en instans av MoveValidator

        // Skapa spelare, varje spelare använder samma MoveValidator
        playerX = new Player("X", moveValidator);
        playerO = new Player("O", moveValidator);
        currentPlayer = playerX;  // Spelare X börjar

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
                        // Använd currentPlayer för att göra draget med MoveValidator
                        if (currentPlayer.makeMove(board, r, c, buttons)) {
                            // Växla spelare efter ett giltigt drag
                            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
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