package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _17_Dec_19_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("sowpods.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (comparesWordToRSTLNE(line)) System.out.println(line);
            }


        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static boolean comparesWordToRSTLNE (String word) {

        for (int i = 0; i < word.length(); i++) {
            if (!containRSTLNE(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containRSTLNE (char letter) {
        switch (letter) {
            case 'R':
            case 'S':
            case 'T':
            case 'L':
            case 'N':
            case 'E':
                return true;
            default: return false;
        }
    }

}