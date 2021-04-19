
public class Mitarbeiter extends Person {

    private String email;

    Mitarbeiter(String vorname, String nachnahme, String email) {
        super(vorname, nachnahme);
        setEmail(email);

    }

    /**
     * @param raum
     * @param beginn
     * @param ende
     * @param bemerkung
     */
    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung) {

        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setBemerkung(bemerkung);
        reservierung.setMitarbeiter(this);
        reservierung.setRaum(raum);
        raum.addReservierung(reservierung);

    }

    /**
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {

        cs.checkIfNullOrEmpty(email, "E-Mail");
        this.email = cs.trimmail(email);
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s %s (%s)", getVorname(), getNachname(), getEmail());
    }

    /**
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mitarbeiter other = (Mitarbeiter) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

}
