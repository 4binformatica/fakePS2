import java.awt.*;
import java.awt.geom.Ellipse2D;
//import java.awt.event.*;

import java.awt.event.*;


public class SuperSlider extends BaseComponent{
    static double defaultValue = 50;
    static double defaultMin = 0;
    static double defaultMax = 100;

    /* ----------------------------- EXTERNAL ACCES ----------------------------- */
    private double value;
    private double max;
    private double min;

    /* ----------------------------- INTERNAL ACCES ----------------------------- */
    private Rectangle myRect;
    private int ellipseY = 0;
    private double pPerc;
    private int radius;

    

    

    SuperSlider(int x, int y, int w, int h){
        setBounds(x, y ,w, h);
        myRect = new Rectangle(w, h);
        radius = h;
        init();
    }

    public void init()
    {
        value = defaultValue;
        max = defaultMax;
        min = defaultMin;
        setIsHoverable(false);
    }


    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.WHITE);
        getSliderPerc();
        g2.fill(new Ellipse2D.Double(pPerc, ellipseY,radius,radius));
        
    }

    private void getSliderPerc(){
        pPerc = ((value - min) / (max - min)) * (myRect.width - radius);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if(!(e.getX() > pPerc && e.getX() < pPerc + radius)){
            moveInMouseX(e.getX());
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if(e.getX() > pPerc && e.getX() < pPerc + radius){
            moveInMouseX(e.getX());
        }

    }

    private void moveInMouseX(double mx){
        double totalRange = max - min;
        double perc = mx / myRect.width;
        double buffer = totalRange * perc;
        value = min + buffer;
        repaint();
    }

    public static double clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }

    /* ---------------------------- GETTER & SETTERS ---------------------------- */
    public double getMax() {
        return this.max;
    }

    public void setMax(double max) {
        if(max != this.min){
            this.max = max;
            setValue(max/2);
        }
        else{
            System.err.println("max same as min---nothing changed");
        }
            
            
        repaint();

    }

    public double getMin() {
        return this.min;
    }

    public void setMin(double min) {
		if(min != this.max)
            this.min = min;
        else{
            System.err.println("min same as max---nothing changed");
        }
        repaint();
	}

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        if(value >= min && value <= max)
            this.value = value;
        else{
            this.value = max / 2;
            System.err.println("value out bounds");
        }
        repaint();
    }

    
}
