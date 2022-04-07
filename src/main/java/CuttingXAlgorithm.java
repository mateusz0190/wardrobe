
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import java.util.stream.Collectors;

public class CuttingXAlgorithm implements Algorithm {
    private BigDecimal scrapArea;
    private int usedWoodBoards;
    private BigDecimal usedArea = BigDecimal.ZERO;
    private List<BoardPiece> sortedListToCut = new ArrayList<>();
    private List<WoodBoard> scrapList = new ArrayList<>();
    private List<WoodBoard> woodBoards = new ArrayList<>();

    public CuttingXAlgorithm(List<BoardPiece> sortedListToCut) {
        this.sortedListToCut = sortedListToCut;
    }

    public BigDecimal getScrapArea() {
        return scrapArea;
    }

    public BigDecimal getUsedArea() {
        return usedArea;
    }


    public List<WoodBoard> getScrapList() {
        return scrapList;
    }

    public List<WoodBoard> getWoodBoards() {
        return woodBoards;
    }

    public int getUsedWoodBoards() {
        if (sortedListToCut.isEmpty()) {
            return 0;
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
                cutting(scrapBoard, pieceToCut);
                scrapBoard.setY(0);
                scrapBoard.setX(0);
            } else
                //first cutting
                if (woodBoardToCut.getX() >= pieceToCut.getX() & woodBoardToCut.getY() >= pieceToCut.getY()) {
                    cutting(woodBoardToCut, pieceToCut);
                } else {
                    woodBoardToCut = new WoodBoard();
                    woodBoards.add(woodBoardToCut);
                    cutting(woodBoardToCut, pieceToCut);
                }
        }
        scrapList = scrapList.stream().filter(s -> s.getX() > 0).collect(Collectors.toList());
        System.out.println("woodBoards.size() = " + woodBoards.size());
        System.out.println("woodBoards.stream().toString() = " + woodBoards.stream().toString());

        return usedWoodBoards;
    }


    @Override
    public void cutting(WoodBoard woodBoardToCut, BoardPiece pieceToCut) {
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

    @Override
    public void showListToCut() {

    }

    @Override
    public void showScrapList() {
        System.out.println("scrapList.size() = " + scrapList.size());
        for (WoodBoard woods :
                scrapList) {
            System.out.println("scraps: = " + woods.getX() + " x " + woods.getY());
        }
    }

    @Override
    public void showWoodBoardsList() {
        for (WoodBoard board :
                woodBoards) {
            board.showBoardPiecesDimmensions();
        }
    }

    @Override
    public void showScrapArea() {
        for (WoodBoard board : scrapList) {
            System.out.println("scrap: " + board.getBoardArea().toString());
        }

    }
}
