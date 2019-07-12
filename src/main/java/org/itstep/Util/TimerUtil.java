package org.itstep.Util;

public class TimerUtil {
    public static void waitSeconds(int seconds){
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
