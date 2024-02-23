package mainSim;

import generellSim.EventQueue;
import snabbköp.SnabbköpSim;
import snabbköp.SnabbköpTillstånd;
import snabbköp.SnabbköpVy;
import snabbköp.händelser.Starthändelse;
import snabbköp.händelser.Stophändelse;

public class Main {

	public static void main(String[] args) {
        // Initialisera ditt snabbköps tillstånd med nödvändiga parametrar
        EventQueue eQ = new EventQueue();
        
    	SnabbköpTillstånd tillstånd = new SnabbköpTillstånd(
        		2, // antal kassor
        		7, //max antal kunder i butiken samtidigt
                1.0, // ankomstrate hur ofta kunderna kommer
                1234, // frö
                2.0, // minKassaTid
                3.0, // maxKassaTid
                0.5, // minPlockTid
                1.0, // maxPlockTid
                10 //Stäng efter 10 timmar?
        );
        
    	
    	
        SnabbköpSim snabbköpSim = new SnabbköpSim(eQ, tillstånd);

        // Starta simuleringen
        eQ.addEvent(new Starthändelse(tillstånd, eQ, 0.0));

        // Lägg till en stopphändelse vid tid 20
        eQ.addEvent(new Stophändelse(tillstånd, eQ, 400.0));
        
        snabbköpSim.runEvents();
       
    }
}
