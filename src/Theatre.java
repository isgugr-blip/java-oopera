import participants.Actor;
import participants.Director;
import participants.Person;
import show.Ballet;
import show.MusicalShow;
import show.Opera;
import types.Gender;

import java.util.List;

public class Theatre {
    public static void main(String[] args) {
        Actor firstActor = new Actor("Иван", "Петров", Gender.MALE, 176);
        Actor secondActor = new Actor("Анна", "Каренина", Gender.FEMALE, 166);
        Actor thirdActor = new Actor("Гурбангулы", "Бердымухамедов", Gender.MALE, 187);

        Person musician = new Person("Ханс", "Циммер", Gender.MALE);
        Person choreographer = new Person("Эдвард", "Паттисон", Gender.MALE);

        Director firstDirector = new Director("Федор", "Небондарчук", Gender.MALE, 5);
        Director secondDirector = new Director("Алина", "Олива", Gender.FEMALE, 0);

        MusicalShow musicalShow = new MusicalShow("Трое в лодке, не считая четвертого", 240,
                firstDirector,
                musician,
                "Ду ю билив ин лав афтер лав..."
        );
        Opera opera = new Opera("Над пропастью не ржи", 20,
                secondDirector,
                musician,
                "Ду! Ду хаст! Ду хаст миш!!!",
                15
        );
        Ballet ballet = new Ballet("Гусиное озеро", 150,
                firstDirector,
                musician,
                "Кря-кря, кря!",
                choreographer
        );

        musicalShow.addActor(firstActor);
        musicalShow.addActor(thirdActor);

        opera.addActor(secondActor);
        opera.addActor(firstActor);
        opera.addActor(thirdActor);
        opera.addActor(secondActor);

        ballet.addActor(secondActor);
        ballet.addActor(thirdActor);

        musicalShow.printActors();
        opera.printActors();
        ballet.printActors();

        List<Actor> operaActors = opera.getActors();
        Actor actorFromOpera = (Actor) operaActors.toArray()[0];
        ballet.changeActor(actorFromOpera, "Каренина");
        ballet.printActors();

        musicalShow.changeActor(secondActor, "Васильев");

        opera.printLibrettoText();
        ballet.printLibrettoText();
    }
}
