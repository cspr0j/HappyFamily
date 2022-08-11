package homework4;

import java.util.Random;

public class Human {
    String name;
    String surname;
    int year;
    int iq;
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public Human() {
    }

    @Override
    public String toString() {
        if (this.mother == null && this.father == null && this.pet == null) {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    ", iq=" + iq +
                    '}';
        } else if (this.mother == null && this.father == null) {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    ", iq=" + iq +
                    ", pet=" + pet +
                    '}';
        } else {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    ", iq=" + iq +
                    ", mother=" + mother.name + " " + mother.surname +
                    ", father=" + father.name + " " + father.surname +
                    ",pet=" + pet +
                    '}';
        }
    }

    public void greetPet() {
        System.out.println("Hello," + pet.nickname);
    }

    public void describePet() {
        System.out.print("I have a " + pet.species + ", he is " + pet.age + " years old, he is ");
        if (pet.trickLevel > 50) System.out.print("very sly\n");
        else System.out.print("almost not sly\n");
    }

    public boolean feedPet(boolean isFeedTime) {
        Random rnd = new Random();
        int randNum = rnd.nextInt(100);

        if (isFeedTime || pet.trickLevel > randNum) {
            System.out.printf("Hm... I will feed %s's\n", pet.nickname);
            return true;
        } else {
            System.out.printf("I think %s is not hungry\n", pet.nickname);
            return false;
        }
    }
}