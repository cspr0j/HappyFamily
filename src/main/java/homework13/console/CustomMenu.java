package homework13.console;

public class CustomMenu {

    public void mainPage() {
        StringBuilder builder = new StringBuilder();

        builder.append("Main Menu:\n");
        builder.append(" 1. Fill with test data\n");
        builder.append(" 2. Display the entire list of families\n");
        builder.append(" 3. Display a list of families where the number of people is greater that the specified number\n");
        builder.append(" 4. Display a list of families where the number of people is less that the specified number\n");
        builder.append(" 5. Calculate the number of families where the number of people equal to required number\n");
        builder.append(" 6. Create a new family\n");
        builder.append(" 7. Delete the family by its index in the general list\n");
        builder.append(" 8. Edit the family by its index in the general list\n");
        builder.append(" 9. Remove all children over the age of majority\n");
        builder.append(" 10. Exit \n");
        builder.append("Please enter the serial number of command: ");

        System.out.println(builder);
    }

    public void updateFamily() {
        StringBuilder builder = new StringBuilder();

        builder.append("Update Menu:\n");
        builder.append(" 1. Give birth to baby\n");
        builder.append(" 2. Adopt child\n");
        builder.append(" 3. Return to the main menu \n");
        builder.append("Please enter the serial number of command: ");

        System.out.println(builder);
    }
}
