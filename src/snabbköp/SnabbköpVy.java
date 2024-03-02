
package snabbköp;

import generellSim.Event;
import generellSim.SimView;
import java.util.Observable;

import snabbköp.händelser.*;

@SuppressWarnings("deprecation")
public class SnabbköpVy extends SimView {
    private SnabbköpTillstånd tillstånd;
    private double lastEventTime;
    private double sistaBetalningsHändelse;

    public SnabbköpVy(SnabbköpTillstånd tillstånd) { this.tillstånd = tillstånd; }

    public void update(Observable o, Object arg) {
    	// Först, hantera alla händelser som involverar en kund och har ett kundID.
        if (arg instanceof Event) {
            Event event = (Event) arg;
            String kundID = "";

            // Calculate time difference
            double eventTidSkillnad = 0.0;
            eventTidSkillnad = event.getTimeOfEvent() - lastEventTime;
            double beräknaLedigaKassaTid = this.tillstånd.getTotalTidLedigaKassor() + (eventTidSkillnad * this.tillstånd.getAntalLedigaKassor());
            double beräknaKassaKöTid = this.tillstånd.getTotalTidIKassaKö() + (eventTidSkillnad * this.tillstånd.getKassaKö().köStorlek());
            this.lastEventTime = event.getTimeOfEvent();

            if (event instanceof Starthändelse) {
            	this.visaParametrar();
            	System.out.println(String.format("%-10.2f\t%-10s", this.tillstånd.getTime(), "Start"));
            } else if (event instanceof KundHändelse) {

                if (!this.tillstånd.ärSnabbköpÖppet() && event instanceof Ankomsthändelse) {
                    this.tillstånd.setTotalTidLedigaKassor(this.tillstånd.getTotalTidLedigaKassor());
                } else {
                    sistaBetalningsHändelse = this.tillstånd.getTime();
                    this.tillstånd.setTotalTidLedigaKassor(beräknaLedigaKassaTid);
                    this.tillstånd.setTotalTidIKassaKö(beräknaKassaKöTid);
                }

            	kundID = String.valueOf(((KundHändelse) event).getKundID());
                visaKörning(event, kundID);
            } else if (event instanceof Stängningshändelse) {
                this.tillstånd.setTotalTidLedigaKassor(beräknaLedigaKassaTid);
            	kundID = "---";
                visaKörning(event, kundID);
            } else {
            	System.out.println(String.format("%-10.2f\t%-10s", this.tillstånd.getTime(), "Stop"));
            	this.visaResultat();
            }

        }

    }

    
    private void visaParametrar() {
        System.out.println(String.format("""
                PARAMETRAR
                ==========
                Antal kassor, N..........: %d
                Max som ryms, M..........: %d
                Ankomshastighet, lambda..: %.2f
                Plocktider, [P_min..Pmax]: [%.2f..%.2f]
                Betaltider, [K_min..Kmax]: [%.2f..%.2f]
                Frö, f...................: %d
                
                FÖRLOPP
                =======
                %-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s""",
                this.tillstånd.getAntalLedigaKassor(),
                this.tillstånd.getMaxAntalKunder(),
                this.tillstånd.getAnkomstRate(),
                this.tillstånd.getMinPlockTid(),
                this.tillstånd.getMaxPlockTid(),
                this.tillstånd.getMinKassaTid(),
                this.tillstånd.getMaxKassaTid(),
                this.tillstånd.getFrö(),
                "Tid",
                "Händelse",
                "Kund",
                "?",
                "led",
                "ledT",
                "I",
                "$",
                ":-(",
                "köat",
                "köT",
                "köar",
                "[Kassakö..]"));
        //System.out.println(String.format("%-10.2f\t%-10s", this.tillstånd.getTime(), "Start"));
    }
    
    private void visaKörning(Event event, String kundID) {
    	System.out.println(String.format(
			 "%-10.2f\t%-10s\t%-10s\t%-10s\t%-10d\t%-10.2f\t%-10d\t%-10d\t%-10d\t%-10d\t%-10.2f\t%-10s\t%-10s",
		     
			 this.tillstånd.getTime(),
		     event.getName(),
		     kundID,
		     this.tillstånd.ärSnabbköpÖppet() ? "Ö" : "S",
		     this.tillstånd.getAntalLedigaKassor(), //led
		     this.tillstånd.getTotalTidLedigaKassor(), //ledT
		     this.tillstånd.getAntalKunderISnabbköpet(),
		     this.tillstånd.getTotaltAntalKunderSomFörsöktHandlat(),
		     this.tillstånd.getTotaltAntalMissadeKunder(), //9
		     this.tillstånd.getTotaltAntalKunderSomKöat(),
		     this.tillstånd.getTotalTidIKassaKö(),
		     this.tillstånd.getKassaKö().köStorlek(),
		     this.tillstånd.getKassaKö().SkapaTillfälligtKö()
		    ));
    }
    
    
    
    
    private void visaResultat() {
        System.out.println(String.format("""
                Resultat
                ========
                1) Av %d kunder handlade %d medan %d missades.
                2) Total tid %d kassor varit lediga: %.2f te.
                Genomsnittlig ledig kassatid: %.2f te (dvs %.2f%% av tiden från öppning tills 
                sista kunden betalat).
                3) Total tid %d kunder tvingats köa: %.2f te.
                Genomsnittlig kötid: %.2f te.""",
                this.tillstånd.getTotaltAntalKunderSomFörsöktHandlat(),
                this.tillstånd.getTotaltAntalBetaldaKunder(),
                this.tillstånd.getTotaltAntalMissadeKunder(),
                this.tillstånd.getMaxAntalKassor(),
                this.tillstånd.getTotalTidLedigaKassor(),
                this.tillstånd.getGenomsnittligLedigKassatid(),
                (this.tillstånd.getGenomsnittligLedigKassatid() / sistaBetalningsHändelse) * 100,
                this.tillstånd.getTotaltAntalKunderSomKöat(),
                this.tillstånd.getTotalTidIKassaKö(),
                this.tillstånd.getGenomsnittligKöTid()
        ));
    }
}