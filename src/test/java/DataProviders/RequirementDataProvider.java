package DataProviders;

import org.testng.annotations.DataProvider;
import utils.ExcelDataProviders;

import java.io.IOException;

public class RequirementDataProvider {
    @DataProvider(name="tc001")
    public static String[][] getDataTC001() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc001");
    }

    @DataProvider(name="tc009")
    public static String[][] getDataTC009() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc009");
    }

    @DataProvider(name="tc010")
    public static String[][] getDataTC010() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc010");
    }


}
