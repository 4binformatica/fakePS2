//import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.event.*;
//import javax.swing.JLabel;
import java.util.ArrayList;
import java.awt.*;

public class MainWindow extends JFrame implements MouseListener{
	SuperButton b1 = new SuperButton(10, 100, 100, 100);
    SuperButton b2 = new SuperButton(120, 100, 100, 100);
    SuperSlider s1 = new SuperSlider(10, 300, 200, 20);
    Editor edit = new Editor(250, 150, 400, 400);
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
        s1.setValue(7000);
        s1.setMin(0);
        s1.setMax(100);
        this.add(s1);
        this.add(edit);
        b1.addMouseListener(this);
        b2.setLabel("conferma");
        b2.addMouseListener(this);
        this.add(b2);
        
        
    }

    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getComponent() == b1){
            Opener o = new Opener();
        }
        if(e.getComponent() == b2){
            //edit.setImgPath(Opener.getFilePath());
            System.out.println(Opener.getFilePath());
            edit.setImgPath(Opener.getFilePath());
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

    
}
