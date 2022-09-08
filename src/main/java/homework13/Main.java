package homework13;

import homework13.Human.Man;
import homework13.Human.Woman;
import homework13.console.CustomMenu;
import homework13.dao.FamilyController;
import homework13.logger.CustomLogger;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    private static final FamilyController controller = new FamilyController();

    public static void main(String[] args) throws Throwable {
        myConsoleApp();
    }

    /**
     * Main menu
     */
    public static void myConsoleApp() {
        CustomMenu displayMenu = new CustomMenu();
        boolean notExitCommand = true;


        while (notExitCommand) {
            displayMenu.mainPage();
            int selection = correctIntegerInput();

            switch (selection) {
                case 1:
                    CustomLogger.info("Loading data from file...");
                    fillWithData();
                    break;

                case 2:
                    CustomLogger.info("Receiving a Family list...");
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
                    System.out.println("Please enter command from menu or \"exit\" to close the application");
                    break;

            }
        }
    }

    private static void fillWithData() {
        controller.loadData();
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

            System.out.println("Enter mother's birthday");
            int motherBirthDay = correctIntegerInput();

            System.out.println("Enter mother's month of birth: ");
            int motherBirthMonth = correctIntegerInput();

            System.out.println("Enter mother's birth year: ");
            int motherBirthYear = correctIntegerInput();

            String birthDate = String.format("%d/%d/%d", motherBirthDay, motherBirthMonth, motherBirthYear);

            System.out.println("Enter mother's iq level:");
            int motherIq = correctIntegerInput();

            Woman mother = new Woman(motherName, motherSurname, birthDate, motherIq);

            System.out.println("Enter father's name:");
            String fatherName = scanner.next();

            System.out.println("Enter father's last name:");
            String fatherSurname = scanner.next();

            System.out.println("Enter father's birth day");
            int fatherBirthDay = correctIntegerInput();

            System.out.println("Enter father's month of birth: ");
            int fatherBirthMonth = correctIntegerInput();

            System.out.println("Enter father's birth year: ");
            int fatherBirthYear = correctIntegerInput();

            birthDate = String.format("%d/%d/%d", fatherBirthDay, fatherBirthMonth, fatherBirthYear);

            System.out.println("Enter father's iq level:");
            int fatherIq = correctIntegerInput();

            Man father = new Man(fatherName, fatherSurname, birthDate, fatherIq);
            controller.createNewFamily(father, mother);

            CustomLogger.info("Saving Family to file...");
            controller.saveData();

        } catch (NullPointerException | ParseException ex) {
            CustomLogger.error(ex.getMessage());
            System.out.println("Please enter valid data");
        }

    }

    private static void deleteFamilyByIndex() {
        System.out.println("Enter the number for searching");
        int index = correctIntegerInput();

        controller.deleteFamilyByIndex(index);

        CustomLogger.info("Saving Family to file...");
        controller.saveData();
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

            CustomLogger.info("Saving Family to file...");
            controller.saveData();
        } catch (NullPointerException | ParseException ex) {
            CustomLogger.error("Invalid data or null pointer");
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

            Family family = controller.getFamilyById(familyId);

            System.out.println("Enter the gender of child(male/female): ");
            String childGender = checkGender();

            System.out.println("Enter name: ");
            String name = scanner.next();

            System.out.println("Enter surname: ");
            String surname = scanner.next();

            System.out.println("Enter birth day: ");
            int birthDay = correctIntegerInput();

            System.out.println("Enter birth month: ");
            int birthMonth = correctIntegerInput();

            System.out.println("Enter birth year: ");
            int birthYear = correctIntegerInput();

            String birthDate = String.format("%d/%d/%d", birthDay, birthMonth, birthYear);

            System.out.println("Enter iq level: ");
            int iq = correctIntegerInput();

            if (childGender.equalsIgnoreCase("male")) {
                controller.adoptChild(family, new Man(name, surname, birthDate, iq));
            } else {
                controller.adoptChild(family, new Woman(name, surname, birthDate, iq));
            }

            CustomLogger.info("Saving Family to file...");
            controller.saveData();
        } catch (NullPointerException | ParseException ex) {
            CustomLogger.error(ex.getMessage());
            System.out.println("Invalid data. Please try again");
        }
    }

    /**
     * Deletes all children, who're older than 'num'
     */
    private static void removeChildrenOlderThan() {
        System.out.print("Older than: ");
        int num = correctIntegerInput();

        controller.deleteAllChildrenOlderThen(num);

        CustomLogger.info("Saving Family to file...");
        controller.saveData();
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

                if (input < 0) {
                    System.out.println("Wrong input. Please, try again");
                } else
                    return input;

            } catch (Exception e) {
                if (buffer.equalsIgnoreCase("exit")) {
                    return 10;
                }
                System.out.println("Wrong input. Please, try again");
            }
        }
    }

    /**
     * Check for correctness of the gender type
     */
    private static String checkGender() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String buffer = scanner.nextLine();
            if (buffer.equalsIgnoreCase("male") ||
                    buffer.equalsIgnoreCase("female")) {
                return buffer;
            } else {
                System.out.println("Wrong input. Please, try again");
            }
        }
    }
}