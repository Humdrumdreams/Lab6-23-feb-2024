//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp.händelser;

import generellSim.Event;
import generellSim.EventQueue;
import snabbköp.SnabbköpTillstånd;

public class Stängningshändelse extends Event {
    private SnabbköpTillstånd tillstånd;

    public Stängningshändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent) {
        super(tillstånd, eQ, timeOfEvent);
        this.tillstånd = tillstånd;
    }

    public void executeEvent() {
        System.out.println("Snabbköpet har stängt vid tid " + this.getTimeOfEvent());
        this.tillstånd.stängSnabbköp();
    }

    public String getName() {
        return "Stänger";
    }
}
