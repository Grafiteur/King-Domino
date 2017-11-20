import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlateauJeuGraphic extends JPanel {

    private Image imgBg;
    private JButton button;
    private Image imgHeader;
    private ArrayList<Object> listDeSpriteTemporaire; //* listes des sprites à afficher
    private ArrayList<Object> listDeSprite; //* listes des sprites temporaire à afficher



    public PlateauJeuGraphic(){
     // imgBg = img;
       ImageIcon imgTmp = new ImageIcon("parchemin.jpg");
       // imgHeader = resizePicture(imgTmp, 400,200).getImage();
        imgBg = resizePicture(imgTmp, 990,750).getImage();
        listDeSprite = new ArrayList<Object>();
        listDeSpriteTemporaire = new ArrayList<Object>();


    }


    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        //* optimisation 2d
        Graphics2D g2 = (Graphics2D) g;

       g2.drawImage(imgBg, 0,0,null);
        for (Object s: listDeSprite){
            if (s instanceof Domino){
                g2.drawImage(((Domino) s).getImage1(), ((Domino) s).getPieceFace1().getX(),((Domino) s).getPieceFace1().getY(),null);
                g2.drawImage(((Domino) s).getImage2(), ((Domino) s).getPieceFace2().getX(),((Domino) s).getPieceFace2().getY(),null);

            }else if (s instanceof  Chateau){
                g2.drawImage(((Chateau) s).getImg(), ((Chateau) s).getX(),((Chateau) s).getY(),null);

            }

        }



    }
    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }

    public void addSpritToDisplay(Object s){
        listDeSprite.add(s);
    }
    public void clearAllSprite(){
        listDeSprite.clear();
    }

    public void addTemporaireSpritToDisplay(Object s){
        listDeSpriteTemporaire.add(s);
    }
    public void clearAllSpriteTemporaire(){
        listDeSpriteTemporaire.clear();
    }

}
