package snabbköp.händelser;

import generellSim.Event;
import generellSim.EventQueue;
import generellSim.SimState;
import snabbköp.SnabbköpTillstånd;

public class Stängningshändelse extends Event{

	private SnabbköpTillstånd tillstånd;

	public Stängningshändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent) {
		super(tillstånd, eQ, timeOfEvent);
		this.tillstånd = tillstånd;
	}

	@Override
	
	public void executeEvent() {
		System.out.println("Snabbköpet har stängt vid tid " + getTimeOfEvent());
		tillstånd.stängSnabbköp();
	}

	@Override
	public String getName() {
		return "Stänger";
	}
}
