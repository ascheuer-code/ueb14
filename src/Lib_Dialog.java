import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lib_Dialog {

    private static final int ENDE = 0;
    private int option = -1;

    private Scanner input;

    public Lib_Dialog(ArrayList menue) {
        input = new Scanner(System.in);

    }

    /**
     * Eigentliche Startmethode
     */

    public void start() {

        while (option != ENDE) {
            try {
                option = einlesenFunktion();
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

    public int einlesenFunktion(ArrayList<String> options) {

        StringBuilder sb = new Stringbuilder();
        int optioncounter = 0;

        for (String string : options) {
            optioncounter++;

            sb.append(str)
        }
    }

    public void ausfuehrenFunktion(int option) {

    }

}
