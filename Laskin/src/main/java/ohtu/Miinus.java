package ohtu;

import javax.swing.JTextField;

public class Miinus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int arvoEdellinenTuloskentassa;
    private int arvoEdellinenSyotekenttassa;

    public Miinus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
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
        sovellus.miinus(arvo);
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
