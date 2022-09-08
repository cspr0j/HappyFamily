package homework13;

import homework13.Human.Human;
import homework13.Human.HumanCreator;
import homework13.Human.Man;
import homework13.Human.Woman;
import homework13.Pets.Pet;
import homework13.date.Converter;

import java.io.Serializable;
import java.text.ParseException;
import java.util.*;


public class Family implements HumanCreator, Serializable {

    static final Map<Integer, List<String>> names;
    private static final long serialVersionUID = 7796724938947432723L;

    // displays only 1 time
    static {
        names = new HashMap<>();
        System.out.println("Family class is being loaded");
    }

    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;
    private boolean flag;

    // displays each time
    {
        System.out.println("New Family type  object is created");
    }

    public Family(Human father, Human mother) {
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
        pet = new HashSet<>();
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Family(Human father, Human mother, Set<Pet> pet) {
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
        this.pet = pet;

        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Family() {
        children = new ArrayList<>();
        pet = new HashSet<>();
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        this.mother.setFamily(this);
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
        this.father.setFamily(this);
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    //methods
    public boolean addChild(Human child) {
        children.add(child);
        child.setFamily(this);
        return true;
    }

    public boolean addPet(Pet pet) {
        this.pet.add(pet);
        return true;
    }

    public boolean deleteChild(int index) {
        int length = this.children.size();
        if (index < length) {
            this.children.get(index).setFamily(null);
            this.children.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteChild(Human child) {
        boolean isRemoved = false;

        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).equals(child)) {
                isRemoved = deleteChild(i);
            }
        }
        return isRemoved;
    }

    public int countFamily() {
        return children.size() + 2;
    }


    public String prettyFormat() {
        StringBuilder st = new StringBuilder();
        flag = false;
        st.append("family:")
                .append("\n\t mother: ").append(mother.prettyFormat()).append(",")
                .append("\n\t father: ").append(father.prettyFormat()).append(",");

        st.append("\n\t children: ");
        if (children.size() != 0) {
            flag = true;
            children.forEach(child ->
                    st.append(child.prettyFormat()));
        } else {
            st.append("No children");
        }
        st.append("\n\t pets: [");

        int[] size = {0};
        pet.forEach(myPet -> {
            st.append(myPet.prettyFormat());
            if (size[0] < pet.size() - 1) {
                st.append(", ");
            }
            size[0]++;
        });

        st.append("]");

        return st.toString();
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        flag = false;
        st.append("Family{")
                .append("\n mother=").append(mother)
                .append(",\n father=").append(father);

        if (children.size() != 0) {
            flag = true;
            st.append(",\n children=").append(children);
        }
        if (pet.size() != 0) {
            st.append(",\n pet=").append(pet).append("\n");
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
                Objects.equals(children, family.children) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, children);
        result = 31 * result;
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family object is deleted by Garbage Collector");
    }

    @Override
    public Human bornChild() throws ParseException {
        Random random = new Random();
        // The sex of the child is defined casually with the 50%/50% probability. 0 or 1 - 50% chance
        int rndNum = random.nextInt(2);

        Human child;
        if (rndNum == 0) {
            child = new Man();
        } else
            child = new Woman();

        // Here it is best to use HashMap to store names,
        // because it allows you to choose by key
        // (rndNum - by which the sex of the child is determined)
        names.put(0, Arrays.asList("Stanley", "James", "Bradley", "Michael")); // for male
        names.put(1, Arrays.asList("Samantha", "Vivian", "Jess")); // for female

        int size = names.get(rndNum).size();
        child.setName(names.get(rndNum)
                .get(random.nextInt(size)));

        child.setSurname(father.getSurname());
        int iq = (father.getIq() + mother.getIq()) / 2;
        child.setIq(iq);

        Converter converter = new Converter();
        double num = ((Math.random() * 0.11) + 0.79);

        String year = converter
                .converterToString((long) (Calendar.getInstance()
                        .getTimeInMillis() * num));

        child.setBirthDate(year);

        child.setFamily(this);
        this.addChild(child);

        return child;
    }
}
