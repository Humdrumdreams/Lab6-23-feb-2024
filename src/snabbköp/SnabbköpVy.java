//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp;

import generellSim.Event;
import generellSim.SimView;
import java.util.Observable;

import snabbköp.händelser.*;

public class SnabbköpVy extends SimView {
    private SnabbköpTillstånd tillstånd;

    public SnabbköpVy(SnabbköpTillstånd tillstånd) {
        this.tillstånd = tillstånd;
    }

    public void update(Observable o, Object arg) {
        Event event = (Event)arg;
        if (event instanceof Starthändelse) {
            this.visaParametrar();
        } else if (event instanceof Stophändelse) {
            this.visaResultat();
        } else {
            if (event instanceof Stängningshändelse) {
                System.out.println(String.format("%-10.2f\t%-10s", this.tillstånd.getTime(),
                        ((Event) arg).getName()));
            } else {
                System.out.println(String.format(
                        "%-10.2f\t%-10s\t%-10s\t%-10s\t%-10s\t%-10.2f\t%-10s\t%-10s\t%-10s\t%-10s\t%-10.2f\t%-10s\t%-10s",
                        this.tillstånd.getTime(),
                        ((Event) arg).getName(),
                        (arg instanceof Ankomsthändelse || arg instanceof Betalningshändelse || arg instanceof Plockhändelse) ?
                                ((Ankomsthändelse) arg).kund.getKundID() : 0,
                        this.tillstånd.ärSnabbköpÖppet() ? "Ö" : "S",
                        this.tillstånd.getAntalLedigaKassor(),
                        this.tillstånd.getTotalTidLedigaKassor(),
                        this.tillstånd.getAntalKunderISnabbköpet(),
                        this.tillstånd.getTotaltAntalKunderSomFörsöktHandlat(),
                        this.tillstånd.getTotaltAntalMissadeKunder(),
                        this.tillstånd.getTotaltAntalKunderSomKöat(),
                        this.tillstånd.getTotalTidIKassaKö(),
                        this.tillstånd.getKassaKö().köStorlek(),
                        this.tillstånd.getKassaKö().SkapaTillfälligtKö()
                ));
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
        System.out.println(String.format("%-10.2f\t%-10s", this.tillstånd.getTime(), "Start"));
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
                this.tillstånd.getAndelTidLedigaKassor(),
                this.tillstånd.getTotaltAntalKunderSomKöat(),
                this.tillstånd.getTotalTidIKassaKö(),
                this.tillstånd.getGenomsnittligKöTid()
        ));
    }
}
