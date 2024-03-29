package homework8.tests;

import homework8.DayOfWeek;
import homework8.Human.Human;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HumanTest {
    private static final Map<String,String> schedule = new HashMap<>();

    static {
        schedule.put(DayOfWeek.SUNDAY.name(),"watch a film");
        schedule.put(DayOfWeek.WEDNESDAY.name(), "meeting with friends");
        schedule.put(DayOfWeek.FRIDAY.name(), "Read a book");
    }

    @Test
    void toStringIsValid() {
        Human male = new Human("Vito", "Corleone", 1887);
        male.setIq(90);
        String str = "Human{" + "name='" + male.getName() + '\'' +
                ", surname='" + male.getSurname() + '\'' +
                ", year=" + male.getYear() +
                ", iq=" + male.getIq();

        assertEquals(str, male.toString());
    }

    @Test
    void iaEquals() {

        Human human1 = new Human("Jalal", "Aliyev", 2000, 100, schedule);

        // reflexive: an object must equal itself
        boolean firstContract = human1.equals(human1); //true

        //create another second Human for comparing
        Human human2 = new Human("Jalal", "Aliyev", 2000, 100, schedule);

        // symmetric: X.equals(Y) must return the same result as Y.equals(X)
        // here our X - human1 ,   and    Y - human2
        boolean secondContract = human1.equals(human2) && human2.equals(human1); //true


        //create another 3rd Human for comparing
        Human human3 = new Human("Jalal", "Aliyev", 2000, 100, schedule);

        // transitive: if X.equals(Y) and Y.equals(Z), then also X.equals(Z)
        // here our X - human1 ,   and    Y - human2  and    Z - human3
        boolean thirdContract = human1.equals(human2) && human2.equals(human3) && human1.equals(human3); //true


        // consistent:
        // for any given values of x and y,
        // a repeated call to x.equals(y)
        // will return the value of the previous call to this method,
        // provided that the fields used to compare these two objects have not changed between calls.
        boolean fourthContract;
        boolean check = human1.equals(human2); //true
        boolean check2 = human1.equals(human2); //true
        boolean check3 = human1.equals(human2); //true

        fourthContract = check && check2 && check3; //true

        // final check with all contracts
        boolean result = firstContract && secondContract && thirdContract && fourthContract;
        assertTrue(result);
    }

    @Test
    void hashCodeTests() {

        Human human1 = new Human("Jalal", "Aliyev", 2000, 100, schedule);

        // internal consistency:
        // calling the hashCode method one or more times over the same object
        // should return the same hash value,
        // provided that the fields of the object involved in calculating the value have not changed.
        int code1 = human1.hashCode();
        int code2 = human1.hashCode();
        int code3 = human1.hashCode();
        boolean firstContract = human1.hashCode() == code1 &&
                                    human1.hashCode() == code2 &&
                                    human1.hashCode() == code3;


        Human human2 = new Human("Jalal", "Aliyev", 2000, 100, schedule);

        // calling the hashCode method on two objects
        // should always return the same number
        // if these objects are equal (calling the equals method on these objects returns true).
        boolean secondContract = (human1.hashCode() == human2.hashCode());

        boolean result = firstContract && secondContract;
        assertTrue(result);
    }
}
