import java.awt.*;

public class CeckBox extends BaseComponent {


    static Color defaultForeground =  new Color(220, 220, 220);
    static boolean defaultIsChecked = false;
    

    /* ----------------------------- EXTERNAL ACCES ----------------------------- */
    private boolean isChecked;
    /* ----------------------------- INTERNAL ACCES ----------------------------- */
    private Rectangle myRect;


    CeckBox(int x, int y, int w, int h){
        super();
        setBounds(x, y , w, h);
        initCeckBox(x, y, w, h);
    }

    private void initCeckBox(int x, int y, int w, int h){
        isChecked = defaultIsChecked;
        myRect = new Rectangle(x, y, w, h);
        setForeground(defaultForeground);
        setIsHoverable(true);
        setIsRised(false);
    }


    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(getIsChecked()){
            g.setColor(super.getForeground());
            int off = 10;
            //g.fillRect(0 + myRect.width / off, 0 + myRect.height / off, myRect.width - 2 * (myRect.width/off), myRect.height - 2 * (myRect.height/off));
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(0 + myRect.width / off, 0 + myRect.height / off, myRect.width - myRect.width / off, myRect.height - myRect.height / off);
            g2.drawLine(0 + myRect.width / off, myRect.height - myRect.height / off, myRect.width - myRect.width / off, 0 + myRect.height / off);
        }
    }

    /* ---------------------------- SETTERS & GETTERS --------------------------- */
    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean newIsChecked) {
        this.isChecked = newIsChecked;
        repaint();
    }

    public void changeChecked(){
        setIsChecked(!getIsChecked());
    }


    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        super.mousePressed(e);
        if(getIsHoverable()){
            changeChecked();
        }
    }
    
}
