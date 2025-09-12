package DataProviders;

import org.testng.annotations.DataProvider;
import utils.DataProviders;

import java.io.IOException;

public class AuthorTestCaseDataProvider {

    @DataProvider(name="tc001")
    public static String[][] getDataTC001() throws IOException {
        return DataProviders.getExcelData("tc001");
    }

    @DataProvider(name="tc003")
    public static String[][] getDataTC002() throws IOException {
        return DataProviders.getExcelData("tc003");
    }

    @DataProvider(name="tc004")
    public static String[][] getDataTC004() throws IOException {
        return DataProviders.getExcelData("tc004");
    }
    @DataProvider(name="tc007")
    public static String[][] getDataTC007() throws IOException {
        return DataProviders.getExcelData("tc007");
    }

    @DataProvider(name="tc011")
    public static String[][] getDataTC011() throws IOException {
        return DataProviders.getExcelData("tc011");
    }

}
