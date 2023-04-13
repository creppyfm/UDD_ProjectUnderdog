package PairProgrammingSessions.StrongestSmellingFlower;

import java.util.*;

    /*
        Maximum diameter = *need to remember this formula for optimization
    */


public class PartTwoListAndMatrix {
    private static final int START_ROW = 4;
    private static final int START_COL = 0;
    private static final List<Flower> FLOWERS = createsFlowerList();
    private static final Map<Flower, Integer> FLOWER_TO_RELATIVE_STRENGTH = new HashMap<>();

    //0 -> open space; 1 -> flower; -1 -> rock;
    private static final int[][] ROCK_MATRIX = {
            { 1, -1, 0, 0, 0 },
            { -1, 0, 0, 0, 1 },
            { 0, 0, 0, 1, 0 },
            { 0, 0, -1, 0, 0 },
            { 0, -1, -1, 0, 1 }
    };

    public static void main(String[] args) {
        Flower strongest = strongestSmelling(START_ROW, START_COL);
        if (strongest == null || strongest.relativeStrength == 0) {
            System.out.println("There are no flowers with fragrance strong enough to reach (" + START_ROW + ", " + START_COL + ").");
        } else {
            int distance = (strongest.strength - strongest.relativeStrength);
            System.out.println("Strongest smelling flower relative to (" + START_ROW + ", " + START_COL + ") is located at: (" + strongest.row + ", " + strongest.col + ")");
            System.out.println("Distance from origin: " + distance);
            System.out.println("Strength: " + strongest.strength);
            System.out.println("Relative strength: " + strongest.relativeStrength);
        }
    }

    private static Flower strongestSmelling(int row, int col) {
        Flower strongest = null;
        for (Flower flower : FLOWERS) {
            int distance = distanceOfPath(START_ROW, START_COL, flower);
            if (distance == 0) {
                FLOWER_TO_RELATIVE_STRENGTH.put(flower, 0);
            } else {
                int relativeStrength = getRelativeStrength(distance, flower);
                FLOWER_TO_RELATIVE_STRENGTH.put(flower, relativeStrength);
            }
        }

        int maxRelativeStrength = 0;
        for (Map.Entry<Flower, Integer> entry : FLOWER_TO_RELATIVE_STRENGTH.entrySet()) {
            if (maxRelativeStrength <= entry.getValue()) {
                maxRelativeStrength = entry.getValue();
                strongest = entry.getKey();
                strongest.relativeStrength = maxRelativeStrength;
            }
        }

        return strongest;

    }

    private static int distanceOfPath(int row, int col, Flower flower) {
        List<Flower> shortestPath = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        visited.add("(" + flower.row + ", " + flower.col + ")");
        Queue<Flower> queue = new LinkedList<>();
        queue.add(flower);

        while (!queue.isEmpty()) {
            Flower curr = queue.poll();
            if (curr.row == START_ROW && curr.col == START_COL) {
                while (!curr.parents.isEmpty()) {
                    shortestPath.add(curr.parents.get(0));
                    curr = curr.parents.get(0);
                }
                return shortestPath.size();
            } else {
                int currRow = curr.row;
                int currCol = curr.col;

                //left bound
                if (inBounds(currRow, currCol - 1) && isValid(currRow, currCol - 1)) {
                    if (visited.add("(" + currRow + ", " + (currCol - 1) + ")")) {
                        Flower left = new Flower(currRow, currCol - 1);
                        queue.add(left);
                        left.parents.add(curr);
                    }
                }
                //top bound
                if (inBounds(currRow - 1, currCol) && isValid(currRow - 1, currCol)) {
                    if (visited.add("(" + (currRow - 1) + ", " + (currCol) + ")")) {
                        Flower top = new Flower(currRow - 1, currCol);
                        queue.add(top);
                        top.parents.add(curr);
                    }
                }
                //right bound
                if (inBounds(currRow, currCol + 1) && isValid(currRow, currCol + 1)) {
                    if (visited.add("(" + currRow + ", " + (currCol + 1) + ")")) {
                        Flower right = new Flower(currRow, currCol + 1);
                        queue.add(right);
                        right.parents.add(curr);
                    }
                }
                //bottom bound
                if (inBounds(currRow + 1, currCol) && isValid(currRow + 1, currCol)) {
                    if (visited.add("(" + (currRow + 1) + ", " + (currCol) + ")")) {
                        Flower bottom = new Flower(currRow + 1, currCol);
                        queue.add(bottom);
                        bottom.parents.add(curr);
                    }
                }
            }
        }

        return 0;
    }

    private static int getRelativeStrength(int distance, Flower flower) {
        int drop = (distance * flower.decline);
        int relativeStrength = (flower.strength - drop);
        return relativeStrength;
    }

    private static boolean isValid(int row, int col) {
        return ROCK_MATRIX[row][col] > -1;
    }

    private static boolean inBounds(int row, int col) {
        return row >= 0 && row < ROCK_MATRIX.length && col >= 0 && col < ROCK_MATRIX[0].length;
    }

    private static List<Flower> createsFlowerList() {
        List<Flower> flowers = new ArrayList<>();
        Flower flowerOne = new Flower(1, 4, 17, 1);
        Flower flowerTwo = new Flower(2, 3, 10, 1);
        Flower flowerThree = new Flower(4, 4, 15, 1);
        Flower flowerFour = new Flower(0, 0, 50, 1);

        flowers.add(flowerOne);
        flowers.add(flowerTwo);
        flowers.add(flowerThree);
        flowers.add(flowerFour);

        return flowers;
    }

}
