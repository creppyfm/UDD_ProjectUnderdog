package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _18_Dec_20_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("sowpods.txt"))) {
            ArrayList<String> returnArray = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (onlyContainsRSTLNE(line)) {
                    if (!returnArray.isEmpty() && returnArray.get(0).length() < line.length()) {
                        returnArray = new ArrayList<>();
                    }
                    if (returnArray.isEmpty() || returnArray.get(0).length() == line.length()) {
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

    private static Pattern pattern = Pattern.compile("[^RSTLNE]");

    private static boolean onlyContainsRSTLNE (String word) {
        Matcher matcher = pattern.matcher(word);
        return !matcher.find();
    }

}