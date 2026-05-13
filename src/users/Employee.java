package users;

import java.util.List;

import assets.Asset;
import assets.AssetTransaction;

public class Employee extends User {
    // ---- static counter ----
    private static int nextEmployeeId = 1;

    // ---- fields ----
    private String department;

    // ---- constructor ----
    public Employee(String name, String department) {
        super(nextEmployeeId++, name);
        this.department = department;
    }

    // ---- employee operations ----
    public void requestAsset(Asset asset, List<AssetTransaction> transactions) {
        System.out.println("[REQUEST] " + name + " (Employee) has requested: " + asset.getAssetName());
        asset.checkAvailability();
        if (!asset.checkAvailability()) {
            AssetTransaction tx = new AssetTransaction(asset.getAssetId(), this.id, "REQUEST_FAILED");
            tx.updateTransaction("FAILED_NOT_AVAILABLE");
            transactions.add(tx);
        }
    }

    public void returnAsset(Asset asset, List<AssetTransaction> transactions) {
        System.out.println("[RETURN] " + name + " has returned " + asset.getAssetName() + ".");
        AssetTransaction tx = new AssetTransaction(asset.getAssetId(), this.id, "RETURNED");
        transactions.add(tx);
    }

    public void viewMyAssets(List<AssetTransaction> transactions) {
        System.out.println("[MY ASSETS] Employee: " + name);
        boolean found = false;
        for (AssetTransaction tx : transactions) {
            if (tx.getEmployeeId() == this.id && "ASSIGNED".equalsIgnoreCase(tx.getType())) {
                System.out.println("Assigned Asset ID: " + tx.getAssetId());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No currently assigned assets found in transaction log.");
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Employee");
    }

    @Override
    public String toString() {
        return super.toString() + " | Role: Employee | Dept: " + department;
    }
}