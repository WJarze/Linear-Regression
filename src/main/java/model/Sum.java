package model;

import data.Point;
import data.Points;
import java.util.NoSuchElementException;

public class Sum {

    public double getSumX(Points points) {
        return points.stream ( )
                .map ( Point::getX )
                .mapToDouble ( Double::doubleValue )
                .sum ( );
    }

    protected double getSumY(Points points) {
        return points.stream ( )
                .map ( Point::getY )
                .mapToDouble ( Double::doubleValue )
                .sum ( );
    }

    protected double getSumXY(Points points) {
        return points.stream ( )
                .map ( Point::getXY )
                .mapToDouble ( Double::doubleValue )
                .sum ( );
    }

    protected double getSumX2(Points points) {
        return points.stream ( )
                .map ( Point::getX )
                .map ( x -> x * x )
                .mapToDouble ( Double::doubleValue )
                .sum ( );
    }

    protected double getAvgY(Points points) {
        double avgY = 0;
        try {
            avgY = points.stream ( )
                    .map ( Point::getY )
                    .mapToDouble ( Double::doubleValue )
                    .average ( )
                    .getAsDouble ( );
        } catch (NoSuchElementException e) {
            System.out.println ("empty file");
        }
        return avgY;
    }

    protected double getAvgX(Points points) {
        double avgX = 0;
        try {
            avgX = points.stream ( )
                    .map ( Point::getX )
                    .mapToDouble ( Double::doubleValue )
                    .average ( )
                    .getAsDouble ( );
        } catch (NoSuchElementException e) {
            System.out.println ("empty file");
        }
        return avgX;
    }
}
