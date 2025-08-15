package view.console;

import java.util.Scanner;

public class InputOutput {
    Scanner scanner = new Scanner(System.in);

    public void clearBuffer() {
        scanner.nextLine();
    }

    public String scanLine() {
        return scanner.nextLine();
    }

    public void blankLine() {
        System.out.println();
    }

    public int scanInt() {
        return scanner.nextInt();
    }

    public void printLine(String line) {
        System.out.println(line);
    }
}
