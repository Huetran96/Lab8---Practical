package Pretest;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
    public static int getAge(Date date){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        if (cal1.after(cal2)){
            return -1;

        }
        return (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR) + 1);
    }
}
