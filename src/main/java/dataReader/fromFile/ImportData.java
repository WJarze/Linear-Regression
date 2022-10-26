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
            point.setX ( Double.parseDouble ( str[ 0 ] ) );
            point.setY ( Double.parseDouble ( str[ 1 ] ) );
            points.addList ( point );
        }
    }
}
