
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Wardrobe wardrobe = new Wardrobe();
        System.out.println("Podaj wymiary wneki:");
        System.out.println("szerokosc:");
        Scanner sc = new Scanner(System.in);
        //wardrobe.setSpaceX(sc.nextInt());
        wardrobe.setSpaceX(2400);
        System.out.println("glebokosc:");
        //wardrobe.setSpaceDeep(sc.nextInt());
        wardrobe.setSpaceDeep(600);
        System.out.println("wysokosc:");
        //wardrobe.setSpaceY(sc.nextInt());
        wardrobe.setSpaceY(2618);
        System.out.println("Czy jest pelny dach szafy?");
        //wardrobe.setRoof(sc.nextBoolean());
        wardrobe.setRoof(true);
        System.out.println("Czy jest pelna podłoga z płyty pod szafą?");
        wardrobe.setBaseBoard(false);
        System.out.println("Podaj ilość drzwi");
        //wardrobe.setAmountOfDoors(sc.nextInt());
        wardrobe.setAmountOfDoors(3);
        System.out.println("Podaj ilość scian");
        // wardrobe.setWallNumber(sc.nextInt());
        wardrobe.setWallNumber(2);

        System.out.println("czy układ symetryczny - rozmiar półek obliczany automatycznie?");
        wardrobe.setSymmetrical(sc.hasNextBoolean());
        wardrobe.setSymmetrical(false);
        if (wardrobe.getSymmetrical()) {
            System.out.println("Podaj ilość półek");
            // wardrobe.setWallNumber(sc.nextInt());
            wardrobe.setShelvesNumber(0);
        } else {
            System.out.println("Podaj ilość rozmiarów półek");
            //int i = sc.nextInt();
            int i = 2;
            String s = "773 x 500 x 2";
            while (i > 0) {
                System.out.println("Podaj wymiar półek oraz ich ilość oddzielając wymiary literą 'x':");
                System.out.println(" np 123 x 321 x 12 - oznacza 12 półek o wymiarach 123mm szerokości i 321mm głębokości");
                //String s = sc.nextLine();
                if (i == 1) {
                    s = "773 x 500 x 2";
                } else {
                    s = "777 x 500 x 5";
                }
                String[] xes = s.replaceAll(" ", "").split("x");
                wardrobe.customShelves(Integer.valueOf(xes[0]), Integer.valueOf(xes[1]), Integer.valueOf(xes[2]));
                i--;
            }

        }

        wardrobe.standardShelves();
        wardrobe.walls();
        BoardCalculations boardCalculations = new BoardCalculations(wardrobe.getBoardPieces());
        int usedWoodBoards = boardCalculations.getUsedWoodBoards();
        System.out.println("Dziekuję");
    }
}
