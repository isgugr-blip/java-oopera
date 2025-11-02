package show;

import participants.Director;
import participants.Person;

public class MusicalShow extends Show {
    private final Person musicAuthor;
    private final String librettoText;

    public MusicalShow(String title, int duration, Director director, Person musicAuthor, String librettoText) {
        super(title, duration, director);

        if (musicAuthor == null) {
            throw new IllegalArgumentException("Автор музыки не может быть null");
        }
        if (librettoText == null || librettoText.trim().isEmpty()) {
            throw new IllegalArgumentException("Текст либретто не может быть пустым");
        }

        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText.trim();
    }

    public Person getMusicAuthor() {
        return musicAuthor;
    }

    public String getLibrettoText() {
        return librettoText;
    }

    public void printLibrettoText() {
        System.out.println(librettoText);
    }

    @Override
    public void printActors() {
        System.out.println("Актеры постановки: " + this.getTitle());
        super.printActors();
    }
}
