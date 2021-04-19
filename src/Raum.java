
import java.util.ArrayList;

public class Raum {

    private int geb;
    private int etage;
    private int raum;

    private ArrayList<Reservierung> reservierung;

    public Raum(int geb, int etage, int raum) {
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
        this.reservierung = new ArrayList<>();

    }

    /**
     * @param reservierung
     */
    public void addReservierung(Reservierung reservierung) {
        this.reservierung.add(reservierung);
    }

    /**
     * @return int
     */
    public int getGeb() {
        return geb;
    }

    /**
     * @param geb
     */
    public void setGeb(int geb) {
        this.geb = geb;
    }

    /**
     * @return int
     */
    public int getEtage() {
        return etage;
    }

    /**
     * @param etage
     */
    public void setEtage(int etage) {
        this.etage = etage;
    }

    /**
     * @return int
     */
    public int getRaum() {
        return raum;
    }

    /**
     * @param raum
     */
    public void setRaum(int raum) {
        this.raum = raum;
    }

    /**
     * @param index
     * @return Reservierung
     */
    public Reservierung getReservierung(int index) {
        cs.checkNullPointer(reservierung.toArray(), index);
        return reservierung.get(index);
    }

    /**
     * @return int
     */
    public int getAnzahlReservierungen() {

        return cs.countNumbersOfIndex(reservierung.toArray());
    }

    /**
     * @return String
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Raum %d-%d.%d", geb, etage, raum));
        reservierung.forEach(reservierung -> sb.append("\ngebucht von " + reservierung));
        return sb.toString();

    }

    /**
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Raum other = (Raum) obj;
        if (etage != other.etage)
            return false;
        if (geb != other.geb)
            return false;
        if (raum != other.raum)
            return false;
        return true;
    }

}
