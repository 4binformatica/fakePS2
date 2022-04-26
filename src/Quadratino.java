import java.awt.*;

public class Quadratino extends BaseComponent{
    //make the constructor
    public Quadratino(int x, int y, int w, int h) {
        setBounds(x, y, w, h);
        init();
    }

    private void init() {
        // TODO Auto-generated method stub
        setIsHoverable(false);
    }


    
    public void setColor(int color) {
        //get a from the color
        int a = (color >> 24) & 0xFF;
        //get r from the color
        int r = (color >> 16) & 0xFF;
        //get g from the color
        int g = (color >> 8) & 0xFF;
        //get b from the color
        int b = (color >> 0) & 0xFF;

        Debugger.log(r + " " + g + " " + b + " " + a);
        setBackgroundColor(new Color(r, g, b, a));
    }
}

        