package realtimeAssignment1;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class convertExcel extends Thread{
    String[][] data;
    String[][] data1;
    String[][] data2;
    String[] header={"Matric","Name","Link"};
    String[] header1={"Matric","Name"};
    convertExcel(String[][] data, String[][] data1, String[][] data2){
        this.data=data;
        this.data1=data1;
        this.data2=data2;
    }
    @Override
    public void run() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Submit");
        XSSFSheet sheet1 = workbook.createSheet("NotSubmit");
        XSSFSheet sheet2 = workbook.createSheet("Unknown");

        //write to first sheet
        int rowCount = 0;
        int column = 0;
        Row row1 = sheet.createRow(++rowCount);
        for (int i=0;i<header.length;i++) {

            Cell cell = row1.createCell(++column);
            cell.setCellValue((String) header[i]);

        }


        for (int i=0;i<data.length;i++) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (int j=0;j<data[i].length;j++) {
                Cell cell = row.createCell(++columnCount);
                cell.setCellValue((String) data[i][j]);
                sheet.autoSizeColumn(j);

            }
        }

        //write to second sheet
        int column1 = 0;
        int row2Count=0;
        Row row2 = sheet1.createRow(++row2Count);
        for (int i=0;i<header1.length;i++) {

            Cell cell = row2.createCell(++column1);
            cell.setCellValue((String) header1[i]);
        }
        for (int i=0;i<data1.length;i++) {
            Row row = sheet1.createRow(++row2Count);

            int columnCount = 0;

            for (int j=1;j<data1[i].length;j++) {
                Cell cell = row.createCell(++columnCount);
                cell.setCellValue((String) data1[i][j]);
                sheet1.autoSizeColumn(j);
            }
        }

        //write to third sheet
        int rowCount1 = 0;
        int column2 = 0;
        Row row3 = sheet2.createRow(++rowCount1);
        for (int i=0;i<header.length;i++) {

            Cell cell = row3.createCell(++column2);
            cell.setCellValue((String) header[i]);
        }


        for (int i=0;i<data2.length;i++) {
            Row row = sheet2.createRow(++rowCount1);

            int columnCount = 0;

            for (int j=0;j<data2[i].length;j++) {
                Cell cell = row.createCell(++columnCount);
                cell.setCellValue((String) data2[i][j]);
                sheet2.autoSizeColumn(j);
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream("Assignment1Output.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
