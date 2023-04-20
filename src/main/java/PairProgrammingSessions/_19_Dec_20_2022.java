package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _19_Dec_20_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("sowpods.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!containsAEIOSHRTN(line)) System.out.println(line);

            }


        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    private static Pattern pattern = Pattern.compile("[AEIOSHRTN]");

    private static boolean containsAEIOSHRTN(String word) {
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }

}