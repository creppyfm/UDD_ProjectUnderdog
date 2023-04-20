package PairProgrammingSessions;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;


public class _27_Jan_4_2023 {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("top_movies.csv"));
        //skip first line (header)
        String[] line = reader.readNext();

        while ((line = reader.readNext()) != null) {
            String distributor = line[1];
            if (distroToMovies.containsKey(distributor)) {
                int count = distroToMovies.get(distributor);
                distroToMovies.put(distributor, count + 1);
            } else {
                distroToMovies.put(distributor, 1);
            }
        }

        String largestDistributor = "";
        int highestCount = 0;
        for (Map.Entry<String, Integer> element : distroToMovies.entrySet()) {
            if (element.getValue() > highestCount) {
                highestCount = element.getValue();
                largestDistributor = element.getKey();
            }
        }

        System.out.println(largestDistributor);
    }

    public static HashMap<String, Integer> distroToMovies = new HashMap<>();
    public static List<String> movies = new ArrayList<>();
}