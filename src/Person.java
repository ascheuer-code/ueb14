
public class Person {

    private String vorname;
    private String nachname;

    Person(String vorname, String nachname) {

        setVorname(vorname);
        setNachname(nachname);
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        Lib_String.checkIfNullOrEmpty(vorname, "vorname");
        this.vorname = Lib_String.AllWhitespaceToOne(vorname);
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        Lib_String.checkIfNullOrEmpty(nachname, "nachname");
        this.nachname = Lib_String.AllWhitespaceToOne(nachname);
    }

    @Override
    public String toString() {
        return String.format("%s %s", vorname, nachname);
    }

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

}
