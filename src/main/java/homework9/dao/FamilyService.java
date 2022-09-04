package homework9.dao;

import homework9.Family;
import homework9.Human.Human;
import homework9.Human.Man;
import homework9.Human.Woman;
import homework9.Pets.Pet;

import java.util.*;

public class FamilyService {

    private final FamilyDao familyDao = new CollectionFamilyDao();

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        for (Family family : familyDao.getAllFamilies()) {
            System.out.printf("Index: %d, %s \n"
                    , getAllFamilies().indexOf(family), family);
        }
    }

    public List<Family> getFamiliesBiggerThan(int size) {
        List<Family> list = new ArrayList<>();
        for (int i = 0; i < familyDao.getAllFamilies().size(); i++) {
            Family family = familyDao.getAllFamilies().get(i);
            if (family.countFamily() > size) {
                list.add(family);
            }
        }
        System.out.println(list);
        return list;
    }

    public List<Family> getFamiliesLessThan(int size) {
        List<Family> list = new ArrayList<>();
        for (int i = 0; i < familyDao.getAllFamilies().size(); i++) {
            Family family = familyDao.getAllFamilies().get(i);
            if (family.countFamily() < size) {
                list.add(family);
            }
        }
        System.out.println(list);
        return list;
    }

    public int countFamiliesWithMemberNumber(int size) {
        int counter = 0;
        for (int i = 0; i < familyDao.getAllFamilies().size(); i++) {
            Family family = familyDao.getAllFamilies().get(i);
            if (family.countFamily() == size) {
                counter++;
            }
        }
        return counter;
    }

    public void createNewFamily(Human father, Human mother) {
        Family family = new Family(father, mother);
        familyDao.saveFamily(family);
    }

    public void deleteFamily(Family family) {
        familyDao.deleteFamily(family);
    }

    public void deleteFamilyByIndex(int index) {
        familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        Random random = new Random();
        // The sex of the child is defined casually with the 50%/50% probability. 0 or 1 - 50% chance
        int rndNum = random.nextInt(2);
        int iq = (family.getFather().getIq() + family.getMother().getIq()) / 2;
        // randomly generated year
        int year = (int) (Math.random() * 10 + 18 + family.getMother().getYear());
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
        for (int i = 0; i < familyDao.getAllFamilies().size(); i++) {
            Family family = familyDao.getAllFamilies().get(i);

            for (int j = 0; j < family.getChildren().size(); j++) {
                Human child = family.getChildren().get(j);
                if (2022 - child.getYear() > age) {
                    family.getChildren().remove(child);
                    // since we've removed child from list,
                    // we need to reduce iterator, so that we can check all children
                    j--;
                }
            }
            familyDao.saveFamily(family);
        }
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
}
