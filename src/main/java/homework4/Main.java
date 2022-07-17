package homework4;

public class Main {
    public static void main(String[] args) {
        boolean isFeedTime;
        String[][] schedule = new String[3][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "watch a film";
        schedule[1][0] = "Wednesday";
        schedule[1][1] = "meeting with friends";
        schedule[2][0] = "Friday";
        schedule[2][1] = "watch a film";

        Pet dog = new Pet("dog", "Rock", 5, 50, new String[]{"sleep", "eat", "drink"});
        Pet cat = new Pet("cat", "Manny");
        cat.age = 3;
        cat.trickLevel = 70;
        cat.habits = new String[]{"eat", "sleep"};

        Pet hamster = new Pet();
        hamster.species = "hamster";
        hamster.nickname = "Bob";
        hamster.age = 1;
        hamster.trickLevel = 20;
        hamster.habits = new String[]{"eat", "sleep", "run"};

        Human male = new Human("Stanley", "Kubrick", 1928);
        male.iq = 80;
        Human female = new Human("Christiane", "Kubrick", 1932);
        female.iq = 60;
        Human child = new Human("Vivian", "Kubrick", 1960, female, male);
        child.iq = 70;
        child.pet = hamster;

        // Display first family
        // toString() is called implicitly
        System.out.printf("%s's Family: \n%s \n%s \n%s\n", male.surname, male, female, child);
        //calling all available methods for the child and pet
        callingMethodsFromClass(child, cat,false);

        //Second Family
        Human male2 = new Human("Vito", "Corleone", 1887);
        male2.iq = 90;
        male2.pet = cat;
        Human female2 = new Human("Carmela", "Corleone", 1897);
        female2.iq = 60;

        Human child2 = new Human("Santino", "Corleone", 1916, female2, male2);
        child2.iq = 78;
        child2.pet = cat;
        Human child3 = new Human("Michael", "Corleone", 1920, 87, dog, female2, male2, schedule);

        Human child4 = new Human();
        child4.name = "Frederico";
        child4.surname = "Corleone";
        child4.year = 1919;
        child4.iq = 60;
        child4.father = male2;
        child4.mother = female2;
        child4.pet = hamster;

        // Display second family
        // toString() is called implicitly
        System.out.printf("%s's Family: \n%s \n%s\n", male2.surname, male2, female2);

        //calling all available methods for the child and pet
        System.out.println(child2);
        callingMethodsFromClass(child2, cat,true);

        System.out.println(child3);
        callingMethodsFromClass(child3, dog,false);

        System.out.println(child4);
        callingMethodsFromClass(child4, hamster,false);
    }

    public static void callingMethodsFromClass(Human child, Pet pet, boolean isFeedTime) {
        child.describePet();
        child.greetPet();
        child.feedPet(isFeedTime);
        System.out.printf("%s\n", pet);
        pet.respond();
        pet.eat();
        pet.foul();
    }
}