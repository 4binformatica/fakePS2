import javax.swing.JPanel;
import java.awt.*;

public class Layer{

    static int defaultrb = 255;
    static int defaultgb = 255;
    static int defaultbb = 255;
    static int defaultab = 0;

    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    int w;
    int h;
    boolean isVisible;
    int[][] color;

    /* ----------------------------- INTERNAL ACCES ----------------------------- */

    public Layer(int w, int h, int r, int g, int b, int a){
        init(w, h, r, g, b, a);
    }

    public Layer(int w, int h) {
        init(w, h, defaultrb, defaultgb, defaultbb, defaultab);
    }
    
    private void init(int w, int h, int r, int g, int b, int a){
        this.w = w;
        this.h = h;
        color = new int[w][h];
        Debugger.log("bg color: " + r + " " + g + " " + b + " " + a);
        setBackGroundColor(r, g, b, a);
    }

    public void drawBrush(int x, int y, int r, int g, int b, int a){
        color[x][y] = (a << 24) | (r << 16) | (g << 8) | b;
    }

    public void setBackGroundColor(int r, int g, int b, int a){
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                color[i][j] = (a << 24) | (r << 16) | (g << 8) | b;
            }
        }
    }
    
    
    

}
