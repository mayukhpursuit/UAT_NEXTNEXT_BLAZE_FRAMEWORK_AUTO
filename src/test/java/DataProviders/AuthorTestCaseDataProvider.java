package DataProviders;

import org.testng.annotations.DataProvider;
import utils.DataProviders;

import java.io.IOException;

public class AuthorTestCaseDataProvider {
    @DataProvider(name="filterRequirement")
    public static String[][] getDataTC002() throws IOException {
        return DataProviders.getExcelData("tc002");
    }

    @DataProvider(name="addTestCase")
    public static String[][] getDataTC003() throws IOException {
        return DataProviders.getExcelData("tc003");
    }
}
