//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp.händelser;

import generellSim.Event;
import generellSim.EventQueue;
import snabbköp.SnabbköpTillstånd;

public class Stophändelse extends Event {
    private SnabbköpTillstånd tillstånd;

    public Stophändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent) {
        super(tillstånd, eQ, timeOfEvent);
        this.tillstånd = tillstånd;
    }

    public void executeEvent() {
        this.tillstånd.stopSimulation();
        System.out.println("Simuleringen stoppas vid tid " + this.getTimeOfEvent());
    }

    public String getName() {
        return "Stopp";
    }
}
