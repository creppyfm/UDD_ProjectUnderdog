package PairProgrammingSessions.StrongestSmellingFlower;

import java.util.List;

public class Garden {
    int rowLength;
    int colLength;
    List<Flower> flowers; //used in random generation version
    Flower[][] gardenMatrix;
    public Garden (int rowLength, int colLength) { // hard-coded for example
        this.rowLength = rowLength;
        this.colLength = colLength;
        gardenMatrix = new Flower[rowLength][colLength];
        gardenMatrix[0][0] = new Flower(0, 0, 2, 1);
        gardenMatrix[0][1] = new Flower(0, 1, 0, 0);
        gardenMatrix[0][2] = new Flower(0, 2, 4, 1);
        gardenMatrix[0][3] = new Flower(0, 3, 3, 1);
        gardenMatrix[0][4] = new Flower(0, 4, 4, 1);
        gardenMatrix[0][5] = new Flower(0, 5, 0, 0);
        gardenMatrix[1][0] = new Flower(1, 0, 0, 0);
        gardenMatrix[1][1] = new Flower(1, 1, 3, 1);
        gardenMatrix[1][2] = new Flower(1, 2, 7, 1);
        gardenMatrix[1][3] = new Flower(1, 3, 0, 0);
        gardenMatrix[1][4] = new Flower(1, 4, 0, 0);
        gardenMatrix[1][5] = new Flower(1, 5, 0, 0);
        gardenMatrix[2][0] = new Flower(2, 0, 2, 1);
        gardenMatrix[2][1] = new Flower(2, 1, 0, 0);
        gardenMatrix[2][2] = new Flower(2, 2, 0, 0);
        gardenMatrix[2][3] = new Flower(2, 3, 3, 1);
        gardenMatrix[2][4] = new Flower(2, 4, 4, 1);
        gardenMatrix[2][5] = new Flower(2, 5, 0, 0);
        gardenMatrix[3][0] = new Flower(3, 0, 0, 0);
        gardenMatrix[3][1] = new Flower(3, 1, 0, 0);
        gardenMatrix[3][2] = new Flower(3, 2, 0, 0);
        gardenMatrix[3][3] = new Flower(3, 3, 0, 0);
        gardenMatrix[3][4] = new Flower(3, 4, 1, 1);
        gardenMatrix[3][5] = new Flower(3, 5, 3, 1);
        gardenMatrix[4][0] = new Flower(4, 0, 0, 0);
        gardenMatrix[4][1] = new Flower(4, 1, 1, 1);
        gardenMatrix[4][2] = new Flower(4, 2, 0, 0);
        gardenMatrix[4][3] = new Flower(4, 3, 2, 1);
        gardenMatrix[4][4] = new Flower(4, 4, 0, 0);
        gardenMatrix[4][5] = new Flower(4, 5, 0, 0);
        gardenMatrix[5][0] = new Flower(5, 0, 0, 0);
        gardenMatrix[5][1] = new Flower(5, 1, 2, 1);
        gardenMatrix[5][2] = new Flower(5, 2, 2, 1);
        gardenMatrix[5][3] = new Flower(5, 3, 0, 0);
        gardenMatrix[5][4] = new Flower(5, 4, 2, 1);
        gardenMatrix[5][5] = new Flower(5, 5, 0, 0);
        //"existence is pain"
    }


/*
    public Garden (int rowLength, int colLength, List<Flower> flowers) { // initializes Garden using randomly generated Flowers
        this.rowLength = rowLength;
        this.colLength = colLength;
        this.gardenMatrix = new Flower[rowLength][colLength];
        this.flowers = flowers;

        int row = 0;
        int col = 0;
        for (Flower flower : flowers) {
            if (row < rowLength && col < colLength) {
                gardenMatrix[row][col] = flower;
                col += 1;
            } else if (row < rowLength) {
                col = 0;
                row += 1;
                gardenMatrix[row][col] = flower;
            }
        }
    }
*/
}
