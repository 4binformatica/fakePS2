import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;

public class Saver {

    //INTERNAL ACCESS
    BufferedImage image;
    
    Saver(Editor panel, String name, String type){
        //save graphics to image
        image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        Graphics g = image.getGraphics();
        panel.paint(g);
        try{
            ImageIO.write(image, type, new File(name + "." + type));
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
