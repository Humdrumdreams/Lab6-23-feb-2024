//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp.händelser;

import generellSim.Event;
import generellSim.EventQueue;
import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.övrigt.Kund;

public class Plockhändelse extends Event {
    private SnabbköpTillstånd tillstånd;
    private Kund kund;

    public Plockhändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent, Kund kund) {
        super(tillstånd, eQ, timeOfEvent);
        this.tillstånd = tillstånd;
        this.kund = kund;
    }

    public void executeEvent() {
        System.out.println("Kund " + this.kund.getKundID() + " har plockat sina varor vid tid " + this.getTimeOfEvent());
        if (this.tillstånd.getAntalLedigaKassor() > 0) {
            this.tillstånd.minskaAntalLedigaKassor();
            double betalningTid = this.tillstånd.getNästaBetalningsTid(this.getTimeOfEvent());
            this.eQ.addEvent(new Betalningshändelse(this.tillstånd, this.eQ, this.getTimeOfEvent() + betalningTid, this.kund));
        } else {
            System.out.println("Kund " + this.kund.getKundID() + " ställs i kassakön");
            this.tillstånd.getKassaKö().läggTillIKö(this.kund);
        }

    }

    public String getName() {
        return "Plock";
    }
}
