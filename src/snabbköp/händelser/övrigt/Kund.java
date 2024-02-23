//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp.händelser.övrigt;

import snabbköp.SnabbköpTillstånd;

public class Kund {
    private int kundID;
    private SnabbköpTillstånd tillstånd;

    public Kund(SnabbköpTillstånd tillstånd) {
        this.tillstånd = tillstånd;
    }

    public void setNyttKundID() {
        this.kundID = this.tillstånd.ökaKundIDRäknare();
    }

    public int getKundID() {
        return this.kundID;
    }
}
