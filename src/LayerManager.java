import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;

public class LayerManager {
    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    private ArrayList<Layer> LayerList = new ArrayList<>();
    /* ----------------------------- INTERNAL ACCESS ---------------------------- */
    int[][] red;
    int[][] green;
    int[][] blue;
    byte[] image; 

    LayerManager() {
        image = new byte[Info.width * Info.height];
        red = new int[Info.width][Info.height];
        green = new int[Info.width][Info.height];
        blue = new int[Info.width][Info.height];
    }

    public void dragging(int x, int y) {
        switch (Info.selectedTool) {
            case Info.Tool.BRUSH:
                
                // check if x and y are in the bounds of the layer
                if (x >= 0 && x < LayerList.get(Info.selectedLayer).w && y >= 0
                        && y < LayerList.get(Info.selectedLayer).h) {
                    Debugger.log(x + " " + y);
                    LayerList.get(Info.selectedLayer).drawBrush(x, y, Info.c.getRed(), Info.c.getGreen(), Info.c.getBlue());
                    
                }
                
                break;
        }
        updatePixel(x, y);
    }

    public void addLayer(Layer newLayer) {
        this.LayerList.add(newLayer);
        overlapLayers();
    }

    private void overlapLayers() {
        // the layer in index 0 is the background and the last layer is the one nearer to user
        red = LayerList.get(0).red;
        green = LayerList.get(0).green;
        blue = LayerList.get(0).blue;
        for (int i = 0; i < LayerList.size(); i++) {
            if(LayerList.get(i).isVisible){
                for (int j = 0; j < LayerList.get(i).w; j++) {
                    for (int k = 0; k < LayerList.get(i).h; k++) {
                        int layerRed = LayerList.get(i).red[j][k];
                        int layerGreen = LayerList.get(i).green[j][k];
                        int layerBlue = LayerList.get(i).blue[j][k];
                        if (layerRed != -1 && layerGreen != -1 && layerBlue != -1) {
                            red[j][k] = layerRed;
                            green[j][k] = layerGreen;
                            blue[j][k] = layerBlue;
                        }
                    }
                }
            }
        }

    }

    public BufferedImage getImage() {
        BufferedImage image = new BufferedImage(red.length, red[0].length, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < red.length; i++) {
            for (int j = 0; j < red[0].length; j++) {

                if (red[i][j] == -1 || green[i][j] == -1 || blue[i][j] == -1) {
                    image.setRGB(i, j, Info.defaultBackgroundColor.getRGB());
                } else {

                    int rgb = new Color(red[i][j], green[i][j], blue[i][j]).getRGB();
                    //Debugger.log("rgb: " + rgb);
                    image.setRGB(i, j, rgb);
                }

            }
        }

        // save the image to a file

        return image;
    }
        
        
    private int convertToHex(int r, int g, int b) {
        int rgb = (r << 16) | (g << 8) | b;
        //Debugger.log(rgb);
        return rgb;
    }

    // noi abbiamo i vettori uno per rosso verde e blu 
    private void updatePixel(int x, int y) {
        if (x >= 0 && x < LayerList.get(Info.selectedLayer).w && y >= 0 && y < LayerList.get(Info.selectedLayer).h) {
            Debugger.log("so dentro");
            red[x][y] = LayerList.get(0).red[x][y];
            green[x][y] = LayerList.get(0).green[x][y];
            blue[x][y] = LayerList.get(0).blue[x][y];
    
    
            for(int i = 1; i < LayerList.size(); i++){
                if(LayerList.get(i).isVisible){
                    if(LayerList.get(i).red[x][y] != -1 && LayerList.get(i).green[x][y] != -1 && LayerList.get(i).blue[x][y] != -1){
                        red[x][y] = LayerList.get(i).red[x][y];
                        green[x][y] = LayerList.get(i).green[x][y];
                        blue[x][y] = LayerList.get(i).blue[x][y];
                    }
                }
            }
            
            Debugger.log("rgb: " + red[x][y] + " " + green[x][y] + " " + blue[x][y]);
        }
        
        
    }
        
        
    



}
