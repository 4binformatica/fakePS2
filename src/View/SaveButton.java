package View;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Controller.Saver;
import Controller.SuperButton;
import Utils.Debugger;

public class SaveButton extends SuperButton{
    
    /* ----------------------------- INTERNAL ACCESS ---------------------------- */
    BufferedImage image;
    Editor editor;
    

    SaveButton(int x, int y, int w, int h, Editor editor){
        super(x, y, w, h);
        this.editor = editor;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        Debugger.log("pressed save button");
        super.mouseClicked(e);
        new Saver(editor, "test", "png");
    }  

    
}
