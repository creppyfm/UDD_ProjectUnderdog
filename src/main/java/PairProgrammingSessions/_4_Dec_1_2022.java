package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _4_Dec_1_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("countries.txt"))) {
            ArrayList<String> shortestWords = new ArrayList<>();

            String shortestWord = "";
            boolean firstPass = true;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (firstPass) {
                    shortestWord = line;
                    firstPass = false;
                } else {
                    if (line.length() < shortestWord.length()) {
                        shortestWord = line;
                    }
                }
                shortestWords.add(line);
            }

            for (int j = 0; j < shortestWords.size();) {
                if (shortestWord.length() < shortestWords.get(j).length()) {
                    shortestWords.remove(j);
                    if (j > 0) {
                        j--;
                    }
                } else {
                    j++;
                }
            }

            //print final result
            System.out.println(shortestWords);

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}