package homework13.console;

public class CustomMenu {

    public void mainPage() {

        String menu = "Main Menu:\n" +
                " 1. Fill with test data\n" +
                " 2. Display the entire list of families\n" +
                " 3. Display a list of families where the number of people is greater that the specified number\n" +
                " 4. Display a list of families where the number of people is less that the specified number\n" +
                " 5. Calculate the number of families where the number of people equal to required number\n" +
                " 6. Create a new family\n" +
                " 7. Delete the family by its index in the general list\n" +
                " 8. Edit the family by its index in the general list\n" +
                " 9. Remove all children over the age of majority\n" +
                " 10. Exit \n" +
                "Please enter the serial number of command: ";

        System.out.println(menu);
    }

    public void updateFamily() {

        String updateMenu = "Update Menu:\n" +
                " 1. Give birth to baby\n" +
                " 2. Adopt child\n" +
                " 3. Return to the main menu \n" +
                "Please enter the serial number of command: ";

        System.out.println(updateMenu);
    }
}
