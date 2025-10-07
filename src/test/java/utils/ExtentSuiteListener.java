package utils;

import org.testng.IExecutionListener;
import java.awt.*;
import java.io.File;

public class ExtentSuiteListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        // Nothing needed here
    }

    @Override
    public void onExecutionFinish() {
        if (ExtentReportManager.extent != null) {
            ExtentReportManager.extent.flush();

            try {
                String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + ExtentReportManager.repName;
                File extentReport = new File(pathOfExtentReport);
                Desktop.getDesktop().browse(extentReport.toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

