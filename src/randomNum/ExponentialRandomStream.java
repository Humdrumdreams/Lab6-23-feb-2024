//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package randomNum;

import java.util.Random;

public class ExponentialRandomStream {
    private Random rand;
    private double arrivalRate;

    public ExponentialRandomStream(double arrivalRate, long seed) {
        this.rand = new Random(seed);
        this.arrivalRate = arrivalRate;
    }

    public ExponentialRandomStream(double arrivalRate) {
        this.rand = new Random();
        this.arrivalRate = arrivalRate;
    }

    public double next() {
        return -Math.log(this.rand.nextDouble()) / this.arrivalRate;
    }
}
