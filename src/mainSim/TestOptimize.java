package mainSim;
import snabbköp.SnabbköpTillstånd;

import java.util.Random;



public class TestOptimize {
    public int metod1(int antalKassor, int maxAntalKunder, double ankomstRate, long frö, double minKassaTid, double maxKassaTid, double minPlockTid, double maxPlockTid, double tidenSnabbköpetStänger) {
        SnabbköpTillstånd tillstånd = new SnabbköpTillstånd(antalKassor, maxAntalKunder, ankomstRate, frö, minKassaTid, maxKassaTid, minPlockTid, maxPlockTid, tidenSnabbköpetStänger);
        return tillstånd.getTotaltAntalMissadeKunder();
    }
    public int metod2(int maxAntalKunder, double ankomstRate, long frö, double minKassaTid, double maxKassaTid, double minPlockTid, double maxPlockTid, double tidenSnabbköpetStänger) {
        int low = 1;
        int high = Integer.MAX_VALUE; // Set a large upper bound for the number of cash registers
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missadeKunder = metod1(mid, maxAntalKunder, ankomstRate, frö, minKassaTid, maxKassaTid, minPlockTid, maxPlockTid, tidenSnabbköpetStänger);
        
            if (missadeKunder == 0) {
                // If no customers are missed, we try to minimize the number of cash registers further
                result = mid;
                high = mid - 1;
            } else {
                // If customers are missed, we need to increase the number of cash registers
                low = mid + 1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        TestOptimize optimize = new TestOptimize();
        System.out.println(optimize.metod2(7, 3.0, 13L, 0.35, 0.6, 0.6, 0.9, 8.0));
        //Object[] hehe = optimize.metod3(1234L);
        //int maxKassor = (int) hehe[0];
        //long seed = (long) hehe[1];
        //System.out.println("Max kassor: "+maxKassor+"\nRandom seed: "+ seed);
    }



}
