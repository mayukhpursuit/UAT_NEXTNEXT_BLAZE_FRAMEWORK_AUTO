package DataProviders;

import org.testng.annotations.DataProvider;
import utils.ExcelDataProviders;

import java.io.IOException;

public class AuthorTestCaseDataProvider {

    @DataProvider(name="tc001")
    public static String[][] getDataTC001() throws IOException {
        return ExcelDataProviders.getExcelData("tc001");
    }

    @DataProvider(name="tc003")
    public static String[][] getDataTC002() throws IOException {
        return ExcelDataProviders.getExcelData("tc003");
    }

    @DataProvider(name="tc004")
    public static String[][] getDataTC004() throws IOException {
        return ExcelDataProviders.getExcelData("tc004");
    }
    @DataProvider(name="tc007")
    public static String[][] getDataTC007() throws IOException {
        return ExcelDataProviders.getExcelData("tc007");
    }

    @DataProvider(name="tc009")
    public static String[][] getDataTC009() throws IOException {
        return ExcelDataProviders.getExcelData("tc009");
    }
    @DataProvider(name="tc011")
    public static String[][] getDataTC011() throws IOException {
        return ExcelDataProviders.getExcelData("tc011");
    }
    @DataProvider(name="AddTest")
    public static String[][] getDataAddTest() throws IOException {
        return ExcelDataProviders.getExcelData("AddTest");
    }

    @DataProvider(name="tc018")
    public static String[][] getDataTC016() throws IOException {
        return ExcelDataProviders.getExcelData("tc018");
    }

    @DataProvider(name="tc028")
    public static String[][] getDataTC028() throws IOException {
        return ExcelDataProviders.getExcelData("tc028");
    }

    @DataProvider(name="tc029")
    public static String[][] getDataTC029() throws IOException {
        return ExcelDataProviders.getExcelData("tc029");
    }
    @DataProvider(name="tc044")
    public static String[][] getDataTC044() throws IOException {
        return ExcelDataProviders.getExcelData("tc044");
    }
    @DataProvider(name="tc042")
    public static String[][] getDataTC042() throws IOException {
        return ExcelDataProviders.getExcelData("tc042");
    }

    @DataProvider(name="tc049")
    public static String[][] getDataTC049() throws IOException {
        return ExcelDataProviders.getExcelData("tc049");
    }

    @DataProvider(name="tc047")
    public static String[][] getDataTC047() throws IOException {
        return ExcelDataProviders.getExcelData("tc047");
    }

    @DataProvider(name="tc040")
    public static String[][] getDataTC050() throws IOException {
        return ExcelDataProviders.getExcelData("tc040");
    }

    @DataProvider(name="tc063")
    public static String[][] getDataTC063() throws IOException {
        return ExcelDataProviders.getExcelData("tc063");
    }

}
