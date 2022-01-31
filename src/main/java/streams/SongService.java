package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SongService {
    private final List<Song> songs = new ArrayList<>();

    //...dalokat lehet hozzáadni a listához
    public void addSong(Song song) {
        songs.add(song);
    }

    //Add vissza a legrövidebb dalt, Optional-ként!
    public Optional<Song> shortestSong() {
        return songs.stream().min(Comparator.comparing(Song::getLength));
    }

    //Add vissza dalok listáját cím alapján! (Két dalnak lehet ugyanaz a címe)
    public List<Song> findSongByTitle(String title) {
        return songs.stream().filter(d -> d.getTitle().equals(title)).toList();
    }

    //Lehessen lekérdezni, hogy egy előadó szerepel-e egy konkrét dal előadóinak listájában!
    public boolean isPerformerInSong(Song title, String name) {
        return title.getPerformers().stream().anyMatch(d -> d.equals(name));
    }

    //Gyűjtsd ki az összes dal címét, ami egy paraméterül átadott dátum előtt jelent meg!
    public List<String> titlesBeforeDate(LocalDate date) {
        return songs.stream().filter(d -> d.getRelease().isBefore(date)).map(Song::getTitle).toList();
    }
}