package Controller;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultButtonModel;
import javax.swing.JPanel;
import java.awt.event.*;

import Utils.Debugger;

import java.awt.Graphics;

public class LayerManager implements MouseListener, MouseMotionListener{
    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    private ArrayList<Layer> LayerList = new ArrayList<>();
    /* ----------------------------- INTERNAL ACCESS ---------------------------- */
    
    private int x;
    private int y;
    private Layer SelectedLayer;
    public LayerManager(){
        
    }

    public void dragging(int x, int y){
        switch (Info.selectedTool) {
            case Info.Tool.BRUSH:
                Debugger.log(LayerList.get(Info.selectedLayer));
                
                SelectedLayer = LayerList.get(Info.selectedLayer);
                SelectedLayer.pixels[x][y] = new Color(255, 255, 255).getRGB();
                break;
        }
    }


    public void createView(JPanel panel, Graphics g){
        for(Layer layer : LayerList){
            for(int i = 0; i < layer.w; i++){
                for(int j = 0; j < layer.h; j++){
                    
                    g.setColor(new Color(layer.pixels[i][j]));
                    g.drawLine(i, j, i, j);
                    panel.repaint();
                }
            }
        }
    }

    public void addLayer(Layer newLayer){
        this.LayerList.add(newLayer);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    // aggiungere una funziona che aggiunge i layer alla lista
    /*public void addOn(JPanel bg){
        for(Layer l : LayerList){
            Debugger.log("I add this " + l);
            bg.add(l);
        }
    }*/


    
}
