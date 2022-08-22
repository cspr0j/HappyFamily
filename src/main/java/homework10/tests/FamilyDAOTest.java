package homework10.tests;

import homework10.DayOfWeek;
import homework10.Family;
import homework10.Human.Man;
import homework10.Human.Woman;
import homework10.Pets.Dog;
import homework10.Pets.Pet;
import homework10.dao.FamilyService;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
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
    public void testGetAllFamilies() throws ParseException {
        Man man1 = new Man("Frank", "Sinatra", "12/02/1980", 100);
        Woman woman1 = new Woman("Barbara", "Sinatra", "12/02/1980",10);
        Family family1 = new Family(man1, woman1);
        familyService.addFamily(family1);
        assertEquals(1, familyService.getAllFamilies().size());

    }

    @Test
    public void testGetFamiliesBiggerThan() throws ParseException {
        Man man1 = new Man("Frank", "Sinatra", "12/02/1980", 100);
        Woman woman1 = new Woman("Barbara", "Sinatra", "12/02/1980",10);
        Family family1 = new Family(man1, woman1);
        familyService.addFamily(family1);
        Man child1 = new Man("Finn", "Child", "12/02/1980",100);
        family1.addChild(child1);
        assertEquals(1, familyService.getFamiliesBiggerThan(2).size());
        assertEquals(0, familyService.getFamiliesBiggerThan(3).size());
    }

    @Test
    public void testGetFamiliesLessThan() throws ParseException {
        Man man1 = new Man("Frank", "Sinatra", "12/02/1980", 100);
        Woman woman1 = new Woman("Barbara", "Sinatra", "12/02/1980",10);
        Family family1 = new Family(man1, woman1);
        familyService.addFamily(family1);
        Man child1 = new Man("Finn", "Child", "12/02/1980",100);
        family1.addChild(child1);
        assertEquals(0, familyService.getFamiliesLessThan(2).size());
        assertEquals(1, familyService.getFamiliesLessThan(4).size());
    }

    @Test
    public void testCountFamiliesWithMemberNumber() throws ParseException {
        Man man1 = new Man("Frank", "Sinatra", "12/02/1980", 100);
        Woman woman1 = new Woman("Barbara", "Sinatra", "12/02/1980",10);
        Family family1 = new Family(man1, woman1);
        familyService.addFamily(family1);
        Man child1 = new Man("Finn", "Child", "12/02/1980",100);
        family1.addChild(child1);
        assertEquals(1, familyService.countFamiliesWithMemberNumber(3));
        assertEquals(0, familyService.countFamiliesWithMemberNumber(4));
    }

    @Test
    public void testCreateNewFamily() throws ParseException {
        assertEquals(0, familyService.getAllFamilies().size());
        Man man2 = new Man("Frank", "Sinatra", "12/02/1980", 100);
        Woman woman2 = new Woman("Barbara", "Sinatra", "12/02/1980",10);
        familyService.createNewFamily(man2, woman2);
        assertEquals(1, familyService.getAllFamilies().size());
    }

    @Test
    public void testDeleteFamilyByIndex() throws ParseException {
        assertEquals(0, familyService.getAllFamilies().size());
        Man man2 = new Man("Frank", "Sinatra", "12/02/1980", 100);
        Woman woman2 = new Woman("Barbara", "Sinatra", "12/02/1980",10);
        familyService.createNewFamily(man2, woman2);
        assertEquals(1, familyService.getAllFamilies().size());
        familyService.deleteFamilyByIndex(0);
        assertEquals(0, familyService.getAllFamilies().size());
    }

    @Test
    public void testBornChild() throws ParseException {
        Man man1 = new Man("Frank", "Sinatra", "12/02/1980", 100);
        Woman woman1 = new Woman("Barbara", "Sinatra", "12/02/1980",10);
        Family family1 = new Family(man1, woman1);
        assertEquals(0, familyService.getAllFamilies().size());
        familyService.bornChild(family1, "Mark", "Fiona");
        assertEquals(1, familyService.getFamilyById(0).getChildren().size());
    }

    @Test
    public void testAdoptChild() throws ParseException {
        Man man1 = new Man("Frank", "Sinatra", "12/02/1980", 100);
        Woman woman1 = new Woman("Barbara", "Sinatra", "12/02/1980",10);
        Family family1 = new Family(man1, woman1);
        assertEquals(0, familyService.getAllFamilies().size());
        Man child1 = new Man("Finn", "Child", "12/02/1980",100);
        familyService.adoptChild(family1, child1);
        assertEquals(1, familyService.getFamilyById(0).getChildren().size());
    }

    @Test
    public void testDeleteAllChildrenOlderThen() throws ParseException {
        Man man1 = new Man("Frank", "Sinatra", "12/02/1980", 100);
        Woman woman1 = new Woman("Barbara", "Sinatra", "12/02/1980",10);
        Family family1 = new Family(man1, woman1);
        assertEquals(0, familyService.getAllFamilies().size());
        Man child1 = new Man("Finn", "Child", "12/02/1980",100);
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
        Man man2 = new Man("Frank", "Sinatra", "12/02/1980", 100);
        Woman woman2 = new Woman("Barbara", "Sinatra", "12/02/1980",10);
        familyService.createNewFamily(man2, woman2);
        assertEquals(1, familyService.count());
    }

    @Test
    public void testAddPetAndGetPet() throws ParseException {
        Man man2 = new Man("Frank", "Sinatra", "12/02/1980", 100);
        Woman woman2 = new Woman("Barbara", "Sinatra", "12/02/1980",10);
        familyService.createNewFamily(man2, woman2);
        assertEquals(0, familyService.getPets(0).size());
        Pet pet = new Dog("Boss", 2, 23, new HashSet<String>() {{
            add("eat");
            add("play");
        }});
        familyService.addPet(0, pet);
        assertEquals(1, familyService.getPets(0).size());
    }
}
