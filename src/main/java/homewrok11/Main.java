package homewrok11;

import homewrok11.Human.Man;
import homewrok11.Human.Woman;
import homewrok11.Pets.Dog;
import homewrok11.Pets.Domestic_Cat;
import homewrok11.dao.FamilyController;

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

        Man man = new Man("Johnathan", "Smith", "12/02/1990", 100, schedule);
        Woman woman = new Woman("Chrissy", "Smith", "28/12/1998", 80, schedule);
        Family family = new Family(man, woman);
        family.bornChild();
        //family.setPet(new HashSet<>(Arrays.asList(dog, cat)));

        FamilyController controller = new FamilyController();

        Man father1 = new Man("Victor", "Backer", "23/11/1915", 121);
        Woman mother1 = new Woman("Samantha", "Backer", "02/06/1919", 110);
        Man child = new Man("Vas", "Savas", "17/05/1943", 121);


        controller.addFamily(family);
        controller.createNewFamily(father1, mother1);
        controller.bornChild(family, "Simon", "Sara");
        controller.adoptChild(family, child);

        System.out.println(child.describeAge());

        controller.displayAllFamilies();
    }
}