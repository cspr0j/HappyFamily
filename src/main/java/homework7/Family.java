package homework7;

import homework7.Human.Human;
import homework7.Human.HumanCreator;
import homework7.Human.Man;
import homework7.Human.Woman;
import homework7.Pets.Pet;

import java.util.*;


public class Family implements HumanCreator {
    static final Map<Integer,List<String>> names;
    // displays only 1 time
    static {
        names = new HashMap<>();
        System.out.println("Family class is being loaded");
    }

    // displays each time
    {
        System.out.println("New Family type  object is created");
    }

    private Human mother;
    private Human father;
    private Human[] children;

    private Pet[] pet;  //it's an Array, because family can have >1 pet
    private boolean flag;

    public Family(Human father, Human mother) {
        this.mother = mother;
        this.father = father;
        children = new Human[0];
        pet = new Pet[0];
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Family(Human father, Human mother, Pet... pet) {
        this.mother = mother;
        this.father = father;
        children = new Human[0];
        this.pet = pet;

        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Family() {
        children = new Human[0];
        pet = new Pet[0];
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        this.mother.setFamily(this);
    }

    public void setFather(Human father) {
        this.father = father;
        this.father.setFamily(this);
    }

    public Human getFather() {
        return father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human... children) {
        this.children = children;
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Pet[] getPet() {
        return pet;
    }

    public Pet getPet(int index) {
        return pet[index];
    }

    public void setPet(Pet... pet) {
        this.pet = pet;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    //methods
    public boolean addChild(Human human) {
        int length = this.children.length;
        Human[] tmpArr = new Human[length + 1];

        System.arraycopy(this.children, 0, tmpArr, 0, length);
        tmpArr[length] = human;
        this.children = tmpArr;
        return true;
    }

    public boolean addPet(Pet pet) {
        int length = this.pet.length;
        Pet[] tmpArr = new Pet[length + 1];

        for (int i = 0; i < length; i++) {
            tmpArr[i] = this.pet[i];
        }
        tmpArr[length] = pet;
        this.pet = tmpArr;

        return true;
    }

    public boolean deleteChild(int arrIndex) {
        int length = this.children.length;
        if (arrIndex < length) {
            children[arrIndex].setFamily(null);
            Human[] tmpArr = Arrays.copyOfRange(children, 0, arrIndex);
            Human[] tmpArr2 = Arrays.copyOfRange(children, arrIndex + 1, length);
            Human[] tmpArr3 = new Human[length - 1];

            System.arraycopy(tmpArr, 0, tmpArr3, 0, tmpArr.length);
            System.arraycopy(tmpArr2, 0, tmpArr3, arrIndex, tmpArr2.length);
            System.out.println(Arrays.toString(tmpArr3));

            this.children = tmpArr3;
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteChild(Human child) {
        boolean isRemoved = false;

        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(child)) {
                isRemoved = deleteChild(i);
            }
        }
        return isRemoved;
    }

    public int countFamily() {
        return children.length + 2;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        flag = false;
        st.append("Family{")
                .append("\n mother=").append(mother)
                .append(",\n father=").append(father);

        if (children.length != 0) {
            flag = true;
            st.append(",\n children=").append(Arrays.toString(children));
        }
        if (pet.length != 0) {
            st.append(",\n pet=").append(Arrays.toString(pet)).append("\n");
        }
        st.append('}');
        return st.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) &&
                father.equals(family.father) &&
                Arrays.equals(children, family.children) &&
                Arrays.equals(pet, family.pet);
    }

//    @Override
//    public int hashCode() {
//        int result = Objects.hash(mother, father, Arrays.hashCode(pet));
//        result = 31 * result + Arrays.hashCode(children);
//        return result;
//    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family object is deleted by Garbage Collector");
    }

    @Override
    public Human bornChild() {
        Random random = new Random();
        // The sex of the child is defined casually with the 50%/50% probability. 0 or 1 - 50% chance
        int rndNum = random.nextInt(2);
        System.out.println(rndNum);
        Human child;
        if (rndNum == 0) {
            child = new Man();
        } else
            child = new Woman();

        // Here it is best to use HashMap to store names,
        // because it allows you to choose by key
        // (rndNum - by which the sex of the child is determined)
        names.put(0, Arrays.asList("Stanley","James","Bradley","Michael")); // for male
        names.put(1,Arrays.asList("Samantha","Vivian","Jess")); // for female

        int size = names.get(rndNum).size();
        child.setName(names.get(rndNum)
                            .get(random.nextInt(size)));

        child.setSurname(father.getSurname());
        int iq = (father.getIq() + mother.getIq()) / 2;
        child.setIq(iq);
        child.setYear(2022);

        child.setFamily(this);
        this.setChildren(child);

        return child;
    }
}