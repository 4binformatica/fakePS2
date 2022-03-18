//import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.event.*;
//import javax.swing.JLabel;
import java.awt.*;

public class MainWindow extends JFrame implements MouseListener, MouseMotionListener{
	SuperButton b1 = new SuperButton(10, 100, 100, 100);
    SuperButton b2 = new SuperButton(120, 100, 100, 100);
    SuperSlider s1 = new SuperSlider(10, 300, 200, 20);
    SuperSlider s2 = new SuperSlider(10, 340, 200, 20);
    SuperSlider s3 = new SuperSlider(10, 380, 200, 20);
    SuperSlider s4 = new SuperSlider(10, 420, 200, 20);
    Editor edit = new Editor(250, 100, 600, 600);
    MainWindow(){
        this.setBounds(10, 10, 1000, 1000);
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

        s1.setMin(0);
        s1.setMax(255);
        s1.addMouseListener(this);
        s1.addMouseMotionListener(this);
        this.add(s1);

        s2.setMin(0);
        s2.setMax(255);
        s2.addMouseListener(this);
        s2.addMouseMotionListener(this);
        this.add(s2);

        s3.setMin(0);
        s3.setMax(255);
        s3.addMouseListener(this);
        s3.addMouseMotionListener(this);
        this.add(s3);

        s4.setMin(0);
        s4.setMax(400);
        s4.addMouseListener(this);
        s4.addMouseMotionListener(this);
        this.add(s4);

        this.add(edit);
        b1.addMouseListener(this);
        b2.setLabel("conferma");
        b2.addMouseListener(this);
        this.add(b2);
        
        
    }

    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getComponent() == b1){
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
        }
        
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
        if(e.getComponent() == s1 ||e.getComponent() == s2 ||e.getComponent() == s3){
            Info.c = new Color((int) s1.getValue(), (int) s2.getValue(),(int) s3.getValue());
        }
        if(e.getComponent() == s4){
            Info.brushDiameter = (float)s4.getValue();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    
}
