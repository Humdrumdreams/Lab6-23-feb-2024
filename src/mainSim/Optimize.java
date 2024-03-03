package mainSim;
import generellSim.EventQueue;
import snabbköp.SnabbköpSim;
import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.Starthändelse;
import snabbköp.händelser.Stophändelse;

import java.util.Random;
import java.util.concurrent.CountDownLatch;


/**
 * Klassen letar efter optimalt antal kassor som behövs för att inte få några missade kunder
 * @author Botzan Güzel, Sergij Wennströmm, Ludvig Lidén
 */
public class Optimize {
    /**
     * Metod1 returnerar det totala antalet missade kunder med givna parametrar.
     *
     * @param antalKassor Antalet kassor i snabbköpet.
     * @param maxAntalKunder Maximalt antal kunder som får vara i butiken.
     * @param ankomstRate Genomsnittlig ankomsthastighet för kunder.
     * @param frö Frö för slumpgeneratorn.
     * @param minKassaTid Minsta tid det tar att betjäna en kund vid en kassa.
     * @param maxKassaTid Största tid det tar att betjäna en kund vid en kassa.
     * @param minPlockTid Minsta tid det tar för en kund att plocka sina varor.
     * @param maxPlockTid Största tid det tar för en kund att plocka sina varor.
     * @param tidenSnabbköpetStänger Tiden när snabbköpet stänger.
     * @return Det totala antalet missade kunder under simuleringen.
     */
    public int metod1(int antalKassor, int maxAntalKunder, double ankomstRate, long frö, double minKassaTid, double maxKassaTid, double minPlockTid, double maxPlockTid, double tidenSnabbköpetStänger) {
        EventQueue eQ = new EventQueue();
        SnabbköpTillstånd tillstånd = new SnabbköpTillstånd(antalKassor, maxAntalKunder, ankomstRate, frö, minKassaTid, maxKassaTid, minPlockTid, maxPlockTid, tidenSnabbköpetStänger);
        SnabbköpSim snabbköpSim = new SnabbköpSim(eQ, tillstånd, true);
        eQ.addEvent(new Starthändelse(tillstånd, eQ, 0.0));
        eQ.addEvent(new Stophändelse(tillstånd, eQ, 999.0));
        snabbköpSim.runEvents();
        return tillstånd.getTotaltAntalMissadeKunder();
    }

    /**
     * Simulerar en ökning av antalet kassor med en enda kassa och returnerar det optimala antalet kassor för att minimera antalet missade kunder.
     *
     * @param frö Frö för slumpgeneratorn.
     * @return Det optimala antalet kassor för att minimera antalet missade kunder.
     */
    public int metod2RaiseOne(long frö){
        int maxAntalKunder = 7; // Max antal kunder som kan vara i snabbköpet samtidigt
        double stängSnabbköp = 10.0;
        double maxPlockTid = 1.0;
        double minPlockTid = 0.5;
        double maxKassaTid = 3;
        double minKassaTid = 2;
        double ankomstRate = 2.0;

        int antalKassor = maxAntalKunder;
        int maxMissadeKunder = metod1(antalKassor, maxAntalKunder, ankomstRate, frö, minKassaTid, maxKassaTid, minPlockTid, maxPlockTid, stängSnabbköp); // Antalet missade kunder när man kör metod1 med givna parametrar

        while(antalKassor >= 1) { //Antalet kassor kan vara minst 1, while-loop börjar från högsta antalet kassor och minskar med ett.
            int nyaAntalMissadeKunder = metod1(antalKassor, maxAntalKunder, ankomstRate, frö, minKassaTid, maxKassaTid, minPlockTid, maxPlockTid, stängSnabbköp); // Kör metod1 med nya antalet kassor
            if (maxMissadeKunder != nyaAntalMissadeKunder){ // När vi når till maxMissadeKunder avbryter programmet
                return antalKassor+1;
            }
            antalKassor--;

        }
        return antalKassor;
    }

/*
    public int metod2RaiseHalf(int maxAntalKunder, double ankomstRate, long frö, double minKassaTid, double maxKassaTid, double minPlockTid, double maxPlockTid, double tidenSnabbköpetStänger) {
        int low = 1;
        int high = maxAntalKunder; // Set a large upper bound for the number of cash registers
        int result = 0;

        while (low < high) {
            int mid = (high - low) / 2;
            // Calculate missed customers for mid kassor
            int missed = metod1(mid, maxAntalKunder, ankomstRate, frö, minKassaTid, maxKassaTid, minPlockTid, maxPlockTid, tidenSnabbköpetStänger); //3 2


            // If missed customers is 0, return mid
            if (missed == 0) {
                result = mid;
                high = mid - 1;
            } else {
                result = mid;
                // If missed customers is not 0, adjust high
                low = mid + 1;
            }
        }
        // Return the lowest number of kassor that results in 0 missed customers
        return result; // testa sista gången med mid - 1
    }
*/

    /**
     * Beräknar det optimala antalet kassor för att minimera antalet missade kunder genom att iterativt öka antalet kassor.
     * Fortsätt tills vi antalet kassor som behövs inte ökat för 100 iterationer i rad.
     *
     * @param frö Frö för slumpgeneratorn.
     * @return Det optimala antalet kassor för att minimera antalet missade kunder.
     */

    public int metod3(long frö){
        Random rand = new Random(frö);
        int counter = 0;
        int antalKassor = 0; // minsta antalet kassor som behövs för att få 0 missade kunder

        while(counter < 100){
            int nyAntalKassor = metod2RaiseOne(rand.nextLong()); //10
            if(antalKassor != Math.max(antalKassor, nyAntalKassor)){ // Kollar om gamla antalet kassor lika stort eller störra än nyaAntaletKassor: öka counter
                counter = 0;
            }
            else{
                counter += 1;
            }
            antalKassor = Math.max(antalKassor, nyAntalKassor);
        }
        return antalKassor;
    }



    public static void main(String[] args) {
        Optimize optimize = new Optimize();
        int metod2 = optimize.metod2RaiseOne(1234L);
        System.out.println("Metod2: " + metod2 + " kassor behövs för att få minsta antal missade kunder");
        int metod1 = optimize.metod1(metod2,7, 2.0, 1234L, 2, 3, 0.5, 1, 10.0);
        System.out.println(String.format("Metod1 with Metod2 (%d) as an argument: %d missade kunder", metod2,metod1));
        int m3 = optimize.metod3(13);
        System.out.println("Metod3: " + m3);
    }



}