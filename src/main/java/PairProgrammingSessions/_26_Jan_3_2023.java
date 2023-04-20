package PairProgrammingSessions;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.opencsv.CSVReader;


public class _26_Jan_3_2023 {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("top_movies.csv"));
        //skip first line (header)
        String[] line = reader.readNext();

        String maxTitle = "";
        long maxGross = 0;
        while ((line = reader.readNext()) != null) {
            if (line[1].contains("Universal Pictures")) {
                long integer = Long.valueOf(line[4]);
                if (integer > maxGross) {
                    maxGross = integer;
                    maxTitle = line[0];
                }
            }
        }

        System.out.println(maxTitle);
    }
}