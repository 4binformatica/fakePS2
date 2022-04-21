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
    SuperSlider s1 = new SuperSlider(10, 300, 200, 20);
    SuperSlider s2 = new SuperSlider(10, 340, 200, 20);
    SuperSlider s3 = new SuperSlider(10, 380, 200, 20);
    SuperSlider s4 = new SuperSlider(10, 420, 200, 20);
    Editor edit = new Editor(250, 100, 1000, 1000);
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
        //this.add(new CContainer(10, 10, 250, 400));
        //this.add(new MySlider(10, 10, 500, 500));
    	/*b1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
    		public void mouseClicked(java.awt.event.MouseEvent evt) {
                super.mouseClicked(evt);
                System.out.println("ciao");
            }
        });*/
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

        s1.addListener(new SuperSliderListenerInterface() {
            @Override
            public void slide(){
                Debugger.log("s1 slided");
                setColor();

            }
        });

        s2.addListener(new SuperSliderListenerInterface() {
            @Override
            public void slide(){
                Debugger.log("s2 slided");
                setColor();
            }
        });

        s3.addListener(new SuperSliderListenerInterface() {
            @Override
            public void slide(){
                Debugger.log("s3 slided");
                setColor();
            }
        });

        s4.addListener(new SuperSliderListenerInterface() {
            @Override
            public void slide(){
                Debugger.log("s4 slided");
                setColor();
            }
        });
        
        s1.setMin(0);
        s1.setMax(255);
        this.add(s1);

        s2.setMin(0);
        s2.setMax(255);
        
        this.add(s2);

        s3.setMin(0);
        s3.setMax(255);
        
        this.add(s3);

        s4.setMin(0);
        s4.setMax(400);
        
        this.add(s4);
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
        if(e.getComponent() == s1 ||e.getComponent() == s2 ||e.getComponent() == s3){
            Info.c = new Color((int) s1.getValue(), (int) s2.getValue(),(int) s3.getValue());
        }

        if(e.getComponent() == s4){
            Info.brushDiameter = (float)s4.getValue();
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
        /* if(e.getComponent() == s1 ||e.getComponent() == s2 ||e.getComponent() == s3){
            Info.c = new Color((int) s1.getValue(), (int) s2.getValue(),(int) s3.getValue());
        }
        if(e.getComponent() == s4){
            Info.brushDiameter = (float)s4.getValue();
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
        Info.c = new Color((int) s1.getValue(), (int) s2.getValue(),(int) s3.getValue());
        Info.brushDiameter = (float) s4.getValue();
        Debugger.log(Info.c);
    }

    /* ---------------------------- END SLIDER EVENT ---------------------------- */
    
}
