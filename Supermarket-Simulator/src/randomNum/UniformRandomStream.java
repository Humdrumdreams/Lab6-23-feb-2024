/**
 * @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */

package randomNum;

import java.util.Random;

/**
 * Generates random numbers according to a uniform distribution between two boundaries.
 */
public class UniformRandomStream {

    private Random rand; // Random number generator
    private double lower; // The lower boundary for the random number
    private double width; // The difference between upper and lower boundaries

    /**
     * Constructor that starts the random number generator with a specific seed.
     * This allows the sequence of random numbers to be reproducible.
     *
     * @param lower The lower boundary for the uniform number
     * @param upper The upper boundary for the uniform number
     * @param seed  The seed to start the random number generator.
     */
    public UniformRandomStream(double lower, double upper, long seed) {
        rand = new Random(seed);
        this.lower = lower;
        this.width = upper - lower;
    }

    /**
     * Constructor that starts the random number generator without a specific seed.
     * This makes the sequence of random numbers vary with each run.
     *
     * @param lower The lower boundary for the uniform number
     * @param upper The upper boundary for the uniform number
     */
    public UniformRandomStream(double lower, double upper) {
        rand = new Random();
        this.lower = lower;
        this.width = upper - lower;
    }

    /**
     * Generates a new random number between the lower and upper boundaries.
     *
     * @return A random number between the lower and upper boundaries.
     */
    public double next() {
        return lower + rand.nextDouble() * width;
    }
}
