package piece;

import main.GamePanel;
import main.Type;

public class Bishop extends Piece{

    public Bishop(int color, int col, int row) {
        super(color, col, row);

        type = Type.BISHOP;
        
        if(color == GamePanel.WHITE) {
            image = getImage("/resources/images/w-bishop.png");
        }
        else {
            image = getImage("/resources/images/b-bishop.png");
        }
    }

    public boolean canMove(int targetCol, int targetRow) {
        if(isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false) {

            // If the bishop moves the same number of columns and rows
            if(Math.abs(targetCol - preCol) == Math.abs(targetRow - preRow)) {

                // If there is no piece of the same color on the way
                if(isValidSquare(targetCol, targetRow) && pieceIsOnDiagonalLine(targetCol, targetRow) == false) {
                    return true;
                }
            }
        }

        return false;
    }

}
