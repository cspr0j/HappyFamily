package homework12;

import homework12.Human.Human;
import homework12.Human.Man;
import homework12.Human.Woman;
import homework12.Pets.Dog;
import homework12.Pets.Domestic_Cat;
import homework12.console.CustomMenu;
import homework12.dao.FamilyController;

import java.text.ParseException;
import java.util.*;

public class Main {
    private static final FamilyController controller = new FamilyController();

    public static void main(String[] args) throws Throwable {
        myConsoleApp();
    }

    /**
     * Main menu
     */
    public static void myConsoleApp() throws ParseException {
        CustomMenu displayMenu = new CustomMenu();
        boolean notExitCommand = true;


        while (notExitCommand) {
            displayMenu.mainPage();
            int selection = correctIntegerInput();

            switch (selection) {
                case 1:
                    fillWithData();
                    break;

                case 2:
                    controller.displayAllFamilies();
                    break;

                case 3:
                    getFamiliesGreaterThan();
                    break;

                case 4:
                    getFamiliesLessThan();
                    break;

                case 5:
                    countFamiliesWithMembersNumber();
                    break;

                case 6:
                    createNewFamily();
                    break;

                case 7:
                    deleteFamilyByIndex();
                    break;


                case 8:
                    updateFamily();
                    break;

                case 9:
                    removeChildrenOlderThan();
                    break;

                case 10:
                    notExitCommand = false;
                    System.out.println("Exiting app...");
                    break;

                default:
                    System.out.println("Please enter command from menu");
                    break;

            }
        }
    }

    private static void fillWithData() throws ParseException {
        Map<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.SUNDAY.name(), "watch a film");
        schedule.put(DayOfWeek.WEDNESDAY.name(), "meeting with friends");
        schedule.put(DayOfWeek.FRIDAY.name(), "Read a book");

        Dog dog = new Dog("Rock", 5, 50, new HashSet<>(Arrays.asList("sleep", "eat", "drink")));
        Domestic_Cat cat = new Domestic_Cat("Manny");
        cat.setAge(3);
        cat.setTrickLevel(70);
        cat.setHabits(new HashSet<>(Arrays.asList("eat", "sleep")));

        Man man = new Man("Johnathan", "Smith", "12/02/1990", 100, schedule);
        Woman woman = new Woman("Chrissy", "Smith", "28/12/1993", 80, schedule);
        Family family = new Family(man, woman);
        family.bornChild();
        family.setPet(new HashSet<>(Arrays.asList(dog, cat)));
        controller.addFamily(family);

        System.out.println("Success!");
    }

    private static void getFamiliesGreaterThan() {
        System.out.println("Enter the number for searching");
        int size = correctIntegerInput();

        System.out.printf("Families bigger than %d:\n", size);
        controller.getFamiliesBiggerThan(size);
    }


    private static void getFamiliesLessThan() {

        System.out.println("Enter the number for searching");
        int size = correctIntegerInput();

        System.out.printf("Families less than %d:\n", size);
        controller.getFamiliesLessThan(size);
    }


    private static void countFamiliesWithMembersNumber() {
        System.out.println("Enter the number for searching");
        int count = correctIntegerInput();

        System.out.printf("Families with %d members:\n", count);
        System.out.println(controller.countFamiliesWithMemberNumber(count));
    }

    /**
     * Creating family
     */
    private static void createNewFamily() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter mother's name:");
            String motherName = scanner.next();

            System.out.println("Enter mother's last name:");
            String motherSurname = scanner.next();

            System.out.println("Enter mother's birth year: ");
            int motherBirthYear = correctIntegerInput();

            System.out.println("Enter mother's month of birth: ");
            int motherBirthMonth = correctIntegerInput();

            System.out.println("Enter mother's birthday");
            int motherBirthDay = correctIntegerInput();

            String birthDate = String.format("%d/%d/%d", motherBirthDay, motherBirthMonth, motherBirthYear);

            System.out.println("Enter mother's iq");
            int motherIq = correctIntegerInput();

            Woman mother = new Woman(motherName, motherSurname, birthDate, motherIq);

            System.out.println("Enter father's name:");
            String fatherName = scanner.next();

            System.out.println("Enter father's last name:");
            String fatherSurname = scanner.next();

            System.out.println("Enter father's birth year: ");
            int fatherBirthYear = correctIntegerInput();

            System.out.println("Enter father's month of birth: ");
            int fatherBirthMonth = correctIntegerInput();

            System.out.println("Enter father's birthday");
            int fatherBirthDay = correctIntegerInput();

            birthDate = String.format("%d/%d/%d", fatherBirthDay, fatherBirthMonth, fatherBirthYear);

            System.out.println("Enter father's iq");
            int fatherIq = correctIntegerInput();

            Man father = new Man(fatherName, fatherSurname, birthDate, fatherIq);
            controller.createNewFamily(father, mother);

        } catch (NullPointerException | ParseException ex){
            System.out.println("Please enter valid data");
        }

    }

    private static void deleteFamilyByIndex() {
        System.out.println("Enter the number for searching");
        int index = correctIntegerInput();
        controller.deleteFamilyByIndex(index);
    }

    /**
     * Update menu
     */
    private static void updateFamily() {
        CustomMenu displayMenu = new CustomMenu();
        boolean notExitCommand = true;

        while (notExitCommand) {
            displayMenu.updateFamily();
            int selection = correctIntegerInput();

            switch (selection) {

                case 1:
                    giveBirthToChild();
                    break;

                case 2:
                    adoptChild();
                    break;

                case 3:
                    notExitCommand = false;
                    break;

                default:
                    System.out.println("Please enter command from menu");
                    break;
            }
        }
    }


    private static void giveBirthToChild() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter ID of family:");
            int familyId = correctIntegerInput();

            Family family = controller.getFamilyById(familyId);

            System.out.println("Enter name for boy");
            String boy = scanner.next();

            System.out.println("Enter name for girl");
            String girl = scanner.next();

            controller.bornChild(family, boy, girl);
            System.out.println("Successfully saved");
        }
        catch (NullPointerException | ParseException ex){
            System.out.println("Invalid data. Please try again");
        }
    }

    /**
     * Adopts child to family
     */
    private static void adoptChild() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter ID of family:");
            int familyId = correctIntegerInput();

            Family family= controller.getFamilyById(familyId);

            System.out.println("Enter name: ");
            String name = scanner.next();

            System.out.println("Enter surname: ");
            String surname = scanner.next();

            System.out.println("Enter birth year: ");
            int birthYear = correctIntegerInput();

            System.out.println("Enter birth month: ");
            int birthMonth = correctIntegerInput();

            System.out.println("Enter birth day: ");
            int birthDay = correctIntegerInput();

            String birthDate = String.format("%d/%d/%d", birthDay, birthMonth, birthYear);

            System.out.println("Enter level of intelligence");
            int iq = correctIntegerInput();

            controller.adoptChild(family, new Human(name, surname, birthDate, iq));
            System.out.println("Successfully saved");
        }
        catch (NullPointerException | ParseException ex){
            System.out.println("Invalid data. Please try again");
        }
    }

    /**
     * Deletes all children, who're older than 'num'
     */
    private static void removeChildrenOlderThan() {
        System.out.print("Older than: ");
        int num= correctIntegerInput();

        controller.deleteAllChildrenOlderThen(num);
    }

    /**
     * Check for correctness of the data
     */
    public static int correctIntegerInput() {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            String buffer = scanner.nextLine();

            try {
                input = Integer.parseInt(buffer);

                if (input < 0){
                    System.out.println("Wrong input. Please, try again");
                }else
                    return input;

            } catch (Exception e) {
                if(buffer.equalsIgnoreCase("exit")){
                    return 10;
                }
                System.out.println("Wrong input. Please, try again");
            }
        }
    }
}