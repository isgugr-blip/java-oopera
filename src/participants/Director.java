package participants;

import types.Gender;

public class Director extends Person {
    private int numberOfShows;

    public Director(String name, String surname, Gender gender, int numberOfShows) {
        super(name, surname, gender);
        if (numberOfShows < 0) {
            throw new IllegalArgumentException("Количество показов не может быть отрицательным");
        }
        this.numberOfShows = numberOfShows;
    }

    public int getNumberOfShows() {
        return numberOfShows;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getSurname();
    }
}
