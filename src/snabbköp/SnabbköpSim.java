//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp;

import generellSim.EventQueue;
import generellSim.Sim;
import generellSim.SimView;

public class SnabbköpSim extends Sim {
    public SnabbköpSim(EventQueue eQ, SnabbköpTillstånd tillstånd) {
        super(eQ, tillstånd);
    }

    protected SimView createView() {
        return new SnabbköpVy((SnabbköpTillstånd)this.state);
    }
}
