//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp.händelser;

import generellSim.Event;
import generellSim.EventQueue;
import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.övrigt.Kund;

public class Betalningshändelse extends Event {
    private SnabbköpTillstånd tillstånd;
    private Kund kund;

    public Betalningshändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent, Kund kund) {
        super(tillstånd, eQ, timeOfEvent);
        this.tillstånd = tillstånd;
        this.kund = kund;
    }

    public void executeEvent() {
        this.tillstånd.setKundID(this.kund.getKundID());
        this.tillstånd.ökaTotaltAntalBetaldaKunder();
        this.tillstånd.minskaAntalKunderISnabbköpet();
        if (!this.tillstånd.getKassaKö().isEmpty()) {
            Kund nästaKund = this.tillstånd.getKassaKö().taNästaFrånKö();
            double betalningTid = this.tillstånd.getNästaBetalningsTid(this.getTimeOfEvent());
            this.eQ.addEvent(new Betalningshändelse(this.tillstånd, this.eQ, this.getTimeOfEvent() + betalningTid, nästaKund));
            this.tillstånd.minskaAntalKunderSomKöar();
        } else {
            this.tillstånd.ökaAntalLedigaKassor();
        }

    }

    public String getName() {
        return "Betalning";
    }
}
