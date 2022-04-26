//import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.event.*;
//import javax.swing.JLabel;
import java.awt.*;

public class MainWindow extends JFrame implements MouseListener, MouseMotionListener{
    SuperButton b1 = new SuperButton(10, 100, 100, 100);
    SuperButton b2 = new SuperButton(120, 100, 100, 100);
    SuperButton addLayer = new SuperButton(10, 600, 100, 100);
    SuperButton changeup = new SuperButton(10, 700, 100, 100);
    SuperButton changedown = new SuperButton(10, 800, 100, 100);
    SuperButton reset = new SuperButton(10, 900, 100, 100);
    
    //slide for r 
    SuperSlider redS = new SuperSlider(10, 300, 200, 20);
    //slide for g
    SuperSlider greenS = new SuperSlider(10, 340, 200, 20);
    //slide for b
    SuperSlider blueS = new SuperSlider(10, 380, 200, 20);
    //slide for a   
    SuperSlider alphaS = new SuperSlider(10, 420, 200, 20);
    //slide for brush size
    SuperSlider dimS = new SuperSlider(10, 460, 200, 20);

    //box for red color
    Quadratino qr = new Quadratino(220, 300, 20, 20);
    //box for green color
    Quadratino qg = new Quadratino(220, 340, 20, 20);
    //box for blue color
    Quadratino qb = new Quadratino(220, 380, 20, 20);
    //box for alpha color
    Quadratino qa = new Quadratino(220, 420, 20, 20);
    //box for the final color
    Quadratino qtot = new Quadratino(10, 260, 20, 20);
    
    Editor edit = new Editor(250, 100, 600, 600);
    SuperButton sb = new SuperButton(10, 500, 100, 100);
    public MainWindow(){
        this.setBounds(10, 10, 1500, 1500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setTitle("Paint");
        this.thingsToAdd();
        this.setVisible(true);
        this.setResizable(false);
    }

    private void thingsToAdd(){
        b1.setLabel("seleziona file");
        this.add(b1);

        b1.addListener(new SuperButtonListenerInterface() {
            @Override
            public void click() {
                // First button actions
                Debugger.log("b1 clicked");
                openOpener();
                
            }
        });

        sb.addListener(new SuperButtonListenerInterface() {
            @Override
            public void click() {
                // First button actions
                Debugger.log("sb clicked");
                edit.saveEditor();
            }
        });

        addLayer.addListener(new SuperButtonListenerInterface() {
            @Override
            public void click() {
                // First button actions
                Debugger.log("add layer");
                edit.layerManager.addLayer();
            }
        });

        changeup.addListener(new SuperButtonListenerInterface() {
            @Override
            public void click() {
                // First button actions
                Debugger.log("up layer");
                Info.selectedLayer++;
                Debugger.log("selected layer: " + Info.selectedLayer);
            }
        });

        changedown.addListener(new SuperButtonListenerInterface() {
            @Override
            public void click() {
                // First button actions
                Debugger.log("down layer");
                Info.selectedLayer--;
                Debugger.log("selected layer: " + Info.selectedLayer);
            }
        });

        reset.addListener(new SuperButtonListenerInterface() {
            @Override
            public void click() {
                // First button actions
                Debugger.log("down layer");
                Info.selectedLayer= 0;
                Debugger.log("selected layer: " + Info.selectedLayer);
            }
        });




        b2.addListener(new SuperButtonListenerInterface() {
            @Override
            public void click() {
                Debugger.log("b2 clicked");
                setEditorImage();
                
            }
        });

        redS.addListener(new SuperSliderListenerInterface() {
            @Override
            public void slide(){
                Debugger.log("redS slided");
                setColor();
            }
        });

        greenS.addListener(new SuperSliderListenerInterface() {
            @Override
            public void slide(){
                Debugger.log("greenS slided");
                setColor();
            }
        });

        blueS.addListener(new SuperSliderListenerInterface() {
            @Override
            public void slide(){
                Debugger.log("blueS slided");
                setColor();
            }
        });

        dimS.addListener(new SuperSliderListenerInterface() {
            @Override
            public void slide(){
                Debugger.log("dimS slided");
                setColor();
            }
        });

        alphaS.addListener(new SuperSliderListenerInterface() {
            @Override
            public void slide(){
                Debugger.log("alphaS slided");
                setColor();
            }
        });
        
        redS.setMin(0);
        redS.setMax(255);
        this.add(redS);

        greenS.setMin(0);
        greenS.setMax(255);
        
        this.add(greenS);

        blueS.setMin(0);
        blueS.setMax(255);
        
        this.add(blueS);

        alphaS.setMin(0);
        alphaS.setMax(255);
        add(alphaS);

        dimS.setMin(1);
        dimS.setMax(100);
        
        this.add(dimS);
        this.add(edit);
        b2.setLabel("conferma");
        this.add(b2);

        add(addLayer);
        addLayer.setLabel("aggiungi layer");

        add(changeup);
        changeup.setLabel("up layer");
        add(changedown);
        changedown.setLabel("down layer");

        add(reset);
        reset.setLabel("reset");

        
        this.add(sb);
        sb.setLabel("salva");

        this.add(qr);   
        this.add(qg);
        this.add(qb);
        this.add(qa);
        this.add(qtot);
        
        
    }
    


    @Override
    public void mouseClicked(MouseEvent e) {
        
       /*  if(e.getComponent() == b1){
            new Opener();
        }
        if(e.getComponent() == b2){
            //edit.setImgPath(Opener.getFilePath());
            System.out.println(Opener.getFilePath());
            edit.setImgPath(Opener.getFilePath());
        }
        if(e.getComponent() == redS ||e.getComponent() == greenS ||e.getComponent() == blueS){
            Info.c = new Color((int) redS.getValue(), (int) greenS.getValue(),(int) blueS.getValue());
        }

        if(e.getComponent() == dimS){
            Info.brushDiameter = (float)dimS.getValue();
        } */
        
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

    @Override
    public void mouseDragged(MouseEvent e) {
        /* if(e.getComponent() == redS ||e.getComponent() == greenS ||e.getComponent() == blueS){
            Info.c = new Color((int) redS.getValue(), (int) greenS.getValue(),(int) blueS.getValue());
        }
        if(e.getComponent() == dimS){
            Info.brushDiameter = (float)dimS.getValue();
        } */
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    /* ------------------------------ BUTTON EVENT ------------------------------ */

    /**
     * <h3>openOpener Method()</h3>
     * <p>
     * This method can open the opener class.
     * </p>
     */
    private void openOpener(){
        Debugger.log("Let's Open the Opener");
        new Opener();    
    }

    private void setEditorImage(){
        Debugger.log(Opener.getFilePath());
        edit.setImgPath(Opener.getFilePath());

    }

    /* ------------------------------ END BUTTON EVENT -------------------------- */

    /* ------------------------------ SLIDER EVENT ------------------------------ */
    
    private void setColor(){
        /* qr.setColor(((int)redS.getValue() << 16) | (0 << 8) | 0); //red
        qg.setColor((0 << 16) | ((int)greenS.getValue() << 8) | 0); //green
        qb.setColor((0 << 16) | (0 << 8) | ((int)blueS.getValue())); //blue
        qa.setColor(((int)alphaS.getValue() << 24) | (255 << 16) | (255 << 8) | (255)); //alphaS
        qtot.setColor(((int)alphaS.getValue() << 24) | ((int)redS.getValue() << 16) | ((int)greenS.getValue() << 8) | ((int)blueS.getValue())); //tot */

        int r = (255 << 24) | ((int)redS.getValue() << 16) | (0 << 8) | 0;

        int g = (255 << 24) | (0 << 16) | ((int)greenS.getValue() << 8) | 0;

        int b = (255 << 24) | (0 << 16) | (0 << 8) | (int)blueS.getValue();

        int a = (255 << 24) | ((int)alphaS.getValue() << 16) | ((int)alphaS.getValue() << 8) | (int)alphaS.getValue();

        int tot = (255 << 24) | ((int)redS.getValue() << 16) | ((int)greenS.getValue() << 8) | (int)blueS.getValue();


        qr.setColor(r);
        qg.setColor(g);
        qb.setColor(b);
        qa.setColor(a);
        qtot.setColor(tot);



        Info.c = new Color((int) redS.getValue(), (int) greenS.getValue(),(int) blueS.getValue(), (int) alphaS.getValue());
        Info.brushDiameter = (float) dimS.getValue();
        Debugger.log(Info.c);
    }

    /* ---------------------------- END SLIDER EVENT ---------------------------- */
    
}
