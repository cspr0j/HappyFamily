package homewrok11.Human;

import homewrok11.Family;
import homewrok11.Pets.Pet;
import homewrok11.Species;
import homewrok11.date.Converter;

import java.text.ParseException;
import java.util.*;

public class Human {

    Converter converter = new Converter();

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
    private long birthDate;
    private int iq;
    private Map<String, String> schedule;

    private boolean flag;


    // ctors
    public Human(String name, String surname, String birthDate, int iq) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birthDate = converter.converterToTimestamp(birthDate);
        this.iq = iq;
    }

    public Human(String name, String surname, String birthDate,
                 int iq, Map<String, String> schedule) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birthDate = converter.converterToTimestamp(birthDate);
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human(String name, String surname, Family family, String birthDate) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birthDate = converter.converterToTimestamp(birthDate);
        this.family = family;
    }

    public Human(String name, String surname, Family family, String birthDate,
                 int iq, Map<String, String> schedule) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.family = family;
        this.birthDate = converter.converterToTimestamp(birthDate);
        this.iq = iq;
        this.schedule = schedule;
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

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getBirthDate() {
        return converter.converterToString(birthDate);
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = converter.converterToTimestamp(birthDate);
    }

    public int age() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.birthDate);

        return calendar.get(Calendar.YEAR);
    }

    //methods
    public String describeAge() {
        Calendar calendar = Calendar.getInstance();
        long result = calendar.getTimeInMillis() - this.birthDate;
        
        calendar.setTimeInMillis(result);

        int year = calendar.get(Calendar.YEAR) - 1970;
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH) - 1;

        return year + " year " + month + " month " + day + " day";
    }

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
                .append(", birth date=").append(converter.converterToString(birthDate))
                .append(", iq=").append(iq);

        if (family != null && family.isFlag()) {
            str.append(", mother=").append(family.getMother().name)
                    .append(", father=").append(family.getFather().name);
            if (family.getPet().size() != 0) {
                str.append(", pet=").append(family.getPet());
            }
        }

        if (schedule != null) {
            str.append(", schedule=").append(schedule);
        }
        str.append('}');

        return str.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate &&
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
        int result = Objects.hash(name, surname, schedule,
                family != null ? family.toString() : null, birthDate, iq);
        result = 31 * result;
        return result;
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human object is deleted by Garbage Collector");
    }
}
