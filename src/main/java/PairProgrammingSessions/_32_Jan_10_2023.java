package PairProgrammingSessions;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;


public class _32_Jan_10_2023 {
    public static void main(String[] args) throws IOException {
        Map<ArtistToSong, Integer> recordToOccurrenceMap = new HashMap<>();
        List
                <Map.Entry<ArtistToSong, Integer>> elements;
        CSVReader reader = new CSVReader(new FileReader("billboard100_2000.csv"));

        String[] line = reader.readNext(); //skips first line (header)
        int max = 0; //stores the largest value in map
        while ((line = reader.readNext()) != null) {
            String artist = line[2];
            String song = line[1];

            ArtistToSong artistToSong = new ArtistToSong(artist, song);

            int counter = 1; //to increment for every week a song charted
            if (recordToOccurrenceMap.containsKey(artistToSong)) {
                counter = recordToOccurrenceMap.get(artistToSong) + 1;
            }

            if (max < counter) {
                max = counter;
            }

            recordToOccurrenceMap.put(artistToSong, counter);
        }

        for (Map.Entry<ArtistToSong, Integer> element : recordToOccurrenceMap.entrySet()) {

            int weeksOnChart = element.getValue();
            if (weeksOnChart == max) {
                System.out.println(element.getKey() + "\nWeeks on chart: " + weeksOnChart);
            }
        }

    }

    public record ArtistToSong (String artist, String song) {

        @Override
        public String toString() {
            return "Artist: " + artist + "\nSong title: " + song;
        }
    }
}
