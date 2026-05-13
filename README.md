Asset Tracking System
A console-based Java application for managing organisational assets. Supports asset registration, allocation to employees, returns, maintenance scheduling, and transaction reporting through role-based user interactions.
Features
Asset management — register, update, and track assets with availability status
Role-based users — Admin, Storekeeper, and Employee with distinct responsibilities
Transaction logging — every assignment, return, and failure is recorded with a timestamp
Reporting — admins can generate full transaction history and monitor asset inventory
Maintenance tracking — storekeepers can flag assets as under maintenance
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
Getting Started
Prerequisites
Java 11 or higher
Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or the JDK CLI
Compile and Run (CLI)
# From the project root, compile all sources
javac -d out $(find src -name "*.java")

# Run the main class
java -cp out main.Main
Run in an IDE
Clone the repository and open it as a Java project.
Set src as the source root.
Run main.Main.
Sample Output
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
[MONITOR] Asset ID: 1 | Name: Laptop-001 | Status: Assigned | Location: IT Room
...
Class Responsibilities


Class
Role
Asset
Holds asset data; tracks status and location
AssetTransaction
Immutable log entry for each asset event
Report
Standalone report object with generation date
User
Abstract base — shared id and name fields
Employee
Requests and returns assets; views own assignments
Storekeeper
Assigns assets to employees; handles returns and maintenance
Admin
System-wide visibility; user and transaction management
Design Patterns & OOP Concepts
Inheritance — Employee, Storekeeper, and Admin all extend the abstract User class
Interfaces — Trackable (assets) and Reportable (reports and admin) define contracts independently of implementation
Polymorphism — Admin.manageUsers() iterates a List<User> and dispatches based on runtime type
Encapsulation — all fields are private/protected with accessor methods
Static counters — auto-incrementing IDs for Asset, AssetTransaction, Report, and each user subtype
Extending the Project
Persistence — swap in-memory ArrayLists for a database (JDBC/JPA)
CLI menu — wrap Main logic in a Scanner-driven interactive loop
REST API — expose operations via Spring Boot controllers
Authentication — add login and session management to User
Notifications — trigger email/SMS alerts on assignment or maintenance events
