package homework13.date;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public  class Converter implements Serializable {
    private static final long serialVersionUID = -4978389465146587433L;
    private final SimpleDateFormat formatForDate = new SimpleDateFormat("dd/MM/yyyy");

    private final SimpleDateFormat formatForLoggerDate = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public long converterToTimestamp(String date) throws ParseException {
        try {
            return formatForDate.parse(date).getTime();
        } catch (ParseException e) {
            throw new ParseException("Sorry, you can't convert this date to Unix Millis Timestamp", 0);
        }
    }

    public String converterToString(long date) {
        return formatForDate.format(date);
    }

    public String loggerFormat(long date) {
        return formatForLoggerDate.format(date);
    }
}
