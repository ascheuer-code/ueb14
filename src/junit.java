
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class junit {

    @Test
    public void testUhrzeit() {

        // Uhrzeit

        Uhrzeit u1 = new Uhrzeit(23, 59);
        Uhrzeit u2 = new Uhrzeit(00, 00);
        Uhrzeit u3 = new Uhrzeit(00, 00);

        // test von getter
        assertEquals(23, u1.getStunde());
        assertEquals(59, u1.getMinute());

        // test konstruktor und toString()
        assertEquals("23:59 Uhr", u1.toString());
        assertEquals("00:00 Uhr", u2.toString());

        // test von equals()
        assertFalse(u1.equals(u2));
        assertTrue(u2.equals(u3));

        // test check()
        assertThrows(IllegalArgumentException.class, () -> {
            Uhrzeit u4 = new Uhrzeit(-1, -1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Uhrzeit u4 = new Uhrzeit(24, 00);
        });

        // Person + Mitarbeiter

        Mitarbeiter m = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        Mitarbeiter m2 = new Mitarbeiter("John", "Doe", "john@htwsaar.de");

        // test check()
        assertThrows(Throwable.class, () -> {
            Mitarbeiter m4 = new Mitarbeiter(null, "null", "null");
        });
        assertThrows(Throwable.class, () -> {
            Mitarbeiter m4 = new Mitarbeiter("null", null, "null");
        });
        assertThrows(Throwable.class, () -> {
            Mitarbeiter m4 = new Mitarbeiter("null", "null", null);
        });

        // test von konstruktor und toString()
        assertEquals("Max Mustermann (max@htwsaar.de)", m.toString());

        // test von getter und setter
        assertEquals("Max", m.getVorname());
        assertEquals("Mustermann", m.getNachname());
        assertEquals("max@htwsaar.de", m.getEmail());

        // test von reserviere() + setter von Reservierung + Raum addReservierung
        Raum raum = new Raum(18, 0, 0);

        m.reserviere(raum, new Uhrzeit(12, 12), new Uhrzeit(15, 15), "bemerkung");

        assertEquals(
                "Raum 18-0.0\ngebucht von Max Mustermann (max@htwsaar.de) von 12:12 Uhr bis 15:15 Uhr für bemerkung",
                raum.toString());

        // test von Mitarbeiter equals()
        assertTrue(m.equals(m1));
        assertFalse(m1.equals(m2));

        // Reservierung

        // reservierung getter
        assertEquals("12:12 Uhr", raum.getReservierung(0).getBeginn().toString());
        assertEquals("15:15 Uhr", raum.getReservierung(0).getEnde().toString());
        assertEquals("bemerkung", raum.getReservierung(0).getBemerkung().toString());

        // Reservierung equals()
        m.reserviere(raum, new Uhrzeit(15, 15), new Uhrzeit(23, 23), "test");

        assertTrue(raum.getReservierung(0).equals(raum.getReservierung(0)));
        assertFalse(raum.getReservierung(0).equals(raum.getReservierung(1)));

        // Raum

        // test von Raum getter
        assertEquals(18, raum.getGeb());
        assertEquals(0, raum.getEtage());
        assertEquals(0, raum.getRaum());

        // testvon Raum equals()
        assertTrue(raum.equals(raum));
        Raum r1 = new Raum(17, 0, 0);
        assertFalse(raum.equals(r1));

        // test von Raum getReservierung()
        assertEquals("Max Mustermann (max@htwsaar.de) von 12:12 Uhr bis 15:15 Uhr für bemerkung",
                raum.getReservierung(0).toString());

        // test von Raum check()
        assertThrows(Throwable.class, () -> {
            assertEquals("Max Mustermann (max@htwsaar.de) von 12:12 Uhr bis 15:15 Uhr für bemerkung",
                    raum.getReservierung(5).toString());
        });

        // Test von Raum getAnzahlReservierungen()

        assertEquals(2, raum.getAnzahlReservierungen());

    }
}
