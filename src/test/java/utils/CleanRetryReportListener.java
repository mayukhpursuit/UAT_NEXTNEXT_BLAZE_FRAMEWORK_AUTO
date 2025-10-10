package utils;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.*;

public class CleanRetryReportListener implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        for (ISuite suite : suites) {
            for (ISuiteResult result : suite.getResults().values()) {
                ITestContext context = result.getTestContext();

                // Remove failed tests that passed later
                removeRetriedTests(context.getFailedTests().getAllResults(), context.getPassedTests().getAllResults());

                // Remove skipped tests that passed later
                removeRetriedTests(context.getSkippedTests().getAllResults(), context.getPassedTests().getAllResults());
            }
        }
    }

    private void removeRetriedTests(Set<ITestResult> source, Set<ITestResult> passed) {
        source.removeIf(r -> passed.stream().anyMatch(p ->
                p.getMethod().getQualifiedName().equals(r.getMethod().getQualifiedName())
                        && Arrays.equals(p.getParameters(), r.getParameters())
        ));
    }
}
