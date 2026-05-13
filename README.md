Asset Tracking System
A console-based Java application for managing organisational assets. Supports asset registration, allocation to employees, returns, maintenance scheduling, and transaction reporting through role-based user interactions.
Team Members


Roll No
Name
Role
AM.SC.U4AIE25107
C V Rohith Reddy
Asset & Transaction Module
AM.SC.U4AIE25130
M Pramod
User Management & Role Design
AM.SC.U4AIE25132
M Srirag Sarma
Interfaces, Reports & OOP Design
AM.SC.U4AIE25135
N Charan
Main Driver, Integration & Testing
Problem Description
Organisations often struggle to track the physical assets they own — laptops, projectors, scanners, and other equipment — especially when those assets are distributed across departments and employees. Manual tracking using spreadsheets is error-prone and lacks accountability.
This system addresses that problem by providing a structured, role-based asset tracking solution where:
Employees can request and return assets
Storekeepers can assign, receive, and maintain assets
Admins can monitor inventory, manage users, and generate transaction reports
Every action is recorded as a transaction, creating a full audit trail of asset movements within the organisation.
Project Structure
src/
├── assets/
│   ├── Asset.java               # Core asset entity; implements Trackable
│   └── AssetTransaction.java    # Transaction record for asset lifecycle events
├── interfaces/
│   ├── Reportable.java          # Interface: generateReport(), viewReport()
│   └── Trackable.java           # Interface: checkAvailability(), updateStatus()
├── reports/
│   └── Report.java              # Report entity; implements Reportable
├── users/
│   ├── User.java                # Abstract base class for all users
│   ├── Admin.java               # Monitors assets, generates reports, manages users
│   ├── Employee.java            # Requests and returns assets
│   └── Storekeeper.java         # Assigns, receives, and maintains assets
└── main/
    └── Main.java                # Entry point — demo of the full workflow
How to Run the Code
Prerequisites
Java 11 or higher
Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or the JDK CLI
Option 1 — Command Line
# Step 1: Clone the repository
git clone https://github.com/your-username/asset-tracking-system.git
cd asset-tracking-system

# Step 2: Compile all source files
javac -d out $(find src -name "*.java")

# Step 3: Run the main class
java -cp out main.Main
Windows users: replace the find command with:
javac -d out src\assets\*.java src\interfaces\*.java src\reports\*.java src\users\*.java src\main\*.java
Option 2 — IDE
Open the project folder in your IDE.
Set src as the source root.
Run main.Main.
Sample Input / Output
This project runs as a scripted demo (no user input required). The Main.java file walks through the full lifecycle automatically.
Input (hardcoded in Main.java):
Assets  : Laptop-001 (IT Room), Projector-002 (Conference Room), Scanner-003 (HR Room)
Users   : John (Employee, IT), Priya (Employee, HR), Ravi (Storekeeper), Kumar (Admin)
Actions : John requests Laptop → Ravi assigns it → John returns it → Ravi receives it
          Kumar monitors all assets and generates a transaction report
          Ravi puts Projector under maintenance
Output:
      ASSET TRACKING SYSTEM v1.0

[ASSET REGISTERED] Laptop-001 added to inventory. Location: IT Room
[ASSET REGISTERED] Projector-002 added to inventory. Location: Conference Room
[ASSET REGISTERED] Scanner-003 added to inventory. Location: HR Room

--- Employee Request ---
[REQUEST] John (Employee) has requested: Laptop-001
[AVAILABILITY] Laptop-001 is Available.

--- Storekeeper Action ---
[AVAILABILITY] Laptop-001 is Available.
[ASSIGNED] Laptop-001 assigned to John by Storekeeper: Ravi
[TRANSACTION RECORDED] TXN-1001 | Asset ID: 1 | Employee ID: 1 | Type: ASSIGNED

--- Admin Monitoring ---
[MONITOR] Asset ID: 1 | Name: Laptop-001    | Status: Assigned          | Location: IT Room
[MONITOR] Asset ID: 2 | Name: Projector-002 | Status: Available         | Location: Conference Room
[MONITOR] Asset ID: 3 | Name: Scanner-003   | Status: Available         | Location: HR Room

--- Employee Returns Asset ---
[RETURN] John has returned Laptop-001.

--- Storekeeper Receives ---
[RECEIVED] Ravi received Laptop-001. Status updated to Available.
[TRANSACTION RECORDED] TXN-1003 | Asset ID: 1 | Employee ID: 1 | Type: RETURNED

--- Admin Report ---
[REPORT] Transaction History:
TXN-1001 | Asset ID: 1 | Employee ID: 1 | ASSIGNED | 2025-05-13 | Status: COMPLETED
TXN-1002 | Asset ID: 1 | Employee ID: 1 | RETURNED | 2025-05-13 | Status: COMPLETED
TXN-1003 | Asset ID: 1 | Employee ID: 1 | RETURNED | 2025-05-13 | Status: COMPLETED

--- Maintenance ---
[MAINTENANCE] Projector-002 marked as Under Maintenance.

--- User Management ---
[USER] ID: 1 | Name: John  | Role: Employee    | Dept: IT
[USER] ID: 2 | Name: Priya | Role: Employee    | Dept: HR
[USER] ID: 1 | Name: Ravi  | Role: Storekeeper
[USER] ID: 1 | Name: Kumar | Role: Admin

--- Report Object ---
[REPORT GENERATED] ID: 1 | Type: Daily Transaction Summary | Date: 2025-05-13
[REPORT VIEW] Report ID: 1 | Type: Daily Transaction Summary | Generated Date: 2025-05-13

         SYSTEM DEMO COMPLETE
Tools & Technologies Used
Code Editer: Visual Studio code;
Programming languages used: java;
Version control tool: GitHub, Git;
Support taken from: claude.ai
