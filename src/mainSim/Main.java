//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mainSim;

import generellSim.EventQueue;
import snabbköp.SnabbköpSim;
import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.Starthändelse;
import snabbköp.händelser.Stophändelse;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        EventQueue eQ = new EventQueue();
        SnabbköpTillstånd tillstånd = new SnabbköpTillstånd(2, 7, 1.0, 1234L, 2.0, 3.0, 0.5, 1.0, 10.0);
        SnabbköpSim snabbköpSim = new SnabbköpSim(eQ, tillstånd);
        eQ.addEvent(new Starthändelse(tillstånd, eQ, 0.0));
        eQ.addEvent(new Stophändelse(tillstånd, eQ, 400.0));
        snabbköpSim.runEvents();
    }
}
