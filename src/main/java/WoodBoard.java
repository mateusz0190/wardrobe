

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WoodBoard {

    private int x = 2800;
    private int y = 2070;
    public static final int thickness = 18;
    private BigDecimal boardArea;
    private List<BoardPiece> boardPiecesCut = new ArrayList<>();


    public WoodBoard() {
    }

    public BigDecimal getBoardArea() {
        boardArea = new BigDecimal(x * y);
        return boardArea;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<BoardPiece> getBoardPiecesCut() {
        return boardPiecesCut;
    }

    public void addPiece(BoardPiece boardPiece) {
        this.boardPiecesCut.add(boardPiece);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
