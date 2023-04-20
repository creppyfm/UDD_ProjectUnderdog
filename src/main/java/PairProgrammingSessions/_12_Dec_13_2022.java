package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class _12_Dec_13_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("sowpods.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("TH") && line.endsWith("TH"))
                    System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}