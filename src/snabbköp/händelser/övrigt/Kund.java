package snabbköp.händelser.övrigt;


/**
 * Representerar en kund i snabbköpssimuleringen. Varje kund har ett unikt ID som
 * tilldelas när kunden ankommer till snabbköpet.
 * 
 * @author Botzan Güzel, Sergij Wennströmm, Ludvig Lidén
 */
public class Kund {
    private int kundID; // Kundens unika identifierare
    
    public Kund(int id) {
        this.kundID = id;
    }

    public int getKundID() {
        return kundID;
    }
    
    
}
