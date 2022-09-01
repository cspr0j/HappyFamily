package homework11.Pets;

import homework11.Species;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public abstract class Pet {
    static final List<String> list = new ArrayList<>();

    // displays only 1 time
    static {
        System.out.println("Pet class is being loaded");

        // 'load' all species to list
        for (int i = 0; i < Species.values().length; i++) {
            list.add(Species.values()[i].toString());
        }
    }

    // displays each time
    {
        String name = getClass().getSimpleName().toUpperCase();
        // 'auto' assigning
        if (list.contains(name)) {
            species = Species.valueOf(name);
        } else
            species = Species.UNKNOWN;
        System.out.println("New Pet type  object is created");
    }


    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    //getters and setters
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }


    //methods
    public void eat() {
        System.out.println("I am eating");
    }

    public abstract void respond();

    @Override
    public String toString() {
        return species + "{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", can fly:" + species.canFly +
                ", number of legs:" + species.numberOfLegs +
                ", has fur:" + species.hasFur +
                ", habits=" + habits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet object is deleted by Garbage Collector");
    }
}
