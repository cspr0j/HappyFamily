package homework9.Human;

import homework9.Family;
import homework9.Pets.Pet;

import java.util.Map;

public final class Woman extends Human {

    public Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public Woman(String name, String surname, int year, int iq, Map<String,String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Woman(String name, String surname, Family family, int year) {
        super(name, surname, family, year);
    }

    public Woman(String name, String surname, Family family, int year, int iq, Map<String,String> schedule) {
        super(name, surname, family, year, iq, schedule);
    }

    public Woman() {
    }

    @Override
    public void greetPet() {
        for (Pet pet : getFamily().getPet()) {
            String nickname = pet.getNickname();
            System.out.printf("Hello %s. I am your owner(%s).\n", nickname, getClass().getSimpleName());
        }
    }

    public void makeup() {
        System.out.println("I'm doing my makeup!");
    }
}
