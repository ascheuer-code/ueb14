
public class Uhrzeit {

    private int stunde;
    private int minute;

    Uhrzeit(int stunde, int minute) {

        setStunde(stunde);
        setMinute(minute);
    }

    /**
     * @return int
     */
    public int getStunde() {
        return stunde;
    }

    /**
     * @param stunde
     */
    public void setStunde(int stunde) {
        cs.checkValueSpan(0, 23, stunde, "Stunde");
        this.stunde = stunde;
    }

    /**
     * @return int
     */
    public int getMinute() {
        return minute;
    }

    /**
     * @param minute
     */
    public void setMinute(int minute) {
        cs.checkValueSpan(0, 59, minute, "Minute");
        this.minute = minute;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {

        String h = cs.numberFormatter("00", stunde);
        String m = cs.numberFormatter("00", minute);

        return String.format("%2s:%2s Uhr", h, m);
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
        Uhrzeit other = (Uhrzeit) obj;
        if (minute != other.minute)
            return false;
        if (stunde != other.stunde)
            return false;
        return true;
    }

}
