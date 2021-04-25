import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Klasse mit statischen Methoden
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class Lib_Dialog {

    private static final int ENDE = 6;
    private int option = -1;
    private Dialog dialog;
    private static Scanner input;

    /**
     * Eigentliche Startmethode
     */

    public void start(ArrayList<String> menue) {
        dialog = new Dialog();
        input = new Scanner(System.in);

        while (option != ENDE) {
            try {
                printMenue(menue);
                option = chooseOption();
                ausfuehrenFunktion(option);
            } catch (IllegalArgumentException msg) {
                System.out.println("\n" + msg);
            } catch (InputMismatchException msg) {
                System.out.println("\n" + msg + ": Kein korrekter Wert");
                input.nextLine();
            } catch (Exception msg) {
                System.out.println("\n" + msg);
            }
        }
    }

    /**
     * Methode zur Ausgabe eines Wahlmenues
     * 
     * @param arraylist Arrayliste anhand der das Menue erstellt wird
     */
    public static <T> void printMenue(ArrayList<T> arraylist) {

        StringBuilder sb = new StringBuilder();
        int optioncounter = 0;

        for (T string : arraylist) {

            optioncounter++;
            sb.append(String.format("%d: %s\n", optioncounter, string));

        }
        System.out.print(sb);

    }

    /**
     * Methode für die Optionsanfrage des Menues
     * 
     * @return int Menuepunkt
     */
    public static int chooseOption() {
        System.out.println("\nBitte wählen sie eine Option");
        return input.nextInt();
    }

    /**
     * Methode zum ausführen der entsprechenden Logik die hinter dem Menuepunkt
     * liegt
     * 
     * @param option Optionsauswahl von chooseOption()
     */
    public void ausfuehrenFunktion(int option) {

        switch (option) {
        case 1:
            dialog.case1();
            break;
        case 2:
            dialog.case2();
            break;
        case 3:
            dialog.case3();
            break;
        case 4:
            dialog.case4();
            break;
        case 5:
            dialog.case5();
            break;

        }

    }

}
