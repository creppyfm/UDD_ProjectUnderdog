package PairProgrammingSessions;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVReader;


public class _28_Jan_5_2023 {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("top_movies.csv"));
        //skip first line (header)
        String[] line = reader.readNext();
        List<String> films = new ArrayList<>();
        int earliestYear = Integer.MAX_VALUE;

        while ((line = reader.readNext()) != null) {
            int currYear = Integer.valueOf(line[2]);
            String currFilm = line[0];
            if (earliestYear > currYear) {
                earliestYear = currYear;
                films.clear();
                films.add(currFilm);
            } else if (earliestYear == currYear) {
                films.add(currFilm);
            }
        }

        System.out.println(earliestYear);
        System.out.println(films);
    }

}