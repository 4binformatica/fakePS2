package Controller;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.w3c.dom.css.RGBColor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.image.DirectColorModel;

public class Layer {

    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    int w;
    int h;
    boolean isVisible;
    boolean isActive;
    String name;


    /* ----------------------------- INTERNAL ACCES ----------------------------- */
    byte[] bytes;

    public Layer(int w, int h) {
        this.w = w;
        this.h = h;
        
        
        BufferedImage bi = new BufferedImage(this.w, this.h, BufferedImage.TYPE_INT_RGB);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            ImageIO.write(bi, "jpg", baos );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        bytes = baos.toByteArray();
    }

    /*int[][] pixels;

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
    }*/



    public void drawBrush(int x, int y) {
    }

}
