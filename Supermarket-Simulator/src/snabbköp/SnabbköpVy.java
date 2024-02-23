

package snabbköp;

import java.util.Observable;

import generellSim.Event;
import generellSim.SimView;
import snabbköp.händelser.*;

@SuppressWarnings("deprecation")
public class SnabbköpVy extends SimView {
    private SnabbköpTillstånd tillstånd;

    public SnabbköpVy(SnabbköpTillstånd tillstånd) {
        super();
        this.tillstånd = tillstånd;
    }

    @Override
    public void update(Observable o, Object arg) {
        // Anta att 'arg' är en instans av en händelse
        Event event = (Event) arg;
        
        // Visa allmänna parametrar endast en gång, t.ex. vid start
        if (event instanceof Starthändelse) {
            // Visa simuleringens initiala parametrar
        	visaParametrar();
        }
        
        
        //visaHändelse (event);
        

        if (event instanceof Stophändelse) {
        	visaResultat();
        }
    }
    
    
    private void visaRubriker() {
        System.out.println("\tTid \tHändelse \tKund \t? \tled \tledT \tI \t$ \t:-( \tköat \tköT \tköar \t[Kassakö..]");
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
            =======""",
            tillstånd.getMaxAntalKassor(),
            tillstånd.getMaxAntalKunder(),
            tillstånd.getAnkomstRate(),
            tillstånd.getMinPlockTid(),
            tillstånd.getMaxPlockTid(),
            tillstånd.getMinKassaTid(),
            tillstånd.getMaxKassaTid(),
            tillstånd.getFrö()
        ));
    }
    
    /**
    private void visaHändelse(Event event) {
        // Exempel på hur man kan formatera utskriften för varje händelse
        System.out.println(String.format(
            "\t%.2f \t%s \t%s \t%s \t%d \t%.2f \t%d \t%d \t%d \t%d \t%.2f \t%s",
            tillstånd.getTime(), // Tid för händelsen
            event.getClass().getSimpleName(), // Händelsetyp
            //(event instanceof Ankomsthändelse) ? String.valueOf(((Ankomsthändelse)event).getKundID()) : "-", // KundID om tillgängligt
            tillstånd.ärSnabbköpÖppet() ? "Ö" : "S", // Om snabbköpet är öppet eller stängt
            tillstånd.getAntalLedigaKassor(), // Antal lediga kassor
            tillstånd.getTotalTidLedigaKassor(), // Total tid kassor varit lediga
            tillstånd.getKundIDRäknare(), // Antal kunder som hanterats
            tillstånd.getTotaltAntalKunderSomFörsöktHandlat(), // Totalt antal kunder som försökt handla
            tillstånd.getTotaltAntalBetaldaKunder(), // Totalt antal kunder som betalat
            tillstånd.getTotaltAntalMissadeKunder(), // Totalt antal missade kunder
            tillstånd.getTotalTidIKassaKö(), // Total tid i kassakö
            //tillstånd.getKassaKö() // Visar kassakön
        ));
    }
    */
    

    private void visaResultat() {
        // Notera: Justera dessa utskrifter enligt dina tillståndsfält.
        System.out.println(String.format("""
            Resultat
            ========
            1) Av %d kunder handlade %d medan %d missades.
            2) Total tid %d kassor varit lediga: %.2f te.
               Genomsnittlig ledig kassatid: %.2f te (dvs %.2f%% av tiden från öppning tills sista kunden betalat).
            3) Total tid %d kunder tvingats köa: %.2f te.
               Genomsnittlig kötid: %.2f te.""",
               
		   tillstånd.getTotaltAntalKunderSomFörsöktHandlat(),
		   tillstånd.getTotaltAntalBetaldaKunder(),
		   tillstånd.getTotaltAntalMissadeKunder(),
		   tillstånd.getMaxAntalKassor(), 
		   tillstånd.getTotalTidLedigaKassor(),
		   tillstånd.getGenomsnittligLedigKassatid(),
		   tillstånd.getAndelTidLedigaKassor(),
		   tillstånd.getTotaltAntalKunderSomKöat(),
           tillstånd.getTotalTidIKassaKö(),
           tillstånd.getGenomsnittligKöTid()
      )); 
    }
}




