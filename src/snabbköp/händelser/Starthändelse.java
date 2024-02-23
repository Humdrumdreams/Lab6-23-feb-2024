 /**
* @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */

package snabbköp.händelser;

import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.övrigt.Kund;
import generellSim.EventQueue;
import generellSim.Event;

public class Starthändelse extends Event {
    private SnabbköpTillstånd tillstånd;

    public Starthändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent) {
        super(tillstånd, eQ, timeOfEvent);
        this.tillstånd = tillstånd;
    }
        
    @Override
    public void executeEvent() {
    	tillstånd.öppnaSnabbköp(); // Sätter snabbköpet till "öppet" och initialiserar tillståndet
    	System.out.println("Snabbköpet är nu öppet och redo att ta emot kunder.");


        // Skapa den första ankomsthändelsen för en kund och lägg till den i event queue
        Kund nyKund = new Kund(tillstånd); // Skapa en ny kund med ett unikt ID
        double nästaAnkomstTid = tillstånd.getNästaAnkomstTid(getTimeOfEvent());
        eQ.addEvent(new Ankomsthändelse(tillstånd, eQ, nästaAnkomstTid, nyKund));
        
        //Skapa även stängningseventet
    	eQ.addEvent(new Stängningshändelse( tillstånd, eQ, tillstånd.getTidentSnabbköpetStänger()));
       
    }
   

    @Override
    public String getName() {
        return "Start";
    }
}