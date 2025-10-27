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
    public static String[][] getDataTC002() throws IOException {
        return ExcelDataProviders.getExcelDataForSettingTestCase("Demo1");
    }

    @DataProvider(name="tc005")
    public static String[][] getDataTC005() throws IOException {
        return ExcelDataProviders.getExcelDataForSettingTestCase("tc005");
    }

    @DataProvider(name="tc006")
    public static String[][] getDataTC006() throws IOException {
        return ExcelDataProviders.getExcelDataForSettingTestCase("tc006");
    }
}
