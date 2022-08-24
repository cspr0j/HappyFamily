package homework10.dao;

import homework10.Family;
import homework10.Human.Human;
import homework10.Human.Man;
import homework10.Human.Woman;
import homework10.Pets.Pet;
import homework10.date.Converter;

import java.text.ParseException;
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

    public void deleteFamilyByIndex(int index) {
        familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) throws ParseException {
        Random random = new Random();
        Converter converter = new Converter();

        // The sex of the child is defined casually with the 50%/50% probability. 0 or 1 - 50% chance
        int rndNum = random.nextInt(2);
        int iq = (family.getFather().getIq() + family.getMother().getIq()) / 2;

        // randomly generated Birth Date
        double num = ((Math.random() * 0.45) + 0.52);
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

    public void deleteAllChildrenOlderThen(int age) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Converter converter = new Converter();

        for (int i = 0; i < familyDao.getAllFamilies().size(); i++) {
            Family family = familyDao.getAllFamilies().get(i);

            for (int j = 0; j < family.getChildren().size(); j++) {
                Human child = family.getChildren().get(j);

                long result = converter.converterToTimestamp(child.getBirthDate());
                calendar.setTimeInMillis(result);

                int year = calendar.get(Calendar.YEAR);
                if (2022 - year > age)
                    family.getChildren().remove(child);
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
