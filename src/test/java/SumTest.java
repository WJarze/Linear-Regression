import data.Points;
import dataReader.fromFile.DataReaderFromFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.Regression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SumTest {


    @Test
    public void calcTest() throws IOException {
        //when
        File file = new File ( "test.txt" );
        FileReader reader = new FileReader ( file );
        BufferedReader bufferedReader = new BufferedReader ( reader );
        DataReaderFromFile dataReader = new DataReaderFromFile ( file , reader , bufferedReader );
        Points points = new Points ( );
        Regression regression = new Regression ( dataReader );
        regression.addPointToList ( points );
        // given
        double x = regression.sumX ( points );
        double y = regression.sumY ( points );
        double xy = regression.sumXY ( points );
        double x2 = regression.sumX2 ( points );
        //then
        Assertions.assertEquals ( 3 , x );
        Assertions.assertEquals ( 3 , y );
        Assertions.assertEquals ( 5 , xy );
        Assertions.assertEquals ( 5 , x2 );
    }
}
