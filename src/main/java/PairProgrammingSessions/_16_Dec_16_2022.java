package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class _16_Dec_16_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("sowpods.txt"))) {
            ArrayList<String> returnArray = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("PRO") && line.endsWith("ING")) {

                    if (returnArray.isEmpty()) {
                        returnArray.add(line);
                    } else if (returnArray.get(0).length() > line.length()) {
                        returnArray = new ArrayList<>();
                        returnArray.add(line);
                    } else if (returnArray.get(0).length() == line.length()){
                        returnArray.add(line);
                    }
                }
            }

            System.out.println(returnArray);


        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}