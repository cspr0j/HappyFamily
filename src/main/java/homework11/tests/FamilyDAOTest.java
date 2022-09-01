package homewrok11.tests;

import homewrok11.DayOfWeek;
import homewrok11.Family;
import homewrok11.Human.Man;
import homewrok11.Human.Woman;
import homewrok11.Pets.Dog;
import homewrok11.dao.FamilyService;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyDAOTest {

    private static final Map<String, String> schedule = new HashMap<>();

    static {
        schedule.put(DayOfWeek.SUNDAY.name(), "watch a film");
        schedule.put(DayOfWeek.WEDNESDAY.name(), "meeting with friends");
        schedule.put(DayOfWeek.FRIDAY.name(), "Read a book");
    }

    private final FamilyService familyService = new FamilyService();

    @Test
    public void testGetAllFamilies() throws ParseException {
        Man man1 = new Man("Stanley", "Kubrick", "26/07/1928", 80);
        Woman woman1 = new Woman("Christiane", "Kubrick", "10/05/1932", 60);

        Family family1 = new Family(man1, woman1);
        familyService.addFamily(family1);

        assertEquals(1, familyService.getAllFamilies().size());

    }

    @Test
    public void testGetFamiliesBiggerThan() throws ParseException {
        Man man1 = new Man("Stanley", "Kubrick", "26/07/1928", 80);
        Woman woman1 = new Woman("Christiane", "Kubrick", "10/05/1932", 60);

        Family family1 = new Family(man1, woman1);
        familyService.addFamily(family1);

        Man child1 = new Man("Finn", "Child_Test", "15/22/1995", 100);
        family1.addChild(child1);

        assertEquals(1, familyService.getFamiliesBiggerThan(2).size());
        assertEquals(0, familyService.getFamiliesBiggerThan(3).size());
    }

    @Test
    public void testGetFamiliesLessThan() throws ParseException {
        Man man1 = new Man("Stanley", "Kubrick", "26/07/1928", 80);
        Woman woman1 = new Woman("Christiane", "Kubrick", "10/05/1932", 60);

        Family family1 = new Family(man1, woman1);
        familyService.addFamily(family1);

        Man child1 = new Man("Finn", "Child_Test", "15/22/1995", 100);
        family1.addChild(child1);

        assertEquals(0, familyService.getFamiliesLessThan(2).size());
        assertEquals(1, familyService.getFamiliesLessThan(4).size());
    }

    @Test
    public void testCountFamiliesWithMemberNumber() throws ParseException {
        Man man1 = new Man("Stanley", "Kubrick", "26/07/1928", 80);
        Woman woman1 = new Woman("Christiane", "Kubrick", "10/05/1932", 60);

        Family family1 = new Family(man1, woman1);
        familyService.addFamily(family1);

        Man child1 = new Man("Finn", "Child_Test", "15/22/1995", 100);
        family1.addChild(child1);

        assertEquals(1, familyService.countFamiliesWithMemberNumber(3));
        assertEquals(0, familyService.countFamiliesWithMemberNumber(4));
    }

    @Test
    public void testCreateNewFamily() throws ParseException {
        assertEquals(0, familyService.getAllFamilies().size());

        Man man2 = new Man("Stanley", "Kubrick", "26/07/1928", 80);
        Woman woman2 = new Woman("Christiane", "Kubrick", "10/05/1932", 60);

        familyService.createNewFamily(man2, woman2);

        assertEquals(1, familyService.getAllFamilies().size());
    }

    @Test
    public void testDeleteFamilyByIndex() throws ParseException {
        assertEquals(0, familyService.getAllFamilies().size());

        Man man2 = new Man("Stanley", "Kubrick", "26/07/1928", 80);
        Woman woman2 = new Woman("Christiane", "Kubrick", "10/05/1932", 60);

        familyService.createNewFamily(man2, woman2);

        assertEquals(1, familyService.getAllFamilies().size());

        familyService.deleteFamilyByIndex(0);

        assertEquals(0, familyService.getAllFamilies().size());
    }

    @Test
    public void testBornChild() throws ParseException {
        Man man1 = new Man("Stanley", "Kubrick", "26/07/1928", 80);
        Woman woman1 = new Woman("Christiane", "Kubrick", "10/05/1932", 60);

        Family family1 = new Family(man1, woman1);
        assertEquals(0, familyService.getAllFamilies().size());

        familyService.bornChild(family1, "Mark", "Fiona");
        assertEquals(1, familyService.getFamilyById(0).getChildren().size());
    }

    @Test
    public void testAdoptChild() throws ParseException {
        Man man1 = new Man("Stanley", "Kubrick", "26/07/1928", 80);
        Woman woman1 = new Woman("Christiane", "Kubrick", "10/05/1932", 60);

        Family family1 = new Family(man1, woman1);
        assertEquals(0, familyService.getAllFamilies().size());

        Man child1 = new Man("Finn", "Child_Test", "15/22/1995", 100);
        familyService.adoptChild(family1, child1);

        assertEquals(1, familyService.getFamilyById(0).getChildren().size());
    }

    @Test
    public void testDeleteAllChildrenOlderThen() throws ParseException {
        Man man1 = new Man("Stanley", "Kubrick", "26/07/1928", 80);
        Woman woman1 = new Woman("Christiane", "Kubrick", "10/05/1932", 60);

        Family family1 = new Family(man1, woman1);
        assertEquals(0, familyService.getAllFamilies().size());

        Man child1 = new Man("Finn", "Child_Test", "15/12/1995", 100);
        familyService.adoptChild(family1, child1);

        assertEquals(1, familyService.getFamilyById(0).getChildren().size());

        familyService.deleteAllChildrenOlderThen(30);
        assertEquals(1, familyService.getFamilyById(0).getChildren().size());

        familyService.deleteAllChildrenOlderThen(10);
        assertEquals(0, familyService.getFamilyById(0).getChildren().size());
    }

    @Test
    public void testCount() throws ParseException {
        assertEquals(0, familyService.getAllFamilies().size());

        Man man2 = new Man("Stanley", "Kubrick", "26/07/1928", 80);
        Woman woman2 = new Woman("Christiane", "Kubrick", "10/05/1932", 60);

        familyService.createNewFamily(man2, woman2);

        assertEquals(1, familyService.count());
    }

    @Test
    public void testAddPetAndGetPet() throws ParseException {
        Man man2 = new Man("Stanley", "Kubrick", "26/07/1928", 80);
        Woman woman2 = new Woman("Christiane", "Kubrick", "10/05/1932", 60);

        familyService.createNewFamily(man2, woman2);

        assertEquals(0, familyService.getPets(0).size());

        Dog dog = new Dog("Rock", 5, 50, new HashSet<>(Arrays.asList("sleep", "eat", "drink")));
        familyService.addPet(0, dog);

        assertEquals(1, familyService.getPets(0).size());
    }
}
