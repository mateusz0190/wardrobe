
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BoardCalculations {
    private BigDecimal scrapArea;
    private int usedWoodBoards;
    private BigDecimal usedArea = BigDecimal.ZERO;
    private Map<BoardPiece, Integer> wardrobePieces;
    public List<WoodBoard> scrapList = new ArrayList<>();
    List<WoodBoard> woodBoards = new ArrayList<>();

    public BoardCalculations(Map<BoardPiece, Integer> wardrobePieces) {
        this.wardrobePieces = wardrobePieces;
    }

    public int getUsedWoodBoards() {
        if (wardrobePieces.isEmpty()) {
            return 0;
        }
        // int algorithm1 = algorithm1();
        int algorithm2 = algorithm2();

        return 0;
    }

    public int algorithm1() {
        WoodBoard woodBoard = new WoodBoard();
        BigDecimal boardArea = woodBoard.getBoardArea();

        System.out.println("usedArea = " + usedArea);

        for (BoardPiece piece : wardrobePieces.keySet()) {
            BigDecimal pieceArea = piece.getBoardArea();
            Integer numberOfPieces = wardrobePieces.get(piece);
            usedArea = usedArea.add(pieceArea.multiply(BigDecimal.valueOf(numberOfPieces)));
            System.out.println("Board piece #" + numberOfPieces + " usedArea = " + usedArea);
        }
        BigDecimal divide = usedArea.divide(boardArea, new MathContext(2));
        System.out.println("divide = " + divide);
        usedWoodBoards = (int) Math.floor(divide.intValue()) + 1;
        return usedWoodBoards;
    }

    //dopasowanie wg najwiekszych kawałków, cięcie najpierw po dłuższym boku
    public int algorithm2() {


        List<BoardPiece> sortedBoardPieceList = wardrobePieces.keySet().stream()
                .sorted(Comparator.comparing(BoardPiece::getX)
                        .thenComparing(BoardPiece::getY).reversed())
                .toList();

        List<BoardPiece> boardPiecesList = new ArrayList<>();
        for (BoardPiece piece : wardrobePieces.keySet()
        ) {
            Integer index = wardrobePieces.get(piece);

            while (index > 0) {
                boardPiecesList.add(piece);
                index--;
            }

        }
        List<BoardPiece> sortedListToCut = boardPiecesList.stream()
                .sorted(Comparator.comparing(BoardPiece::getX)
                        .thenComparing(BoardPiece::getY)
                        .reversed())
                .toList();
        for (BoardPiece piece :
                sortedListToCut) {
            System.out.println("piece = " + piece.getX() + " x " + piece.getY());
        }
        WoodBoard woodBoardToCut = new WoodBoard();

        List<BoardPiece> boardPiecesCut = woodBoardToCut.getBoardPiecesCut();
        woodBoards.add(woodBoardToCut);

        for (BoardPiece pieceToCut :
                sortedListToCut) {


            if (scrapList.stream()
                    .filter(sb -> sb.getX() >= pieceToCut.getX())
                    .filter(s -> s.getY() >= pieceToCut.getY())
                    .findFirst().isPresent()) {
                WoodBoard scrapBoard = scrapList.stream()
                        .filter(sb -> sb.getX() >= pieceToCut.getX())
                        .filter(s -> s.getY() >= pieceToCut.getY())
                        .findFirst().get();
                cuttingX(scrapBoard, pieceToCut);
                scrapBoard.setY(0);
                scrapBoard.setX(0);
            } else
                //first cutting
                if (woodBoardToCut.getX() >= pieceToCut.getX() & woodBoardToCut.getY() >= pieceToCut.getY()) {
                    cuttingX(woodBoardToCut, pieceToCut);
                } else {
                    woodBoardToCut = new WoodBoard();
                    woodBoards.add(woodBoardToCut);
                    cuttingX(woodBoardToCut, pieceToCut);

                }
        }
        scrapList = scrapList.stream().filter(s -> s.getX() > 0).collect(Collectors.toList());
        System.out.println("woodBoards.size() = " + woodBoards.size());
        System.out.println("woodBoards.stream().toString() = " + woodBoards.stream().toString());
        System.out.println("scrapList.size() = " + scrapList.size());
        for (WoodBoard woods :
                scrapList) {
            System.out.println("scraps: = " + woods.getX() + " x " + woods.getY());
        }
        return usedWoodBoards;
    }

    public void cuttingX(WoodBoard woodBoardToCut, BoardPiece pieceToCut) {
        //define scrap piece
        WoodBoard scrapWoodBoard = new WoodBoard();
        scrapWoodBoard.setX(woodBoardToCut.getX() - pieceToCut.getX());
        scrapWoodBoard.setY(woodBoardToCut.getY());
        scrapList.add(scrapWoodBoard);

        //define woodBoardToCut after cutting
        woodBoardToCut.setX(pieceToCut.getX());
        woodBoardToCut.setY(woodBoardToCut.getY());
        //cutting new piece
        woodBoardToCut.setX(pieceToCut.getX());
        woodBoardToCut.setY((woodBoardToCut.getY() - pieceToCut.getY()));
        woodBoardToCut.addPiece(pieceToCut);
        pieceToCut.setCut(true);
    }
}
