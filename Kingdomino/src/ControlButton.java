
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlButton implements ActionListener {

    private Plateau p;
    private Fenetre f;

    public ControlButton(Plateau p, Fenetre f) {
        this.p = p;
        this.f = f;
        this.f.setControlButton(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Début de la partie");
        f.switchFrame();
        String j1 = ((PlateauGraphic)f.getImageMenu()).getJ1().getText();
        if (j1.length() == 0)
            j1 = "Joueur 1";
        String j2 = ((PlateauGraphic)f.getImageMenu()).getJ2().getText();
        if (j2.length() == 0)
            j2 = "Joueur 2";
        System.out.println("Le joueur 1 s'appele : " + j1 );
        System.out.println("Le joueur 2 s'appele : " + j2 );
        p.initGame(j1, j2);
        Chateau cht1 = p.getChateau(0);
        ((PlateauJeuGraphic)f.getImagePlateau()).addSpritToDisplay(cht1);
        Chateau cht2 = p.getChateau(1);
        ((PlateauJeuGraphic)f.getImagePlateau()).addSpritToDisplay(cht2);
        Domino domino = p.getListeDomino().get(0);
        Domino domino2 = p.getListeDomino().get(1);
        domino2.setDroit(true);
      /*  domino.getPieceFace1().setX(cht2.getX()-100);
        domino.getPieceFace2().setX(cht2.getX()-200);
        domino.getPieceFace1().setY(cht2.getY());
        domino.getPieceFace2().setY(cht2.getY()); */
      cht2.placeDomino(new Position(16,0), domino);
      cht2.placeDomino(new Position(6,11), domino2);
        ((PlateauJeuGraphic)f.getImagePlateau()).addSpritToDisplay(domino);
        ((PlateauJeuGraphic)f.getImagePlateau()).addSpritToDisplay(domino2);

//        ((PlateauJeuGraphic)f.getImagePlateau()).addSpritToDisplay(new Sprite(domino.getImage1(), cht2.getX()-100, cht2.getY()));
  //      ((PlateauJeuGraphic)f.getImagePlateau()).addSpritToDisplay(new Sprite(domino.getImage2(), cht2.getX()-200, cht2.getY()));
        ((PlateauJeuGraphic)f.getImagePlateau()).repaint();
    }

    public void placeImageDomino(Domino dm){

    }
}
