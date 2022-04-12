package Controller;
//package testproject;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.*;
import java.util.List;

import View.BaseComponent;

public class SuperButton extends BaseComponent{
    
    static Color defaultTextColor =  new Color(220, 220, 220);
    static Font defaultTextFont = new Font("assets/fonts/Ubuntu-Bold.ttf", Font.BOLD, 12);
    static String defaultLabel = "";
    static boolean defaultIsPressable = true;
   
    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    private boolean isPressable;
    private Color textColor;
    private Font textFont;
    private String label;
    private List<SuperButtonListenerInterface> listeners = new ArrayList<>();



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
        isPressable = defaultIsPressable;
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
        if(isPressable){
            super.setIsRised(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        super.mouseClicked(e);
        if(isPressable){
            startAction();
        }
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        super.mouseReleased(e);
        if(isPressable){
            super.setIsRised(true);
        }
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

    public void setIsPressable(boolean newIsPressable){
        isPressable = newIsPressable;
        repaint();
    }

    public boolean getIsPressable(){
        return isPressable;
    }

    

    

    
    /* ENDS SETTERS & GETTERS */
    
    public void addListener(SuperButtonListenerInterface toAdd) {
        listeners.add(toAdd);
    }
    
    public void startAction() {
        //System.out.println("Hello!!");

        // Notify everybody that may be interested.
        for (SuperButtonListenerInterface hl : listeners)
            hl.click();
    }
}
