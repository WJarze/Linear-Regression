package dataReader.fromExcel;

import data.Points;
import dataReader.Import;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import model.Regression;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FromExcel implements Import {
    File file;
    FileInputStream fis;

    public File getFile() {
        boolean result;
        file = new File ( "data.xlsx" );
        try {
            result = file.createNewFile ( );  //creates a new file
            if ( result )      // test if successfully created a new file
            {
                System.out.println ( "file created " + file.getCanonicalPath ( ) ); //returns the path string
            } else {
                System.out.println ( "File already exist at location: " + file.getCanonicalPath ( ) );
            }
        } catch (IOException e) {
            e.printStackTrace ( );    //prints exception if any
        }
        return new File ( "data.xlsx" );
    }

    @Override
    public void importsAndCalculate(Points points) {
        getFile ( );   //creating a new file instance
        try {
            fis = new FileInputStream ( file );
        } catch (FileNotFoundException e) {
            System.out.println ( "file not exist" );
        }
        XSSFWorkbook wb;
        try {
            wb = new XSSFWorkbook ( fis );
        } catch (IOException e) {
            throw new RuntimeException ( e );
        }
        DataReadFromExcel dataReadFromExcel = new DataReadFromExcel ( file , fis , wb );
        Regression regression = new Regression ( dataReadFromExcel );
        regression.addPointToToListFromExcel ( points );
        regression.show ( points );

    }
}