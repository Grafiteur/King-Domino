import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * Created by bcontrer on 04/10/17.
 */
public class ControlMouse implements MouseListener {

    private Plateau plateau;
    private Fenetre fenetre;
    private int caseClicked;
    //* Liste de cases
    private final int HAUTEUR_PETITE_CASE = 101;
    private final int LARGEUR_PETITE_CASE = 144;
    private final int DEPASSEMENT_PETITE_CASE_X = 32;
    private final int DEPASSEMENT_PETITE_CASE_Y = 101;
    private int bordureX;
    private int largeurCase;
    private int bordureY;
    private int hauteurCase;


    public ControlMouse(Plateau p, Fenetre f){
        this.plateau = p;
        this.fenetre = f;
        this.fenetre.setControlClick(this);

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        int tourJoueur = plateau.getTourJoueur();
        if ((x <= plateau.getChateau(tourJoueur).getX()+600 && x >= plateau.getChateau(tourJoueur).getX()-500) && (y <= plateau.getChateau(tourJoueur).getY()+500 && y >= plateau.getChateau(tourJoueur).getY()-500)){

            System.out.println("clicked");
        }

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void initCasesPetitPlateau(){

    }


}
