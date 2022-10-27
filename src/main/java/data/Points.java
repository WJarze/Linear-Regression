package data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Points {
    public List<Point> list = new ArrayList<> ( );

    public void addList(Point point) {
        list.add ( point );
    }

    public  Stream<Point> stream() {
        return list.stream ( );
    }

    @Override
    public String toString() {
        return "data.Points(" +
                "list = \n " + list +
                ')';
    }
}
