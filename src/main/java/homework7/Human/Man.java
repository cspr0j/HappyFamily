package homework7.Human;

import homework7.Family;

public final class Man extends Human {
    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Man(String name, String surname, Family family, int year) {
        super(name, surname, family, year);
    }

    public Man(String name, String surname, Family family, int year, int iq, String[][] schedule) {
        super(name, surname, family, year, iq, schedule);
    }

    public Man() {
    }

    @Override
    public void greetPet() {
        for (int i = 0; i < getFamily().getPet().length; i++) {
            String nickname = getFamily().getPet(i).getNickname();
            System.out.printf("Hello %s. I am your owner(%s).\n", nickname, getClass().getSimpleName());
        }
    }

    public void repairCar() {
        System.out.println("I'm going to repair my car!");
    }
}
