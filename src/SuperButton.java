//package testproject;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

public class SuperButton extends BaseComponent{
    
    static Color defaultTextColor = new Color(220, 220, 220);
    static Font defaultTextFont = new Font("assets/fonts/Ubuntu-Bold.ttf", Font.BOLD, 12);
    static String defaultLabel = "";
   
    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    private Color textColor;
    private Font textFont;
    private String label;

    /* ----------------------------- INTERNAL ACCES ----------------------------- */
    private Rectangle myRect;
    
    
    
    
    public SuperButton(int w, int h){
        setSize(w, h);
        myRect = new Rectangle(w, h);
        initButton();
    }

    public SuperButton(int x, int y, int w, int h){
        setBounds(x, y, w, h);
        myRect = new Rectangle(w, h);
        initButton();
    }

    private void initButton(){
        label = defaultLabel;
        textColor = defaultTextColor;
        textFont = defaultTextFont;
        super.setIsHoverable(true);
        super.setIsRised(true);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(textColor);
        drawCenteredString(g, label, myRect, textFont);
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        super.mousePressed(e);
        super.setIsRised(false);
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        super.mouseReleased(e);
        super.setIsRised(true);
    }
    
    
    
    
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }
    

    
    
    
    /* BEGIN SETTERS & GETTERS */
    public void setTextColor(Color newTextColor){
        textColor = newTextColor;
        repaint();
    }

    public void setLabel(String newLabel){
        label = newLabel;
        repaint();
    }

    public String getLabel(){
        return label;
    }

    public Color getTextColor(){
        return textColor;
    }

    public void setTextFont(Font newTextFont){
        textFont = newTextFont;
        repaint();
    }

    public Font getTextFont(){
        return textFont;
    }




    
    /* ENDS SETTERS & GETTERS */
    
    
    
}
