/**
 * @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */
package generellSim;

import java.util.Observable;

public abstract class SimState extends Observable {
    
    private boolean simulationRunning = false; // Spårar om simuleringen är igång
    private double time = 0; // Den simulerade tiden
    
    // Konstruktorn behöver inte sätta simuleringen som startad från början
    public SimState() {
    }
    
    // Startar simuleringen
    public void startSimulation() {
        simulationRunning = true;
        notifyObservers(); // Notifiera observatörer om ändring
    }
    
    // Stoppar simuleringen
    public void stopSimulation() {
        this.simulationRunning = false;
        notifyObservers(); // Notifiera observatörer om ändring
    }
    
    // Kontrollerar om simuleringen är igång
    public boolean simulationRunning() {
        return simulationRunning;
    }
    
    public double getTime() {
        return time;
    }
    
    public void setTime(double time) {
        this.time = time;
    }
    
    // Uppdaterar tillståndet baserat på en händelse
    public void update(Event e) {
        this.time = e.getTimeOfEvent(); // Sätt den simulerade tiden till händelsens tid
        setChanged(); // Markera att tillståndet har ändrats
        notifyObservers(); // Notifiera alla observatörer om ändringen
    }
}
