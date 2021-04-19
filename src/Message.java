
public class Message {

    /**
     * @param min
     * @param max
     * @return String
     */
    public static <T> String errorWrongValueSpan(T min, T max, T value, T fieldname) {
        return String.format("Der eingegebene Wert bei %s ist: %s er unterschreitet %s oder überschreitet %s",
                fieldname.toString(), value.toString(), min.toString(), max.toString());
    }

    /**
     * @param min
     * @param fieldname
     * @return String
     */
    public static <T> String errorWrongValueMin(T min, T value, T fieldname) {
        return String.format("Der eingegebene Wert bei %s ist: %s er unterschreitet %s", fieldname.toString(),
                value.toString(), min.toString());
    }

    /**
     * @param max
     * @param fieldname
     * @return String
     */
    public static <T> String errorWrongValueMax(T max, T value, T fieldname) {
        return String.format("Der eingegebene Wert bei %s ist: %s überschreitet %s", fieldname.toString(),
                value.toString(), max.toString());
    }

    /**
     * @param fieldname
     * @return String
     */
    public static <T> String errorEmptyString(T fieldname) {
        return String.format("Das Feld %s darf nicht leer sein", fieldname.toString());
    }

    /**
     * @param index
     * @return String
     */
    public static String errorNullPointerArray(int index) {
        return String.format("Der angegeben Index %d ist nicht belegt", index);
    }

}
