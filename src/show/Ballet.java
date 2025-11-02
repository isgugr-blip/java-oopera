package show;

import participants.Director;
import participants.Person;

public class Ballet extends MusicalShow {
    private final Person choreographer;

    public Ballet(String title, int duration, Director director, Person musicAuthor,
                  String librettoText, Person choreographer) {
        super(title, duration, director, musicAuthor, librettoText);

        if (choreographer == null) {
            throw new IllegalArgumentException("Хореограф не может быть null");
        }

        this.choreographer = choreographer;
    }

    public Person getChoreographer() {
        return choreographer;
    }
}
