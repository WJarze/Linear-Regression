import data.Points;
import dataReader.FileChoice;
import dataReader.fromExcel.FromExcel;
import dataReader.fromFile.FromFile;
import dataReader.Import;
import dataReader.fromUser.InputReader;
import java.util.Scanner;

public class Manager {
    Scanner scanner;
    Points points ;
    InputReader reader ;

    public Manager(Scanner scanner , Points points , InputReader reader) {
        this.scanner = scanner;
        this.points = points;
        this.reader = reader;
    }

    public void choiceImportAndCalculate() {
        System.out.println ("select data format" );
        FileChoice choice = getFileType ( );
        switch (choice) {
            case EXCEL -> {
                Import excel = new FromExcel ( );
                excel.importsAndCalculate ( points );
            }
            case TXT -> {
                Import file = new FromFile ( );
                file.importsAndCalculate ( points );
            }
        }
    }

    private FileChoice getFileType() {
        boolean typeOk = false;
        FileChoice result = null;
        do {
            printTypes();
            String type = reader.getString ( ).toUpperCase ( );
            try {
                result = FileChoice.valueOf ( type );
                typeOk = true;
            } catch (IllegalArgumentException e) {
                System.out.println ( "Unsupported data type, select again." );
            }
        } while (!typeOk);

        return result;
    }

    private void printTypes() {
        for (FileChoice value : FileChoice.values ( )) {
            System.out.println ( value.name ( ) );
        }
    }
}
