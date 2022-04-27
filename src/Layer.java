

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
        color = new int[w][h];
        Debugger.log("bg color: " + r + " " + g + " " + b + " " + a);
        setBackGroundColor(r, g, b, a);
    }

    public int[] setPixel(int x, int y, int r, int g, int b, int a){
        color[x][y] = (a << 24) | (r << 16) | (g << 8) | b;
        int[] updatedPixels = {x, y};
        return updatedPixels;
    }

    public void setBackGroundColor(int r, int g, int b, int a){
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                color[i][j] = (a << 24) | (r << 16) | (g << 8) | b;
            }
        }
    }

    public int[] drawCircle(int x, int y, int r, int red, int green, int blue, int alpha){
        int[] updatedPixels = new int[w * h];
        int index = 0;
        int x0 = x - r;
        int y0 = y - r;
        int x1 = x + r;
        int y1 = y + r;
        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                if (Math.sqrt(Math.pow(i - x, 2) + Math.pow(j - y, 2)) <= r) {
                    //continue if out of bounds
                    if(i < 0 || i >= w || j < 0 || j >= h) continue;                    
                    setPixel(i, j, red, green, blue, alpha);
                    updatedPixels[index] = i;
                    updatedPixels[index + 1] = j;
                    index += 2;
                }
            }
        }
        return updatedPixels;
    }
    
    
    

}
