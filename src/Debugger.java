import java.util.*;

public class Debugger{
    static Date d;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static boolean isEnabled(){
        return Info.debug;
        
    }

    public static void log(Object o){
        if (Debugger.isEnabled()){
            updateDate();
            System.out.println(ANSI_GREEN+d.toString() + " [DEBUG] "+o.toString()+ANSI_RESET);
        }
    }

    public static void log(){
        if (Debugger.isEnabled()){
            updateDate();
            System.out.println(ANSI_GREEN+d.toString()+" [DEBUG] "+"\n"+ANSI_RESET);
        }
    }

    private static void updateDate(){
        d = new Date();
    }
}