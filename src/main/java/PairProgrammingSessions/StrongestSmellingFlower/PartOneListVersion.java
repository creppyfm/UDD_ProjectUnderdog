package PairProgrammingSessions.StrongestSmellingFlower;

import java.util.*;

public class PartOneListVersion {
    private static final int ROW = 2;
    private static final int COL = 4;
    public static void main(String[] args) {
        List<Flower> flowers = new ArrayList<>();
        Flower flowerOne = new Flower(1, 4, 7, 1);
        Flower flowerTwo = new Flower(2, 3, 3, 1);
        Flower flowerThree = new Flower(5, 5, 1, 1);
        Flower flowerFour = new Flower(0, 0, 5, 1);

        flowers.add(flowerOne);
        flowers.add(flowerTwo);
        flowers.add(flowerThree);
        flowers.add(flowerFour);

        Flower strongest = strongestSmelling(ROW, COL, flowers);
        System.out.println("Strongest flower at: (" + strongest.row + ", " + strongest.col + ")");
        System.out.println("Relative strength: " + getRelativeStrength(ROW, COL, strongest));
    }

    private static Flower strongestSmelling(int row, int col, List<Flower> flowers) {
        int highestRelativeStrength = 0;
        Flower strongest = null;
        for (Flower flower : flowers) {
            int relativeStrength = getRelativeStrength(row, col, flower);
            if (highestRelativeStrength < relativeStrength) {
                highestRelativeStrength = relativeStrength;
                strongest = flower;
            }
        }
        return strongest;
    }

    private static int getRelativeStrength(int row, int col, Flower flower) {
        int drop = (calculatesDistance(row, col, flower) * flower.decline);
        int relativeStrength = (flower.strength - drop);
        return relativeStrength;
    }


    private static int calculatesDistance(int row, int col, Flower flower) {
        int rowDiff = Math.abs(row - flower.row);
        int colDiff = Math.abs(col - flower.col);

        return rowDiff + colDiff;
    }


}
