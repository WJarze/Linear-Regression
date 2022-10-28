package model;

import data.Points;
import dataReader.fromExcel.DataReadFromExcel;
import dataReader.fromFile.DataReaderFromFile;
import dataReader.fromFile.ImportData;

public class Regression {
    private DataReaderFromFile dataReader;
    private DataReadFromExcel dataReaderExcel;
    private final Sum sum = new Sum ( );
    private final ImportData importData = new ImportData ( );

    public Regression(DataReaderFromFile dataReader) {
        this.dataReader = dataReader;
    }

    public Regression(DataReadFromExcel dataReaderExcel) {
        this.dataReaderExcel = dataReaderExcel;
    }

    public void addPointToList(Points points) {
        importData.addPointToList ( points , dataReader );
    }

    public void addPointToToListFromExcel(Points points) {
        dataReaderExcel.readExcel ( points );
    }

    public double sumX(Points points) {
        return sum.getSumX ( points );
    }

    public double sumY(Points points) {
        return sum.getSumY ( points );
    }

    public double sumXY(Points points) {
        return sum.getSumXY ( points );
    }

    public double sumX2(Points points) {
        return sum.getSumX2 ( points );
    }

    public double avgY(Points points) {
        return sum.getAvgY ( points );
    }

    public double avgX(Points points) {
        return sum.getAvgX ( points );
    }

    private double slope(Points points) {
        return (((sumY ( points )) * avgX ( points )) - sumXY ( points ))
                / (((sumX ( points ) * avgX ( points ))) - sumX2 ( points ));
    }

    private double intercept(Points points) {
        return avgY ( points ) - slope ( points ) * avgX ( points );
    }

    private double getR2(Points points) {
        double num = 0;
        double den = 0;
        for (int i = 0; i < points.list.size ( ); i++) {
            num += Math.pow ( getNum ( points , i ) , 2 );
            den += Math.pow ( getDen ( points , i ) , 2 );
        }
        return 1 - (num / den);
    }

    private double getDen(Points points , int i) {
        return points.list.get ( i ).getY ( ) - avgY ( points );
    }

    private double getNum(Points points , int i) {
        return points.list.get ( i ).getY ( )
                - (points.list.get ( i ).getX ( ) * slope ( points ) + intercept ( points ));
    }

    public void show(Points points) {
        String slope = String.format ( "%.4f" , slope ( points ) );
        String intercept = String.format ( "%.4f" , intercept ( points ) );
        String r2 = String.format ( "%.4f" , getR2 ( points ) );
        System.out.println ( "regression equation " + slope + " * X " + intercept );
        System.out.println ( "coefficient of determination " + r2 );
    }
}



