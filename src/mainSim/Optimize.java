package mainSim;
import generellSim.EventQueue;
import snabbköp.SnabbköpSim;
import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.Starthändelse;
import snabbköp.händelser.Stophändelse;

import java.util.Random;



public class Optimize {
    public int metod1(int antalKassor, int maxAntalKunder, double ankomstRate, long frö, double minKassaTid, double maxKassaTid, double minPlockTid, double maxPlockTid, double tidenSnabbköpetStänger) {
        EventQueue eQ = new EventQueue();
        SnabbköpTillstånd tillstånd = new SnabbköpTillstånd(antalKassor, maxAntalKunder, ankomstRate, frö, minKassaTid, maxKassaTid, minPlockTid, maxPlockTid, tidenSnabbköpetStänger);
        SnabbköpSim snabbköpSim = new SnabbköpSim(eQ, tillstånd, true);
        eQ.addEvent(new Starthändelse(tillstånd, eQ, 0.0));
        eQ.addEvent(new Stophändelse(tillstånd, eQ, 999.0));
        snabbköpSim.runEvents();
        return tillstånd.getTotaltAntalMissadeKunder();
    }
    public int metod2(int maxAntalKunder, double ankomstRate, long frö, double minKassaTid, double maxKassaTid, double minPlockTid, double maxPlockTid, double tidenSnabbköpetStänger) {
        int low = 1;
        int high = Integer.MAX_VALUE; // Set a large upper bound for the number of cash registers
        int result = -2;

        while (low < high) {
            int mid = low + (high - low) / 2;
            //System.out.println(mid);
            // Calculate missed customers for mid kassor
            int missed = metod1(mid, maxAntalKunder, ankomstRate, frö, minKassaTid, maxKassaTid, minPlockTid, maxPlockTid, tidenSnabbköpetStänger);

            // If missed customers is 0, return mid
            if (missed == 0) {
                result = mid;
                high = mid - 1;
            } else {
                // If missed customers is not 0, adjust high
                low = mid + 1;
            }
        }
        // Return the lowest number of kassor that results in 0 missed customers
        return result;
    }

    public int metod3(long f, int maxAntalKunder, double ankomstRate, double minKassaTid, double maxKassaTid, double minPlockTid, double maxPlockTid, double tidenSnabbköpetStänger) {
        Random random = new Random((long) f); // Initialize Random with seed f
        int previousResult = 0;
        int consecutiveEqualResults = 0;
        while (consecutiveEqualResults < 100) {
            int result = metod2(maxAntalKunder, ankomstRate, random.nextLong(), minKassaTid, maxKassaTid, minPlockTid, maxPlockTid, tidenSnabbköpetStänger);
            //System.out.println(consecutiveEqualResults);
            if (result == previousResult) {
                consecutiveEqualResults++;
            } else {
                consecutiveEqualResults = 0; // Reset if result is not equal to previous result
            }
            previousResult = result;
        }
        return previousResult;
    }




    public static void main(String[] args) {
        Optimize optimize = new Optimize();
        int m2 = optimize.metod2(7, 3.0, 13L, 0.35, 0.6, 0.6, 0.9, 8.0);
        System.out.println("Metod2: " + m2);
        System.out.println("Metod1 with metod2 as an argument: " + optimize.metod1( m2,7, 3.0, 13L, 0.35, 0.6, 0.6, 0.9, 8.0));
        int m3 = optimize.metod3(13,7, 3.0, 0.35, 0.6, 0.6, 0.9, 8.0);
        System.out.println("Metod3: " + m3);
    }



}
