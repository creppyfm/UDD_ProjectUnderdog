package PairProgrammingSessions;


import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVReader;

public class _25_Dec_30_2022 {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("nba_finals.csv"));
        //skip first line (header)
        String[] line = reader.readNext();

        //create hashmap of individual winners mapped to wins
        while ((line = reader.readNext()) != null) {
            String player = line[4];

            if (!player.equals("")) {
                if (!mapWinsToWinners.containsKey(player)) {
                    mapWinsToWinners.put(player, 1);
                } else {
                    int wins = mapWinsToWinners.get(player) + 1;
                    mapWinsToWinners.put(player, wins);
                }
            }
        }

        //create hashmap of wins mapped to lists of winners
        for (Map.Entry<String, Integer> element : mapWinsToWinners.entrySet()) {
            int wins = element.getValue();
            String player = element.getKey();

            if (!mapWinsToLists.containsKey(wins)) {
                winners = new ArrayList<>();
            } else {
                winners = mapWinsToLists.get(wins);
            }
            winners.add(player);
            mapWinsToLists.put(wins, winners);
        }

        //create records for each tuple; create list of tuples
        for (Map.Entry<Integer, List<String>> element : mapWinsToLists.entrySet()) {
            int wins = element.getKey();
            List<String> winnersList = element.getValue();

            //filter out players with < 2 wins
            if (wins > 1) {
                WinsToList winsToList = new WinsToList(wins, winnersList);
                unsortedRecords.add(winsToList);
            }
        }

        //sort records; name list appropriately
        Collections.sort (unsortedRecords, Collections.reverseOrder());
        sortedRecords = unsortedRecords;

        //final solution method call
        printsRecords();

    }

    //prints the return Record (sortedRecords)
    public static void printsRecords() {
        for (int i = 0; i < sortedRecords.size(); i++) {
            int wins = sortedRecords.get(i).wins; //6
            List<String> names = sortedRecords.get(i).winners; //Michael Jordan

            System.out.print(wins + " times: ");
            printsList(names);
            System.out.println();
        }
    }

    //helper -- prints names from list
    public static void printsList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            int listSize = list.size() - 1;
            String name = list.get(i);

            if (i == listSize) {
                System.out.print(name);
            } else {
                System.out.print(name + ", ");
            }
        }
    }

    //records to store KV pairs; allows records to be compared to each other
    public record WinsToList(int wins, List<String> winners) implements Comparable<WinsToList> {
        @Override
        public int compareTo(WinsToList o1) {
            int thisWins = this.wins;
            int thatWins = o1.wins;

            if (thisWins > thatWins) {
                return 1;
            } else if (thisWins < thatWins) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    //storage
    public static List<WinsToList> sortedRecords = new ArrayList<>();
    public static List<WinsToList> unsortedRecords = new ArrayList<>();
    public static List<String> winners = new ArrayList<>();
    public static HashMap<String, Integer> mapWinsToWinners = new HashMap<>();
    public static HashMap<Integer, List<String>> mapWinsToLists = new HashMap<>();
}