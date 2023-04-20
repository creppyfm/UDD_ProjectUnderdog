package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _7_Dec_6_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("countries.txt"))) {
            ArrayList<String> countryList = new ArrayList<>();
            ArrayList<String> returnArray = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                countryList.add(line);

            }

            for (String outerList: countryList) {
                for (String innerList: countryList) {
                    if (outerList != innerList) {
                        if (outerList.contains(innerList)) {
                            returnArray.add(outerList);
                        }
                    }
                }
            }

            //print final result
            System.out.println(returnArray);

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}