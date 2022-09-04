package homework12.Human;

import homework12.Family;
import homework12.Pets.Pet;

import java.text.ParseException;
import java.util.Map;

public final class Woman extends Human {

    public Woman(String name, String surname, String birthDate, int iq) throws ParseException {
        super(name, surname, birthDate, iq);
    }

    public Woman(String name, String surname, String birthDate, int iq, Map<String, String> schedule) throws ParseException {
        super(name, surname, birthDate, iq, schedule);
    }

    public Woman(String name, String surname, Family family, String birthDate) throws ParseException {
        super(name, surname, family, birthDate);
    }

    public Woman(String name, String surname, Family family, String birthDate, int iq, Map<String, String> schedule) throws ParseException {
        super(name, surname, family, birthDate, iq, schedule);
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
