package homework6.tests;

import homework6.DayOfWeek;
import homework6.Human;
import homework6.Pet;
import homework6.Species;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetTest {
    private final String[] habits = {"sleep", "eat", "drink"};

    @Test
    void toStringIsValid() {
        Pet dog = new Pet(Species.DOG, "Rock", 5, 50, habits);
        String expected =  dog.getSpecies() + "{" +
                "nickname='" + dog.getNickname() + '\'' +
                ", age=" + dog.getAge() +
                ", trickLevel=" + dog.getTrickLevel() +
                ", can fly:" + dog.getSpecies().canFly +
                ", number of legs:" + dog.getSpecies().numberOfLegs +
                ", has fur:" + dog.getSpecies().hasFur +
                ", habits=" + Arrays.toString(habits) +
                '}';
        assertEquals(expected, dog.toString());
    }

    @Test
    void iaEquals() {
        Pet pet1 = new Pet(Species.DOG, "Rock", 5, 50, habits);

        // reflexive: an object must equal itself
        boolean firstContract = pet1.equals(pet1); //true

        //create another second Human for comparing
        Pet pet2 = new Pet(Species.DOG, "Rock", 5, 50, habits);

        // symmetric: X.equals(Y) must return the same result as Y.equals(X)
        // here our X - pet1 ,   and    Y - pet2
        boolean secondContract = pet1.equals(pet2) && pet2.equals(pet1); //true


        //create another 3rd Human for comparing
        Pet pet3 = new Pet(Species.DOG, "Rock", 5, 50, habits);

        // transitive: if X.equals(Y) and Y.equals(Z), then also X.equals(Z)
        // here our X - pet1 ,   and    Y - pet2  and    Z - pet3
        boolean thirdContract = pet1.equals(pet2) && pet2.equals(pet3) && pet1.equals(pet3); //true


        // consistent:
        // for any given values of x and y,
        // a repeated call to x.equals(y)
        // will return the value of the previous call to this method,
        // provided that the fields used to compare these two objects have not changed between calls.
        boolean fourthContract;
        boolean check = pet1.equals(pet2); //true
        boolean check2 = pet1.equals(pet2); //true
        boolean check3 = pet1.equals(pet2); //true

        fourthContract = check && check2 && check3; //true

        // final check with all contracts
        boolean result = firstContract && secondContract && thirdContract && fourthContract;
        assertTrue(result);
    }

    @Test
    void hashCodeTests() {

        Pet pet1 = new Pet(Species.DOG, "Rock", 5, 50, habits);
        // internal consistency:
        // calling the hashCode method one or more times over the same object
        // should return the same hash value,
        // provided that the fields of the object involved in calculating the value have not changed.
        int code1 = pet1.hashCode();
        int code2 = pet1.hashCode();
        int code3 = pet1.hashCode();
        boolean firstContract = pet1.hashCode() == code1 &&
                                    pet1.hashCode() == code2 &&
                                    pet1.hashCode() == code3;


        Pet pet2 = new Pet(Species.DOG, "Rock", 5, 50, habits);
        // calling the hashCode method on two objects
        // should always return the same number
        // if these objects are equal (calling the equals method on these objects returns true).
        boolean secondContract = (pet1.hashCode() == pet2.hashCode());

        boolean result = firstContract && secondContract;
        assertTrue(result);
    }
}