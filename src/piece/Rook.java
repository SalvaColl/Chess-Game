package piece;

import main.GamePanel;
import main.Type;

public class Rook extends Piece{

    public Rook(int color, int col, int row) {
        super(color, col, row);

        type = Type.ROOK;
        
        if(color == GamePanel.WHITE) {
            image = getImage("/resources/images/w-rook.png");
        }
        else {
            image = getImage("/resources/images/b-rook.png");
        }
    }

    public boolean canMove(int targetCol, int targetRow) {
        if(isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false) {

            // If the rook stays in the same row or column
            if(targetCol == preCol || targetRow == preRow) {

                // If there is no piece of the same color on the way    
                if(isValidSquare(targetCol, targetRow) && pieceIsOnStraightLine(targetCol, targetRow) == false) {
                        return true;
                }
            }
        }

        return false;
    }

}
