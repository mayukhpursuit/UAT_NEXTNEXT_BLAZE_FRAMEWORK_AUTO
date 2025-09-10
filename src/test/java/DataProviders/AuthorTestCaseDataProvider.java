package DataProviders;

import org.testng.annotations.DataProvider;
import utils.DataProviders;

import java.io.IOException;

public class AuthorTestCaseDataProvider {

    @DataProvider(name="tc001")
    public static String[][] getDataTC001() throws IOException {
        return DataProviders.getExcelData("tc001");
    }

    @DataProvider(name="tc002")
    public static String[][] getDataTC002() throws IOException {
        return DataProviders.getExcelData("tc002");
    }

    @DataProvider(name="tc003")
    public static String[][] getDataTC003() throws IOException {
        return DataProviders.getExcelData("tc003");
    }
}
