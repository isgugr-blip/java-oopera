package show;

import participants.Actor;
import participants.Director;

import java.util.Collection;
import java.util.HashMap;

public class Show {
    private final String title;
    private final int duration;
    private final Director director;
    private final HashMap<Integer, Actor> actors = new HashMap<>();

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

    public Collection<Actor> getActors() {
        return actors.values();
    }

    public void addActor(Actor actor) {
        if(actors.containsKey(actor.hashCode())) {
            System.out.println("Актер " + actor + " уже участвует в постановке " + title);
        } else {
            System.out.println("Актер " + actor + " добавлен в постановку " + title);
            actors.put(actor.hashCode(), actor);
        }
    }

    public void changeActor(Actor actor, String replacementSurname) {
        for (Integer actorHashCode : actors.keySet()) {
            Actor currentActor = actors.get(actorHashCode);
            if(currentActor.getSurname().equals(replacementSurname)) {
                actors.remove(actorHashCode);
                actors.put(actor.hashCode(), actor);
                System.out.println("Замена актера " + currentActor + " на актера " + actor + "в постановке " + title);
                return;
            }
        }
        System.out.println("Актер по фамилии " + replacementSurname + " не найден в постановке " + title);
    }

    public void printActors() {
        for (Actor actorValue : actors.values()) {
            System.out.println(actorValue);
        }
    }
}
