import java.util.ArrayList;
import java.awt.image.*;
import java.awt.Rectangle;

public class LayerManager {
    private ArrayList<Layer> LayerList = new ArrayList<>();
    private Rectangle myRect;
    private int[] pixels;
    

    public LayerManager(int w, int h ){
        myRect = new Rectangle(w, h);
        BufferedImage myImage;
        myImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        pixels = ((DataBufferInt) myImage.getRaster().getDataBuffer()).getData();
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0xffffffff;
        }
    }


    public void addLayer() {
        if(LayerList.size() == 0){
            LayerList.add(new Layer(myRect.width, myRect.height, Info.defaultBackgroundColor.getRed(), Info.defaultBackgroundColor.getGreen(), Info.defaultBackgroundColor.getBlue(), Info.defaultBackgroundColor.getAlpha()));
        }
        else{
            LayerList.add(new Layer(myRect.width, myRect.height));
        }
        overlapLayers();
    }

    public void updatePixel(int x, int y, int color) {
        int index = x + y * myRect.width;
        pixels[index] = color;
    }

    public BufferedImage updateImage(int x, int y, BufferedImage image){
        image.setRGB(x, y, pixels[x + y * myRect.width]);
        return image;
    }

    public BufferedImage getImage(BufferedImage image) {
        Debugger.log("getImage");
        for (int i = 0; i < myRect.width; i++) {
            for (int j = 0; j < myRect.height; j++) {
                int index = i + j * myRect.width;
                image.setRGB(i, j, pixels[index]);
            }
        }
        return image;
    }

    
    //TODO: FIXME:
    private void overlapPixel(int x, int y){
        int index = x + y * myRect.width;
        int alpha = 0;
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int k = LayerList.size() - 1; k >= 0; k--) {
            int[][] layerPixels = LayerList.get(k).color;
            alpha += (layerPixels[x][y] >> 24) & 0xff;
            red += (layerPixels[x][y] >> 16) & 0xff;
            green += (layerPixels[x][y] >> 8) & 0xff;
            blue += layerPixels[x][y] & 0xff;
        }
        alpha = alpha / LayerList.size();
        red = red / LayerList.size();
        green = green / LayerList.size();
        blue = blue / LayerList.size();
        pixels[index] = (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    private void overlapLayers(){
        Debugger.log("overlapLayers");
        for (int i = 0; i < myRect.width; i++) {
            for (int j = 0; j < myRect.height; j++) {
                overlapPixel(i, j);
            }
        }
    }

    public void dragging(int x, int y) {
        switch (Info.selectedTool) {
            case Info.Tool.BRUSH:
                // check if x and y are in the bounds of the layer
                if (x >= 0 && x < LayerList.get(Info.selectedLayer).w && y >= 0
                        && y < LayerList.get(Info.selectedLayer).h) {
                    //Debugger.log(x + " " + y);
                    LayerList.get(Info.selectedLayer).drawBrush(x, y, Info.c.getRed(), Info.c.getGreen(), Info.c.getBlue(), Info.c.getAlpha());
                    
                }
                
                break;
        }
        overlapPixel(x, y);
    }




}