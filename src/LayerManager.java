import java.util.ArrayList;

import javax.swing.JPanel;

public class LayerManager {
    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    private ArrayList<Layer> LayerList = new ArrayList<>();
    /* ----------------------------- INTERNAL ACCESS ---------------------------- */
    
    LayerManager(){
        
    }

    public void dragging(int x, int y){
        switch (Info.selectedTool) {
            case Info.Tool.BRUSH:
                Debugger.log(LayerList.get(Info.selectedLayer));
                LayerList.get(Info.selectedLayer).drawBrush(x, y);
                break;
        }
    }

    public void addLayer(Layer newLayer){
        this.LayerList.add(newLayer);
    }

    public void addOn(JPanel bg){
        for(Layer l : LayerList){
            Debugger.log("I add this " + l);
            bg.add(l);
        }
    }


    
}
