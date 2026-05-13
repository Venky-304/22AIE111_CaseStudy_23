package users;

import java.util.List;

import assets.Asset;
import assets.AssetTransaction;

public class Storekeeper extends User {
    // ---- static counter ----
    private static int nextStorekeeperId = 1;

    // ---- constructor ----
    public Storekeeper(String name) {
        super(nextStorekeeperId++, name);
    }

    // ---- storekeeper operations ----
    public void assignAsset(Asset asset, Employee employee, List<AssetTransaction> transactions) {
        if (asset.checkAvailability()) {
            asset.updateStatus("Assigned");
            System.out.println("[ASSIGNED] " + asset.getAssetName() + " assigned to " + employee.getName()
                    + " by Storekeeper: " + name);
            AssetTransaction tx = new AssetTransaction(asset.getAssetId(), employee.getId(), "ASSIGNED");
            transactions.add(tx);
            tx.recordTransaction();
        } else {
            System.out.println("[ASSIGNMENT FAILED] " + asset.getAssetName() + " is not available.");
        }
    }

    public void receiveAsset(Asset asset, List<AssetTransaction> transactions) {
        asset.updateStatus("Available");
        System.out.println("[RECEIVED] " + name + " received " + asset.getAssetName()
                + ". Status updated to Available.");

        int employeeId = 0;
        for (int i = transactions.size() - 1; i >= 0; i--) {
            AssetTransaction tx = transactions.get(i);
            if (tx.getAssetId() == asset.getAssetId() && "RETURNED".equalsIgnoreCase(tx.getType())) {
                employeeId = tx.getEmployeeId();
                break;
            }
        }

        AssetTransaction receiptTx = new AssetTransaction(asset.getAssetId(), employeeId, "RETURNED");
        transactions.add(receiptTx);
        receiptTx.recordTransaction();
    }

    public void maintainAsset(Asset asset) {
        asset.updateStatus("Under Maintenance");
        System.out.println("[MAINTENANCE] " + asset.getAssetName() + " marked as Under Maintenance.");
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Storekeeper");
    }

    @Override
    public String toString() {
        return super.toString() + " | Role: Storekeeper";
    }
}
