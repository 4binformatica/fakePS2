import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.awt.Color;

public class LayerManager {
    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    private ArrayList<Layer> LayerList = new ArrayList<>();
    /* ----------------------------- INTERNAL ACCESS ---------------------------- */
    int[][] red;
    int[][] green;
    int[][] blue;

    LayerManager() {

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
    }

    public void addLayer(Layer newLayer) {
        this.LayerList.add(newLayer);
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
        overlapLayers();
        BufferedImage image = new BufferedImage(red.length, red[0].length, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < red.length; i++) {
            for (int j = 0; j < red[0].length; j++) {

                if (red[i][j] == -1 || green[i][j] == -1 || blue[i][j] == -1) {
                    image.setRGB(i, j, Color.WHITE.getRGB());
                } else {

                    int rgb = new Color(red[i][j], green[i][j], blue[i][j]).getRGB();
                    Debugger.log("rgb: " + rgb);
                    image.setRGB(i, j, rgb);
                }

            }
        }

        // save the image to a file

        return image;
    }

}
