package homework5;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {
    // displays only 1 time
    static {
        System.out.println("Human class is being loaded");
    }

    // displays each time
    {
        System.out.println("New Human type  object is created");
    }

    private String name;
    private String surname;
    private Family family;
    private int year;
    private int iq;
    private String[][] schedule;


    // ctor for parents
    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    // ctor for children
    public Human(String name, String surname, Family family, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.family = family;
        family.addChild(this);
    }

    // ctor for children
    public Human(String name, String surname, Family family, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.family = family;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        family.addChild(this);
    }

    public Human() {
    }


    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Family getFamily() {
        return family;
    }


    public void setFamily(Family family) {
        this.family = family;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }


    //methods
    public void greetPet() {
        for (int i = 0; i < family.getPet().length; i++) {
            String nickname = family.getPet(i).getNickname();
            System.out.println("Hello," + nickname);
        }
    }

    public void describePet() {
        for (int i = 0; i < family.getPet().length; i++) {
            String species = family.getPet(i).getSpecies();
            int age = family.getPet(i).getAge();
            int trickLevel = family.getPet(i).getTrickLevel();
            System.out.print("I have a " + species + ", he is " + age + " years old, he is ");
            if (trickLevel > 50) System.out.print("very sly\n");
            else System.out.print("almost not sly\n");
        }
    }

    public boolean feedPet(boolean isFeedTime) {
        Random rnd = new Random();
        boolean result = false;
        for (int i = 0; i < family.getPet().length; i++) {
            int randNum = rnd.nextInt(100);
            int trickLevel = family.getPet(i).getTrickLevel();
            String nickname = family.getPet(i).getNickname();

            if (isFeedTime || trickLevel > randNum) {
                System.out.printf("Hm... I will feed %s's\n", nickname);
                result = true;
            } else {
                System.out.printf("I think %s is not hungry\n", nickname);
                result = false;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Human{" + "name='").append(name).append('\'')
                .append(", surname='").append(surname).append('\'')
                .append(", year=").append(year)
                .append(", iq=").append(iq);
        if (family.isFlag()) {
            str.append(", mother=").append(family.getMother().name)
                    .append(", father=").append(family.getFather().name)
                    .append(", pet=").append(Arrays.toString(family.getPet()));
        }
        if (schedule != null) {
            str.append(", schedule=").append(Arrays.deepToString(schedule))
                    .append('}');
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                name.equals(human.name) &&
                surname.equals(human.surname) &&
                (
                        family == null || human.family != null &&
                        family.getMother().name.equals(human.family.getMother().name) &&
                        family.getMother().surname.equals(human.family.getMother().surname) &&
                        family.getFather().name.equals(human.family.getFather().name) &&
                        family.getFather().surname.equals(human.family.getFather().surname) &&
                        Arrays.equals(family.getChildren(), human.getFamily().getChildren())
                );
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, family, year, iq);
        result = 31 * result + Arrays.hashCode(schedule);
        return result;
    }

}