package utils;

import java.io.IOException;

public class ExcelDataProviders {
    public static String[][] getExcelData(String sheetName) throws IOException {
        String path = ".\\testData\\authorTestTabTestData\\authorTestCaseTab_testData.xlsx";
        XLUtility utility = new XLUtility(path);

        int totalRows = utility.getRowCount(sheetName);
        int totalCols = utility.getCellCount(sheetName, 1);

        String [][] data = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                data[i - 1][j] = utility.getCellData(sheetName, i, j);
            }
        }
        return data;
    }

    public static String[][] getExcelDataForRequirement(String sheetName) throws IOException {
        String path = ".\\testData\\requirementTabTestData\\requirementTab_testData.xlsx";
        XLUtility utility = new XLUtility(path);

        int totalRows = utility.getRowCount(sheetName);
        int totalCols = utility.getCellCount(sheetName, 1);

        String [][] data = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                data[i - 1][j] = utility.getCellData(sheetName, i, j);
            }
        }
        return data;
    }

}
