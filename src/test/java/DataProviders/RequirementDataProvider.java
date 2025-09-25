package DataProviders;

import org.testng.annotations.DataProvider;
import utils.ExcelDataProviders;

import java.io.IOException;

public class RequirementDataProvider {
    @DataProvider(name="tc001")
    public static String[][] getDataTC001() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc001");
    }
    @DataProvider(name="tc007")
    public static String[][] getDataTC007() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc007");
    }
    @DataProvider(name="tc021")
    public static String[][] getDataTC021() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc021");
    }
    @DataProvider(name="tc022")
    public static String[][] getDataTC022() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc022");
    }

}
