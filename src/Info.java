import java.awt.*;

public class Info {


    static int width;
    static int height;
        
    static Color c = Color.blue;
    static float brushDiameter = 10;
    static boolean debug = true;
    static int selectedTool= 0;
    static int selectedLayer = 0;


    static Color defaultBackgroundColor = Color.white;

    //tool
    class Tool{
        public static final int BRUSH = 0;
        public static final int ERASER = 1;
        public static final int PEN = 2;
        public static final int LINE = 3;
        public static final int RECTANGLE = 4;
        public static final int CIRCLE = 5;
        public static final int FILL = 6;
        public static final int TEXT = 7;
        public static final int SELECT = 8;
        public static final int MOVE = 9;
        public static final int RESIZE = 10;
        public static final int ROTATE = 11;
        public static final int ZOOM = 12;
        public static final int PENCIL = 13;
        public static final int EYEDROPPER = 14;
        public static final int COLORPICKER = 15;
        public static final int PIPETTE = 16;
        public static final int PASTE = 17;
        public static final int SAVE = 18;
        public static final int LOAD = 19;
        public static final int UNDO = 20;
        public static final int REDO = 21;
        public static final int CUT = 22;
        public static final int COPY = 23;
        public static final int PASTE_INTO = 24;
        public static final int PASTE_INTO_LAYER = 25;
        public static final int PASTE_INTO_ALL = 26;
        public static final int PASTE_INTO_ALL_LAYER = 27;
        public static final int PASTE_INTO_ALL_LAYER_ONLY = 28;
        public static final int PASTE_INTO_ALL_LAYER_ONLY_ONLY = 29;
        public static final int PASTE_INTO_ALL_LAYER_ONLY_ONLY_ONLY = 30;
        public static final int PASTE_INTO_ALL_LAYER_ONLY_ONLY_ONLY_ONLY = 31;
        public static final int PASTE_INTO_ALL_LAYER_ONLY_ONLY_ONLY_ONLY_ONLY = 32;
    }
}


