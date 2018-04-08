import org.apache.http.client.utils.DateUtils;

import java.util.Date;

/**
 * @author Liukx
 * @create 2017-06-15 11:00
 * @email liukx@elab-plus.com
 **/
public class TestWenzhang {


    /**
     *

     *
     *
     */

    public static void main(String[] args) {
        String time = "Wed, 07 Apr 2021 06:17:01 GMT";
        String datepatterns [] = {"EEE, dd-MMM-yy HH:mm:ss z","EEE, d MMM yyyy HH:mm:ss Z"};
        Date date = DateUtils.parseDate(time, datepatterns);
        System.out.println(date);
    }
}
