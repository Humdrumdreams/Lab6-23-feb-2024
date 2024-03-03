//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp;

import generellSim.SimState;
import snabbköp.händelser.övrigt.Kund;
import snabbköp.händelser.övrigt.KundFabrik;

/**
 * Representerar tillståndet för simulering av ett snabbköp.
 * Den extends SimState-klassen.
* Denna klass sparar allt information om snabbköpstillstånd, inklusive händelse tider, kassa köer,
 * tillgänglighet för kassor och spårning av statistisk data.
 *
 * <p> <h3><u>Viktiga funktioner inkluderar: </u></h3>
 * <ul>
 *   <li> Spåra antalet tillgängliga kassor.</li>
 *   <li> Beräkna ankomsttider, plockningstider och betalningstider för kunder.</li>
 *   <li> Övervaka statistik som antalet kunder, missade kunder och genomsnittliga kötider.</li>
 *   <li> Öppna och stänga snabbköpet för verksamhet.</li>
 * </ul>
 *
 * <p>Utöver detta tillhandahåller klassen metoder för att avgöra om snabbköpet för närvarande är öppet.
 * <p>Den förlitar sig på klassen KassaKö för att hantera kundköer och klassen KundFabrik för att
 * generera nya kunder.
 * @author Botan Güzel, Sergij Wennströmm, Ludvig Lidén
 * @version -
 * @Date: 24/02/23
 */
public class SnabbköpTillstånd extends SimState {
    private TimeCalculations tidBeräkningar;
    private int antalLedigaKassor;
    private double totalTidLedigaKassor;
    private double totalTidIKassaKö;
    private int totaltAntalKunderSomKöat;
    private int totaltAntalKunderSomFörsöktHandlat;
    private int antalKunderISnabbköpet = 0;
    private int totaltAntalBetaldaKunder;
    private int totaltAntalMissadeKunder;
    private boolean ärSnabbköpÖppet;
    private KassaKö kassaKö;
    private int maxAntalKassor;
    private int maxAntalKunder;
    private double ankomstRate;
    private long frö;
    private double minKassaTid;
    private double maxKassaTid;
    private double minPlockTid;
    private double maxPlockTid;
    private double tidenSnabbköpetStänger;
    private KundFabrik kundFabrik;

    /**
     * Skapar ett nytt SnabbköpTillstånd-objekt med angivna parametrar och kund generator.
     *
     * @param antalKassor             Maximalt antal kassor i snabbköpet.
     * @param maxAntalKunder          Maximalt antal kunder som snabbköpet kan hantera samtidigt.
     * @param ankomstRate             Genomsnittlig ankomsthastighet av kunder till snabbköpet per enhet tid.
     * @param frö                     Frö för slumpgenerator för att generera händelsetider för kunder.
     * @param minKassaTid             Minsta tid det tar för en kassör att hantera en kund.
     * @param maxKassaTid             Högsta tid det tar för en kassör att hantera en kund.
     * @param minPlockTid             Minsta tid det tar för en kund att plocka varor.
     * @param maxPlockTid             Högsta tid det tar för en kund att plocka varor.
     * @param tidenSnabbköpetStänger  Tidpunkt då snabbköpet stänger.
     */
    public SnabbköpTillstånd(int antalKassor, int maxAntalKunder, double ankomstRate, long frö, double minKassaTid, double maxKassaTid, double minPlockTid, double maxPlockTid, double tidenSnabbköpetStänger) {
        this.antalLedigaKassor = antalKassor;
        this.maxAntalKunder = maxAntalKunder;
        this.ankomstRate = ankomstRate;
        this.frö = frö;
        this.minKassaTid = minKassaTid;
        this.maxKassaTid = maxKassaTid;
        this.minPlockTid = minPlockTid;
        this.maxPlockTid = maxPlockTid;
        this.tidBeräkningar = new TimeCalculations(ankomstRate, frö, minKassaTid, maxKassaTid, minPlockTid, maxPlockTid);
        this.maxAntalKassor = antalKassor;
        this.kassaKö = new KassaKö();
        this.tidenSnabbköpetStänger = tidenSnabbköpetStänger;
        this.kundFabrik = new KundFabrik();
    }

    //Getter och setter funktioner, används för att uppdatera tillståndet
    public Kund skapaKund() { return this.kundFabrik.skapaNyKund(); }

    public KassaKö getKassaKö() { return this.kassaKö; }

    public int getTotaltAntalMissadeKunder() { return this.totaltAntalMissadeKunder; }

    public int getMaxAntalKassor() { return this.maxAntalKassor; }

    public int getAntalLedigaKassor() { return this.antalLedigaKassor; }

    public void ökaAntalLedigaKassor() { ++this.antalLedigaKassor; }

    public void minskaAntalLedigaKassor() { --this.antalLedigaKassor; }

    public double getTotalTidLedigaKassor() { return this.totalTidLedigaKassor; }

    public void setTotalTidLedigaKassor(double value) { this.totalTidLedigaKassor = value; }

    public double getAnkomstRate() { return this.ankomstRate; }

    public double getMinKassaTid() { return this.minKassaTid; }

    public double getMaxKassaTid() { return this.maxKassaTid; }

    public double getMinPlockTid() { return this.minPlockTid; }

    public double getMaxPlockTid() { return this.maxPlockTid; }

    public long getFrö() { return this.frö; }

    public int getTotaltAntalBetaldaKunder() { return this.totaltAntalBetaldaKunder; }

    public void ökaTotaltAntalBetaldaKunder() { ++this.totaltAntalBetaldaKunder; }

    public int getTotaltAntalKunderSomFörsöktHandlat() { return this.totaltAntalKunderSomFörsöktHandlat; }

    public int ökaTotaltAntalKunderSomFörsöktHandlat() { return this.totaltAntalKunderSomFörsöktHandlat++; }

    public int getAntalKunderISnabbköpet() { return this.antalKunderISnabbköpet; }

    public void ökaAntalKunderISnabbköpet() { ++this.antalKunderISnabbköpet; }

    public void minskaAntalKunderISnabbköpet() { --this.antalKunderISnabbköpet; }

    public int getMaxAntalKunder() { return this.maxAntalKunder; }

    public void läggTillMissadKund() { ++this.totaltAntalMissadeKunder; }

    public int getTotaltAntalKunderSomKöat() { return this.totaltAntalKunderSomKöat; }

    public void ökaTotaltAntalKunderSomKöat() { this.totaltAntalKunderSomKöat++; }

    public double getTotalTidIKassaKö() { return this.totalTidIKassaKö; }

    public void setTotalTidIKassaKö(double value) { this.totalTidIKassaKö = value;}

    public double getGenomsnittligLedigKassatid() {
        return (double)this.totalTidLedigaKassor / (double)this.maxAntalKassor;
    }

    public double getGenomsnittligKöTid() {
        return this.totaltAntalKunderSomKöat > 0 ? (double)this.totalTidIKassaKö / (double)this.totaltAntalKunderSomKöat : 0.0;
    }

    public double getNästaAnkomstTid(double nuvarandeTid) { return this.tidBeräkningar.calculateAnkomst(nuvarandeTid); }

    public double getNästaPlockTid(double nuvarandeTid) { return this.tidBeräkningar.calculatePlock(nuvarandeTid); }

    public double getNästaBetalningsTid(double nuvarandeTid) { return this.tidBeräkningar.calculateBetalnings(nuvarandeTid); }

    public boolean simulationRunning() { return super.simulationRunning(); }

    public void startSimulation() { super.startSimulation(); }

    public void stopSimulation() { super.stopSimulation(); }

    public void stängSnabbköp() { this.ärSnabbköpÖppet = false; }

    @SuppressWarnings("deprecation")
	public void öppnaSnabbköp() {
        this.ärSnabbköpÖppet = true;
        this.startSimulation();
        this.setChanged();
        this.notifyObservers("Snabbköpet är öppet");
    }

    public boolean ärSnabbköpÖppet() { return this.ärSnabbköpÖppet; }

    public double getTidentSnabbköpetStänger() { return this.tidenSnabbköpetStänger; }
}