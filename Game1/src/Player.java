/*public class Player implements PlayerInterface, SymbolChooser {
    private String name;
    private String symbol;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public void makeMove(GameBoard3x3 board, int position) {
        int size = board.getSize();
        int row = position / size;   // Beräknar vilken rad
        int col = position % size;   // Beräknar vilken kolumn
        board.updateBoard(row, col, symbol);  // Använder uppdaterad metod för 2D-array
    }

    @Override
    public void chooseSymbol(String symbol) {
        this.symbol = symbol;
    }
}
*/