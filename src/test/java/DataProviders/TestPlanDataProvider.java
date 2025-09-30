package DataProviders;

import org.testng.annotations.DataProvider;
import utils.ExcelDataProviders;

import java.io.IOException;

public class TestPlanDataProvider {
    @DataProvider(name="tc001")
    public static String[][] getDataTC001() throws IOException {
        return ExcelDataProviders.getExcelDataForTestPlan("tc001");
    }
    
    @DataProvider(name="tc002")
    public static String[][] getDataTC002() throws IOException {
        return ExcelDataProviders.getExcelDataForTestPlan("tc002");
    }

    @DataProvider(name = "tc004")
    public static String[][] getDataTC004() throws IOException {
        return ExcelDataProviders.getExcelDataForTestPlan("tc004");
    }

    @DataProvider(name = "tc005")
    public static String[][] getDataTC005() throws IOException {
        return ExcelDataProviders.getExcelDataForTestPlan("tc005");
    }
}
