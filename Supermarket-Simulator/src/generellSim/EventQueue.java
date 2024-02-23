/**
 * @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */
package generellSim;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Manages a queue of events for the simulation.
 * Ensures that events are ordered by their occurrence time,
 * and handles adding and removing events.
 */
public class EventQueue {
    private ArrayList<Event> eventQueue;

    /**
     * Creates a new event queue.
     */
    public EventQueue() {
        eventQueue = new ArrayList<>();
    }

    /**
     * Adds an event to the event queue if it has not been processed yet and sort the list by event time. 
     * 
     * @param e The event to add.
     * @return true if the event was added, otherwise false.
     */
    public boolean addEvent(Event e) {
        if (!e.hasEventHappened()) {
            eventQueue.add(e);
            eventQueue.sort(Comparator.comparingDouble(Event::getTimeOfEvent)); // Sorts the list after each addition
            return true;
        }
        return false;
    }

    /**
     * Retrieves and removes the next event to be processed from the event queue.
     * 
     * @return the next event, or null if the queue is empty.
     */
    public Event getNextEvent() {
        if (!eventQueue.isEmpty()) {
            return eventQueue.remove(0); // Removes and returns the first event thanks to sorting
        }
        return null;
    }

    /**
     * Checks if the event queue is empty.
     * 
     * @return true if the queue is empty, otherwise false.
     */
   public boolean isEmpty() {
        return eventQueue.isEmpty();
   }

    // Other methods as needed...
}
