/**
 * @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */
package snabbköp.händelser;
import snabbköp.SnabbköpVy;

import generellSim.Event;
import generellSim.EventQueue;
import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.övrigt.Kund;

public class Ankomsthändelse extends Event {
    private SnabbköpTillstånd tillstånd;
    private Kund kund;

    public Ankomsthändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent, Kund kund) {
        super(tillstånd, eQ, timeOfEvent);
        this.tillstånd = tillstånd;
        this.kund = kund;
    }
    
    
    @Override
    public void executeEvent() {
    	
    	//Vi skapar kundID:t för kunden
    	
    	//tillstånd.visaParametrar();
    	
        // Kontrollera om det finns utrymme för en ny kund
        if (tillstånd.ärSnabbköpÖppet()) {
        	kund.setNyttKundID();

        	if (tillstånd.getAntalKunderISnabbköpet() <= tillstånd.getMaxAntalKunder()) {
                System.out.println("Kund " + kund.getKundID() + " ankommer vid tid " + getTimeOfEvent());
        		tillstånd.ökaAntalKunderISnabbköpet(); // Öka antalet kunder i snabbköpet
	            tillstånd.ökaTotaltAntalKunderSomFörsöktHandlat(); // Öka det totala antalet kunder
	            
	            double plockTid = tillstånd.getNästaPlockTid(getTimeOfEvent()); // Antag att denna metod finns i SnabbköpTillstånd
	            eQ.addEvent(new Plockhändelse(tillstånd, eQ, getTimeOfEvent() + plockTid, kund));
	        } else {
	            tillstånd.läggTillMissadKund(); // Räkna kunden som missad om det inte finns utrymme
	            System.out.println("Kund " + kund.getKundID() + " missades eftersom snabbköpet är fullt.");
	        }
        	if (tillstånd.ärSnabbköpÖppet()) {  
        	 //Planera nästa ankomsthändelse
        		double nästaAnkomstTid = tillstånd.getNästaAnkomstTid(getTimeOfEvent());
        		eQ.addEvent(new Ankomsthändelse(tillstånd, eQ, nästaAnkomstTid, new Kund(tillstånd)));
        	}
        }
    }     	

    @Override
    public String getName() {
        return "Ankomst";
    }

}


