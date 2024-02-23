/**
 * @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */
package snabbköp.händelser;

import generellSim.Event;
import generellSim.EventQueue;
import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.övrigt.Kund;

public class Plockhändelse extends Event {
    private SnabbköpTillstånd tillstånd;
    private Kund kund;

    public Plockhändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent, Kund kund) {
        super(tillstånd, eQ, timeOfEvent);
        this.tillstånd = tillstånd;
        this.kund = kund;
    }

    @Override
    public void executeEvent() {
        // Logik för plockhändelse
         //Skapa nytt kundID
    	System.out.println("Kund " + kund.getKundID() + " har plockat sina varor vid tid " + getTimeOfEvent());

        if (tillstånd.getAntalLedigaKassor() > 0) {
            // Om det finns lediga kassor, gå till en av dem för betalning
            tillstånd.minskaAntalLedigaKassor(); // Minska antalet lediga kassor
            double betalningTid = tillstånd.getNästaBetalningsTid(getTimeOfEvent()); // Hämta betalningstiden
            eQ.addEvent(new Betalningshändelse(tillstånd, eQ, getTimeOfEvent() + betalningTid, kund)); // Skapa en betalningshändelse
        } else {
            // Annars ställs kunden i kassakön
            System.out.println("Kund " + kund.getKundID() + " ställs i kassakön");
            //tillstånd.getKassaKö().läggTillIKö(kund.getKundID()); Kod från inann
            tillstånd.getKassaKö().läggTillIKö(kund);
  

        }
    }

    @Override
    public String getName() {
        return "Plock";
    }
}



