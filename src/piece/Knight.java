package piece;

import main.GamePanel;
import main.Type;

public class Knight extends Piece{

    public Knight(int color, int col, int row) {
        super(color, col, row);

        type = Type.KNIGHT;
        
        if(color == GamePanel.WHITE) {
            image = getImage("/resources/images/w-knight.png");
        }
        else {
            image = getImage("/resources/images/b-knight.png");
        }
    }

    public boolean canMove(int targetCol, int targetRow) {
        if(isWithinBoard(targetCol, targetRow)) {

            // If the knight moves 2 columns and 1 row or vice versa
            if(Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 2) {

                // If there is no piece of the same color there
                if(isValidSquare(targetCol, targetRow)) {
                    return true;
                }
            }
        }

        return false;
    }    
}
