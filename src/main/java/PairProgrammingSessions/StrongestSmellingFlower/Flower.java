package PairProgrammingSessions.StrongestSmellingFlower;

public class Flower {
    int row;
    int col;
    int strength;
    int decline;
    public Flower () {}
    public Flower (int row, int col) {
        this.row = row;
        this.col = col;
        this.strength = (int)((Math.random() * 5));
        this.decline = (int)((Math.random() * 2));

    }
    public Flower (int row, int col, int strength, int decline) {
        this.row = row;
        this.col = col;
        this.strength = strength;
        this.decline = decline;
    }
    /*
        Generates Flower objects with random strength between 0 and 5, inclusive;
        Sets rate of decline to random int between 1 and 2 if strength is > 0; 0 otherwise;
        If rate of decline is > strength, increases strength by rate of decline
    */
/*
    public Flower () {
        this.strength = (int)((Math.random() * 5));
        this.decline = this.strength > 0 ? (int)((Math.random() * 2) + 1) : 0;
        this.strength = this.decline >= this.strength ? (this.strength + this.decline) : this.strength;
    }
*/

}
