package vehiclerental;
import java.time.LocalTime;

public class Car implements Rentable {

    private final int rcpm;
    private String licencePlate;
    private LocalTime rentingTime;

    public Car(String licencePlate, int price) {
        this.licencePlate = licencePlate;
        this.rcpm = price;
    }

    public int getRcpm() {
        return this.rcpm;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
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
    public int calculateSumPrice(long minutes) {
        return (int) minutes * rcpm;
    }
    @Override
    public void closeRent() {
        rentingTime = null;
    }
}