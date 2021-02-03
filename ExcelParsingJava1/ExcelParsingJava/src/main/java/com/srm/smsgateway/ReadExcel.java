package com.srm.smsgateway;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    public static List<Employee> readMobileData(String fileName) {
        List<Employee> employeesList = new ArrayList<>();

        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(fileName);

            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook;

            workbook = new XSSFWorkbook(fis);

            //Get the nth sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            //every sheet has rows, iterate over them
            for (Row cells : sheet) {

                String employeeId = "";
                String employeeName = "";
                String mobileNumber = "";

                //Get the row object
                if (cells.getRowNum() < 1) {
                    continue;
                }

                Cell cell = cells.getCell(0);

                if (cell == null) {
                    continue;
                }

                //check the cell type and process accordingly
                switch (cell.getCellType()) {
                    case STRING:
                        employeeId = cell.getStringCellValue().trim();
                        break;
                    case NUMERIC:
                        System.out.println("Random data::" + cell.getNumericCellValue());
                }

                cell = cells.getCell(2);

                if (cell == null) {
                    continue;
                }

                //check the cell type and process accordingly
                switch (cell.getCellType()) {
                    case STRING:
                        employeeName = cell.getStringCellValue().trim();
                        break;
                    case NUMERIC:
                        System.out.println("Random data::" + cell.getNumericCellValue());
                }

                cell = cells.getCell(4);

                if (cell == null) {
                    continue;
                }

                //check the cell type and process accordingly
                switch (cell.getCellType()) {
                    case STRING:
                        mobileNumber = cell.getStringCellValue().trim();
                        break;
                    case NUMERIC:
                        System.out.println("Random data::" + cell.getNumericCellValue());
                }

                Employee c = new Employee(employeeId, employeeName, mobileNumber);
                employeesList.add(c);
            } //end of rows iterator

            //close file input stream
            fis.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employeesList;
    }

    public static List<Employee> readTimesheetData(String fileName) {
        List<Employee> employeesList = new ArrayList<>();

        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(fileName);

            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook;

            workbook = new XSSFWorkbook(fis);
            //Get the nth sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            //every sheet has rows, iterate over them

            for (Row cells : sheet) {
                String employeeId;
                String employeeName;
                String employeeNameId = "";
                String supervisor = "";

                //Get the row object
                if (cells.getRowNum() < 17) {
                    continue;
                }

                Cell cell = cells.getCell(1);

                if (cell == null) {
                    continue;
                }

                //check the cell type and process accordingly
                switch (cell.getCellType()) {
                    case STRING:
                        employeeNameId = cell.getStringCellValue().trim();
                        break;
                    case NUMERIC:
                        System.out.println("Random data::" + cell.getNumericCellValue());
                }

                if (employeeNameId.length() > 0) {
                    employeeId = employeeNameId.substring(employeeNameId.indexOf('(') + 1, employeeNameId.indexOf(')'));
                    employeeName = employeeNameId.substring(0, employeeNameId.indexOf('('));
                } else {
                    continue;
                }

                cell = cells.getCell(3);

                if (cell == null) {
                    continue;
                }

                //check the cell type and process accordingly
                switch (cell.getCellType()) {
                    case STRING:
                        supervisor = cell.getStringCellValue().trim();
                        break;
                    case NUMERIC:
                        System.out.println("Random data::" + cell.getNumericCellValue());
                }

                Employee c = new Employee(employeeId, employeeName, employeeNameId, supervisor);

                employeesList.add(c);
            } //end of rows iterator

            //close file input stream
            fis.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employeesList;
    }
}
