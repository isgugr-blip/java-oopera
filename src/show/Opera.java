package show;

import participants.Director;
import participants.Person;

public class Opera extends MusicalShow {
    private final int choirSize;

    public Opera(String title, int duration, Director director,
                 Person musicAuthor, String librettoText, int choirSize) {
        super(title, duration, director, musicAuthor, librettoText);

        if (choirSize < 0) {
            throw new IllegalArgumentException("Количество участников хора не может быть отрицательным");
        }

        this.choirSize = choirSize;
    }

    public int getChoirSize() {
        return choirSize;
    }
}
