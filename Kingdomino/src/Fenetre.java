import javax.swing.*;
import java.awt.*;

/**
 * Created by bcontrer on 04/10/17.
 */
public class Fenetre extends JFrame {

    //* Composants graphiques
    //* Panel principal
    private JPanel fenetre, imagePlateau, imageMenu;
    //* Menu
    private JMenuBar menuBar;
    private JMenu menuPrincipal, menuAutre;
    private JMenuItem quitItem, resizeItem, newgameItem;
    //* Autres
    private Plateau plateau;
    private boolean petiteFenetre;
    private int xFenetre;
    private int yFenetre;
    private int test = 1;



    public Fenetre(Plateau plateau){
        this.petiteFenetre = true;
        this.xFenetre = 800;
        this.yFenetre = 850;
        this.plateau = plateau;
        //* Création fenêtre
        creerFenetre();
        initMenu();
        addToWindow();
        pack();

        setSize(this.xFenetre, this.yFenetre);
        setTitle("Kingdomino");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        switchFrame();
    }

    //* Méthodes pour créer la fenêtre
    public void creerFenetre() {
        //* Création de tout les composants graphiques de la fenetre ( sauf Menu )
        ImageIcon imageIcon =new ImageIcon( "bg.jpg");
        ImageIcon imgNull =new ImageIcon( "fond3.png");

        this.imageMenu = new PlateauGraphic(resizePicture(imageIcon, 800,850).getImage());
        JLabel image = new JLabel(resizePicture(imgNull, 800,850));

        this.imagePlateau = new PlateauJeuGraphic();

        this.imageMenu.add(image);

        //* Création de l'image de fond ( plateau )



    }
    public void switchFrame(){
        if (test == 0){

            ImageIcon imgNull =new ImageIcon( "fond3.png");




            // this.imagePlateau.add(image);
            test = 1;
            setContentPane(imagePlateau);
            revalidate();
            this.imagePlateau.repaint();
            setSize(1000,800);

        }else{
            ImageIcon imageIcon =new ImageIcon( "bg.jpg");

            ImageIcon imgNull =new ImageIcon( "fond3.png");

            this.imageMenu = new PlateauGraphic(resizePicture(imageIcon, 800,850).getImage());
            JLabel image = new JLabel(resizePicture(imgNull, 800,850));

            this.imageMenu.add(image);

            test = 0;
            setContentPane(imageMenu);
            revalidate();
            this.imageMenu.repaint();
        }

    }
    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }

    public void initMenu() {
        //* Création des componsants du menu

        //* Barre de menu *\\
        this.menuBar = new JMenuBar();

        //*  menu *\\
        this.menuPrincipal = new JMenu("Option");
        this.menuAutre = new JMenu("Aide");

        //* sous menu *\\
        this.newgameItem = new JMenuItem("Nouvelle partie");
        this.resizeItem = new JMenuItem("Changer la taille");
        this.quitItem = new JMenuItem("Quitter");

        //*  Ajout des items *\\

        this.menuPrincipal.add(this.newgameItem);
        this.menuPrincipal.add(this.resizeItem);
        this.menuPrincipal.addSeparator();
        this.menuPrincipal.add(this.quitItem);

        this.menuBar.add(this.menuPrincipal);
        this.menuBar.add(this.menuAutre);

        setJMenuBar(this.menuBar);

    }
    public void addToWindow() {
        //* Ajouts des composants graphique dans la fenêtre principales
        this.fenetre = new JPanel();
        this.fenetre.add(this.imageMenu);
        setContentPane(this.fenetre);
    }




    //* Méthodes pour initialiser les controleurs
    public void  setControlMenu(ControlMenu cm){
        //* initialiser le controlMenu
        this.resizeItem.addActionListener(cm);

    }

    public void setControlClick(ControlMouse controlMouse) {
        //* initialiser le ControlClick
        this.imagePlateau.addMouseListener(controlMouse);

    }

    public void setControlButton(ControlButton cb){
        ((PlateauGraphic)this.imageMenu).getButton().addActionListener(cb);
    }
    public void update(){
    }

    public JPanel getImagePlateau() {
        return imagePlateau;
    }

    public JPanel getImageMenu() {
        return imageMenu;
    }


    //* ...

    //* GETTERS && SETTERS


}
