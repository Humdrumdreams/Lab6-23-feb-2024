//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package generellSim;

import java.util.ArrayList;
import java.util.Comparator;

public class EventQueue {
    private ArrayList<Event> eventQueue = new ArrayList();

    public EventQueue() {
    }

    public boolean addEvent(Event e) {
        if (!e.hasEventHappened()) {
            this.eventQueue.add(e);
            this.eventQueue.sort(Comparator.comparingDouble(Event::getTimeOfEvent));
            return true;
        } else {
            return false;
        }
    }

    public Event getNextEvent() {
        return !this.eventQueue.isEmpty() ? (Event)this.eventQueue.remove(0) : null;
    }

    public boolean isEmpty() {
        return this.eventQueue.isEmpty();
    }
}
