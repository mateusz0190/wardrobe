import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CuttingXAlgorithmTest {

    @Test
    void getScrapArea() {
    }

    @Test
    void getUsedArea() {
    }

    @Test
    void getScrapList() {
    }

    @Test
    void getWoodBoards() {
    }

    @Test
    void getUsedWoodBoardsOnePieceOneWoodBoardZeroScrap() {
        List<BoardPiece> boards = new ArrayList<>();
        boards.add(0, new BoardPiece(2800, 2070));
        CuttingXAlgorithm cuttingXAlgorithm = new CuttingXAlgorithm(boards);
        int usedWoodBoards = cuttingXAlgorithm.getUsedWoodBoards();
        int pieces = cuttingXAlgorithm.getCutPieces();
        int scraps = cuttingXAlgorithm.getScrapList().size();
        cuttingXAlgorithm.showListToCut();
        cuttingXAlgorithm.showScrapList();
        Assertions.assertEquals(1, pieces);
        Assertions.assertEquals(1, usedWoodBoards);
        Assertions.assertEquals(0, scraps);

    }

    @Test
    void getUsedWoodBoardsTwoPiecesOneWoodBoardZeroScrap() {
        List<BoardPiece> boards = new ArrayList<>();
        boards.add(0, new BoardPiece(2800, 1035));
        boards.add(1, new BoardPiece(2800, 1035));
        CuttingXAlgorithm cuttingXAlgorithm = new CuttingXAlgorithm(boards);
        int usedWoodBoards = cuttingXAlgorithm.getUsedWoodBoards();
        int pieces = cuttingXAlgorithm.getCutPieces();
        int scraps = cuttingXAlgorithm.getScrapList().size();
        cuttingXAlgorithm.showListToCut();
        cuttingXAlgorithm.showScrapList();
        Assertions.assertEquals(2, pieces);
        Assertions.assertEquals(1, usedWoodBoards);
        Assertions.assertEquals(0, scraps);
    }

    @Test
    void getUsedWoodBoardsTwoPiecesOneWoodBoardThreeScraps() {
        List<BoardPiece> boards = new ArrayList<>();
        boards.add(0, new BoardPiece(1200, 1035));
        boards.add(1, new BoardPiece(1200, 1035));
        CuttingXAlgorithm cuttingXAlgorithm = new CuttingXAlgorithm(boards);
        int usedWoodBoards = cuttingXAlgorithm.getUsedWoodBoards();
        int pieces = cuttingXAlgorithm.getCutPieces();
        int scraps = cuttingXAlgorithm.getScrapList().size();
        cuttingXAlgorithm.showListToCut();
        cuttingXAlgorithm.showScrapList();
        Assertions.assertEquals(2, pieces);
        Assertions.assertEquals(1, usedWoodBoards);
        Assertions.assertEquals(3, scraps);

    }

    @Test
    void getUsedWoodBoardsTwoPiecesOneWoodBoardTwoScraps() {
        List<BoardPiece> boards = new ArrayList<>();
        boards.add(0, new BoardPiece(1400, 935));
        boards.add(1, new BoardPiece(1400, 935));
        CuttingXAlgorithm cuttingXAlgorithm = new CuttingXAlgorithm(boards);
        int usedWoodBoards = cuttingXAlgorithm.getUsedWoodBoards();
        int pieces = cuttingXAlgorithm.getCutPieces();
        int scraps = cuttingXAlgorithm.getScrapList().size();
        cuttingXAlgorithm.showListToCut();
        cuttingXAlgorithm.showScrapList();
        Assertions.assertEquals(2, pieces);
        Assertions.assertEquals(1, usedWoodBoards);
        Assertions.assertEquals(2, scraps);

    }
    @Test
    void getUsedWoodBoardsThreePiecesOneWoodBoardThreeScraps() {
        List<BoardPiece> boards = new ArrayList<>();
        boards.add(0, new BoardPiece(2400, 1070));
        boards.add(1, new BoardPiece(2400, 1000));
        boards.add(2, new BoardPiece(400, 2070));
        CuttingXAlgorithm cuttingXAlgorithm = new CuttingXAlgorithm(boards);
        int usedWoodBoards = cuttingXAlgorithm.getUsedWoodBoards();
        int pieces = cuttingXAlgorithm.getCutPieces();
        int scraps = cuttingXAlgorithm.getScrapList().size();
        cuttingXAlgorithm.showListToCut();
        cuttingXAlgorithm.showScrapList();
        Assertions.assertEquals(3, pieces);
        Assertions.assertEquals(1, usedWoodBoards);
        Assertions.assertEquals(3, scraps);

    }
}