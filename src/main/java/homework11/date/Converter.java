package homework11.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public  class Converter {
    private final SimpleDateFormat formatForDate = new SimpleDateFormat("dd/MM/yyyy");

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
}
