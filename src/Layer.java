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

    public ArrayList<Point> fill(int x, int y, int t, int red, int green, int blue, int alpha){
        ArrayList<Point> updatedPixels = makeSelection(x, y, t);
        for (Point p : updatedPixels) {
            setPixel(p.x, p.y, red, green, blue, alpha);
        }
        return updatedPixels;
        
    }

    public ArrayList<Point> eraseCircle(int x, int y, int r){
        return drawCircle(x, y, r, 0, 0, 0, 0);
    }

    public String getName(){
        return name;
    }

    private ArrayList<Point> makeSelection(int x, int y, int tollerance){
        ArrayList<Point> points = new ArrayList<>();
        int[][] bounds = makeBinaryMatrix(x, y, tollerance);
        selectOnlyInnerPoints(x, y, bounds, points);
        return points;
    }

    
    private void selectOnlyInnerPoints(int x, int y, int[][] m, ArrayList<Point> p){
        p.add(new Point(x, y));
        m[y][x] = 0;
        if (x - 1 >= 0 && m[y][x - 1] == 1) selectOnlyInnerPoints(x - 1, y, m, p);
        if (x + 1 < w && m[y][x + 1] == 1) selectOnlyInnerPoints(x + 1, y, m, p);
        if (y - 1 >= 0 && m[y - 1][x] == 1) selectOnlyInnerPoints(x, y - 1, m, p);
        if (y + 1 < h && m[y + 1][x] == 1) selectOnlyInnerPoints(x, y + 1, m, p);
    }

    

    private int[][] makeBinaryMatrix(int x, int y, int tollerance){
        int[][] bounds = new int[h][w];
        int sc = color[y][x];
        int sr = (sc >> 16) & 0xFF;
        int sg = (sc >> 8) & 0xFF;
        int sb = sc & 0xFF;
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                int c = color[j][i];
                int r = (c >> 16) & 0xFF;
                int g = (c >> 8) & 0xFF;
                int b = c & 0xFF;
                if(Math.abs(sr - r) <= tollerance && Math.abs(sg - g) <= tollerance && Math.abs(sb - b) <= tollerance){
                    bounds[j][i] = 1;
                }
            }
        }
        return bounds;
    }



    


    
    
    

}
