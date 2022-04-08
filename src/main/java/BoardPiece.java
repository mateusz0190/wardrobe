

import java.math.BigDecimal;

public class BoardPiece {
    private int x;
    private int y;
    private BigDecimal pieceArea;
    private boolean isCut = false;

    public boolean isCut() {
        return isCut;
    }

    public void setCut(boolean cut) {
        isCut = cut;
    }

    public BoardPiece(int x, int y) {
        if (x >= y) {
            this.x = x;
            this.y = y;
        } else {
            this.x = y;
            this.y = x;
        }
        pieceArea = new BigDecimal(x * y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BigDecimal getBoardArea() {
        return pieceArea;
    }


}
