
public class Mitarbeiter extends Person {

    private String email;

    Mitarbeiter(String vorname, String nachnahme, String email) {
        super(vorname, nachnahme);
        setEmail(email);

    }

    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung) {

        Lib_String.checkIfNullOrEmpty(bemerkung, "bemerkung");
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setBemerkung(bemerkung);
        reservierung.setMitarbeiter(this);
        reservierung.setRaum(raum);
        raum.addReservierung(reservierung);

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        Lib_String.checkIfNullOrEmpty(email, "email");
        this.email = Lib_String.RemoveAllWhitespaces(email);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", getVorname(), getNachname(), getEmail());
    }

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
