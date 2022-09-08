package homework13.logger;

import homework13.date.Converter;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        Converter converter = new Converter();
        String date = converter.loggerFormat(record.getMillis());

        builder.append(date);
        System.out.println(record.getLevel().getName());

        if (record.getLevel().getName().equals("INFO")) {
            builder.append(" [DEBUG]: ");
        } else if (record.getLevel().getName().equals("WARNING")) {
            builder.append(" [ERROR]: ");
        }
        builder.append(record.getMessage()).append("\n");

        return builder.toString();
    }
}
