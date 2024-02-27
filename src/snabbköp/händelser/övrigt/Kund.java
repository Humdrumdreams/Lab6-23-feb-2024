package snabbköp.händelser.övrigt;

import snabbköp.SnabbköpTillstånd;

/**
 * Representerar en kund i snabbköpssimuleringen. Varje kund har ett unikt ID som
 * tilldelas när kunden ankommer till snabbköpet.
 *
 * @author Botzan Güzel, Sergij Wennströmm, Ludvig Lidén
 */
public class Kund {
    private int kundID; // Kundens unika identifierare
    private SnabbköpTillstånd tillstånd; // Tillståndet för snabbköpet som kunden tillhör

    /**
     * Skapar en ny kund och associerar denna med ett specifikt tillstånd av snabbköpet.
     *
     * @param tillstånd Det aktuella tillståndet i snabbköpet där kunden skapas.
     */
    public Kund(SnabbköpTillstånd tillstånd) {
        this.tillstånd = tillstånd;
    }

    /**
     * Tilldelar ett nytt unikt ID till kunden baserat på en räknare i klassen snabbköptillstånd.
     * Metoden används i ankomsthändelsen för att ge varje kund ett KundID.
     */
    public void setNyttKundID() {
        this.kundID = this.tillstånd.ökaKundIDRäknare();
    }

    /**
     * Hämtar kundens unika ID.
     *
     * @return Kundens unika ID.
     */
    public int getKundID() {
        return this.kundID;
    }
}
