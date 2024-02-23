//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp.händelser;

import generellSim.Event;
import generellSim.EventQueue;
import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.övrigt.Kund;

public class Starthändelse extends Event {
    private SnabbköpTillstånd tillstånd;

    public Starthändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent) {
        super(tillstånd, eQ, timeOfEvent);
        this.tillstånd = tillstånd;
    }

    public void executeEvent() {
        this.tillstånd.öppnaSnabbköp();
        System.out.println("Snabbköpet är nu öppet och redo att ta emot kunder.");
        Kund nyKund = new Kund(this.tillstånd);
        double nästaAnkomstTid = this.tillstånd.getNästaAnkomstTid(this.getTimeOfEvent());
        this.eQ.addEvent(new Ankomsthändelse(this.tillstånd, this.eQ, nästaAnkomstTid, nyKund));
        this.eQ.addEvent(new Stängningshändelse(this.tillstånd, this.eQ, this.tillstånd.getTidentSnabbköpetStänger()));
    }

    public String getName() {
        return "Start";
    }
}
