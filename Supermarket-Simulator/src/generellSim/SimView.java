/**
 * @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */

package generellSim;

import java.util.Observable;
import java.util.Observer;

/**
 * An abstract class that serves as a general observer of the simulation state by implementing the Observer interface. 
 * It acts as a base for specific view classes that can observe and visualize changes in the simulation state.
 *
 * Classes inheriting from SimView should implement the update method to define how changes in the simulation state
 * are handled and presented.
 */
public abstract class SimView implements Observer{
    
    /**
     * An abstract method that defines how an object inheriting from SimView should handle updates
     * from the observed object (Observable).
     *
     * @param o The observed object notifying about changes.
     * @param e An argument that may contain specific data related to the update,
     *          depending on how the Observable object is configured to send notifications.
     */
    public abstract void update(Observable o, Object e);

}

