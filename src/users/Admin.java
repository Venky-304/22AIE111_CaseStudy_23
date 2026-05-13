package users;

import java.util.List;

import assets.Asset;
import assets.AssetTransaction;
import interfaces.Reportable;

public class Admin extends User implements Reportable {
    // ---- static counter ----
    private static int nextAdminId = 1;

    // ---- constructor ----
    public Admin(String name) {
        super(nextAdminId++, name);
    }

    // ---- admin operations ----
    public void monitorAssets(List<Asset> assets) {
        for (Asset asset : assets) {
            System.out.println("[MONITOR] Asset ID: " + asset.getAssetId()
                    + " | Name: " + asset.getAssetName()
                    + " | Status: " + asset.getStatus()
                    + " | Location: " + asset.getLocation());
        }
    }

    public void generateReports(List<AssetTransaction> transactions) {
        System.out.println("[REPORT] Transaction History:");
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }
        for (AssetTransaction tx : transactions) {
            System.out.println(tx.getTransactionHistory());
        }
    }

    public void manageUsers(List<User> users) {
        for (User user : users) {
            if (user instanceof Employee) {
                Employee employee = (Employee) user;
                System.out.println("[USER] ID: " + employee.getId() + " | Name: " + employee.getName()
                        + " | Role: Employee | Dept: " + employee.getDepartment());
            } else if (user instanceof Storekeeper) {
                System.out.println("[USER] ID: " + user.getId() + " | Name: " + user.getName()
                        + " | Role: Storekeeper");
            } else if (user instanceof Admin) {
                System.out.println("[USER] ID: " + user.getId() + " | Name: " + user.getName()
                        + " | Role: Admin");
            }
        }
    }

    @Override
    public void generateReport() {
        System.out.println("[ADMIN REPORT] Use generateReports(transactions) for full transaction history.");
    }

    @Override
    public void viewReport() {
        System.out.println("[ADMIN VIEW] System-level reporting is available via monitorAssets and manageUsers.");
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Admin");
    }

    @Override
    public String toString() {
        return super.toString() + " | Role: Admin";
    }
}
