package viewmodel;

import javafx.beans.property.*;

/**
 * Cette classe représente une couleur sur une aile de papillons
 */
public class ColorVM {

    /**
     * Quantité de rouge dans la couleur (0-255)
     */
    private IntegerProperty rouge = new SimpleIntegerProperty();
    public int getRouge() {return rouge.get();}
    public ReadOnlyIntegerProperty rougeProperty() {return rouge;}
    private void setRouge(int rouge) {this.rouge.set(rouge);}

    /**
     * Quantité de vert dans la couleur (0-255)
     */
    private IntegerProperty vert = new SimpleIntegerProperty();
    public int getVert() {return vert.get();}
    public ReadOnlyIntegerProperty vertProperty() {return vert;}
    private void setVert(int vert) {this.vert.set(vert);}

    /**
     * Quantité de bleu dans la couleur (0-255)
     */
    private IntegerProperty bleu = new SimpleIntegerProperty();
    public int getBleu() {return bleu.get();}
    public ReadOnlyIntegerProperty bleuProperty() {return bleu;}
    private void setBleu(int bleu) {this.bleu.set(bleu);}

    /**
     * La couleur a proprement parlé
     */
    private ObjectProperty<javafx.scene.paint.Color> laCouleur = new SimpleObjectProperty<>();
    public javafx.scene.paint.Color getLaCouleur() {return laCouleur.get();}
    public ObjectProperty<javafx.scene.paint.Color> laCouleurProperty() {return laCouleur;}
    private void setLaCouleur(javafx.scene.paint.Color laCouleur) {this.laCouleur.set(laCouleur);}

    /**
     * Contructeur de couleur
     * @param rouge quantité de rouge [0-255]
     * @param vert quantité de vert [0-255]
     * @param bleu quantité de bleu [0-255]
     */
    ColorVM(int rouge, int vert, int bleu) {
        laCouleur.addListener((obs,old,newV)->{
            setRouge((int)(newV.getRed()*255));
            setVert((int)(newV.getGreen()*255));
            setBleu((int)(newV.getBlue()*255));
        });

        laCouleur.set(new javafx.scene.paint.Color(rouge/255.,vert/255.,bleu/255.,1));
    }
}
