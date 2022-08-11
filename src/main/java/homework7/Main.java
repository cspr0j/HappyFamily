package homework7;

import homework7.Human.Human;
import homework7.Human.Man;
import homework7.Human.Woman;
import homework7.Pets.Dog;
import homework7.Pets.Domestic_Cat;
import homework7.Pets.Pet;

public class Main {
    public static void main(String[] args) throws Throwable {
        String[][] schedule = new String[3][2];
        schedule[0][0] = DayOfWeek.SUNDAY.name();
        schedule[0][1] = "watch a film";
        schedule[1][0] = DayOfWeek.WEDNESDAY.name();
        schedule[1][1] = "meeting with friends";
        schedule[2][0] = DayOfWeek.FRIDAY.name();
        schedule[2][1] = "Read a book";

        Pet dog = new Dog("Rock", 5, 50, new String[]{"sleep", "eat", "drink"});
        Pet cat = new Domestic_Cat("Manny");
        cat.setAge(3);
        cat.setTrickLevel(70);
        cat.setHabits(new String[]{"eat", "sleep"});

        Human man = new Man("Johnathan","Smith",1990,100,schedule);
        Human woman = new Woman("Chrissy","Smith",1998,80,schedule);
        Family family = new Family(man,woman);
        family.bornChild();
        family.setPet(dog,cat);

        System.out.println(family);
    }

}
