package model;

import data.Points;

public class Sum {
    private double sum;

    public double getSumX(Points points) {
        sum = 0;
        for (int i = 0; i < points.list.size ( ); i++) {
            sum += points.list.get ( i ).getX ( );
        }
        return sum;
    }

    protected double getSumY(Points points) {
        sum = 0;
        for (int i = 0; i < points.list.size ( ); i++) {
            sum += points.list.get ( i ).getY ( );
        }
        return sum;
    }

    protected double getSumXY(Points points) {
        sum = 0;
        for (int i = 0; i < points.list.size ( ); i++) {
            sum += points.list.get ( i ).getXY ( );
        }
        return sum;
    }

    protected double getSumX2(Points points) {
        sum = 0;
        for (int i = 0; i < points.list.size ( ); i++) {
            sum += Math.pow ( points.list.get ( i ).getX ( ) , 2 );
        }
        return sum;
    }
}
