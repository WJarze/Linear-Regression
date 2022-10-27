package model;

import data.Point;
import data.Points;

public class Sum {
    private double sum;

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
        sum = 0;
        for (int i = 0; i < points.list.size ( ); i++) {
            sum += Math.pow ( points.list.get ( i ).getX ( ) , 2 );
        }
        return sum;
    }
}
