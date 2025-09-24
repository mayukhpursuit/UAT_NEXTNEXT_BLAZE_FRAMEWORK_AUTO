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

}
