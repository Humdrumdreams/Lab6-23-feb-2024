/**
 * @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */

package snabbköp.händelser;

import generellSim.Event;
import generellSim.EventQueue;
import snabbköp.SnabbköpTillstånd;
import snabbköp.händelser.övrigt.Kund;


public class Betalningshändelse extends Event{

	private SnabbköpTillstånd tillstånd; 
	private Kund kund;
	
	public Betalningshändelse(SnabbköpTillstånd tillstånd, EventQueue eQ, double timeOfEvent, Kund kund) {
		super(tillstånd, eQ, timeOfEvent);
		this.tillstånd = tillstånd;
		this.kund = kund;
		
	}
		
		//Tar nästa kund från kassakön 
		//Metod: Ändra på arrayen 
		//Metod: Öka totalkötid
		
		
    public void executeEvent() {
        System.out.println("Kund " + kund.getKundID() + " betalar vid tid " + getTimeOfEvent());
        tillstånd.ökaTotaltAntalBetaldaKunder();
        tillstånd.minskaAntalKunderISnabbköpet();
       
        if (!tillstånd.getKassaKö().isEmpty()) { //Om ej tom kommer nästa betalningshändelse att genereras
            Kund nästaKund = tillstånd.getKassaKö().taNästaFrånKö();
            /**
        	int förstaKundIKön = tillstånd.getKassaKö().taNästaFrånKö();            
            Kund förstaKund = hittaKundMedID(förstaKundIKön);
            */
            double betalningTid = tillstånd.getNästaBetalningsTid(getTimeOfEvent());
            eQ.addEvent(new Betalningshändelse(tillstånd, eQ, getTimeOfEvent() + betalningTid, nästaKund));
            tillstånd.minskaAntalKunderSomKöar();
        } else {
            tillstånd.ökaAntalLedigaKassor(); // En kassa blir ledig
        }
    }

		


	@Override
	public String getName() {
		return "Betalning";
	}
	
}
