package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author JL
 */
public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int arvoEdellinenTuloskentassa;
    private int arvoEdellinenSyotekenttassa;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
            this.arvoEdellinenSyotekenttassa = arvo;
        } catch (Exception e) {

        }
        this.arvoEdellinenTuloskentassa = Integer.parseInt(tuloskentta.getText());
        sovellus.nollaa();
        int laskunTulos = sovellus.tulos();
        tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public void peru() {
        tuloskentta.setText("" + arvoEdellinenTuloskentassa);
        sovellus.aseta(arvoEdellinenTuloskentassa);
        syotekentta.setText("" + arvoEdellinenSyotekenttassa);
    }

}
