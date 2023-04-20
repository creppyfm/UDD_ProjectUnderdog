package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _8_Dec_6_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("baby_names_2020_short.txt"))) {

            int i = 0;
            String shortestName = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (i == 0) {
                    shortestName = line;

                } else if (i < 41) {
                    if (line.length() < shortestName.length()) {
                        shortestName = line;
                    }
                }
                i++;
            }

            //print final result
            System.out.println(shortestName);

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}