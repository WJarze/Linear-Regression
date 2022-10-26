package data;

import java.util.ArrayList;
import java.util.List;

public class Points {
    public List<Point> list = new ArrayList<> ( );

    public void addList(Point point) {
        list.add ( point );
    }

    @Override
    public String toString() {
        return "data.Points(" +
                "list = \n " + list +
                ')';
    }
}
