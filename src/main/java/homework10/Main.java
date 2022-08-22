package homework10;

import homework10.Human.Man;
import homework10.Human.Woman;
import homework10.Pets.Dog;
import homework10.Pets.Domestic_Cat;
import homework10.dao.FamilyController;

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

        Man man = new Man("Johnathan", "Smith", "12/02/1980", 100, schedule);
        Woman woman = new Woman("Chrissy", "Smith", "12/02/1980", 80, schedule);
        Family family = new Family(man, woman);
        //family.bornChild();
        //family.setPet(new HashSet<>(Arrays.asList(dog, cat)));

        FamilyController controller = new FamilyController();

        Man father1 = new Man("Victor", "Backer", "12/02/1980", 121);
        Woman mother1 = new Woman("Samantha", "Backer", "12/02/1980", 110);
        Man child = new Man("Vas", "Savas", "12/02/1980", 121);


        controller.addFamily(family);
        controller.createNewFamily(father1, mother1);
        controller.bornChild(family, "Simon", "Sara");
        controller.adoptChild(family, child);

        System.out.printf("Families count: %d\n",controller.count());

        controller.addPet(0, dog);
        controller.createNewFamily(father1, mother1);
        controller.displayAllFamilies();

        System.out.println(controller.getPets(0));
        controller.deleteAllChildrenOlderThen(18);
        controller.deleteFamilyByIndex(1);
        controller.displayAllFamilies();

        System.out.println(controller.getFamilyById(10));
        System.out.println(controller.countFamiliesWithMemberNumber(2));

        System.out.println("Families bigger than");
        controller.getFamiliesBiggerThan(1);
        System.out.println("Families less than");
        controller.getFamiliesLessThan(3);

        System.out.println("List of families");
        System.out.println(controller.getAllFamilies());

        controller.displayAllFamilies();
    }
}