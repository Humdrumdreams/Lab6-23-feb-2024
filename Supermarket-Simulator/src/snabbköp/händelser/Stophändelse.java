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

    @Override
    public void executeEvent() {
        tillstånd.stopSimulation(); 
    	System.out.println("Simuleringen stoppas vid tid " + getTimeOfEvent());
    }

    @Override
    public String getName() {
        return "Stopp";
    }
}