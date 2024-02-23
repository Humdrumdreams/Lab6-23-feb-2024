package snabbköp.händelser.övrigt;

import snabbköp.SnabbköpTillstånd;

public class Kund {
    private int kundID;
    private SnabbköpTillstånd tillstånd;

    public Kund(SnabbköpTillstånd tillstånd) {
        this.tillstånd = tillstånd;
    }
    
    public void setNyttKundID() {
    	kundID = tillstånd.ökaKundIDRäknare();
    }

    public int getKundID() {
    	return kundID;
    }
}
