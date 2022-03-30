import javax.swing.JPanel;
import java.awt.*;

public class Layer extends JPanel {

    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    int w;
    int h;
    boolean isVisible;
    boolean isActive;

    /* ----------------------------- INTERNAL ACCES ----------------------------- */

    public Layer(int w, int h) {
        this.w = w;
        this.h = h;
        setBounds(0, 0, w, h);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Info.c);
        g.fillOval(300, 300, 50, 50);

    }


    public void drawBrush(int x, int y){
            Graphics g = getGraphics();
            
            g.setColor(Info.c);
            g.fillOval((int) (x - Info.brushDiameter / 2), (int) (y - Info.brushDiameter / 2),
                            (int) Info.brushDiameter, (int) Info.brushDiameter); 
            Debugger.log();
    }

}
