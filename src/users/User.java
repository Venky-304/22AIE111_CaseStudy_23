package users;

public abstract class User {
    // ---- fields ----
    protected int id;
    protected String name;

    // ---- constructor ----
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // ---- abstract behavior ----
    public abstract void displayRole();

    // ---- getters ----
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name;
    }
}