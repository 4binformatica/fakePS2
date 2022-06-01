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
        floodFill(x, y, bounds, points);
        return points;
    }

    /* public void riempiR(int[][] b, int x, int y, long coloreIniziale)
    {
        if (b[y][x]==0)
           return;
        if (sonoUnBordo(x,y,coloreIniziale))
           return;
        points[y][x] = coloreDesiderato;

        pw larghezza Pattern
        pattern[][x%pw]

        b[y][x] = 0;
        
        riempiR(b, x+1, y, coloreIniziale);
        riempiR(b, x-1, y, coloreIniziale);
        riempiR(b, x, y+1, coloreIniziale);
        riempiR(b, x, y-1, coloreIniziale);

    }

    public void riempi(int x, int y)
    {
        Colore coloreIniziale = pixel[y][x];
        riempiR(x,y,coloreIniziale)
    } */

    
    
    

    private void floodFill(int x, int y, int[][] bounds, ArrayList<Point> points){
        //if(x < 0 || x >= w - 1|| y < 0 || y >= h - 1) return;
        if (bounds[y][x] == 1)
            return;
        points.add(new Point(x, y));
        bounds[y][x] = 1;
        //tot++;
        //System.out.println(tot);
        floodFill(x + 1, y, bounds, points);
        floodFill(x - 1, y, bounds, points);
        floodFill(x, y + 1, bounds, points);
        floodFill(x, y - 1, bounds, points);
    }

    

    private int[][] makeBinaryMatrix(int x, int y, int tollerance){
        int[][] bounds = new int[h + 2][w + 2];
        
        
        for(int i=0; i<h+2; i++)
        {
           bounds[i][0] = 1;
           bounds[i][w+1] = 1;
        }
        for(int j=0; j<w+2; j++)
        {
           bounds[0][j] = 1;
           bounds[h+1][j] = 1;
        }

        int sc = color[y][x];
        int sr = (sc >> 16) & 0xFF;
        int sg = (sc >> 8) & 0xFF;
        int sb = sc & 0xFF;
        int vscolor = (sr+sg+sb)/3;
        for(int i = 1; i < w -1; i++){
            for(int j = 1; j < h - 1; j++){
                int c = color[j][i];
                int r = (c >> 16) & 0xFF;
                int g = (c >> 8) & 0xFF;
                int b = c & 0xFF;
                int vcolor = (r+g+b)/3;
                if(Math.abs(vcolor - vscolor) > tollerance)
                    bounds[j][i] = 1;
/*
                if(Math.abs(sr - r) <= tollerance && Math.abs(sg - g) <= tollerance && Math.abs(sb - b) <= tollerance){
                    bounds[j][i] = 1;
                }
                */
            }
        }
        return bounds;
    }
}
