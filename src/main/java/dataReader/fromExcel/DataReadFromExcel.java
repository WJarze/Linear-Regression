package dataReader.fromExcel;

import data.Point;
import data.Points;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class DataReadFromExcel {
    File file;
    FileInputStream fis;
    XSSFWorkbook wb;

    public DataReadFromExcel(File file , FileInputStream fis , XSSFWorkbook wb) {
        this.file = file;
        this.fis = fis;
        this.wb = wb;
    }

    //creating Workbook instance that refers to .xlsx file
    public void readExcel(Points points) {
        try {
            points.list.clear ();
            XSSFSheet sheet = getSheet ( );
            Iterator<Row> rowIterator = sheet.iterator ( );    //iterating over excel file
            while (rowIterator.hasNext ( )) {
                Row row = rowIterator.next ( );
                Iterator<Cell> cellIterator = row.cellIterator ( );
                int i = 0;
                Point point = new Point ( );
                //iterating over each column
                while (cellIterator.hasNext ( )) {
                    double c;
                    i++;
                    switch (i) {
                        case 1 -> {
                            c = cellReader ( cellIterator );
                            point.setX ( c );
                        }
                        case 2 -> {
                            c = cellReader ( cellIterator );
                            point.setY ( c );
                        }
                    }
                }
                points.addList ( point );
            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    private XSSFSheet getSheet() {
        XSSFSheet sheet = wb.getSheetAt ( 0 );     //creating a Sheet object to retrieve object
        return sheet;
    }

    private static double cellReader(Iterator<Cell> cellIterator) {
        Cell cell = cellIterator.next ( );
        return cell.getNumericCellValue ( );
    }
}

