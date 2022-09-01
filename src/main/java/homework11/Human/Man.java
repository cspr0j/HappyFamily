package homework11.Human;

import homework11.Family;
import homework11.Pets.Pet;

import java.text.ParseException;
import java.util.Map;

public final class Man extends Human {

    public Man(String name, String surname, String birthDate, int iq) throws ParseException {
        super(name, surname, birthDate, iq);
    }

    public Man(String name, String surname, String birthDate, int iq, Map<String, String> schedule) throws ParseException {
        super(name, surname, birthDate, iq, schedule);
    }

    public Man(String name, String surname, Family family, String birthDate) throws ParseException {
        super(name, surname, family, birthDate);
    }

    public Man(String name, String surname, Family family, String birthDate, int iq, Map<String, String> schedule) throws ParseException {
        super(name, surname, family, birthDate, iq, schedule);
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
