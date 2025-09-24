package DataProviders;

import org.testng.annotations.DataProvider;
import utils.ExcelDataProviders;

import java.io.IOException;

public class RequirementDataProvider {
    @DataProvider(name="tc001")
    public static String[][] getDataTC001() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc001");
    }

    @DataProvider(name="tc002")
    public static String[][] getDataTC002() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc002");
    }

    @DataProvider(name="tc011")
    public static String[][] getDataTC011() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc011");
    }

    @DataProvider(name="tc012")
    public static String[][] getDataTC012() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc012");
    }

}
