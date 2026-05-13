package reports;

import java.time.LocalDate;

import interfaces.Reportable;

public class Report implements Reportable {
    // ---- static counter ----
    private static int nextReportId = 1;

    // ---- fields ----
    private int reportId;
    private String reportType;
    private String generatedDate;

    // ---- constructor ----
    public Report(String reportType) {
        this.reportId = nextReportId++;
        this.reportType = reportType;
        this.generatedDate = LocalDate.now().toString();
    }

    @Override
    public void generateReport() {
        System.out.println("[REPORT GENERATED] ID: " + reportId + " | Type: " + reportType + " | Date: " + generatedDate);
    }

    @Override
    public void viewReport() {
        System.out.println("[REPORT VIEW] " + toString());
    }

    @Override
    public String toString() {
        return "Report ID: " + reportId + " | Type: " + reportType + " | Generated Date: " + generatedDate;
    }
}