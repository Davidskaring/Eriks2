import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard3x3 extends JFrame implements IGameBoard {
    private String[][] board;
    private final int SIZE = 3;  // Storleken på brädet är alltid 3x3
    private JButton[][] buttons;
    private JButton undoButton;  // Knapp för att ångra drag
    private Player playerX, playerO;  // Två spelare
    private Player currentPlayer;  // Spårar vilken spelare som är aktuell
    private MoveValidator moveValidator;
    private UndoManager undoManager; // Instans av UndoManager
    private IAudioManager soundUndo;

    public GameBoard3x3() {
        this.setTitle("Tic Tac Toe - 3 i rad");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); // Använder BorderLayout för att separera kontrollpanelen från spelbrädet

        JPanel gamePanel = new JPanel(new GridLayout(SIZE, SIZE)); // Skapar ett panel för 3x3 spelrutnätet
        JPanel controlPanel = new JPanel(); // Skapar en panel för kontrollknappar
        controlPanel.setLayout(new FlowLayout());

        buttons = new JButton[SIZE][SIZE];
        boardSize(); // Initierar brädet

        moveValidator = new MoveValidator();  // Skapar en instans av MoveValidator
        undoManager = new UndoManager(); // Skapar en instans av UndoManager

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
                        if (moveValidator.makeMove(board, r, c, currentPlayer.getSymbol(), buttons)) {
                            // Spara draget i UndoManager
                            undoManager.addMove(r, c, currentPlayer.getSymbol());
                            // Växla spelare efter ett giltigt drag
                            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
                        }
                    }
                });
                gamePanel.add(buttons[row][col]); // Lägger till knappen i spelpanelen
            }
        }

        // Skapa och lägg till ångra-knappen
        undoButton = new JButton("Undo");
        //Skapa och lägg till ångra ljud
        soundUndo = new SoundUndo();
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.hasMoves()) {
                    int[] lastMove = undoManager.undoMove();
                    if (lastMove != null) {
                        resetMove(lastMove[0], lastMove[1]);
                        // Växla tillbaka spelaren eftersom draget ångras
                        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
                        soundUndo.playSound();
                    }
                }

            }
        });

        controlPanel.add(undoButton); // Lägger till ångra-knappen i kontrollpanelen

        this.add(gamePanel, BorderLayout.CENTER); // Lägger till spelpanelen i mitten
        this.add(controlPanel, BorderLayout.SOUTH); // Lägger till kontrollpanelen längst ned

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

    public void updateBoard(int row, int col, String symbol) {
        board[row][col] = symbol;
    }

    public void resetMove(int row, int col) {
        board[row][col] = " ";
        buttons[row][col].setText(" "); // Återställer även knappen i GUI
    }

    public String[][] getBoard() {
        return board;
    }

    public int getBoardSize() {
        return SIZE;
    }
}
