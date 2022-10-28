import data.Points;
import dataReader.fromUser.InputReader;
import java.io.IOException;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner ( System.in );
        Points points = new Points ( );
        InputReader reader = new InputReader ( scanner );
        Manager manager = new Manager ( scanner , points , reader );
        boolean isAvailable = false;
        do {
            manager.choiceImportAndCalculate ( );
            isAvailable = true;
        }while(isAvailable);


    }
}