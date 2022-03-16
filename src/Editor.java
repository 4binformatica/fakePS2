import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;


public class Editor extends BaseComponent{

/* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    private String imgPath;
/* ----------------------------- INTERNAL ACCESS ---------------------------- */
    private Rectangle myRect;
    private Image image;


    Editor(int x, int y, int w, int h){
        setBounds(x, y, w, h);
        myRect = new Rectangle(w, h);
        init();
    }

    void init(){
        setIsHoverable(false);
        setIsRised(true);
        setIsBorderVisible(false);
        //super.setImgPath("src\\Test_image.jpg");
        super.setImgPath("C:\\Users\\Utente\\Desktop\\fakePS2-main\\src\\assets\\Test_image.jpg");
        super.setShowImg(true);

    }



    /* ---------------------------- SETTERS & GETTERS --------------------------- */
    public void setImgPath(String newImgPath)
    {
        imgPath = newImgPath;
    }

    public String getImgPath(){
        return imgPath;
    }
}
