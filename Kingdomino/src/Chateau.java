import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Chateau {
    private String nomJoueur;
    private List<Domino> listeDomino;
    private Image img;
    private int x;
    private int y;
    private final int  tailleX = 100;
    private final int  tailleY = 100;


    public Chateau(String nomJoueur, int x, int y) {
        this.nomJoueur = nomJoueur;
        listeDomino = new ArrayList<Domino>();
        ImageIcon imgTmp = new ImageIcon("chateau.jpg");
        img = resizePicture(imgTmp, 100,100).getImage();
        this.x = x;
        this.y = y;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public List<Domino> getListeDomino() {
        return listeDomino;
    }

    public void setListeDomino(List<Domino> listeDomino) {
        this.listeDomino = listeDomino;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }
    public void placeDomino(Position pos, Domino domino){
        int newPosX = pos.getX()%5;
        if (newPosX == 0 && pos.getX() != 0)
            newPosX = 5;
        int newPosY = pos.getY()%10;
        if (!domino.isDroit()){ //* si le domino est horizontal
            if (pos.getX() > 10){ //* domino a droite du chateau
                domino.getPieceFace1().setX(x - (newPosX * tailleX));
                int newPosX2 = (pos.getX()+1)%5;
                if (newPosX2 == 0 && pos.getX() != 0)
                    newPosX2 = 5;
                domino.getPieceFace2().setX(x - (newPosX2 * tailleX));
            }else { //* domino a gauche
                domino.getPieceFace1().setX(x +0+ (newPosX * tailleX));
                int newPosX2 =( pos.getX()+1)%5;
                if (newPosX2 == 0 && pos.getX() != 0)
                    newPosX2 = 5;
                domino.getPieceFace2().setX(x +0+ (newPosX2 * tailleX));
            }
            if (pos.getY()>10){ //* en bas
                domino.getPieceFace1().setY(y + 0 + (newPosY * tailleY));
                int newPosY2 = (pos.getY()+1)%10;
                domino.getPieceFace2().setY(y + 0 + (newPosY * tailleY));
            }else{ //* au dessus
                domino.getPieceFace1().setY(y  - (newPosY * tailleY));
                domino.getPieceFace2().setY(y - (newPosY * tailleY));
            }

        }else{
            if (pos.getX() > 10){
                domino.getPieceFace1().setX(x - (newPosX * tailleX));
                domino.getPieceFace2().setX(x - (newPosX * tailleX));
            }else {
                domino.getPieceFace1().setX(x +0+ (newPosX * tailleX));
                domino.getPieceFace2().setX(x +0+ (newPosX * tailleX));
            }
            if (pos.getY()>10){
                domino.getPieceFace1().setY(y + 0 + (newPosY * tailleY));
                int newPosY2 = (pos.getY()+1)%10;
                domino.getPieceFace2().setY(y + 0 + (newPosY2 * tailleY));
            }else{
                domino.getPieceFace1().setY(y  - (newPosY * tailleY));
                int newPosY2 = (pos.getY()+1)%10;
                domino.getPieceFace2().setY(y - (newPosY2 * tailleY));
            }
        }
    }
}
