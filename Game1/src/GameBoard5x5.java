public class GameBoard5x5 implements IGameBoard {
    private String[][] board;
    private final int SIZE = 5;  // Storleken på brädet är alltid 3x3

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
    }

    // Returnerar den aktuella spelbrädet som en 2D-array
    public String[][] getBoard() {
        return board;
    }

    // Returnerar storleken på brädet (3x3)
    public int getSize() {
        return SIZE;
    }

}