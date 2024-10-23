public interface PlayerInterface {
    String getName();
    String getSymbol();
    void makeMove(GameBoard3x3 board, int position);

    void chooseSymbol(String player1Symbol);
}
