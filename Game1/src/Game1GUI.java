public class Game1GUI extends Game{
public Game1GUI(){
    audioManager = new SoundVictory();
    gameBoard = new GameBoard3x3();
   performMoveValidator();
}
}
