package teamie.ayesh.wikigame.utils;

/**
 * Created by ayesh on 9/11/15.
 */
public class Utils {


    public static int getRandomNumber() throws Exception {
        try {

            long value = System.currentTimeMillis();


            return safeLongToInt(value);


        } catch (Exception e) {
            throw e;
        }
    }


    public static int safeLongToInt(long l) {
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {

            return 1;
        }
        return (int) l;
    }
}
