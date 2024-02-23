package snabbköp;

import generellSim.EventQueue;
import generellSim.Sim;
import generellSim.SimView;

public class SnabbköpSim extends Sim {
    
    public SnabbköpSim(EventQueue eQ, SnabbköpTillstånd tillstånd) {
        super(eQ, tillstånd);
    }

    protected SimView createView() {
        // Här vet vi att state är en instans av SnabbköpTillstånd
        return new SnabbköpVy((SnabbköpTillstånd) state);
    }
}
