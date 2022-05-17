
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;





public class Editor extends BaseComponent{

/* ----------------------------- EXTERNAL ACCESS ---------------------------- */
/* ----------------------------- INTERNAL ACCESS ---------------------------- */
    private Rectangle myRect;
    public LayerManager layerManager;
    private BufferedImage myImage;


    Editor(int x, int y, int w, int h){
        setBounds(x, y, w, h);
        myRect = new Rectangle(w, h);
        init();
    }

    void init(){
        layerManager = new LayerManager(myRect.width, myRect.height);
        Info.width = (int)myRect.getWidth();
        Info.height = (int)myRect.getHeight();
        setLayout(null);
        Debugger.log(myRect.width + " " + myRect.height);
        
        layerManager.addLayer();
        layerManager.getImage();
        setIsHoverable(false);
        setIsRised(true);
        setIsBorderVisible(false);
        setShowImg(true);
        setIsInteractive(false);
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    
    
    public void paint(Graphics g){
        super.paint(g);
        try {
            g.drawImage(layerManager.getImage() , 0, 0, null);
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }

    public void saveEditor(){
        try {
            BufferedImage bi = layerManager.getImage();  // retrieve image
            File outputfile = new File("pippo.png");
            ImageIO.write(bi, "png", outputfile);
        } catch (IOException e) {
            // handle exception
        }
    }
    



    /* ---------------------------- SETTERS & GETTERS --------------------------- */

    
    
    /* -------------------------- END SETTERS & GETTERS ------------------------- */

    @Override
    public void mouseDragged(MouseEvent e){
        layerManager.dragging(e.getX(), e.getY());
        repaint();   
    } 

    
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        super.mousePressed(e);
        layerManager.clicking(e.getX(), e.getY());
    }
}
