package homework13.dao;

import homework13.Family;
import homework13.logger.CustomLogger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {

    private final File file = new File("src/main/java/homework13/files/FamilyDB.bin");
    List<Family> familyList = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return familyList;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        CustomLogger.info("Receiving Family by index");
        if (index < familyList.size()) {
            return familyList.get(index);
        } else {
            CustomLogger.error("Cannot find family with index " + index);
            return null;
        }
    }

    @Override
    public boolean deleteFamily(int index) {
        CustomLogger.info("Deleting Family by index");
        int length = this.familyList.size();

        if (index < length) {
            this.familyList.remove(index);
            return true;
        } else {
            CustomLogger.error("Cannot delete family with index " + index);
            return false;
        }
    }

    @Override
    public boolean deleteFamily(Family family) {
        CustomLogger.info("Receiving Family by Family object");
        return familyList.remove(family);
    }

    @Override
    public Family saveFamily(Family family) {
        CustomLogger.info("Saving Family to DB");
        if (familyList.isEmpty() && file.exists()) {
            loadData();
        }

        if (familyList.contains(family)) {
            int index = familyList.indexOf(family);
            familyList.set(index, family);
        } else
            familyList.add(family);
        return family;
    }

    @Override
    public void saveData() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(familyList);
            oos.close();
            fos.close();

            System.out.println("Successfully saved");

        } catch (IOException e) {
            System.out.println("An error occurred. Please try again");
            CustomLogger.error(e.getMessage());
        }
    }

    @Override
    public List<Family> loadData() {
        List<Family> families = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fis);
            families = (List<Family>) objectInputStream.readObject();

            objectInputStream.close();
            fis.close();

            System.out.println("Successfully loaded");

        } catch (IOException e) {
            System.out.println("An error occurred.\n" +
                    "Please, follow these instruction to fix it:\n" +
                    "1) Check if your file exists or not.\n" +
                    "2) Check if your file is filled with data. If not then create family and fill your file\n" +
                    "3) Try again");
            CustomLogger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Can't Deserialize this data");
            CustomLogger.error(e.getMessage());
        }
        familyList = families;
        return families;
    }
}
