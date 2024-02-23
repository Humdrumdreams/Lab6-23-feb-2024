//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp.händelser;

import generellSim.Event;
import generellSim.EventQueue;
import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.övrigt.Kund;

public class Ankomsthändelse extends Event {
    private SnabbköpTillstånd tillstånd;
    private Kund kund;

    public Ankomsthändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent, Kund kund) {
        super(tillstånd, eQ, timeOfEvent);
        this.tillstånd = tillstånd;
        this.kund = kund;
    }

    public void executeEvent() {
        if (this.tillstånd.ärSnabbköpÖppet()) {
            this.kund.setNyttKundID();
            double nästaAnkomstTid;
            if (this.tillstånd.getAntalKunderISnabbköpet() <= this.tillstånd.getMaxAntalKunder()) {
                System.out.println("Kund " + this.kund.getKundID() + " ankommer vid tid " + this.getTimeOfEvent());
                this.tillstånd.ökaAntalKunderISnabbköpet();
                this.tillstånd.ökaTotaltAntalKunderSomFörsöktHandlat();
                nästaAnkomstTid = this.tillstånd.getNästaPlockTid(this.getTimeOfEvent());
                this.eQ.addEvent(new Plockhändelse(this.tillstånd, this.eQ, this.getTimeOfEvent() + nästaAnkomstTid, this.kund));
            } else {
                this.tillstånd.läggTillMissadKund();
                System.out.println("Kund " + this.kund.getKundID() + " missades eftersom snabbköpet är fullt.");
            }

            if (this.tillstånd.ärSnabbköpÖppet()) {
                nästaAnkomstTid = this.tillstånd.getNästaAnkomstTid(this.getTimeOfEvent());
                this.eQ.addEvent(new Ankomsthändelse(this.tillstånd, this.eQ, nästaAnkomstTid, new Kund(this.tillstånd)));
            }
        }

    }

    public String getName() {
        return "Ankomst";
    }
}
