/**
 * @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */

package generellSim;

<<<<<<< HEAD
/**
 * The Sim class coordinates the execution of the simulation.
 * It maintains the simulation's event queue and state and triggers updates
 * on the simulation view.
 * 
 * It is responsible for executing the event loop, processing each event sequentially,
 * and managing state transitions and updates until the simulation concludes.
 * 
 * This class is designed to be flexible and can be extended or modified for various
 * types of simulations, not just a supermarket scenario.
 */
public abstract class Sim {
    protected EventQueue eQ;
    protected SimState state;
    protected SimView view;
=======
import snabbköp.*;
import snabbköp.kunder.Ankomst;
import snabbköp.kunder.Betalning;
import snabbköp.kunder.Kund;
import snabbköp.kunder.KundHändelse;
>>>>>>> ade1037b59e57499f437042daa8306d37d5874c4

    /**
     * Constructs a new simulation controller.
     * 
     * @param eQ The event queue holding the simulation's events.
     * @param ss The general state of the simulation.
     */
    public Sim(EventQueue eQ, SimState state) {
        this.eQ = eQ;
        this.state = state;
        this.view = createView(); // Creates a view, to be implemented by subclasses.
    }

<<<<<<< HEAD
    /**
     * An abstract method that should be implemented by subclasses to create a specific view.
     * 
     * @return An instance of SimView tailored to the specific simulation.
     */
    protected abstract SimView createView();
=======
	SnabbköpView skV;
	public Sim(EventQueue eQ, SimState ss, SnabbköpState sss) {
		this.eQ = eQ;
		this.ss = ss;
		this.sss = sss;
		skV = new SnabbköpView(sss, eQ);
	}
	
	public void körHändelser() {
		//skV.update(ss, eQ);
		while (ss.getIo() && !this.eQ.isEmpty()) {
			//System.out.println(String.format("%s\t%s",sss.getAntalLedigaKassor(),  sss.getKassaKöFIFO()));
			//System.out.println(sss.getAntalLedigaKassor());
			//for (int i = 0; i < eQ.size(); i++) {System.out.println(eQ.get(i).getName());}
			eQ.get(0).createEvent();
			sss.setTime(eQ.get(0).händelseTid());
			eQ.remove(0);
			//System.out.println(eQ);
			if (sss.getTotalAntalKunder() == 6) { sss.setSnabbköpÖppet(false); }
			if (eQContainsBetalning() && !sss.isSnabbköpÖppet()) {
				//System.out.println(eQ);
				Stop stop = new Stop(sss, ss, eQ, sss.getTime());
				eQ.add(stop);
			}
			skV.update(sss, eQ);
		}
	}
>>>>>>> ade1037b59e57499f437042daa8306d37d5874c4

    /**
     * Starts the simulation, processing events sequentially until all events are processed
     * or a stopping condition is met.
     */
    public void runEvents() {
        while (!eQ.isEmpty()) {
            Event nextEvent = eQ.getNextEvent();
            nextEvent.executeEvent(); // Processes the event.
            state.setTime(nextEvent.getTimeOfEvent()); // Updates the simulation time.
            view.update(state, null); // Updates the simulation view.
            if (!state.simulationRunning()) { // Checks the stop condition after each event.
                System.out.print("Rad 54 i Sim, stopp");
            	break;
            }
        }
    }
    
    // Additional methods and logic as needed for the simulation.
}
