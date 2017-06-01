package codingpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wartree on 5/26/17.
 *
 */

public class TimeConversion {
    private static Logger LOGGER = LoggerFactory.getLogger(TimeConversion.class);

    public void convertTime(String str) {
        int hour = Integer.parseInt(str.substring(0,2));
        boolean isPM = (str.charAt(8) == 'P' || str.charAt(8) == 'p');
        StringBuilder newTime = new StringBuilder();

        if (!isPM && hour == 12) {
            newTime.append("00");
        }
        else if (isPM && hour != 12) {
            newTime.append(hour + 12);
        }
        else {
            if (hour < 10) {
                newTime.append("0").append(hour);
            }
            else {
                newTime.append(hour);
            }
        }
        newTime.append(str.substring(2,8));

        LOGGER.info("New Time:  {}", newTime.toString());
    }



    public void convertTime2(String str) {
        DateFormat inFormat = new SimpleDateFormat("hh:mm:ssaa");
        DateFormat outFormat = new SimpleDateFormat("HH:mm:ss");
        Date date;
        String newTime = "";

        try {
            date = inFormat.parse(str);
        }
        catch (ParseException e) {
            LOGGER.error("Bad Parsing of STR:  {}", str);
            date = null;
        }
        if (date != null) {
            newTime = outFormat.format(date);
        }

        LOGGER.info("New Time:  {}", newTime);
    }
}
