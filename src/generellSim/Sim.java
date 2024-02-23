//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package generellSim;

public abstract class Sim {
    protected EventQueue eQ;
    protected SimState state;
    protected SimView view;

    public Sim(EventQueue eQ, SimState state) {
        this.eQ = eQ;
        this.state = state;
        this.view = this.createView();
    }

    protected abstract SimView createView();

    public void runEvents() {
        while(true) {
            if (!this.eQ.isEmpty()) {
                Event nextEvent = this.eQ.getNextEvent();
                nextEvent.executeEvent();
                this.state.setTime(nextEvent.getTimeOfEvent());
                this.view.update(this.state, (Object)null);
                if (this.state.simulationRunning()) {
                    continue;
                }

                System.out.print("Rad 54 i Sim, stopp");
            }

            return;
        }
    }
}
