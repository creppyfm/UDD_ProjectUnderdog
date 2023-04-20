package PairProgrammingSessions;

import java.io.FileReader;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import com.opencsv.CSVReader;

public class _22_Dec_27_2022 {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("nba_finals.csv"));
        String[] line = reader.readNext();

        while ((line = reader.readNext()) != null) {
            mapYearToWinner.put(Integer.valueOf(line[0]), line[1]);
        }

        System.out.println(returnsWinner(2018));

    }

    public static HashMap<Integer, String> mapYearToWinner = new HashMap<>();

    public static String returnsWinner (int year) {
        return mapYearToWinner.get(year);
    }
}