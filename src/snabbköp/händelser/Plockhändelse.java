package snabbköp.händelser;

import generellSim.Event;
import generellSim.EventQueue;
import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.övrigt.Kund;

/**
 * Hanterar händelsen då en kund plockar sina varor i snabbköpssimuleringen.
 * Denna händelse triggar när en kund börjar plocka varor.
 * 
 * @author Botzan Güzel, Sergij Wennströmm, Ludvig Lidén
 */
public class Plockhändelse extends Event implements KundHändelse{
    private SnabbköpTillstånd tillstånd;
    private Kund kund;

    /**
     * Konstruerar en plockhändelse med given snabbköpstillstånd, händelsekö, tidpunkt för händelsen, och kunden som plockar varor.
     * 
     * @param tillstånd Det aktuella tillståndet i snabbköpet.
     * @param eQ Händelsekön där händelsen hanteras.
     * @param timeOfEvent Tidpunkten då händelsen inträffar.
     * @param kund Kunden som plockar varorna.
     */
    public Plockhändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent, Kund kund) {
        super(tillstånd, eQ, timeOfEvent);
        this.tillstånd = tillstånd;
        this.kund = kund;
    }
    

	public int getKundID() {
		return this.kund.getKundID();
	}

    /**
     * Exekvierar plockhändelsen och antingen skapar en betalningshändelse för kunden
     * eller om kassan är full ställs kunden i kassakön.
     */
    public void executeEvent() {
        //this.tillstånd.setTotalTidLedigaKassor(this.calculateLed());
        if (this.tillstånd.getAntalLedigaKassor() > 0) {  
            this.tillstånd.minskaAntalLedigaKassor();
            double betalningTid = this.tillstånd.getNästaBetalningsTid(this.getTimeOfEvent()); //Skapa ny betalningstid
            this.eQ.addEvent(new Betalningshändelse(this.tillstånd, this.eQ, betalningTid, this.kund));
        } else { //Ställ kunden i kassakön
        	this.tillstånd.ökaTotaltAntalKunderSomKöat();
        	this.tillstånd.getKassaKö().läggTillIKö(this.kund);
        }

    }
    
   
  
    public String getName() {
        return "Plock";
    }
    private double calculateLed() {
        return (this.tillstånd.getTotalTidLedigaKassor() + (this.eQ.getDifference() * this.tillstånd.getAntalLedigaKassor()));
    }
	
}