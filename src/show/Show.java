package show;

import participants.Actor;
import participants.Director;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private final String title;
    private final int duration;
    private final Director director;
    private final ArrayList<Actor> actors = new ArrayList<>();

    public Show(String title, int duration, Director director) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название постановки не может быть пустым");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Продолжительность должна быть положительной");
        }
        if (director == null) {
            throw new IllegalArgumentException("Режиссер не может быть null");
        }

        this.title = title.trim();
        this.duration = duration;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Director getDirector() {
        return director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        for (Actor currentActor : actors) {
            if (currentActor.getSurname().equals(actor.getSurname())
                            && currentActor.getName().equals(actor.getName())
                            && currentActor.getHeight() == actor.getHeight()) {
                System.out.println("Актер " + actor + " уже участвует в постановке " + title);

                return;
            }
        }
        System.out.println("Актер " + actor + " добавлен в постановку " + title);
        actors.add(actor);
    }

    public void changeActor(Actor actor, String replacementSurname) {
        for (int i = 0; i < actors.size(); i++) {
            Actor currentActor = actors.get(i);
            if (currentActor.getSurname().equals(replacementSurname)) {
                actors.remove(i);
                actors.add(actor);
                System.out.println("Замена актера " + currentActor + " на актера " + actor + "в постановке " + title);
                return;
            }
        }
        System.out.println("Актер по фамилии " + replacementSurname + " не найден в постановке " + title);
    }

    public void printActors() {
        for (Actor actorValue : actors) {
            System.out.println(actorValue);
        }
    }
}
