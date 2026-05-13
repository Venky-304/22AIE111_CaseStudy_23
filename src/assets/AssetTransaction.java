package assets;

import java.time.LocalDate;

public class AssetTransaction {
    // ---- static counter ----
    private static int nextTransactionId = 1001;

    // ---- fields ----
    private int transactionId;
    private int assetId;
    private int employeeId;
    private String date;
    private String type;
    private String status;

    // ---- constructor ----
    public AssetTransaction(int assetId, int employeeId, String type) {
        this.transactionId = nextTransactionId++;
        this.assetId = assetId;
        this.employeeId = employeeId;
        this.type = type;
        this.date = LocalDate.now().toString();
        this.status = "COMPLETED";
    }

    // ---- operations ----
    public void recordTransaction() {
        System.out.println("[TRANSACTION RECORDED] TXN-" + transactionId
                + " | Asset ID: " + assetId
                + " | Employee ID: " + employeeId
                + " | Type: " + type);
    }

    public void updateTransaction(String status) {
        this.status = status;
    }

    public String getTransactionHistory() {
        return "TXN-" + transactionId
                + " | Asset ID: " + assetId
                + " | Employee ID: " + employeeId
                + " | " + type
                + " | " + date
                + " | Status: " + status;
    }

    // ---- getters ----
    public int getTransactionId() {
        return transactionId;
    }

    public int getAssetId() {
        return assetId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return getTransactionHistory();
    }
}
