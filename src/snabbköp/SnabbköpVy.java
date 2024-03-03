
package snabbköp;

import generellSim.Event;
import generellSim.SimView;
import java.util.Observable;

import snabbköp.händelser.*;

/**
 * Vyklass som hanterar presentationen av händelser och resultat för en snabbköpsimulering.
 * Den ärver från SimView och implementerar Observer-gränssnittet för att kunna uppdateras med händelser
 * från simuleringen.
 */
@SuppressWarnings("deprecation")
public class SnabbköpVy extends SimView {
    private SnabbköpTillstånd tillstånd;
    private double lastEventTime;
    private double sistaBetalningsHändelse;
    /**
     * Konstruktör för SnabbköpVy.
     *
     * @param tillstånd SnabbköpTillstånd-objektet som innehåller tillståndsdata för simuleringen.
     */
    public SnabbköpVy(SnabbköpTillstånd tillstånd) { this.tillstånd = tillstånd; }

    /**
     * Metod för att uppdatera vyn med nya händelser.
     * Visar simuleringens förlopp och resultat.
     *
     * @param o   Den observerbara klassen (SimState).
     * @param arg Det objekt som skickas med notifikationen (Event).
     */
    public void update(Observable o, Object arg) {
        /* Först, hantera alla händelser som involverar en kund och har ett kundID. */
        if (arg instanceof Event) {
            Event event = (Event) arg;
            String kundID = "";

            /* Beräkna tidsdifferens mellan nuvarande och senaste händelse
                current empty register time + (timeDifference * empty registers) */
            double eventTidSkillnad = 0.0;
            eventTidSkillnad = event.getTimeOfEvent() - lastEventTime;
            double beräknaLedigaKassaTid = this.tillstånd.getTotalTidLedigaKassor() + (eventTidSkillnad * this.tillstånd.getAntalLedigaKassor());
            double beräknaKassaKöTid = this.tillstånd.getTotalTidIKassaKö() + (eventTidSkillnad * this.tillstånd.getKassaKö().köStorlek());
            this.lastEventTime = event.getTimeOfEvent();

            // Uppdatera vyn enligt nuvarande event
            if (event instanceof Starthändelse) {
            	this.visaParametrar();
            	System.out.println(String.format("%-10.2f\t%-10s", this.tillstånd.getTime(), "Start"));
            } else if (event instanceof KundHändelse) {
                /* Uppdatera lediga kassa tid endast om snabnköp är öppet, när ankomst händelse körs */
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

    /**
     * Metoden används för att skriva ut parametrar och ordning.
     * Parametrarna inkluderar antal kassor, maximal kapacitet, ankomsthastighet, plocktider, betaltider och frö.
     * Förloppet inkluderar ordning av parametrar, som händelser och deras tidsstämplar.
     */
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
    }

    /**
     * Metoden används för att skriva ut körningen av händelser, inklusive olika variabler från tillstånd.
     * @param event händelsen som inträffade
     * @param kundID ID för kunden
     */
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



    /**
     * Metoden används för att visa resultatet av simulatorn, inklusive statistik
     */
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