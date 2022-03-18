
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;




public class Editor extends BaseComponent{

/* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    
/* ----------------------------- INTERNAL ACCESS ---------------------------- */
    private Rectangle myRect;


    Editor(int x, int y, int w, int h){
        setBounds(x, y, w, h);
        myRect = new Rectangle(w, h);
        init();
    }

    void init(){
        setIsHoverable(false);
        setIsRised(true);
        setIsBorderVisible(false);
        setBackgroundColor(Color.lightGray);
        //super.setImgPath("src\\Test_image.jpg");
        setShowImg(true);
        setIsInteractive(false);
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    
    


    



    /* ---------------------------- SETTERS & GETTERS --------------------------- */

    
    
    /* -------------------------- END SETTERS & GETTERS ------------------------- */

    @Override
    public void mouseDragged(MouseEvent e){
        Graphics g = getGraphics();
        g.setColor(Info.c);
        g.fillOval((int)(e.getX() - Info.brushDiameter / 2), (int)(e.getY() - Info.brushDiameter / 2), (int)Info.brushDiameter, (int)Info.brushDiameter);
    }
}
