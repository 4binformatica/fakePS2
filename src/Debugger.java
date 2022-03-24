import java.util.*;

public class Debugger{
    static Date d;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static boolean isEnabled(){
        return Info.debug;
        
    }

    public static void log(Object o){
        if (Debugger.isEnabled()){
            updateDate();
            System.out.println(ANSI_GREEN+d.toString() + " [DEBUG_LOG] "+o.toString()+ANSI_RESET);
        }
    }

    public static void log(){
        if (Debugger.isEnabled()){
            updateDate();
            System.out.println(ANSI_GREEN+d.toString()+" [DEBUG_LOG] "+ANSI_RESET);
        }
    }

    public static void warn(Object o){
        if (Debugger.isEnabled()){
            updateDate();
            System.out.println(ANSI_YELLOW+d.toString() + " [DEBUG_WARN] "+o.toString()+ANSI_RESET);
        }
    }

    public static void warn(){
        if (Debugger.isEnabled()){
            updateDate();
            System.out.println(ANSI_YELLOW+d.toString() + " [DEBUG_WARN] "+ANSI_RESET);
        }
    }

    public static void err(Object o){
        if (Debugger.isEnabled()){
            updateDate();
            System.out.println(ANSI_RED+d.toString() + " [DEBUG_ERR] "+o.toString()+ANSI_RESET);
        }
    }

    public static void err(){
        if (Debugger.isEnabled()){
            updateDate();
            System.out.println(ANSI_RED+d.toString() + " [DEBUG_ERR] "+ANSI_RESET);
        }
    }

    private static void updateDate(){
        d = new Date();
    }
}