//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package generellSim;

public abstract class Event {
    protected SimState state;
    protected EventQueue eQ;
    protected double timeOfEvent;
    protected boolean eventHappened;

    public Event(SimState state, EventQueue eQ, double timeOfEvent) {
        if (state != null && eQ != null) {
            this.state = state;
            this.eQ = eQ;
            this.timeOfEvent = timeOfEvent;
        } else {
            throw new IllegalArgumentException("State and EventQueue cannot be null");
        }
    }

    public abstract void executeEvent();

    public abstract String getName();

    public double getTimeOfEvent() {
        return this.timeOfEvent;
    }

    public boolean hasEventHappened() {
        return this.eventHappened;
    }

    public void setEventHappened(boolean eventHappened) {
        this.eventHappened = eventHappened;
    }
}
