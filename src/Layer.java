import java.awt.Point;
import java.awt.image.*;
import java.util.ArrayList;

public class Layer{

    static int defaultrb = 255;
    static int defaultgb = 255;
    static int defaultbb = 255;
    static int defaultab = 0;

    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    int w;
    int h;
    boolean isVisible = true;
    String name;
    int[][] color;
    BufferedImage image;

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
        color = new int[h][w];
        Debugger.log("bg color: " + r + " " + g + " " + b + " " + a);
        setBackGroundColor(r, g, b, a);
    }

    

    public void setBackGroundColor(int r, int g, int b, int a){
        for (int i = 0; i < w; i++)
            for (int j = 0; j < h; j++)
                color[j][i] = (a << 24) | (r << 16) | (g << 8) | b;
    }

//get image from color array
    public BufferedImage getImage(){
        if (image == null){
            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            WritableRaster raster = image.getRaster();
            for (int i = 0; i < w; i++)
                for (int j = 0; j < h; j++)
                    raster.setPixel(i, j, new int[]{color[j][i]});
        }
        return image;
    }


    private Point setPixel(int x, int y, int r, int g, int b, int a){
        color[y][x] = (a << 24) | (r << 16) | (g << 8) | b;
        return new Point(x, y);
    }
    

    public ArrayList<Point> drawCircle(int x, int y, int r, int red, int green, int blue, int alpha){        
        int x0 = x - r;
        int y0 = y - r;
        int x1 = x + r;
        int y1 = y + r;
        ArrayList<Point> updatedPixels = new ArrayList<Point>();
        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                if (Math.sqrt(Math.pow(i - x, 2) + Math.pow(j - y, 2)) <= r) {
                    //continue if out of bounds
                    if(i < 0 || i >= w || j < 0 || j >= h) continue;                    
                    setPixel(i, j, red, green, blue, alpha);
                    updatedPixels.add(new Point(i, j));
                }
            }
        }
        return updatedPixels;
    }

    public ArrayList<Point> eraseCircle(int x, int y, int r){
        return drawCircle(x, y, r, 0, 0, 0, 0);
    }

    public String getName(){
        return name;
    }

    
    
    

}
