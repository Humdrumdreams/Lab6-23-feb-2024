/**
 * @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */


package generellSim;

/**
 * Abstract class for events in the simulation.
 * Defines common structure and behavior for simulation events.
 */
public abstract class Event {
    
    protected SimState state; // The current state of the simulation
    protected EventQueue eQ; // Queue for managing events
    protected double timeOfEvent; // The simulation time when the event occurs
    protected boolean eventHappened; // Flag to indicate if the event has been processed

    /**
     * Constructs an event with the given state, event queue, and time.
     * 
     * @param state the current state of the simulation
     * @param eQ the event queue this event belongs to
     * @param time the simulation time when the event occurs
     */
    public Event(SimState state, EventQueue eQ, double timeOfEvent) {
        if(state == null || eQ == null) {
            throw new IllegalArgumentException("State and EventQueue cannot be null");
        }
        this.state = state;
        this.eQ = eQ;
        this.timeOfEvent = timeOfEvent;
    }

    /**
     * Abstract method to execute the event.
     */
    public abstract void executeEvent();
    
    /**
     * Abstract method to get the name of the event.
     * 
     * @return the name of the event
     */
    public abstract String getName();
    
    /**
    * Gets the time when the event is scheduled to occur.
    * 
    * @return the event time
    */
    public double getTimeOfEvent() {
        return this.timeOfEvent; 
    }
    
    /**
     * Gets the state of the event.
     * 
     * @return true if the event has been processed, otherwise false
     */
    public boolean hasEventHappened() { 
        return this.eventHappened; 
    }
    
    /**
     * Sets the state of the event.
     * 
     * @param eventHasOccurred the new state of the event
     */
    public void setEventHappened(boolean eventHappened) { 
        this.eventHappened = eventHappened; 
    }    
}

