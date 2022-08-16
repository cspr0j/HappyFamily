package homework9.Human;

import homework9.Family;
import homework9.Pets.Pet;
import homework9.Species;

import java.util.Arrays;
import java.util.Map;
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
    private Map<String,String> schedule;

    private boolean flag;


    // ctor for parents
    public Human(String name, String surname, int year, int iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }

    public Human(String name, String surname, int year, int iq, Map<String,String> schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    // ctor for children
    public Human(String name, String surname, Family family, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.family = family;
        //family.addChild(this);
    }

    // ctor for children
    public Human(String name, String surname, Family family, int year, int iq, Map<String,String> schedule) {
        this.name = name;
        this.surname = surname;
        this.family = family;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        //family.addChild(this);
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

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String,String> schedule) {
        this.schedule = schedule;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    //methods
    public void greetPet() {
        for (int i = 0; i < family.getPet().size(); i++) {
            String nickname = family.getPet().iterator().next().getNickname();
            System.out.println("Hello," + nickname);
        }
    }

    public void describePet() {
        for (Pet pet : family.getPet()) {
            Species species = pet.getSpecies();
            int age = pet.getAge();
            int trickLevel = pet.getTrickLevel();
            System.out.print("I have a " + species + ", he is " + age + " years old, he is ");
            if (trickLevel > 50) System.out.print("very sly\n");
            else System.out.print("almost not sly\n");
        }
    }

    public boolean feedPet(boolean isFeedTime) {
        Random rnd = new Random();
        boolean result = false;
        for (Pet pet : family.getPet()) {
            int randNum = rnd.nextInt(100);
            int trickLevel = pet.getTrickLevel();
            String nickname = pet.getNickname();

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
        if (family != null && family.isFlag()) {
            str.append(", mother=").append(family.getMother().name)
                    .append(", father=").append(family.getFather().name);
            if (family.getPet().size() != 0) {
             str.append(", pet=").append(family.getPet());
        }
        }
        if (schedule != null) {
            str.append(", schedule=").append(schedule)
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
                                Objects.equals(Arrays.toString(family.getChildren().toArray()),
                                                Arrays.toString(human.getFamily().getChildren().toArray()))
                );
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname,schedule,
                family != null ? family.toString() : null, year, iq);
        result = 31 * result;
        return result;
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human object is deleted by Garbage Collector");
    }
}