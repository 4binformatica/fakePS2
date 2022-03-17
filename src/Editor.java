
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
        //super.setImgPath("src\\Test_image.jpg");
        setShowImg(true);
        setIsInteractive(false);
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    
    @Override
    public void mouseDragged(MouseEvent e){
        Graphics g = getGraphics();
        g.setColor(Info.c);
        g.fillOval(e.getX(), e.getY(), 10, 10);
    }

    



    /* ---------------------------- SETTERS & GETTERS --------------------------- */
    
    

}
