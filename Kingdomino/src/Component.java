import javax.swing.*;
import java.awt.*;

/**
 * Created by hannibal on 11/17/17.
 */
public class Component {

    protected Image image1;
    protected Image image2;

    public Component(ImageIcon image1, ImageIcon image2) {
        this.image1 = image1.getImage();
        this.image2 = image2.getImage();
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
}
