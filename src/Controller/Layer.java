package Controller;
import javax.swing.JPanel;

import org.w3c.dom.css.RGBColor;

import java.awt.*;

public class Layer {

    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    int w;
    int h;
    boolean isVisible;
    boolean isActive;
    String name;


    /* ----------------------------- INTERNAL ACCES ----------------------------- */
    int[][] pixels;

    public Layer(int w, int h) {
        this.w = w;
        this.h = h;
        pixels = new int[w][h];
        
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                pixels[i][j] = new Color(0, 0, 0).getRGB();

            }
        }

        pixels[10][90] = new Color(255, 255, 255).getRGB();
    }

    public void drawBrush(int x, int y) {
    }

}
