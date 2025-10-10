package utils;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Set;

public class CleanRetryReportListener implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        for (ISuite suite : suites) {
            for (ISuiteResult result : suite.getResults().values()) {
                ITestContext context = result.getTestContext();

                // remove skipped tests that were retried and passed later
                removeRetriedTests(context.getFailedTests().getAllResults(), context.getPassedTests().getAllResults());
                removeRetriedTests(context.getSkippedTests().getAllResults(), context.getPassedTests().getAllResults());
            }
        }
    }

    private void removeRetriedTests(Set<ITestResult> source, Set<ITestResult> passed) {
        source.removeIf(r -> passed.stream()
                .anyMatch(p -> p.getMethod().getMethodName().equals(r.getMethod().getMethodName())));
    }
}

