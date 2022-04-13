import javax.swing.JPanel;
import java.awt.*;

public class Layer{

    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    int w;
    int h;
    boolean isVisible;
    int[][] red;
    int[][] green;
    int[][] blue;

    /* ----------------------------- INTERNAL ACCES ----------------------------- */

    public Layer(int w, int h) {
        this.w = w;
        this.h = h;
        red = new int[w][h];
        green = new int[w][h];
        blue = new int[w][h];

        //fill all the matrix with -1
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                red[i][j] = -1;
                green[i][j] = -1;
                blue[i][j] = -1;
            }
        }
    }

    public void drawBrush(int x, int y, int r, int g, int b){
        red[x][y] = r;
        green[x][y] = g;
        blue[x][y] = b;
    }
    

}
