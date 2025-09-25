package DataProviders;

import org.testng.annotations.DataProvider;
import utils.ExcelDataProviders;

import java.io.IOException;

public class RequirementDataProvider {
    @DataProvider(name="tc001")
    public static String[][] getDataTC001() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc001");
    }

    @DataProvider(name="tc004")
    public static String[][] getDataTC004() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc004");
    }

}
