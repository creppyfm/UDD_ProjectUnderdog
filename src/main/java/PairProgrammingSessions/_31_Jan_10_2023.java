package PairProgrammingSessions;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVReader;


public class _31_Jan_10_2023 {
    public static void main(String[] args) throws IOException {
        Map<String, Set<String>> artistToSongsMap = new HashMap<>();
        CSVReader reader = new CSVReader(new FileReader("billboard100_2000.csv"));
        //skip first line (header)
        String[] line = reader.readNext();

        int max = 0;
        while ((line = reader.readNext()) != null) {
            String artist = line[2];
            String title = line[1];
            Set<String> songs;

            if (artistToSongsMap.containsKey(artist)) {
                songs = artistToSongsMap.get(artist);
            } else {
                songs = new HashSet<>();
                artistToSongsMap.put(artist, songs);
            }

            songs.add(title);
            int setLength = songs.size();
            if (max < setLength) {
                max = setLength;
            }

        }

        for (Map.Entry<String, Set<String>> element : artistToSongsMap.entrySet()) {
            Set<String> songs = element.getValue();
            int setLength = songs.size();

            if (setLength == max) {
                String artist = element.getKey();
                System.out.println("Artist: " + artist);
                System.out.println("Songs: ");
                System.out.println(songs);
            }
        }


    }


}