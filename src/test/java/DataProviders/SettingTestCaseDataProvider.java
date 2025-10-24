package DataProviders;

import org.testng.annotations.DataProvider;
import utils.ExcelDataProviders;

import java.io.IOException;

public class SettingTestCaseDataProvider {
    @DataProvider(name="Demo")
    public static String[][] getDataTC001() throws IOException {
        return ExcelDataProviders.getExcelDataForSettingTestCase("Demo");
    }
}
