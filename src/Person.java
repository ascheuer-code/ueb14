
public class Person {

    private String vorname;
    private String nachname;

    Person(String vorname, String nachname) {

        setVorname(vorname);
        setNachname(nachname);
    }

    /**
     * @return String
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * @param vorname
     */
    public void setVorname(String vorname) {
        cs.checkIfNullOrEmpty(vorname, "Vorname");
        this.vorname = cs.trimstring(vorname);
    }

    /**
     * @return String
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * @param nachname
     */
    public void setNachname(String nachname) {
        cs.checkIfNullOrEmpty(nachname, "Nachname");
        this.nachname = cs.trimstring(nachname);
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s %s", vorname, nachname);
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
        Person other = (Person) obj;
        if (nachname == null) {
            if (other.nachname != null)
                return false;
        } else if (!nachname.equals(other.nachname))
            return false;
        if (vorname == null) {
            if (other.vorname != null)
                return false;
        } else if (!vorname.equals(other.vorname))
            return false;
        return true;
    }

    /**
     * @param obj
     * @return boolean
     */

}
