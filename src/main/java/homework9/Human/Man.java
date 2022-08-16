package homework9.Human;

import homework9.Family;
import homework9.Pets.Pet;

import java.util.Map;

public final class Man extends Human {

    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public Man(String name, String surname, int year, int iq, Map<String,String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Man(String name, String surname, Family family, int year) {
        super(name, surname, family, year);
    }

    public Man(String name, String surname, Family family, int year, int iq, Map<String,String> schedule) {
        super(name, surname, family, year, iq, schedule);
    }

    public Man() {
    }

    @Override
    public void greetPet() {
        for (Pet pet : getFamily().getPet()) {
            String nickname = pet.getNickname();
            System.out.printf("Hello %s. I am your owner(%s).\n", nickname, getClass().getSimpleName());
        }
    }

    public void repairCar() {
        System.out.println("I'm going to repair my car!");
    }
}
