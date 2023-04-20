package PairProgrammingSessions.StrongestSmellingFlower;

import java.util.HashMap;
import java.util.Map;

public class PartOneMatrixVersion {
    private static final int ROW = 5;
    private static final int COL = 5;
    private static final int ROW_LENGTH = 6;
    private static final int COL_LENGTH = 6;
    private static final Garden GARDEN = new Garden(ROW_LENGTH, COL_LENGTH);

    public static void main(String[] args) {
        for (Flower[] row : GARDEN.gardenMatrix) {
            for (Flower flower : row) {
                System.out.print("(" + flower.strength + ", " + flower.decline + ") ");
            }
            System.out.println("");
        }
        System.out.println("");

        Flower strongestSmelling = strongestSmellingFlower(ROW, COL, GARDEN.gardenMatrix);
        System.out.println("Starting at: (" + ROW + ", " + COL + ")");
        System.out.println("Strongest Smelling Located at: (" + strongestSmelling.row + ", " + strongestSmelling.col + ")");
        System.out.println("Strength: " + strongestSmelling.strength);

    }

    /*
    * Return strongest smelling flower in garden relative to location (Row, col)
    * Input:
    *   row ->
    *   col ->
    * Output:
    *   strongest smelling Flower
    * Exceptions:
    * */
    private static Flower strongestSmellingFlower(int row, int col, Flower[][] garden) {
        Flower start = garden[row][col];
        Map<Flower, Integer> flowerToRelativeStrength = new HashMap<>();
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[0].length; j++) {
                if (isValid(i, j)) {
                    Flower curr = garden[i][j];
                    int drop = (calculatesDistance(start, curr) * curr.decline);
                    int relativeStrength = (curr.strength - drop);
                    flowerToRelativeStrength.put(curr, relativeStrength);
                }
            }
        }
        
        Flower strongestSmellingFlower = new Flower();
        for (Map.Entry<Flower, Integer> flower : flowerToRelativeStrength.entrySet()) {
            if (strongestSmellingFlower.strength < flower.getValue()) {
                strongestSmellingFlower = flower.getKey();
            }
        }

        return strongestSmellingFlower;
    }


    private static int calculatesDistance(Flower start, Flower curr) {
        int rowDiff = Math.abs(start.row - curr.row);
        int colDiff = Math.abs(start.col - curr.col);

        return rowDiff + colDiff;
    }


    private static boolean isValid(int row, int col) {
        return GARDEN.gardenMatrix[row][col].strength > 0;
    }



/*
    private static List<Flower> createListOfFlowers() {
        List<Flower> flowerList = new ArrayList<>();
        for (int i = 0; i < (rowLength * colLength); i++) {
            flowerList.add(new Flower());
        }
        return flowerList;
    }
*/
}
