package PracticeProblems.RecursionPractice;

import java.io.File;

public class PathToFilesInDirectory {
    private static final File testParentDir = new File("C:\\Users\\Foli\\Desktop\\TEST_ParentDir");
    private static final File testParentDirTwo = new File("C:\\Users\\Foli\\Desktop\\Life\\Job Hunt");
    private static final File testParentDirThree = new File("C:\\Users\\Foli\\Desktop\\Life\\Music\\Fortunes_Session_11.11.22");

    public static void main(String[] args) {
        printFilePaths(testParentDirThree);
    }

    private static void printFilePaths(File parentDir) {
        var paths = parentDir.listFiles();
        for (var path : paths) {
            if (path.isFile()) {
                System.out.println(path.getAbsolutePath());
            } else if (path.isDirectory() && !path.getName().startsWith(".")) {
                printFilePaths(path.getAbsoluteFile());
            }
        }

    }


}
