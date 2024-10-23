import java.util.ArrayList;

public class UndoManager {
    private ArrayList<int[]> moveHistory;  // ArrayList för att lagra drag
    private boolean undoAvailable;  // Indikerar om ångra är möjligt

    public UndoManager() {
        moveHistory = new ArrayList<>();
        undoAvailable = false;
    }

    // Lägger till ett drag i historiken
    public void addMove(int row, int col, String symbol) {
        moveHistory.add(new int[]{row, col});
        undoAvailable = true;  // Gör ångra möjligt efter ett nytt drag
    }

    // Tar bort det senaste draget och returnerar dess koordinater
    public int[] undoMove() {
        if (undoAvailable && !moveHistory.isEmpty()) {
            undoAvailable = false;  // Efter ett ångra kan inget mer ångras tills ett nytt drag görs
            return moveHistory.remove(moveHistory.size() - 1);
        }
        return null;  // Om det inte finns några drag att ångra eller om ångra redan använts
    }

    // Kollar om det finns ett drag att ångra och om det är tillåtet
    public boolean canUndo() {
        return undoAvailable && !moveHistory.isEmpty();
    }

    // Kollar om det finns drag kvar i historiken
    public boolean hasMoves() {
        return !moveHistory.isEmpty();
    }
}
