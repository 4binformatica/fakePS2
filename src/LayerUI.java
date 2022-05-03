import java.awt.*;
import java.awt.image.*;

public class LayerUI extends BaseComponent {
    /* ----------------------------- EXTERNAL ACCES ----------------------------- */
    private Layer layer;
    /* ----------------------------- INTERNAL ACCES ----------------------------- */
    Rectangle myRect;
    CeckBox myCeckBox;
    LayerUI(Layer l, int x, int y, int w, int h) {
        super();
        initLayerUI(l, x, y, w, h);
    }

    void initLayerUI(Layer l,int x, int y, int w, int h) {
        setBounds(x, y , w, h);
        setIsHoverable(false);
        setIsRised(false);
        layer = l;
        myRect = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        BufferedImage bf = resize(layer.getImage(), (int)(myRect.height* .75), (int)(myRect.height * .75));
        
        Graphics2D g2 = bf.createGraphics();
        g2.setColor(Color.white);
        g2.fillRect(0, 0, bf.getWidth(), bf.getHeight());
        g.drawImage(bf, (int)(myRect.height * 0.25) / 2, (int)(myRect.height * 0.25) / 2, null);        
    }
    public void updateLayerUI(){
        repaint();
    }

    public BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
    
        return dimg;
    }  
}
