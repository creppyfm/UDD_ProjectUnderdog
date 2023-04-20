package PairProgrammingSessions;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVReader;


public class _30_Jan_9_2023 {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("billboard100_2000.csv"));
        //skip first line (header)
        String[] line = reader.readNext();

        while ((line = reader.readNext()) != null) {
            int rank = Integer.valueOf(line[0]);
            String title = line[1];
            String artist = line[2];

            TitleArtistRank titleArtistRank = new TitleArtistRank(title, artist, rank);
            if (rank == 1) {
                if (rankOccurrenceMap.containsKey(titleArtistRank)) {
                    int counter = rankOccurrenceMap.get(titleArtistRank);
                    rankOccurrenceMap.put(titleArtistRank, counter + 1);
                } else {
                    rankOccurrenceMap.put(titleArtistRank, 1);
                }
            }
        }
        List<Map.Entry<TitleArtistRank, Integer>> elementList = new ArrayList<>(rankOccurrenceMap.entrySet());

        Map.Entry<TitleArtistRank, Integer> max = elementList.get(0);
        for (Map.Entry<TitleArtistRank, Integer> element : elementList) {
            int occurrences = element.getValue();
            if (max.getValue() < occurrences) {
                max = element;
            }
        }

    }

//    public static void returnMax(Map.Entry<TitleArtistRank, Integer> record) {
//        int max = record.getValue();
//    }

    public static Map<TitleArtistRank, Integer> rankOccurrenceMap = new HashMap<>();
    public record TitleArtistRank(String title, String artist, int rank) {

//        public String toString () {
//            String title = this.title;
//            String artist = this.artist;
//
//            System.out.println("Artist: " + artist);
//            System.out.println("Song: " + title);
//            System.out.println("Weeks at number one: " + );
//        }
    }
}