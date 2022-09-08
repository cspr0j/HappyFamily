package homework9.tests;

import homework9.DayOfWeek;
import homework9.Family;
import homework9.Human.Human;
import homework9.Human.Man;
import homework9.Human.Woman;
import homework9.Pets.Dog;
import homework9.dao.FamilyService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyDAOTest {

    private static final Map<String,String> schedule = new HashMap<>();

    static {
        schedule.put(DayOfWeek.SUNDAY.name(),"watch a film");
        schedule.put(DayOfWeek.WEDNESDAY.name(), "meeting with friends");
        schedule.put(DayOfWeek.FRIDAY.name(), "Read a book");
    }
    private final FamilyService familyService = new FamilyService();

    @Test
    public void testGetAllFamilies() {
        Man father = new Man("Stanley", "Kubrick", 1928,80, schedule);
        Woman mother = new Woman("Christiane", "Kubrick", 1932,60, schedule);
        Family family = new Family(father, mother);

        familyService.addFamily(family);

        assertEquals(1, familyService.getAllFamilies().size());

    }

    @Test
    public void testGetFamiliesBiggerThan() {
        Man father = new Man("Stanley", "Kubrick", 1928,80, schedule);
        Woman mother = new Woman("Christiane", "Kubrick", 1932,60, schedule);
        Family family = new Family(father, mother);

        familyService.addFamily(family);

        Woman child = new Woman("Vivian", "Kubrick", family, 1960);
        family.addChild(child);

        assertEquals(1, familyService.getFamiliesBiggerThan(2).size());
        assertEquals(0, familyService.getFamiliesBiggerThan(3).size());
    }

    @Test
    public void testGetFamiliesLessThan() {
        Man father = new Man("Stanley", "Kubrick", 1928,80, schedule);
        Woman mother = new Woman("Christiane", "Kubrick", 1932,60, schedule);
        Family family = new Family(father, mother);

        familyService.addFamily(family);

        Woman child = new Woman("Vivian", "Kubrick", family, 1960);
        family.addChild(child);

        assertEquals(0, familyService.getFamiliesLessThan(2).size());
        assertEquals(1, familyService.getFamiliesLessThan(4).size());
    }

    @Test
    public void testCountFamiliesWithMemberNumber() {
        Man father = new Man("Stanley", "Kubrick", 1928,80, schedule);
        Woman mother = new Woman("Christiane", "Kubrick", 1932,60, schedule);
        Family family = new Family(father, mother);

        familyService.addFamily(family);

        Woman child = new Woman("Vivian", "Kubrick", family, 1960);
        family.addChild(child);

        assertEquals(1, familyService.countFamiliesWithMemberNumber(3));
        assertEquals(0, familyService.countFamiliesWithMemberNumber(4));
    }

    @Test
    public void testCreateNewFamily() {
        assertEquals(0, familyService.getAllFamilies().size());

        Man father = new Man("Stanley", "Kubrick", 1928,80, schedule);
        Woman mother = new Woman("Christiane", "Kubrick", 1932,60, schedule);
        familyService.createNewFamily(father, mother);

        assertEquals(1, familyService.getAllFamilies().size());
    }

    @Test
    public void testDeleteFamilyByIndex() {
        assertEquals(0, familyService.getAllFamilies().size());

        Man father = new Man("Stanley", "Kubrick", 1928,80, schedule);
        Woman mother = new Woman("Christiane", "Kubrick", 1932,60, schedule);
        familyService.createNewFamily(father, mother);

        assertEquals(1, familyService.getAllFamilies().size());

        familyService.deleteFamilyByIndex(0);

        assertEquals(0, familyService.getAllFamilies().size());
    }

    @Test
    public void testBornChild() {
        Man father = new Man("Stanley", "Kubrick", 1928,80, schedule);
        Woman mother = new Woman("Christiane", "Kubrick", 1932,60, schedule);
        Family family = new Family(father, mother);

        assertEquals(0, familyService.getAllFamilies().size());

        familyService.bornChild(family, "Mark", "Fiona");

        assertEquals(1, familyService.getFamilyById(0).getChildren().size());
    }

    @Test
    public void testAdoptChild() {
        Man father = new Man("Stanley", "Kubrick", 1928,80, schedule);
        Woman mother = new Woman("Christiane", "Kubrick", 1932,60, schedule);
        Family family = new Family(father, mother);

        assertEquals(0, familyService.getAllFamilies().size());

        Woman child = new Woman("Vivian", "Kubrick", family, 1960);
        familyService.adoptChild(family, child);

        assertEquals(1, familyService.getFamilyById(0).getChildren().size());
    }

    @Test
    public void testDeleteAllChildrenOlderThen() {
        Man father = new Man("Stanley", "Kubrick", 1928,80, schedule);
        Woman mother = new Woman("Christiane", "Kubrick", 1932,60, schedule);
        Family family = new Family(father, mother);

        assertEquals(0, familyService.getAllFamilies().size());

        Human child = new Human("Frank", "Smith", family, 1990);
        Human child2 = new Human("MyChild", "Smith", family, 1900);
        familyService.adoptChild(family, child);
        family.addChild(child2);

        assertEquals(2, familyService.getFamilyById(0).getChildren().size());

        familyService.deleteAllChildrenOlderThen(40);
        assertEquals(1, familyService.getFamilyById(0).getChildren().size());

        familyService.deleteAllChildrenOlderThen(10);
        assertEquals(0, familyService.getFamilyById(0).getChildren().size());
    }

    @Test
    public void testCount() {
        assertEquals(0, familyService.getAllFamilies().size());

        Man father = new Man("Stanley", "Kubrick", 1928,80, schedule);
        Woman mother = new Woman("Christiane", "Kubrick", 1932,60, schedule);
        familyService.createNewFamily(father, mother);

        assertEquals(1, familyService.count());
    }

    @Test
    public void testAddPetAndGetPet() {
        Man father = new Man("Stanley", "Kubrick", 1928,80, schedule);
        Woman mother = new Woman("Christiane", "Kubrick", 1932,60, schedule);
        familyService.createNewFamily(father, mother);

        assertEquals(0, familyService.getPets(0).size());

        Dog dog = new Dog("Rock", 5, 50, new HashSet<>(Arrays.asList("sleep", "eat", "drink")));
        familyService.addPet(0, dog);

        assertEquals(1, familyService.getPets(0).size());
    }
}
