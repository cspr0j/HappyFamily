package homework13.dao;

import homework13.Family;
import homework13.Human.Human;
import homework13.Pets.Pet;
import homework13.exception.FamilyOverflowException;
import homework13.logger.CustomLogger;

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
        Family updatedFamily = null;
        try {

            if (family.countFamily() >= limit) {
                throw new FamilyOverflowException("Reaches to the limit");
            }

            updatedFamily = familyService.bornChild(family, manName, womanName);
        } catch (FamilyOverflowException e) {
            CustomLogger.error(e.getMessage());
        }
        return updatedFamily;
    }

    public Family adoptChild(Family family, Human child) {
        int limit = 8;
        // throws an exception if family size reaches the limit
        Family updatedFamily = null;
        try {

            if (family.countFamily() >= limit) {
                throw new FamilyOverflowException("Reaches to the limit");
            }

            updatedFamily = familyService.adoptChild(family, child);
        } catch (FamilyOverflowException e) {
            CustomLogger.error(e.getMessage());
        }
        return updatedFamily;
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

    public void saveData() {
        familyService.saveData();
    }

    public List<Family> loadData(){
        return familyService.loadData();
    }
}