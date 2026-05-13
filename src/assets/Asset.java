package assets;

import interfaces.Trackable;

public class Asset implements Trackable {
    // ---- static counter ----
    private static int nextAssetId = 1;

    // ---- fields ----
    private int assetId;
    private String assetName;
    private String assetType;
    private String status;
    private String location;

    // ---- constructor ----
    public Asset(String assetName, String assetType, String location) {
        this.assetId = nextAssetId++;
        this.assetName = assetName;
        this.assetType = assetType;
        this.location = location;
        this.status = "Available";
    }

    // ---- core operations ----
    public void addAsset() {
        System.out.println("[ASSET REGISTERED] " + assetName + " added to inventory. Location: " + location);
    }

    public void updateAsset(String name, String type, String location) {
        this.assetName = name;
        this.assetType = type;
        this.location = location;
    }

    @Override
    public boolean checkAvailability() {
        boolean available = "Available".equalsIgnoreCase(status);
        System.out.println("[AVAILABILITY] " + assetName + " is " + status + ".");
        return available;
    }

    @Override
    public void updateStatus(String status) {
        this.status = status;
    }

    // ---- getters and setters ----
    public int getAssetId() {
        return assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getStatus() {
        return status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Asset ID: " + assetId + " | Name: " + assetName + " | Type: " + assetType
                + " | Status: " + status + " | Location: " + location;
    }
}
