import java.util.ArrayList;

/**
 * ueb 14 - Dialogklasse
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class Dialog {

    /**
     * @param args
     */
    public static void main(String[] args) {

        ArrayList<String> menue = new ArrayList<String>();

        menue.add("Mitarbeiter anlegen");
        menue.add("Raum anlegen");
        menue.add("Raum reservieren");
        menue.add("Raum reservierungen anzeigen");
        menue.add("Anzahl der reservierungen anzeigen");

        new Lib_Dialog(menue).start(menue);

    }

}
