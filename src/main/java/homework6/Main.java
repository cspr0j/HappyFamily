package homework6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Throwable {
        String[][] schedule = new String[3][2];
        schedule[0][0] = DayOfWeek.SUNDAY.name();
        schedule[0][1] = "watch a film";
        schedule[1][0] = DayOfWeek.WEDNESDAY.name();
        schedule[1][1] = "meeting with friends";
        schedule[2][0] = DayOfWeek.FRIDAY.name();
        schedule[2][1] = "Read a book";

        Pet dog = new Pet(Species.DOG, "Rock", 5, 50, new String[]{"sleep", "eat", "drink"});
        Pet cat = new Pet(Species.CAT, "Manny");
        cat.setAge(3);
        cat.setTrickLevel(70);
        cat.setHabits(new String[]{"eat", "sleep"});

        System.out.println(dog);
        System.out.println(cat);

        for (int i = 0; i < 1_000_000; i++) {
            Human human1 = new Human("Jalal","Aliyev",2000,100,schedule);
        }
    }

}
