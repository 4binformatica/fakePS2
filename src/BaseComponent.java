import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;


import javax.swing.JPanel;

import javax.imageio.*;
import java.io.*;
import java.awt.image.*;

public class BaseComponent extends JPanel implements MouseListener, MouseMotionListener
{
 
    static Color defaultBackgroundColor = new Color(40,40,40);
    static Color defaultHoverBackgroundColor = new Color(75,75,75);
    static boolean defaultIsBorderVisible = true;
    static boolean defaultIsHoverable = false;
    static boolean defaultIsInteractive = true;
    
    static Color defaultBorderColor1 = Color.white;
    static Color defaultBorderColor2 = Color.darkGray;
    static boolean defaultIsRised = false;
    static boolean defaultShowImg = false;
    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    
    private Color backgroundColor;
    private boolean isBorderVisible;
    private Color hoverBackgroundColor;
    private boolean isHoverable;
    private boolean isInteractive;

    private Color borderColor1;
    private Color borderColor2;
    private boolean isRised;
    private String imgPath;
    private boolean showImg;

    
    /* ----------------------------- INTERNAL USAGE ----------------------------- */
    private int width;
    private int height;
    private Rectangle myRect;
    private boolean isHover;
    private BufferedImage image;

    public BaseComponent(){
       backgroundColor = defaultBackgroundColor;  
       isBorderVisible = defaultIsBorderVisible;
       hoverBackgroundColor=defaultHoverBackgroundColor;
       borderColor1 = defaultBorderColor1;
       borderColor2 = defaultBorderColor2;
       isRised = defaultIsRised;
       isHover = false;
       isHoverable = defaultIsHoverable;
       showImg = defaultShowImg;
       isInteractive = defaultIsInteractive;
       manageInteraction();
    }
    
    @Override
    public void paint(Graphics g){
        Color backupColor = g.getColor();
        myRect = getBounds();
        width = myRect.width;
        height= myRect.height;
        
        /* disegno lo sfondo */
        Color bgColor = isHover && isHoverable ? hoverBackgroundColor : backgroundColor;
        g.setColor(bgColor); 
        g.fillRect(0,0,width,height);
        
        if (isBorderVisible){
            // Disegno il colore dei bordi in modo automatico

            //3d design get from: http://www.java2s.com/Tutorials/Java/Swing/Border/Create_a_Solid_3D_border_in_Java.htm
            width--;
            height--;
            if(isRised) g.setColor(borderColor1);
            else g.setColor(borderColor2);
            g.drawLine(0, 0 + height, 0, 0);
            g.drawLine(0, 0, 0 + width, 0);

            if(isRised) g.setColor(borderColor2);
            else g.setColor(borderColor1);
            g.drawLine(0 + width, 0, 0 + width, 0 + height);
            g.drawLine(0, 0 + height, 0 + width, 0 + height);

            /* int borderHue = 255 - (backgroundColor.getRed()+backgroundColor.getGreen()+backgroundColor.getBlue())/3;
            Color borderColor = new Color(borderHue,borderHue,borderHue);
            g.setColor(borderColor);
            g.drawLine(0,0,width,0);
            g.drawLine(0,0,0,height);
            borderHue = 255 - borderHue;
            borderColor = new Color(borderHue,borderHue,borderHue);
            g.setColor(borderColor);
            g.drawLine(width, 0, height, width);
            g.drawLine(0, height, height, width); */
        }        
        
        g.setColor(backupColor);
        
        if(showImg && image != null){
            g.drawImage(image, 0, 0, width, height, null);
        }
    }

    
    private String convertToJavaPath(String p){
        p = p.replace("\\", "\\\\");
        return p;
    }

    private String convertToRealPath(String p){
        p = p.replace("\\\\", "\\");
        return p;
    }


    private void setImageFromPath(String path){
        try {
            image = ImageIO.read(new File(path));
        } catch (Exception e) {
            image = null;
            System.err.println(e);
        }
        repaint();
    }

    private void manageInteraction(){
        if(isInteractive){
            addMouseListener(this);
            addMouseMotionListener(this);
        } else {
            removeMouseListener(this);
            removeMouseMotionListener(this);
        }
        setIsHoverable(isInteractive); 
    }
    
    /* ------------------------- BEGIN SETTERS & GETTERS ------------------------ */


    /**
     * <h3>void setBackgroundColor(Color newBackgroundColor)</h3>
     * <p>
     * setter method to set the color for the background of the BaseComponent
     * </p>
     */
    public void setBackgroundColor(Color newBackgroundColor)
    {
        backgroundColor = newBackgroundColor;
        repaint();
    }
    
    /**
     * <h3>Color getBackgroundColor()</h3>
     * <p>
     * getter method to get the color for the background of the BaseComponent 
     * </p>
     */
    public Color getBackgroundColor(){
        return backgroundColor;
    }
    
    /**
     * <h3>void setHoverBackgroundColor(Color newHoverBackgroundColor)</h3>
     * <p>
     * setter method to set the secondary color of the background of the BaseComponent while hovering it
     * </p>
     */
    public void setHoverBackgroundColor(Color newHoverBackgroundColor)
    {
        hoverBackgroundColor = newHoverBackgroundColor;
        repaint();
    }
    
    /**
     * <h3>Color getHoverBackgroundColor()</h3>
     * <p>
     * getter method to get the secondary color for the background of the BaseComponent while hovering it
     * </p>
     */
    public Color getHoverBackgroundColor(){
        return hoverBackgroundColor;
    }
    
    /**
     * <h3>void setIsBorderVisible(boolean newVisibility)</h3>
     * <p>
     * setter method to set if the border of the BaseComponent is visible
     * </p>
     */
    public void setIsBorderVisible(boolean newVisibility){
        isBorderVisible = newVisibility;
        repaint();
    }

    /**
     * <h3>boolean getIsBorderVisible()</h3>
     * <p>
     * getter method to get if the border of the BaseComponent is visible
     * </p>
     */
    public boolean getIsBorderVisible(){
        return isBorderVisible;
    }

    /**
     * <h3>void setIsHoverable(boolean newIsHoverable)</h3>
     * <p>
     * setter method to set if the BaseComponent is able change color while it is hovered
     * </p>
     */
    public void setIsHoverable(boolean newIsHoverable){
        isHoverable = newIsHoverable;
        repaint();
    } 

     /**
     * <h3>boolean getIsHoverable()</h3>
     * <p>
     * getter method to get if the BaseComponent is able change color while it is hovered
     * </p>
     */
    public boolean getIsHoverable(){
        return isHoverable;
    }

    /**
     * <h3>void setBorderColor1(Color newTopBorderColor)</h3>
     * <p>
     * setter method to set the top border color
     * </p>
     */
    public void setBorderColor1(Color newTopBorderColor){
        borderColor1 = newTopBorderColor;
        repaint();
    }
    /**
     * <h3>Color getBorderColor1()</h3>
     * <p>
     * getter method to get the top border color
     * </p>
     */
    public Color getBorderColor1(){
        return borderColor1;
    }

    /**
     * <h3>void setBorderColor2(Color newBottomBorderColor)</h3>
     * <p>
     * setter method to set the bottom border color
     * </p>
     */
    public void setBorderColor2(Color newBottomBorderColor){
        borderColor2 = newBottomBorderColor;
        repaint();
    }

    /**
     * <h3>Color getBorderColor2()</h3>
     * <p>
     * getter method to get the bottom border color
     * </p>
     */
    public Color getBorderColor2(){
        return borderColor2;
    }

    public void setIsRised(boolean newIsRised){
        isRised = newIsRised;
        repaint();
    }

    public boolean getIsRised(){
        return isRised;
    }

    public void setImgPath(String newImgPath){
        imgPath = convertToJavaPath(newImgPath);
        setImageFromPath(imgPath);
    }

    public String getImgPath(){
        return convertToRealPath(imgPath);
    }

    public void setShowImg(boolean newShowImg){
        showImg = newShowImg;
        repaint();
    }
    
    public boolean getShowImg(){
        return showImg; 
    }

    public void setIsInteractive(boolean newIsInteractive){
        isInteractive = newIsInteractive;
        manageInteraction();
    }

    public boolean getIsInteractive(){
        return isInteractive;
    }
    
    /* -------------------------- END SETTERS & GETTERS ------------------------- */



    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
       
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
       if(isHoverable){
        isHover = true;
        repaint();
       }
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
       if(isHoverable){
        isHover = false;
        repaint(); 
       }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    
}
