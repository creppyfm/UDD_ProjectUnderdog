package PairProgrammingSessions;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _29_ElementalSymbols {
    public static void main(String[] args) throws IOException {

        CSVReader reader = new CSVReader(new FileReader("periodic_table.csv"));
        String[] elementArr;
        while ((elementArr = reader.readNext()) != null) {
            elements.add(elementArr[0].toUpperCase());
        }

        Scanner scanner = new Scanner(Paths.get("sowpods.txt"));
        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (validWord(line)) {
                count++;
                System.out.println(line);
            }
        }
        System.out.println(count);

    }
    public static boolean validWord(String word) {
        if (word.length() == 0) return true;

        String subStr = word.substring(0, 1);
        if (elements.contains(subStr)) {
            String paramSubString = word.substring(1);
            if (validWord(paramSubString)) return true;
        }
        if (word.length() > 1 ) {
            subStr = word.substring(0, 2);
            if (elements.contains(subStr)) {
                String paramSubString = word.substring(2);
                if (validWord(paramSubString)) return true;
            }
        }
        return false;
    }

    private static final Set<String> elements = new HashSet<>();
}


/*
* Part 1: Print all words that can be made from chemical elemental symbols
*
* Part two: Print out specific sequence of symbols that make up a word
* */
