package generellSim;

import snabbköp.SnabbköpTillstånd;

/**
 * Abstract class for the simulation. It is core in managing events, 
 * changing the state, and updating the view.
 * Specific simulation implementations should extend this class.
 * 
 * @author Botzan Güzel, Sergij Wennströmm, Ludvig Lidén
 */
public abstract class Sim {
    protected EventQueue eQ; // Queue for managing simulation events
    protected SimState state; // General state of the simulation
    protected SimView view; // View for observing simulation state changes
    private boolean optimize = false;
    
    /**
     * Constructs a simulation instance with specified event queue and simulation state.
     * Initializes the simulation view through a call to {@code createView()}.
     * 
     * @param eQ Event queue instance.
     * @param state Simulation state instance.
     */
    public Sim(EventQueue eQ, SimState state, boolean optimize) {
        this.eQ = eQ;
        this.state = state;
        this.view = this.createView();
        this.optimize = optimize;
    }

    /**
     * Abstract method to create a simulation view. 
     * 
     * @return SimView the initialized view for the simulation.
     */
    protected abstract SimView createView();
    
    /**
     * Executes events in the event queue as long as there are events and the simulation is running.
     * It exectues each event in the event queue, updates the simulationstate, and notifying the view of changes.
     */
    public void runEvents() {
        while(true) {
            if (!this.eQ.isEmpty()) {
            	Event nextEvent = this.eQ.getNextEvent();

                //double currentTime = nextEvent.getTimeOfEvent(); // Get current event time
                //double timeDifference = currentTime - lastEventTime; // Calculate time difference
                //lastEventTime = currentTime; // Update last event time
                //this.eQ.setDifference(timeDifference); // Set time difference to Event queue

                this.state.setTime(nextEvent.getTimeOfEvent()); //Changes in state
            	if (!optimize) this.view.update(this.state, nextEvent); //Updates view
            	nextEvent.executeEvent(); //Execute the event
                if (this.state.simulationRunning()) { //Check if the simulation is runnign
                    continue;
                } else {
                    //System.out.print("Simulation stopped");
                    break;
                }
            }
            return;
        }
    }
}
