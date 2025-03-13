package piece;

import main.GamePanel;
import main.Type;

public class King extends Piece{

    public King(int color, int col, int row) {
        super(color, col, row);

        type = Type.KING;
        
        if(color == GamePanel.WHITE) {
            image = getImage("/images/w-king.png");
        }
        else {
            image = getImage("/images/b-king.png");
        }
    }

    public boolean canMove(int targetCol, int targetRow) {
        if(isWithinBoard(targetCol, targetRow)) {

            // MOVEMENT
            // If the king only moves one row or one column or if it moves one row and one column
            if(Math.abs(targetCol - preCol) + Math.abs(targetRow - preRow) == 1 ||
                    Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 1) {
                
                // If there is no piece of the same color there
                if(isValidSquare(targetCol, targetRow)) {
                    return true;
                }
            }

            // CASTLING
            if(hasMoved == false) {

                // Right castling
                if(targetCol == preCol+2 && targetRow == preRow && pieceIsOnStraightLine(targetCol, targetRow) == false) {
                    for(Piece piece : GamePanel.simPieces) {
                        if(piece.col == preCol+3 && piece.row == preRow && piece.hasMoved == false) {
                            GamePanel.castlingP = piece;
                            return true;
                        }
                    }
                }

                // Left castling
                if(targetCol == preCol-2 && targetRow == preRow && pieceIsOnStraightLine(targetCol, targetRow) == false) {
                    Piece p[] = new Piece[2];
                    for(Piece piece : GamePanel.simPieces) {
                        if(piece.col == preCol-3 && piece.row == targetRow) {
                            p[0] = piece;
                        }
                        if(piece.col == preCol-4 && piece.row == targetRow) {
                            p[1] = piece;
                        }
                        if(p[0] == null && p[1] != null && p[1].hasMoved == false) {
                            GamePanel.castlingP = p[1];
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

}
