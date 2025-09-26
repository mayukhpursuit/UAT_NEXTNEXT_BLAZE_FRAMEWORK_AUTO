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

    @DataProvider(name="tc002")
    public static String[][] getDataTC002() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc002");
    }

    @DataProvider(name="tc005")
    public static String[][] getDataTC005() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc005");
    }
    @DataProvider(name="tc006")
    public static String[][] getDataTC006() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc006");
    }


    @DataProvider(name="tc011")
    public static String[][] getDataTC011() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc011");
    }

    @DataProvider(name="tc012")
    public static String[][] getDataTC012() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc012");
    }

    @DataProvider(name="tc009")
    public static String[][] getDataTC009() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc009");
    }

    @DataProvider(name="tc010")
    public static String[][] getDataTC010() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc010");
    }


    @DataProvider(name="tc004")
    public static String[][] getDataTC004() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc004");
    }

    @DataProvider(name="tc019")
    public static String[][] getDataTC019() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc019");
    }

    @DataProvider(name="tc020")
    public static String[][] getDataTC020() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc020");
    }

    @DataProvider(name="tc017")
    public static String[][] getDataTC017() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc017");
    }

    @DataProvider(name="tc018")
    public static String[][] getDataTC018() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc018");
    }

    @DataProvider(name="tc024")
    public static String[][] getDataTC024() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc024");
    }

    @DataProvider(name="tc027")
    public static String[][] getDataTC027() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc027");
    }

    @DataProvider(name="tc015")
    public static String[][] getDataTC015() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc015");
    }

    @DataProvider(name="tc025")
    public static String[][] getDataTC025() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc025");
    }

    @DataProvider(name = "tc032")
    public static String[][] getDataTC032() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc032");
    }
    @DataProvider(name = "tc033")
    public static String[][] getDataTC033() throws IOException {
        return ExcelDataProviders.getExcelDataForRequirement("tc033");
    }
    
}
