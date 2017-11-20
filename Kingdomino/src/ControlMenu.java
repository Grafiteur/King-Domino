import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bcontrer on 04/10/17.
 */
public class ControlMenu implements ActionListener {

    private Plateau plateau;
    private Fenetre fenetre;

    //* Constantes



    public ControlMenu(Plateau p, Fenetre f){
        this.plateau = p;
        this.fenetre = f;
        this.fenetre.setControlMenu(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Changer la taille")){
            System.out.println("ok");
            fenetre.switchFrame();
        }

    }
}
