package PairProgrammingSessions;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import com.opencsv.CSVReader;


public class _24_Dec_29_2022 {

    public static final int LOSER_INDEX = 2;
    public static final int WINNER_INDEX = 1;

    public static void main(String[] args) throws IOException {
        HashSet<String> losersReturn = new HashSet<>();
        HashSet<String> winners = new HashSet<>();
        CSVReader reader = new CSVReader(new FileReader("nba_finals.csv"));
        //skip first line (header)
        String[] line = reader.readNext();

        while ((line = reader.readNext()) != null) {
            winners.add(line[WINNER_INDEX]);
            losersReturn.remove(line[WINNER_INDEX]);

            if (!winners.contains(line[LOSER_INDEX])) {
                losersReturn.add(line[LOSER_INDEX]);
            }
        }

        System.out.println(losersReturn);
    }
}