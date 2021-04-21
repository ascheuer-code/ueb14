import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lib_Dialog {

    private static final int ENDE = 6;
    private int option = -1;
    private Dialog dialog;
    private static Scanner input;

    // private Arraylist<Mitarbeiter> mitarbeiterListe;

    public Lib_Dialog() {

        new Dialog().start();

    }

    /**
     * Eigentliche Startmethode
     */

    public void start(ArrayList<String> menue) {
        dialog = new Dialog();
        input = new Scanner(System.in);

        while (option != ENDE) {
            try {
                option = einlesenFunktion(menue);
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

    public static <T> int einlesenFunktion(ArrayList<T> arraylist) {

        StringBuilder sb = new StringBuilder();
        int optioncounter = 0;

        for (T string : arraylist) {

            optioncounter++;
            sb.append(String.format("%d: %s\n", optioncounter, string));

        }
        sb.append("\nBitte wählen sie eine Option\n");
        System.out.print(sb);

        return input.nextInt();

    }

    public void ausfuehrenFunktion(int option) {

        switch (option) {
        case 0:
            System.out.println("Ende");
            break;
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
