
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
        Lib_Digits.checkSpan(0, 23, stunde, "stunde");
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
        Lib_Digits.checkSpan(0, 59, minute, "minute");
        this.minute = minute;
    }

    @Override
    public String toString() {

        String h = Lib_Digits.numberFormatter("00", stunde);
        String m = Lib_Digits.numberFormatter("00", minute);

        return String.format("%2s:%2s Uhr", h, m);
    }

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
