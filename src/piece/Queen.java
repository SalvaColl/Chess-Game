package piece;

import main.GamePanel;
import main.Type;

public class Queen extends Piece{

    public Queen(int color, int col, int row) {
        super(color, col, row);

        type = Type.QUEEN;
        
        if(color == GamePanel.WHITE) {
            image = getImage("/images/w-queen.png");
        }
        else {
            image = getImage("/images/b-queen.png");
        }
    }

    public boolean canMove(int targetCol, int targetRow) {
        if(isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false) {

            // If the queen stays on the same column or row
            if(targetCol == preCol || targetRow == preRow) {
                
                // If there is no piece of the same color on the way
                if(isValidSquare(targetCol, targetRow) && pieceIsOnStraightLine(targetCol, targetRow) == false ) {
                    return true;
                }
            }

            // If the queen moves the same number of columns and rows
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
