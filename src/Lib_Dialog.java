import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lib_Dialog {

    private static final int ENDE = 0;
    private int option = -1;
    private Arraylist<Mitarbeiter> mitarbeiterListe;

    private Scanner input;

    public Lib_Dialog() {
        input = new Scanner(System.in);

    }

    /**
     * Eigentliche Startmethode
     */

    public void start(ArrayList<String> menue) {

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

    public int einlesenFunktion(ArrayList<String> menue) {

        StringBuilder sb = new StringBuilder();
        int optioncounter = 0;

        for (String string : menue) {

            optioncounter++;
            sb.append(String.format("%d: %s\n", optioncounter, string));

        }
        sb.append("\nBitte wählen sie eine Option\n");
        System.out.print(sb);

        return input.nextInt();

    }

    public void ausfuehrenFunktion(int option) {

        switch (option) {
        case 1:
            mitarbeiterAnlegen();
        case 2:
            raumAnlegen();
        case 3:

        case 4:

        case 5:

        case 6:

        case 7:

        }

    }

    private void raumAnlegen() {
        input.nextLine();
        System.out.print("Gebäude:");
        int gebäude = input.nextInt();
        System.out.print("\nEtage:");
        int etage = input.nextInt();
        System.out.print("\nRaum:");
        int raum = input.nextInt();

        Raum neuerRaum = new Raum(gebäude, etage, raum);
        System.out.println(String.format("%s wurde angelegt", neuerRaum.toString()));
    }

    private void mitarbeiterAnlegen() {
        input.nextLine();
        System.out.print("Vorname:");
        String vorname = input.nextLine();
        System.out.print("\nNachname:");
        String nachname = input.nextLine();
        System.out.print("\nE-Mail:");
        String email = input.nextLine();

        Mitarbeiter m = new Mitarbeiter(vorname, nachname, email);
        System.out.println(String.format("%s wurde angelegt", m.toString()));
    }

}
