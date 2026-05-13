package main;

import java.util.ArrayList;
import java.util.List;

import assets.Asset;
import assets.AssetTransaction;
import reports.Report;
import users.Admin;
import users.Employee;
import users.Storekeeper;
import users.User;

public class Main {
    public static void main(String[] args) {
        // ---- system banners ----
       
        System.out.println("      ASSET TRACKING SYSTEM v1.0");
        
        System.out.println();

        // ---- collections ----
        List<Asset> assets = new ArrayList<>();
        List<User> users = new ArrayList<>();
        List<AssetTransaction> transactions = new ArrayList<>();

        // ---- 1) create assets ----
        Asset laptop = new Asset("Laptop-001", "Electronics", "IT Room");
        Asset projector = new Asset("Projector-002", "Electronics", "Conference Room");
        Asset scanner = new Asset("Scanner-003", "Electronics", "HR Room");

        assets.add(laptop);
        assets.add(projector);
        assets.add(scanner);

        laptop.addAsset();
        projector.addAsset();
        scanner.addAsset();
        System.out.println();

        // ---- 2) create users ----
        Employee john = new Employee("John", "IT");
        Employee priya = new Employee("Priya", "HR");
        Storekeeper ravi = new Storekeeper("Ravi");
        Admin kumar = new Admin("Kumar");

        users.add(john);
        users.add(priya);
        users.add(ravi);
        users.add(kumar);

        // ---- 3) employee requests asset ----
        System.out.println("--- Employee Request ---");
        john.requestAsset(laptop, transactions);
        System.out.println();

        // ---- 4) storekeeper assigns asset ----
        System.out.println("--- Storekeeper Action ---");
        ravi.assignAsset(laptop, john, transactions);
        System.out.println();

        // ---- 5) admin monitors assets ----
        System.out.println("--- Admin Monitoring ---");
        kumar.monitorAssets(assets);
        System.out.println();

        // ---- 6) employee returns asset ----
        System.out.println("--- Employee Returns Asset ---");
        john.returnAsset(laptop, transactions);
        System.out.println();

        // ---- 7) storekeeper receives returned asset ----
        System.out.println("--- Storekeeper Receives ---");
        ravi.receiveAsset(laptop, transactions);
        System.out.println();

        // ---- 8) admin generates report ----
        System.out.println("--- Admin Report ---");
        kumar.generateReports(transactions);
        System.out.println();

        // ---- 9) storekeeper puts asset under maintenance ----
        System.out.println("--- Maintenance ---");
        ravi.maintainAsset(projector);
        System.out.println();

        // ---- 10) admin manages users ----
        System.out.println("--- User Management ---");
        kumar.manageUsers(users);
        System.out.println();

        // ---- 11) generate and view report object ----
        System.out.println("--- Report Object ---");
        Report systemReport = new Report("Daily Transaction Summary");
        systemReport.generateReport();
        systemReport.viewReport();
        System.out.println();

        System.out.println("         SYSTEM DEMO COMPLETE");
    }
}