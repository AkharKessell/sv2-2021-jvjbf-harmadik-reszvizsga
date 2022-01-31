package movietheatres;
import java.time.LocalTime;
import java.util.Objects;

public class Movie {
    private String title;
    private LocalTime startTime;

    public Movie(String title, LocalTime startTime) {
        this.title = title;
        this.startTime = startTime;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    //Két filmet egyenlőnek tekintünk, ha azonos a címe.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
