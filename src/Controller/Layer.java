package Controller;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.w3c.dom.css.RGBColor;

import Utils.Debugger;

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
    byte[][][] bytes;

    public Layer(int w, int h) {
        this.w = w;
        this.h = h;
        bytes = new byte [w][h][4];

        Debugger.log("Layer created");
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                    bytes[i][j][0] = (byte) 51;
                    bytes[i][j][1] = (byte) 220;
                    bytes[i][j][2] = (byte) 255;
                    //Debugger.log(Byte.toUnsignedInt(bytes[i][j][1]));

            }
        }




        
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
