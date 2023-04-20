package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _9_Dec_8_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("baby_names_2020_short.txt"))) {
            ArrayList<String> longestNames = new ArrayList<>();
            int longestLength = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() > longestLength) {
                    longestLength = line.length();
                    longestNames.clear();
                    longestNames.add(line);
                } else if (line.length() == longestLength) {
                    longestNames.add(line);
                } //else: line < longestLength; discard

            }
            //ಠ_ಠ

            //print final result
            System.out.println(longestNames);

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}