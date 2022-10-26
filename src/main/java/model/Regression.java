package model;

import data.Points;
import dataReader.fromExcel.DataReadFromExcel;
//import DataReaderFromFile;
import dataReader.fromFile.DataReaderFromFile;
import dataReader.fromFile.ImportData;


public class Regression {
    private DataReaderFromFile dataReader;
    private DataReadFromExcel dataReaderExcel;
    Sum sum = new Sum ( );

    public Regression(DataReaderFromFile dataReader) {
        this.dataReader = dataReader;
    }

    public Regression(DataReadFromExcel dataReaderExcel) {
        this.dataReaderExcel = dataReaderExcel;
    }

    private ImportData importData = new ImportData ( );

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

    private double slope(Points points) {
        return (((sumY ( points )) * (sumX ( points )) / points.list.size ( )) - sumXY ( points ))
                / (((sumX ( points ) * sumX ( points )) / points.list.size ( )) - sumX2 ( points ));
    }

    private double intercept(Points points) {
        return (sumY ( points ) - slope ( points ) * sumX ( points )) / points.list.size ( );
    }

    private double getR2(Points points) {
        double num = 0;
        double den = 0;
        double avgY = sumY ( points ) / points.list.size ( );

        for (int i = 0; i < points.list.size ( ); i++) {
            num += Math.pow ( (points.list.get ( i ).getY ( )
                    - (points.list.get ( i ).getX ( ) * slope ( points ) + intercept ( points ))) , 2 );
            den += Math.pow ( (points.list.get ( i ).getY ( ) - avgY) , 2 );
        }
        return 1 - (num / den);
    }

    public void show(Points points) {
        String slope = String.format ( "%.4f" , slope ( points ) );
        String intercept = String.format ( "%.4f" , intercept ( points ) );
        String r2 = String.format ( "%.4f" , getR2 ( points ) );
        System.out.println ( "regression equation " + slope + " * X " + intercept );
        System.out.println ( "Correlation coefficient " + r2 );
    }


}



