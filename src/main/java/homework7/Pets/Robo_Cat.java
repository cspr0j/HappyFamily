package homework7.Pets;

public class Robo_Cat extends Pet implements NastyThings{

    public Robo_Cat(String nickname) {
        super(nickname);
    }

    public Robo_Cat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Robo_Cat() {
    }

    @Override
    public void respond() {
        {
            System.out.printf("Hello, owner. I am - %s (%s). I miss you!\n", getNickname(), getSpecies());
        }
    }

    @Override
    public void foul() {
        System.out.printf("I am - %s. I need to cover it up\n", getSpecies());
    }
}
