package vehiclerental;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RentService {

    private static final int maxRent = 180;
    private Map<Rentable, User> actualRenting = new TreeMap<>();
    private Set<User> users = new HashSet<>();
    private Set<Rentable> rentables = new HashSet<>();

    public Set<User> getUsers() {
        return this.users;
    }

    public Set<Rentable> getRentables() {
        return this.rentables;
    }

    public Map<Rentable, User> getActualRenting() {
        return this.actualRenting;
    }

    public void registerUser(User user) {
        compareUser(user);
        users.add(user);
    }

    public void addRentable(Rentable rentable) {
        rentables.add(rentable);
    }

    private void compareUser(User user) {
        if (users.stream().anyMatch(u -> u.getUserName().equals(user.getUserName()))) {
            throw new UserNameIsAlreadyTakenException("Username is taken!");
        }
    }

    private void validateRent(User user, Rentable rentable) {
        if (rentable.getRentingTime() != null) {
            throw new IllegalStateException("Already rented");
        }
        if (user.getBalance() < rentable.calculateSumPrice(maxRent)) {
            throw new IllegalStateException("Not enough money");
        }
        if (!users.contains(user)) {
            throw new IllegalStateException("User not found");
        }
        if (!rentables.contains(rentable)) {
            throw new IllegalStateException("Object Not found");
        }
    }

    public void rent(User user, Rentable rentable, LocalTime time) {
        validateRent(user, rentable);
        rentable.rent(time);
        actualRenting.put(rentable, user);
    }

    public void closeRent(Rentable rentable, int minutes) {
        if (!actualRenting.containsKey(rentable)) {
            throw new IllegalArgumentException("Order item not found");
        }
        actualRenting.get(rentable).minusBalance(rentable.calculateSumPrice(minutes));
        actualRenting.remove(rentable);
        rentable.closeRent();
    }
}