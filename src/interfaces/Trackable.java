package interfaces;

public interface Trackable {
    boolean checkAvailability();
    void updateStatus(String status);
}
