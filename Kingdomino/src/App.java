public class App {
    public static void main(String[] args) {
        Plateau p = new Plateau(); //* Création du model
        Controleur c = new Controleur(p); //* Création du controleur
    }
}
