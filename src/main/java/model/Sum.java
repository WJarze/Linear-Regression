package model;

import data.Point;
import data.Points;

public class Sum {

    public double getSumX(Points points) {
        return points.stream ( )
                .map ( Point::getX )
                .mapToDouble (Double::doubleValue)
                .sum (  );
    }

    protected double getSumY(Points points) {
        return points.stream ( )
                .map ( Point::getY )
                .mapToDouble (Double::doubleValue)
                .sum (  );
    }


    protected double getSumXY(Points points) {
        return points.stream ( )
                .map ( Point::getXY )
                .mapToDouble (Double::doubleValue)
                .sum (  );
    }
    protected double getSumX2(Points points) {
        return points.stream ( )
                .map ( Point::getX )
                .map(x -> x * x)
                .mapToDouble (Double::doubleValue)
                .sum (  );
    }

    protected double getAvgY(Points points) {
        return points.stream ( )
                .map ( Point::getY )
                .mapToDouble (Double::doubleValue)
                .average ( )
                .getAsDouble ( );
    }
    protected double getAvgX(Points points) {
        return points.stream ( )
                .map ( Point::getX )
                .mapToDouble (Double::doubleValue)
                .average ( )
                .getAsDouble ( );
    }
}
