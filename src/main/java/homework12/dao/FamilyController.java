package homework12.dao;

import homework12.Family;
import homework12.Human.Human;
import homework12.Pets.Pet;
import homework12.exception.FamilyOverflowException;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

public class FamilyController {

    private final FamilyService familyService = new FamilyService();

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int size) {
        return familyService.getFamiliesBiggerThan(size);
    }

    public List<Family> getFamiliesLessThan(int size) {
        return familyService.getFamiliesLessThan(size);
    }

    public int countFamiliesWithMemberNumber(int familySize) {
        return familyService.countFamiliesWithMemberNumber(familySize);
    }

    public void createNewFamily(Human father, Human mother) {
        familyService.createNewFamily(father, mother);
    }

    public void deleteFamilyByIndex(int index) {
        familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String manName, String womanName) throws ParseException {
        int limit = 8;
        // throws an exception if family size reaches the limit
        if (family.countFamily() >= limit) {
            throw new FamilyOverflowException("Reaches to the limit");
        }
        return familyService.bornChild(family, manName, womanName);
    }

    public Family adoptChild(Family family, Human child) {
        int limit = 8;
        // throws an exception if family size reaches the limit
        if (family.countFamily() >= limit) {
            throw new FamilyOverflowException("Reaches to the limit");
        }
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }

    public void addFamily(Family family) {
        familyService.addFamily(family);
    }
}