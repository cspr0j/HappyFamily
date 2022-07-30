package homework5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] schedule = new String[3][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "watch a film";
        schedule[1][0] = "Wednesday";
        schedule[1][1] = "meeting with friends";
        schedule[2][0] = "Friday";
        schedule[2][1] = "Read a book";

        Pet dog = new Pet("dog", "Rock", 5, 50, new String[]{"sleep", "eat", "drink"});
        Pet cat = new Pet("cat", "Manny");
        cat.setAge(3);
        cat.setTrickLevel(70);
        cat.setHabits(new String[]{"eat", "sleep"});

        Pet hamster = new Pet();
        hamster.setSpecies("hamster");
        hamster.setNickname("Bob");
        hamster.setAge(1);
        hamster.setTrickLevel(20);
        hamster.setHabits(new String[]{"eat", "sleep", "run"});

        // Create first family members
        Human male = new Human("Stanley", "Kubrick", 1928);
        male.setIq(80);
        Human female = new Human("Christiane", "Kubrick", 1932);
        female.setIq(60);

        // Create first family
        Family family1 = new Family(male, female);
        family1.setPet(dog, cat);
        // Create  child
        Human child = new Human("Vivian", "Kubrick", family1, 1960);
        child.setIq(70);
        child.setSchedule(schedule);
        child.setFamily(family1);

        // using some methods for specify family
        family1.setChildren(child);
        //display family
        System.out.println(family1);
        // call methods for describe pet and etc
        callingMethodsFromClas(child, false, family1.getPet());

        // Create second family members
        Human male2 = new Human("Vito", "Corleone", 1887);
        male2.setIq(90);
        Human female2 = new Human("Carmela", "Corleone", 1897);
        female2.setIq(60);
        // Create second family
        Family family2 = new Family(male2, female2, dog);
        family2.addPet(cat);
        family2.addPet(hamster);
        ;

        // Create  children
        Human child2 = new Human("Santino", "Corleone", family2, 1916);
        child2.setIq(78);
        Human child3 = new Human("Michael", "Corleone", family2, 1920, 87, schedule);
        Human child4 = new Human();
        child4.setName("Frederico");
        child4.setSurname("Corleone");
        child4.setYear(1929);
        child4.setIq(60);
        child4.setFamily(family2);

        // using some methods for specify family
        family2.setChildren(child2);
        family2.addChild(child3);
        family2.addChild(child4);
        //display family
        System.out.println(family2);
        // call methods for describe pet and etc
        callingMethodsFromClas(child2, true, family2.getPet());

        // Create third family members
        Human male3 = new Human("Harry", "Smith", 1887);
        male3.setIq(90);
        male3.setSchedule(schedule);
        Human female3 = new Human("Jane", "Smith", 1897);
        female3.setIq(60);
        female3.setSchedule(schedule);

        // Create third family
        Family family3 = new Family();
        family3.setFather(male3);
        family3.setMother(female3);
        family3.setPet(hamster);
        //display family
        System.out.println(family3);

        // call methods for describe pet and etc
        callingMethodsFromClas(male3, false, family3.getPet());


        // check for equals
        // NOTE: It will be true only when
        // the objects have the same first name, last name, year, family members
        // They may have different IQs and schedule
        Pet dogEq = new Pet("dog", "Rock", 5, 50, new String[]{"sleep", "eat", "drink"});
        Human maleEquals = new Human("Stanley", "Kubrick", 1928);
        maleEquals.setIq(80);
        Human femaleEquals = new Human("Christiane", "Kubrick", 1932);
        female.setIq(60);
        Family familyEq = new Family(maleEquals, femaleEquals);
        familyEq.setPet(dog, cat);
        Human childEq = new Human("Vivian", "Kubrick", familyEq, 1960);
        childEq.setIq(70);
        childEq.setSchedule(schedule);
        childEq.setFamily(family1);

        // uncomment for output
        //System.out.println(male.equals(maleEquals));//true
        //System.out.println(maleEquals.equals(male));//true
        //System.out.println(family1.equals(familyEq));//true
        //System.out.println(familyEq.equals(family1));//true
        //System.out.println(dog.equals(dogEq));//true
        //System.out.println(dogEq.equals(dog));//true

    }

    private static void callingMethodsFromClas(Human human, boolean isFeedTime, Pet... pet) {
        System.out.printf("Hello, I'm %s %s\n", human.getName(), human.getSurname());
        human.describePet();
        System.out.printf("%s\n", Arrays.toString(pet));
        human.greetPet();
        human.feedPet(isFeedTime);
        for (Pet pets : pet) {
            pets.respond();
            pets.eat();
            pets.foul();
        }
    }
}
