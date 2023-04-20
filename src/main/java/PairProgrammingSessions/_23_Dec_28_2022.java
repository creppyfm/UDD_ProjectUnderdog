package PairProgrammingSessions;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;

public class _23_Dec_28_2022 {
    public static void main (String[] args) throws IOException {
        System.out.println(returnsWinningYears("Los Angeles Lakers"));

    }

    public static HashMap<String, List<Integer>> map = new HashMap<>();

    public static List<Integer> returnsWinningYears (String teamName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("nba_finals.csv"));
        String[] line = reader.readNext();

        while ((line = reader.readNext()) != null) {
            String team = line[1];
            int year = Integer.valueOf(line[0]);
            if (map.containsKey(team)) {
                List<Integer> years = map.get(team);
                years.add(year);
                map.put(team, years);
            } else {
                List<Integer> years = new ArrayList<>();
                years.add(year);
                map.put(team, years);
            }
        }

        List<Integer> test = map.get(teamName);
        if (test == null) {
            return new ArrayList<>();
        }

        return test;

    }
}

