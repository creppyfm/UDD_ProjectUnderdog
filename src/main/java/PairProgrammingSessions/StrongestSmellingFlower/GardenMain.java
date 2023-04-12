package PairProgrammingSessions.StrongestSmellingFlower;

import java.util.HashMap;
import java.util.Map;

public class GardenMain {
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
        traverses matrix looking for valid Flowers (Strength > 0)
            -> calculates fragrance drop by comparing each Flower's
                respective place in the matrix (see calculatesDrop().)
            -> subtracts drop from valid Flower's strength, leaving us
                with the strength of a Flower relative to it's distance
                from the starting Flower.
            -> maps current Flower to its relative strength
            -> iterates over map to find Flower with the highest relative strength

    */
    private static Flower strongestSmellingFlower(int row, int col, Flower[][] garden) {
        Flower start = garden[row][col];
        Map<Flower, Integer> flowerToRelativeStrength = new HashMap<>();
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[0].length; j++) {
                if (isValid(i, j)) {
                    Flower curr = garden[i][j];
                    int drop = calculatesDrop(start, curr);
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

    /*
        Calculates drop by subtracting the smaller row value from the larger row value
            -> allows method to always subtract 'drop' from 'curr.strength' as
                opposed to checking if 'drop' is > 0 or < 0 and subtracting/adding
                as necessary.
    */
    private static int calculatesDrop (Flower start, Flower curr) {
        int rowDiff = (Math.max(start.row, curr.row) - Math.min(start.row, curr.row));
        int colDiff = (Math.max(start.col, curr.col) - Math.min(start.col, curr.col));
        return rowDiff + colDiff;
    }

    /*
        allows parent method to skip Flowers with strength 0,
        since they cannot be the strongest smelling flower.
    */
    private static boolean isValid(int row, int col) {
        return GARDEN.gardenMatrix[row][col].strength > 0;
    }


/*
    for use in random generation version; creates List<Flower>
    to be passed to Garden.java
*/
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
