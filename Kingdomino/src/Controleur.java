public class Controleur {

    public Controleur(Plateau p) {
        Fenetre f = new Fenetre(p);
        new ControlMouse(p,f);
        new ControlMenu(p,f);
        new ControlButton(p,f);
        f.setVisible(true);
    }
}
