package DataProviders;

import org.testng.annotations.DataProvider;
import utils.ExcelDataProviders;

import java.io.IOException;

public class SettingTestCaseDataProvider {
    @DataProvider(name="Demo")
    public static String[][] getDataTC001() throws IOException {
        return ExcelDataProviders.getExcelDataForSettingTestCase("Demo");
    }

    @DataProvider(name="Demo1")
    public static String[][] getDataDemo1() throws IOException {
        return ExcelDataProviders.getExcelDataForSettingTestCase("Demo1");
    }

    @DataProvider(name="TC002")
    public static String[][] getDataTC002() throws IOException {
        return ExcelDataProviders.getExcelDataForSettingTestCase("TC002");
    }

    @DataProvider(name="TC009")
    public static String[][] getDataTC009() throws IOException {
        return ExcelDataProviders.getExcelDataForSettingTestCase("TC009");
    }
}
