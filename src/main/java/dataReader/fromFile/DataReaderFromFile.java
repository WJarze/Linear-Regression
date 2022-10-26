package dataReader.fromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataReaderFromFile {
    private  File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public DataReaderFromFile(File file , FileReader fileReader , BufferedReader bufferedReader) {
        this.file = file;
        this.fileReader = fileReader;
        this.bufferedReader = bufferedReader;
    }
    public String lineReader()  {
        try {
            return bufferedReader.readLine ( );
        } catch (IOException e) {
            throw new RuntimeException ( e );
        }
    }

    public void close()  {
        try {
            bufferedReader.close ( );
        } catch (IOException e) {
            throw new RuntimeException ( e );
        }
    }
}

