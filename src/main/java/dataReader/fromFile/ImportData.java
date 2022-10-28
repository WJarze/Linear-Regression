package dataReader.fromFile;

import data.Point;
import data.Points;

public class ImportData {

    public void addPointToList(Points points, DataReaderFromFile dataReader)  {
        String line;
        points.list.clear ();
        while ((line = dataReader.lineReader ( )) != null) {
            Point point = new Point ( );
            String[] str = line.split ( "," );
            try {
                point.setX ( Double.parseDouble ( str[ 0 ] ) );
            }catch ( NumberFormatException e ){
                System.out.println ("wrong data format" );
            }
            try {
                point.setY ( Double.parseDouble ( str[ 1 ] ) );
            }catch ( NumberFormatException e ){
                System.out.println ( "wrong data format");
            }
            points.addList ( point );


        }
    }
}
