package dataReader.fromFile;

import data.Points;
import dataReader.Import;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.Regression;

public class FromFile implements Import {
    FileReader reader;
    File file;

    public File getFile() {
        boolean result;
        file = new File ( "data.txt" );
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
        return new File ( "data.txt" );
    }

    @Override
    public void importsAndCalculate(Points points) {
        getFile ( );
        try {
            reader = new FileReader ( file );
        } catch (FileNotFoundException e) {
            System.out.println ( "file not exist" );
        }
        BufferedReader bufferedReader = new BufferedReader ( reader );
        DataReaderFromFile dataReader = new DataReaderFromFile ( file , reader , bufferedReader );
        Regression regression = new Regression ( dataReader );
        regression.addPointToList ( points );
        regression.show ( points );
        dataReader.close ( );
    }
}
