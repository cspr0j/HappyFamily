package homework13.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CustomLogger {

    private static final Logger logger = Logger.getLogger(CustomLogger.class.getName());

    private static FileHandler fileHandler = null;

    public static void info(String message) {
        LogManager.getLogManager().reset();
        try {

            // This block configures the logger with handler and formatter
            fileHandler = new FileHandler("src/main/java/homework13/files/application.log", true);
            fileHandler.setLevel(Level.INFO);
            logger.addHandler(fileHandler);

            CustomFormatter fileFormatter = new CustomFormatter();
            fileHandler.setFormatter(fileFormatter);

            // the following statement is used to log any messages
            logger.info(message);

            fileHandler.close();

        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }


    public static void error(String message) {
        LogManager.getLogManager().reset();
        try {

            // This block configures the logger with handler and formatter
            fileHandler = new FileHandler("src/main/java/homework13/files/application.log", true);
            logger.addHandler(fileHandler);

            CustomFormatter fileFormatter = new CustomFormatter();
            fileHandler.setFormatter(fileFormatter);

            // the following statement is used to log any messages
            logger.warning(message);

            fileHandler.close();

        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }
}
