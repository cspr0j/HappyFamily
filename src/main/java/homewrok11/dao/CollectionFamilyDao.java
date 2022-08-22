package homewrok11.dao;

import homewrok11.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {

    List<Family> familyList = new ArrayList<>();


    @Override
    public List<Family> getAllFamilies() {
        return familyList;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index < familyList.size()) {
            return familyList.get(index);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteFamily(int index) {
        int length = this.familyList.size();
        if (index < length) {
            this.familyList.remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteFamily(Family family) {
        return familyList.remove(family);
    }

    @Override
    public Family saveFamily(Family family) {
        if (familyList.contains(family)) {
            int index = familyList.indexOf(family);
            familyList.set(index, family);
        } else
            familyList.add(family);
        return family;
    }
}
