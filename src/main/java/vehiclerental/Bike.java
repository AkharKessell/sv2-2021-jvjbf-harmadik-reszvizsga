package vehiclerental;
import java.time.LocalTime;

public class Bike implements Rentable {
    private static final int RCPM = 15;
    private String idNumber;
    private LocalTime rentingTime;

    public Bike(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }

    @Override
    public void rent(LocalTime time) {
        rentingTime = time;
    }

    @Override
    public void closeRent() {
        rentingTime = null;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) minutes * RCPM;
    }
}