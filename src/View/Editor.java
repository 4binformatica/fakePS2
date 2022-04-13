package View;

import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import Controller.Layer;
import Controller.LayerManager;
import Utils.Debugger;




public class Editor extends BaseComponent{

/* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    private int selectedLayer = 0;
/* ----------------------------- INTERNAL ACCESS ---------------------------- */
    private Rectangle myRect;
    private LayerManager layerManager;


    public Editor(int x, int y, int w, int h) {
        setBounds(x, y, w, h);
        myRect = new Rectangle(w, h);
       
        init();
    }

    void init() {
        setLayout(null);
        layerManager = new LayerManager();
        layerManager.addLayer(new Layer(myRect.width, myRect.height));
        setIsHoverable(false);
        setIsRised(true);
        setIsBorderVisible(false);
        setShowImg(true);
        setIsInteractive(false);
        addMouseMotionListener(this);
        addMouseListener(this);
        

        
        
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            g.drawImage(LayerManager.createView(myRect.width, myRect.height), 0, 0, null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Debugger.log("test");
            e.printStackTrace();
        } // see javadoc for more info on the parameters            
    }



    
    


    



    /* ---------------------------- SETTERS & GETTERS --------------------------- */

    
    
    /* -------------------------- END SETTERS & GETTERS ------------------------- */

    @Override
    public void mouseDragged(MouseEvent e){
        //LayerManager.dragging(e.getX(), e.getY());
        repaint();
    }

    
}
