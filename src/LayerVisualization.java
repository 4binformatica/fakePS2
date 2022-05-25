import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class LayerVisualization extends BaseComponent {

    Rectangle myRect;

    /* ----------------------------- INTERNAL ACCESS ---------------------------- */
    ArrayList<LayerUI> layeruilist = new ArrayList<LayerUI>();
    
    LayerVisualization(LayerManager lm, int x, int y, int w, int h){
        super();
        setLayout(null);
        initLayerVisualization(lm, x, y, w, h);
    }

    void initLayerVisualization(LayerManager lm, int x, int y, int w, int h){
        myRect = new Rectangle(x, y, w, h);
        setBounds(x, y , w, h);
        //setIsHoverable(false);
        //setIsRised(false);
        for(int i =0; i<lm.LayerList.size(); i++){
        
            layeruilist.add(new LayerUI(lm.LayerList.get(i), 0, i*100, w, 100));

            //Debugger.log(lm.LayerList.get(i).getName());
            
        }
        


        //make the paint method
        

    }

    public void paint(Graphics g){
        super.paint(g);
        for(int i=0; i<layeruilist.size(); i++){
            layeruilist.get(i).paint(g);
            layeruilist.get(i).updateLayerUI();
            Debugger.log(i);
        }
    }

    public void updateLayerVisualization(){
        
        repaint();
    }





    
}
