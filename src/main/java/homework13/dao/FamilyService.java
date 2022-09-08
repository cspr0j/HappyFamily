package homework13.dao;

import homework13.Family;
import homework13.Human.Human;
import homework13.Human.Man;
import homework13.Human.Woman;
import homework13.Pets.Pet;
import homework13.date.Converter;

import java.text.ParseException;
import java.util.*;

public class FamilyService {

    private final FamilyDao familyDao = new CollectionFamilyDao();

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyDao
                .getAllFamilies()
                .forEach(family ->
                        System.out.printf("Index: %d, %s \n",
                                getAllFamilies().indexOf(family), family.prettyFormat())
                );
    }

    public List<Family> getFamiliesBiggerThan(int size) {
        List<Family> list = new ArrayList<>();

        familyDao
                .getAllFamilies()
                .forEach(family ->
                {
                    if (family.countFamily() > size) {
                        list.add(family);
                        System.out.println(family.prettyFormat());
                    }
                });
        return list;
    }

    public List<Family> getFamiliesLessThan(int size) {
        List<Family> list = new ArrayList<>();

        familyDao
                .getAllFamilies()
                .forEach(family ->
                {
                    if (family.countFamily() < size) {
                        list.add(family);
                        System.out.println(family.prettyFormat());
                    }
                });;
        return list;
    }

    public int countFamiliesWithMemberNumber(int size) {
        return (int) familyDao
                .getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() == size).count();
    }

    public void createNewFamily(Human father, Human mother) {
        Family family = new Family(father, mother);
        familyDao.saveFamily(family);
    }

    public void deleteFamilyByIndex(int index) {
        familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) throws ParseException {
        Random random = new Random();
        Converter converter = new Converter();

        // The sex of the child is defined casually with the 50%/50% probability. 0 or 1 - 50% chance
        int rndNum = random.nextInt(2);
        int iq = (family.getFather().getIq() + family.getMother().getIq()) / 2;

        // randomly generated year
        double num = ((Math.random() * 0.11) + 0.89);
        String year = converter
                .converterToString((long) (Calendar.getInstance()
                        .getTimeInMillis() * num));

        String surname = family.getFather().getSurname();
        Human child;

        if (rndNum == 0) {
            child = new Man(maleName, surname, year, iq);
        } else {
            child = new Woman(femaleName, surname, year, iq);
        }
        family.addChild(child);

        return familyDao.saveFamily(family);
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        return familyDao.saveFamily(family);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyDao.getAllFamilies()
                .stream()
                .filter(family -> family
                        .getChildren()
                        .removeIf(child -> (2022 - child.age() > age)))
                .forEach(familyDao::saveFamily);
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public Set<Pet> getPets(int index) {
        return familyDao.getAllFamilies().get(index).getPet();
    }

    public void addPet(int index, Pet pet) {
        familyDao.getAllFamilies().get(index).getPet().add(pet);
        familyDao.saveFamily(familyDao.getAllFamilies().get(index));
    }

    public void addFamily(Family family) {
        familyDao.saveFamily(family);
    }

    public void saveData() {
        familyDao.saveData();
    }

    public List<Family> loadData(){
        return familyDao.loadData();
    }
}