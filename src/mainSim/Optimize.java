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

    public int metod2RaiseOne(long frö){
        int maxAntalKunder = 10;
        double stängSnabbköp = 10.0;
        double maxPlockTid = 1.0;
        double minPlockTid = 0.5;
        double maxKassaTid = 3.0;
        double minKassaTid = 2.0;
        @SuppressWarnings("unused")
        double lambda = 1.0;

        int antalKassor = maxAntalKunder;

        int totaltAntalKunderSomFörsöktHandlat = metod1(antalKassor, maxAntalKunder, antalKassor, frö, minKassaTid, maxKassaTid, minPlockTid, maxPlockTid, stängSnabbköp);

        while(antalKassor >= 1){
            int nyaMissadeKunder = metod1(antalKassor, maxAntalKunder, antalKassor, frö, minKassaTid, maxKassaTid, minPlockTid, maxPlockTid, stängSnabbköp);

            if(totaltAntalKunderSomFörsöktHandlat != nyaMissadeKunder){
                return antalKassor + 1;
            }
            antalKassor -= 1;
        }
        return maxAntalKunder;
    }


    public int metod2RaiseHalf(int maxAntalKunder, double ankomstRate, long frö, double minKassaTid, double maxKassaTid, double minPlockTid, double maxPlockTid, double tidenSnabbköpetStänger) {
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
        return result; // testa sista gången med mid - 1
    }


    public int metod3(long frö){
        Random rand = new Random(frö);
        int counter = 0;
        int maxAntalKassor = 0;

        while(counter < 100){
            int nyAntalKassor = metod2RaiseOne(rand.nextLong());
            if(maxAntalKassor != Math.max(maxAntalKassor, nyAntalKassor)){
                counter = 0;
            }
            else{
                counter += 1;
            }
            maxAntalKassor = Math.max(maxAntalKassor, nyAntalKassor);
        }
        return maxAntalKassor;
    }



    public static void main(String[] args) {
        Optimize optimize = new Optimize();
        int m2RaiseOne = optimize.metod2RaiseOne(13L);
        int m2RaiseHalf = optimize.metod2RaiseHalf(7, 3.0, 13L, 0.35, 0.6, 0.6, 0.9, 8.0);
        System.out.println("Metod2 Raise One: " + m2RaiseOne);
        System.out.println("Metod2 Raise Half: " + m2RaiseHalf);

        int m1RaiseOne = optimize.metod1(m2RaiseOne,7, 3.0, 13L, 0.35, 0.6, 0.6, 0.9, 8.0);
        int m1RaiseHalf = optimize.metod1(m2RaiseHalf,7, 3.0, 13L, 0.35, 0.6, 0.6, 0.9, 8.0);
        System.out.println(String.format("Metod1 with Metod2 Raise One (%d) as an argument: %d", m2RaiseOne,m1RaiseOne));
        System.out.println(String.format("Metod1 with Metod2 Raise Half (%d) as an argument: %d", m2RaiseHalf,m1RaiseHalf));
        int m3 = optimize.metod3(13);
        System.out.println("Metod3: " + m3);
    }



}