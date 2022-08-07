package homework6.tests;

import homework6.DayOfWeek;
import homework6.Family;
import homework6.Human;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {

    private final String[][] schedule = {
            {DayOfWeek.SUNDAY.name(),"watch a film"},
            {DayOfWeek.WEDNESDAY.name(), "meeting with friends"},
            {DayOfWeek.FRIDAY.name(), "Read a book"}
    };

    @Test
    void toStringIsValid() {
        Human father = new Human("Stanley", "Kubrick", 1928);
        father.setIq(80);
        Human mother = new Human("Christiane", "Kubrick", 1932);
        mother.setIq(60);

        Family family = new Family(father, mother);
        Human child = new Human("Vivian", "Kubrick", family, 1960);
        child.setIq(70);
        child.setSchedule(schedule);
        family.setChildren(child);

        StringBuilder st = new StringBuilder();
        st.append("Family{")
                .append("\n mother=").append(family.getMother().toString())
                .append(",\n father=").append(family.getFather().toString());

        if (family.getChildren().length != 0) {
            family.setFlag(true);
            st.append(",\n children=").append(Arrays.toString(family.getChildren()));
        }
        if (family.getPet().length != 0) {
            st.append(",\n pet=")
                    .append(Arrays.toString(family.getPet()))
                    .append("\n");
        }
        st.append('}');
        System.out.println(family);

        assertEquals(st.toString(), family.toString());
    }

    @Test
    void deleteChild1() {
        Human father1 = new Human("Stanley", "Kubrick", 1928);
        father1.setIq(80);
        Human mother1 = new Human("Christiane", "Kubrick", 1932);
        mother1.setIq(60);
        Family family1 = new Family(father1, mother1);

        Human child1 = new Human("Vivian", "Kubrick", family1, 1960);
        child1.setIq(70);
        Human child2 = new Human("TestName", "TestSurname", family1, 1960);

        family1.setChildren(child1);
        family1.addChild(child2);

        family1.deleteChild(child2);
        assertArrayEquals(family1.getChildren(), new Human[]{child1});
    }

    @Test
    void deleteChild2() {

        Human father1 = new Human("Stanley", "Kubrick", 1928);
        father1.setIq(80);
        Human mother1 = new Human("Christiane", "Kubrick", 1932);
        mother1.setIq(60);
        Family family1 = new Family(father1, mother1);

        Human child1 = new Human("Vivian", "Kubrick", family1, 1960);
        child1.setIq(70);
        Human child2 = new Human("TestName", "TestSurname", family1, 1960);
        Human child3 = new Human("TestName2", "TestSurname2", family1, 1960);

        family1.setChildren(child1);
        family1.addChild(child2);

        family1.deleteChild(child3); // pass an object that is not equivalent to any array element

        assertArrayEquals(family1.getChildren(), new Human[]{child1,child2});
    }

    @Test
    void deleteChildByIndex() {
        Human father1 = new Human("Stanley", "Kubrick", 1928);
        father1.setIq(80);
        Human mother1 = new Human("Christiane", "Kubrick", 1932);
        mother1.setIq(60);
        Family family1 = new Family(father1, mother1);

        Human child1 = new Human("Vivian", "Kubrick", family1, 1960);
        child1.setIq(70);
        Human child2 = new Human("TestName", "TestSurname", family1, 1960);

        family1.setChildren(child1);
        family1.addChild(child2);

        family1.deleteChild(0);

        assertArrayEquals(family1.getChildren(), new Human[]{child2});
    }

    @Test
    void deleteChildByIndex2() {
        Human father1 = new Human("Stanley", "Kubrick", 1928);
        father1.setIq(80);
        Human mother1 = new Human("Christiane", "Kubrick", 1932);
        mother1.setIq(60);
        Family family1 = new Family(father1, mother1);

        Human child1 = new Human("Vivian", "Kubrick", family1, 1960);
        child1.setIq(70);
        Human child2 = new Human("TestName", "TestSurname", family1, 1960);

        family1.setChildren(child1);
        family1.addChild(child2);

        family1.deleteChild(3); // pass an index outside the index range

        assertArrayEquals(family1.getChildren(), new Human[]{child1,child2});
    }

    @Test
    void addChild() {
        Human father1 = new Human("Stanley", "Kubrick", 1928);
        father1.setIq(80);
        Human mother1 = new Human("Christiane", "Kubrick", 1932);
        mother1.setIq(60);
        Family family1 = new Family(father1, mother1);

        Human child = new Human("Vivian", "Kubrick", family1, 1960);
        child.setIq(70);

        family1.addChild(child);
        int actualLength = family1.getChildren().length;

        assertTrue(actualLength == 1 &&
                family1.getChildren()[actualLength-1].equals(child));
    }


    @Test
    void countFamily() {
        Human father1 = new Human("Stanley", "Kubrick", 1928);
        father1.setIq(80);
        Human mother1 = new Human("Christiane", "Kubrick", 1932);
        mother1.setIq(60);
        Family family1 = new Family(father1, mother1);

        Human child1 = new Human("Vivian", "Kubrick", family1, 1960);
        child1.setIq(70);
        Human child2 = new Human("TestName", "TestSurname", family1, 1960);

        family1.setChildren(child1);
        family1.addChild(child2);

        assertEquals(4, family1.countFamily());
    }

    @Test
    void iaEquals() {
        // Create first Family members
        Human father1 = new Human("Stanley", "Kubrick", 1928);
        father1.setIq(80);
        Human mother1 = new Human("Christiane", "Kubrick", 1932);
        mother1.setIq(60);

        Family family1 = new Family(father1, mother1);
        // Create  child
        Human child1 = new Human("Vivian", "Kubrick", family1, 1960);
        child1.setIq(70);
        family1.setChildren(child1);

        // reflexive: an object must equal itself
        boolean firstContract = family1.equals(family1); //true

        // Create second Family members
        Human father2 = new Human("Stanley", "Kubrick", 1928);
        father1.setIq(80);
        Human mother2 = new Human("Christiane", "Kubrick", 1932);
        mother1.setIq(60);

        Family family2 = new Family(father2, mother2);
        // Create  child
        Human child2 = new Human("Vivian", "Kubrick", family2, 1960);
        child2.setIq(70);
        family2.setChildren(child2);

        // symmetric: X.equals(Y) must return the same result as Y.equals(X)
        // here our X - family1 ,   and    Y - family2
        boolean secondContract = family1.equals(family2) && family2.equals(family1); //true

        // Create 3rd Family members
        Human father3 = new Human("Stanley", "Kubrick", 1928);
        father3.setIq(80);
        Human mother3 = new Human("Christiane", "Kubrick", 1932);
        mother3.setIq(60);

        Family family3 = new Family(father3, mother3);
        // Create  child
        Human child3 = new Human("Vivian", "Kubrick", family3, 1960);
        child3.setIq(70);
        family3.setChildren(child3);

        // transitive: if X.equals(Y) and Y.equals(Z), then also X.equals(Z)
        // here our X - family1 ,   and    Y - family2  and    Z - family3
        boolean thirdContract = family1.equals(family2) &&
                                family2.equals(family3) &&
                                family1.equals(family3); //true

        // consistent:
        // for any given values of x and y,
        // a repeated call to x.equals(y)
        // will return the value of the previous call to this method,
        // provided that the fields used to compare these two objects have not changed between calls.;
        boolean check = family1.equals(family2); //true
        boolean check2 = family1.equals(family2); //true
        boolean check3 = family1.equals(family2); //true

        boolean fourthContract = check && check2 && check3; //true

        // final check with all contracts
        boolean result = firstContract && secondContract && thirdContract && fourthContract;
        assertTrue(result);
    }

    @Test
    void hashCodeTests() {

        // Create first Family members
        Human father1 = new Human("Stanley", "Kubrick", 1928);
        father1.setIq(80);
        Human mother1 = new Human("Christiane", "Kubrick", 1932);
        mother1.setIq(60);

        Family family1 = new Family(father1, mother1);
        // Create  child
        Human child1 = new Human("Vivian", "Kubrick", family1, 1960);
        child1.setIq(70);
        family1.setChildren(child1);

        // internal consistency:
        // calling the hashCode method one or more times over the same object
        // should return the same hash value,
        // provided that the fields of the object involved in calculating the value have not changed.
        int code1 = family1.hashCode();
        int code2 = family1.hashCode();
        int code3 = family1.hashCode();
        boolean firstContract = family1.hashCode() == code1 &&
                family1.hashCode() == code2 &&
                family1.hashCode() == code3;

        Human father2 = new Human("Stanley", "Kubrick", 1928);
        father2.setIq(80);
        Human mother2 = new Human("Christiane", "Kubrick", 1932);
        mother2.setIq(60);

        Family family2 = new Family(father2, mother2);
        Human child2 = new Human("Vivian", "Kubrick", family2, 1960);
        child2.setIq(70);
        family2.setChildren(child2);

        // calling the hashCode method on two objects
        // should always return the same number
        // if these objects are equal (calling the equals method on these objects returns true).
        boolean secondContract = (family1.hashCode() == family2.hashCode());

        boolean result = firstContract && secondContract;
        assertTrue(result);
    }
}
