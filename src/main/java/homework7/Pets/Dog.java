package homework7.Pets;

public class Dog extends Pet implements NastyThings{

    public Dog(String nickname) {
        super(nickname);
    }

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Dog() {
    }

    @Override
    public void respond() {
        {
            System.out.printf("Hello, owner. I am - %s (%s). I miss you!", getNickname(), getSpecies());
        }
    }


    @Override
    public void foul() {
        System.out.printf("I am - %s. I need to cover it up", getSpecies());
    }
}
