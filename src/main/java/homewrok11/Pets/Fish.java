package homewrok11.Pets;

import java.util.Set;

public class Fish extends Pet {

    public Fish(String nickname) {
        super(nickname);
    }

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Fish() {
    }

    @Override
    public void respond() {
        {
            System.out.println("Hello, owner. I am - " + getNickname() + ". I miss you!\n");
        }
    }

}
