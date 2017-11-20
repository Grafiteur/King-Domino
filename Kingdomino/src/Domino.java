import javax.swing.*;
import java.awt.*;

public class Domino {

    private Image image1;
    private Image image2;
    private Piece pieceFace1;
    private Piece pieceFace2;
    private boolean isDroit;

    public Domino(ImageIcon image1, ImageIcon image2, Piece pieceFace1, Piece pieceFace2) {
        this.image1 = image1.getImage();
        this.image2 = image2.getImage();
        this.pieceFace1 = pieceFace1;
        this.pieceFace2 = pieceFace2;
        isDroit = false;
    }

    public Image getImage1() {
        return image1;
    }

    public void setImage1(Image image1) {
        this.image1 = image1;
    }

    public Image getImage2() {
        return image2;
    }

    public void setImage2(Image image2) {
        this.image2 = image2;
    }

    public Piece getPieceFace1() {
        return pieceFace1;
    }

    public void setPieceFace1(Piece pieceFace1) {
        this.pieceFace1 = pieceFace1;
    }

    public Piece getPieceFace2() {
        return pieceFace2;
    }

    public void setPieceFace2(Piece pieceFace2) {
        this.pieceFace2 = pieceFace2;
    }

    public boolean isDroit() {
        return isDroit;
    }

    public void setDroit(boolean droit) {
        isDroit = droit;
    }

    public boolean isCompatible(Domino d){
        if (pieceFace1.equals(d.pieceFace1) || pieceFace1.equals(d.pieceFace2) || pieceFace2.equals(d.pieceFace1) || pieceFace2.equals(d.pieceFace2))
            return true;
        return false;
    }
    public boolean isClicked(int x, int y){
        return  ((x >= pieceFace1.getX() && x <= pieceFace2.getX()+100) && (y >= pieceFace1.getY() && y <= pieceFace1.getY()+100));

    }




}
