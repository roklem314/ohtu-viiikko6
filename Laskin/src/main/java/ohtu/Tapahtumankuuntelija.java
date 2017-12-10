package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JTextField;
 
public class Tapahtumankuuntelija implements ActionListener {
    private JButton nollaa;
    private JButton undo;

//    private JTextField tuloskentta;
//    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    private Map<JButton, Komento> komennot;
    private Komento edellinen;

 
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.nollaa = nollaa;
        this.undo = undo;
//        this.tuloskentta = tuloskentta;
//        this.syotekentta = syotekentta;
        this.sovellus = new Sovelluslogiikka();
        komennot = new HashMap<>();
        komennot.put(plus, new Summa(sovellus,tuloskentta,syotekentta));
        komennot.put(miinus, new Miinus(sovellus, tuloskentta, syotekentta));
        komennot.put(nollaa,new Nollaa(sovellus,tuloskentta,syotekentta));
       // komennot.put(undo, new Undo(sovellus,tuloskentta,syotekentta));
   
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Komento komento = komennot.get(ae.getSource());
        if( komento!=null){
            komento.suorita();
            edellinen = komento;
        } else {
            edellinen.peru();
            edellinen = null;
        }
        nollaa.setEnabled(sovellus.tulos() != 0);
        undo.setEnabled(edellinen != null);
    }
 
}