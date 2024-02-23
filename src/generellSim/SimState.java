//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package generellSim;

import java.util.Observable;

public abstract class SimState extends Observable {
    private boolean simulationRunning = false;
    private double time = 0.0;

    public SimState() {
    }

    public void startSimulation() {
        this.simulationRunning = true;
        this.notifyObservers();
    }

    public void stopSimulation() {
        this.simulationRunning = false;
        this.notifyObservers();
    }

    public boolean simulationRunning() {
        return this.simulationRunning;
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void update(Event e) {
        this.time = e.getTimeOfEvent();
        this.setChanged();
        this.notifyObservers();
    }
}
