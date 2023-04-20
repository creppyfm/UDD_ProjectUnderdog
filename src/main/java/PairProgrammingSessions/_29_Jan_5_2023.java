package PairProgrammingSessions;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;


public class _29_Jan_5_2023 {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("top_movies.csv"));
        //skip first line (header)
        String[] line = reader.readNext();
        Map<String, Integer> mapRatingToOccurrence = new HashMap<>();
        while ((line = reader.readNext()) != null) {
            String rating = line[6];

            if (!mapRatingToOccurrence.containsKey(rating)) {
                mapRatingToOccurrence.put(rating, 1);
            } else {
                int counter = mapRatingToOccurrence.get(rating);
                mapRatingToOccurrence.put(rating, counter + 1);
            }
        }

        System.out.println(mapRatingToOccurrence);
    }

}