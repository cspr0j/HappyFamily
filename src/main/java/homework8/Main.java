package homework8;

import homework8.Human.Man;
import homework8.Human.Woman;
import homework8.Pets.Dog;
import homework8.Pets.Domestic_Cat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Throwable {
        Map<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.SUNDAY.name(), "watch a film");
        schedule.put(DayOfWeek.WEDNESDAY.name(), "meeting with friends");
        schedule.put(DayOfWeek.FRIDAY.name(), "Read a book");

        Dog dog = new Dog("Rock", 5, 50, new HashSet<>(Arrays.asList("sleep", "eat", "drink")));
        Domestic_Cat cat = new Domestic_Cat("Manny");
        cat.setAge(3);
        cat.setTrickLevel(70);
        cat.setHabits(new HashSet<>(Arrays.asList("eat", "sleep")));

        Man man = new Man("Johnathan", "Smith", 1990, 100, schedule);
        Woman woman = new Woman("Chrissy", "Smith", 1998, 80, schedule);
        Family family = new Family(man, woman);
        family.bornChild();
        family.setPet(new HashSet<>(Arrays.asList(dog, cat)));

        System.out.println(family);
    }
}
