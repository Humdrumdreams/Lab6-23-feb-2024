//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp;

import generellSim.Event;
import generellSim.SimView;
import java.util.Observable;
import snabbköp.händelser.Starthändelse;
import snabbköp.händelser.Stophändelse;

public class SnabbköpVy extends SimView {
    private SnabbköpTillstånd tillstånd;

    public SnabbköpVy(SnabbköpTillstånd tillstånd) {
        this.tillstånd = tillstånd;
    }

    public void update(Observable o, Object arg) {
        Event event = (Event)arg;
        if (event instanceof Starthändelse) {
            this.visaParametrar();
        }

        if (event instanceof Stophändelse) {
            this.visaResultat();
        }

    }

    private void visaRubriker() {
        System.out.println("\tTid \tHändelse \tKund \t? \tled \tledT \tI \t$ \t:-( \tköat \tköT \tköar \t[Kassakö..]");
    }

    private void visaParametrar() {
        System.out.println(String.format("PARAMETRAR\n==========\nAntal kassor, N..........: %d\nMax som ryms, M..........: %d\nAnkomshastighet, lambda..: %.2f\nPlocktider, [P_min..Pmax]: [%.2f..%.2f]\nBetaltider, [K_min..Kmax]: [%.2f..%.2f]\nFrö, f...................: %d\nFÖRLOPP\n=======", this.tillstånd.getMaxAntalKassor(), this.tillstånd.getMaxAntalKunder(), this.tillstånd.getAnkomstRate(), this.tillstånd.getMinPlockTid(), this.tillstånd.getMaxPlockTid(), this.tillstånd.getMinKassaTid(), this.tillstånd.getMaxKassaTid(), this.tillstånd.getFrö()));
    }

    private void visaResultat() {
        System.out.println(String.format("Resultat\n========\n1) Av %d kunder handlade %d medan %d missades.\n2) Total tid %d kassor varit lediga: %.2f te.\n   Genomsnittlig ledig kassatid: %.2f te (dvs %.2f%% av tiden från öppning tills sista kunden betalat).\n3) Total tid %d kunder tvingats köa: %.2f te.\n   Genomsnittlig kötid: %.2f te.", this.tillstånd.getTotaltAntalKunderSomFörsöktHandlat(), this.tillstånd.getTotaltAntalBetaldaKunder(), this.tillstånd.getTotaltAntalMissadeKunder(), this.tillstånd.getMaxAntalKassor(), this.tillstånd.getTotalTidLedigaKassor(), this.tillstånd.getGenomsnittligLedigKassatid(), this.tillstånd.getAndelTidLedigaKassor(), this.tillstånd.getTotaltAntalKunderSomKöat(), this.tillstånd.getTotalTidIKassaKö(), this.tillstånd.getGenomsnittligKöTid()));
    }
}
