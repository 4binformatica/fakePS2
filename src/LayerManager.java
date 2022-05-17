import java.util.ArrayList;
import java.awt.image.*;
import java.awt.Rectangle;
import java.awt.Point;

public class LayerManager {
    public ArrayList<Layer> LayerList = new ArrayList<>();
    private Rectangle myRect;
    private int[] pixels;
    private BufferedImage image;
    

    public LayerManager(int w, int h ){
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
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

    public BufferedImage updateImage(int x, int y){
        image.setRGB(x, y, pixels[x + y * myRect.width]);
        return image;
    }


    private void overlapPixel(int x, int y){
        //return if out of bounds
        if(x < 0 || x >= myRect.width || y < 0 || y >= myRect.height) return;
        
        int index = x + y * myRect.width;
        int backColor = LayerList.get(0).color[y][x];
        for(int i = 1; i < LayerList.size(); i++){
            Layer current = LayerList.get(i);
            if(!current.isVisible) continue;
            int foreColor =  current.color[y][x];
            int[] fc = {(foreColor >> 16) & 0xff, (foreColor >> 8) & 0xff, foreColor & 0xff, (foreColor >> 24) & 0xff};
            int[] bc = {(backColor >> 16) & 0xff, (backColor >> 8) & 0xff, backColor & 0xff, (backColor >> 24) & 0xff};

            int[] c = calculateColor(fc, bc);
            backColor = (c[3] << 24) | (c[0] << 16) | (c[1] << 8) | c[2];
        }
        pixels[index] = backColor;
        updateImage(x, y);
    }

    public int[] calculateColor(int[] f, int[] b){
        //calculate the sum of the color
        int[] c = new int[4];
        //calculate the generated color of f over b
        for(int i = 0; i < 4; i++){
            c[i] = (int) ((f[i] * f[3] + b[i] * (255 - f[3])) / 255);
        }

        //calculate the alpha
        c[3] =  b[3] + f[3] - b[3] * f[3] / 255;
        
        //clamp the color
        for(int i = 0; i < 3; i++){
            if(c[i] > 255){
                c[i] = 255;
            }
            else if(c[i] < 0){
                c[i] = 0;
            }
        }
        return c;
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
        
        //return if out of bounds
        ArrayList<Point> updatedPixels = new ArrayList<Point>();

        
        if(x < 0 || x >= myRect.width || y < 0 || y >= myRect.height) return;
        switch (Info.selectedTool) {
            case Info.Tool.BRUSH:                  
                updatedPixels = LayerList.get(Info.selectedLayer).drawCircle(x, y, (int)Info.brushDiameter, Info.c.getRed(), Info.c.getGreen(), Info.c.getBlue(), Info.c.getAlpha());
            break;
            case Info.Tool.ERASER:
                updatedPixels = LayerList.get(Info.selectedLayer).eraseCircle(x, y, (int)Info.brushDiameter);
            break;
            default:
                updatedPixels = new ArrayList<Point>();
            break;
        }

        for (int i = 0; i < updatedPixels.size(); i++) {
            overlapPixel(updatedPixels.get(i).x, updatedPixels.get(i).y);
        }
    }

    public void clicking(int x, int y) {
        //return if out of bounds
        ArrayList<Point> updatedPixels = new ArrayList<Point>();;
        if(x < 0 || x >= myRect.width || y < 0 || y >= myRect.height) return;
        switch (Info.selectedTool) {
            case Info.Tool.FILL:
                updatedPixels = LayerList.get(Info.selectedLayer).fill(x, y, 1, Info.c.getRed(), Info.c.getGreen(), Info.c.getBlue(), Info.c.getAlpha());
            break;
            default:
                updatedPixels = new ArrayList<Point>();
            break;
        }

        for (int i = 0; i < updatedPixels.size(); i++) {
            overlapPixel(updatedPixels.get(i).x, updatedPixels.get(i).y);
        }
    }

    

    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage getSingleImage(int layer){
        BufferedImage myImage;
        myImage = new BufferedImage(myRect.width, myRect.height, BufferedImage.TYPE_INT_ARGB);
        int[] pixels = ((DataBufferInt) myImage.getRaster().getDataBuffer()).getData();
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0xffffffff;
        }
        for (int i = 0; i < myRect.width; i++) {
            for (int j = 0; j < myRect.height; j++) {
                int index = i + j * myRect.width;
                pixels[index] = LayerList.get(layer).color[j][i];
            }
        }
        return myImage;
    }





}