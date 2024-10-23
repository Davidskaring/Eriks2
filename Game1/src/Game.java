public abstract class Game {
    IAudioManager audioManager;
    IGameBoard gameBoard;
    MoveValidator moveValidator;

    public void performSound(){
        audioManager.playSound();
    }
    public void addBoard(){
        gameBoard.boardSize();
    }
    public boolean performMoveValidator(){
        moveValidator.makeMove();
        return true;
    }
}
