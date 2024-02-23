//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package randomNum;

import java.util.Random;

public class UniformRandomStream {
    private Random rand;
    private double lower;
    private double width;

    public UniformRandomStream(double lower, double upper, long seed) {
        this.rand = new Random(seed);
        this.lower = lower;
        this.width = upper - lower;
    }

    public UniformRandomStream(double lower, double upper) {
        this.rand = new Random();
        this.lower = lower;
        this.width = upper - lower;
    }

    public double next() {
        return this.lower + this.rand.nextDouble() * this.width;
    }
}
