package dataReader.fromUser;

import java.util.Scanner;

public class InputReader {
    Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getString() {
        return scanner.nextLine();
    }
}
