/**
 * @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */

package randomNum;

import java.util.Random;

/**
 * Generates exponentially distributed random numbers.
 * Used to simulate time intervals between arriving events in a simulation,
 * based on a defined "arrival rate".
 */
public class ExponentialRandomStream {
    
    private Random rand; // Random number generator
    private double arrivalRate; // The arrival rate of events
    
    /**
     * Creates a new exponential random stream with a specified arrival rate and a seed.
     * 
     * @param arrivalRate The arrival rate of events.
     * @param seed        Used to generate reproducible results.
     */
    public ExponentialRandomStream(double arrivalRate, long seed) {
        rand = new Random(seed);
        this.arrivalRate = arrivalRate;
    }
    
    /**
     * Creates a new exponential random stream with a specified arrival rate.
     * Uses a random seed for the random number generator.
     * 
     * @param arrivalRate The arrival rate of events.
     */
    public ExponentialRandomStream(double arrivalRate) {
        rand = new Random();
        this.arrivalRate = arrivalRate;
    }
    
    /**
     * Generates and returns the next exponentially distributed random number.
     * 
     * @return An exponentially distributed random number based on the arrival rate.
     */
    public double next() {
        return -Math.log(rand.nextDouble()) / arrivalRate;
    }
}
