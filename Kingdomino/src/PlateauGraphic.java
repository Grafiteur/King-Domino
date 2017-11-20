import javax.swing.*;
import java.awt.*;

public class PlateauGraphic extends JPanel {


  private Image imgBg;
  private JButton button;
  private Image imgHeader;
  private JTextField j1, j2;



    public PlateauGraphic(Image img){
        imgBg = img;
        ImageIcon imgTmp = new ImageIcon("header.png");
        imgHeader = resizePicture(imgTmp, 400,200).getImage();
        JButton b = new JButton("Commencer la partie");
        JTextField j1 = new JTextField("Joueur 1");
        JTextField j2 = new JTextField("Joueur 2");

        setLayout(null);
        j1.setSize(new Dimension(150,30));
        j2.setSize(new Dimension(150,30));
        j1.setLocation(200,350);
        j2.setLocation(400,350);
        b.setSize(new Dimension(200,40));
        b.setLocation(280,400);
        this.button = b;
        this.j1 = j1;
        this.j2 = j2;
        add(j1);
        add(j2);
        add(b);
    }


    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        //* optimisation 2d
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imgBg, 0,0,null);
        g2.drawImage(imgHeader, 200,0,null);



    }
    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JTextField getJ1() {
        return j1;
    }

    public JTextField getJ2() {
        return j2;
    }
}