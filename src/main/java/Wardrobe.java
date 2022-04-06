

import java.util.HashMap;
import java.util.Map;

public class Wardrobe {
    private static int spaceX;
    private static int spaceY;
    private static int spaceDeep;
    private int wallNumber;
    private boolean isRoof;
    private boolean isBaseBoard;
    private boolean isSymmetrical;
    private int shelvesNumber;
    private int symmetricalShelves;
    private int amountOfDoors;
    private static int doorSpace = 100;
    private Map<BoardPiece, Integer> boardPieces = new HashMap<>();

    public void setShelvesNumber(int shelvesNumber) {
        this.shelvesNumber = shelvesNumber;
    }


    public void setSpaceX(int spaceX) {
        this.spaceX = spaceX;
    }

    public void setSpaceY(int spaceY) {
        this.spaceY = spaceY;
    }

    public void setSpaceDeep(int spaceDeep) {
        this.spaceDeep = spaceDeep;
    }

    public void setWallNumber(int wallNumber) {
        this.wallNumber = wallNumber;
    }

    public void setRoof(boolean roof) {
        isRoof = roof;
        BoardPiece piece = calculationBaseOrRoof(isRoof);
        boardPieces.put(piece, 1);
    }

    public void setAmountOfDoors(int amountOfDoors) {
        this.amountOfDoors = amountOfDoors;
        if (amountOfDoors > 0) {
            final int Z = 28;   //from documentation GTV
            final int h = 40;     //from documentation GTV

            int k = amountOfDoors - 1;
            int doorX = ((spaceX - 2 * 18) + k * Z) / amountOfDoors;
            int doorY = spaceY - h - 18;
            if (isRoof) {
                doorY = doorY - 18;
            }
            BoardPiece door = new BoardPiece(doorX, doorY);
            boardPieces.put(door, amountOfDoors);
        }

    }

    public void setBaseBoard(boolean base) {
        isBaseBoard = base;
        BoardPiece piece = calculationBaseOrRoof(isBaseBoard);
        boardPieces.put(piece, 1);
    }

    public boolean getSymmetrical() {
        return isSymmetrical;
    }

    public void setSymmetrical(boolean symmetrical) {
        isSymmetrical = symmetrical;
    }

    static BoardPiece calculationBaseOrRoof(boolean argument) {
        if (argument) {
            return new BoardPiece(spaceX, spaceDeep);
        } else {
            return new BoardPiece(spaceX - 2 * 18, doorSpace);
        }
    }

    public void standardShelves() {
        int internalX = (spaceX - wallNumber * 18) / (wallNumber - 1);
        int internalY = spaceDeep - doorSpace;
        BoardPiece shelf = new BoardPiece(internalX, internalY);
        boardPieces.put(shelf, shelvesNumber);
        System.out.println("shelf = " + shelf);
    }

    public void customShelves(int x, int y, int amount) {
        BoardPiece shelf = new BoardPiece(x,y);
        boardPieces.put(shelf, amount);
    }

    public void walls() {
        int wallDeepInternal = spaceDeep - doorSpace;
        int wallHigh = spaceY;
        if (isRoof) {
            wallHigh = wallHigh - 18;
        }
        if (isBaseBoard) {
            wallHigh = wallHigh - 18;
        }
        BoardPiece extWalls = new BoardPiece(spaceDeep, wallHigh);
        BoardPiece intWalls = new BoardPiece(wallDeepInternal, wallHigh);
        boardPieces.put(extWalls, 2);
        boardPieces.put(intWalls, wallNumber - 2);

    }

    public Map<BoardPiece, Integer> getBoardPieces() {
        return boardPieces;
    }
}
