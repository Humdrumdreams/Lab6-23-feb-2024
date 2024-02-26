//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp;

import generellSim.SimState;

public class SnabbköpTillstånd extends SimState {
    private TimeCalculations tidBeräkningar;
    private int kundIDRäknare;
    private int kundID;
    private int antalLedigaKassor;
    private double totalTidLedigaKassor;
    private double totalTidIKassaKö;
    private int totaltAntalKunderSomKöat;
    private int totaltAntalKunderSomFörsöktHandlat;
    private int antalKunderISnabbköpet = 0;
    private int totaltAntalBetaldaKunder;
    private int totaltAntalMissadeKunder;
    private int antalKunderSomKöar;
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
        this.kundIDRäknare = -1;
        this.maxAntalKassor = antalKassor;
        this.kassaKö = new KassaKö();
        this.tidenSnabbköpetStänger = tidenSnabbköpetStänger;
    }

    public int ökaKundIDRäknare() {
        return ++this.kundIDRäknare;
    }
    public void setKundID(int kundID) { this.kundID = kundID; }
    public int getKundID() { return this.kundID; }

    public KassaKö getKassaKö() {
        return this.kassaKö;
    }

    public int getTotaltAntalMissadeKunder() {
        return this.totaltAntalMissadeKunder;
    }

    public int getMaxAntalKassor() {
        return this.maxAntalKassor;
    }

    public int getAntalLedigaKassor() {
        return this.antalLedigaKassor;
    }

    public void ökaAntalLedigaKassor() {
        ++this.antalLedigaKassor;
    }

    public void minskaAntalLedigaKassor() {
        --this.antalLedigaKassor;
    }

    public double getTotalTidLedigaKassor() { return this.totalTidLedigaKassor; }
    public void setTotalTidLedigaKassor(double value) { this.totalTidLedigaKassor = value; }

    public double getAnkomstRate() {
        return this.ankomstRate;
    }

    public double getMinKassaTid() {
        return this.minKassaTid;
    }

    public double getMaxKassaTid() {
        return this.maxKassaTid;
    }

    public double getMinPlockTid() {
        return this.minPlockTid;
    }

    public double getMaxPlockTid() {
        return this.maxPlockTid;
    }

    public long getFrö() {
        return this.frö;
    }

    public int getTotaltAntalBetaldaKunder() {
        return this.totaltAntalBetaldaKunder;
    }

    public void ökaTotaltAntalBetaldaKunder() {
        ++this.totaltAntalBetaldaKunder;
    }

    public int getTotaltAntalKunderSomFörsöktHandlat() {
        return this.totaltAntalKunderSomFörsöktHandlat;
    }

    public int ökaTotaltAntalKunderSomFörsöktHandlat() {
        return this.totaltAntalKunderSomFörsöktHandlat++;
    }

    public int getAntalKunderISnabbköpet() {
        return this.antalKunderISnabbköpet;
    }

    public void ökaAntalKunderISnabbköpet() {
        ++this.antalKunderISnabbköpet;
    }

    public void minskaAntalKunderISnabbköpet() {
        --this.antalKunderISnabbköpet;
    }

    public int getMaxAntalKunder() {
        return this.maxAntalKunder;
    }

    public void läggTillMissadKund() {
        ++this.totaltAntalMissadeKunder;
    }

    public int getTotaltAntalKunderSomKöat() { return this.totaltAntalKunderSomKöat; }
    public void ökaTotaltAntalKunderSomKöat() { this.totaltAntalKunderSomKöat++; }

    public double getTotalTidIKassaKö() {
        return this.totalTidIKassaKö;
    }

    public int getAntalKunderSomKöar() {
        return this.antalKunderSomKöar;
    }

    public void ökaAntalKunderSomKöar() {
        ++this.antalKunderSomKöar;
    }

    public void minskaAntalKunderSomKöar() {
        --this.antalKunderSomKöar;
    }

    public double getGenomsnittligLedigKassatid() {
        double totalTidÖppen = this.getTime();
        return (double)this.totalTidLedigaKassor / (totalTidÖppen * (double)this.maxAntalKassor);
    }

    public double getGenomsnittligKöTid() {
        return this.totaltAntalKunderSomKöat > 0 ? (double)this.totalTidIKassaKö / (double)this.totaltAntalKunderSomKöat : 0.0;
    }

    public double getAndelTidLedigaKassor() {
        double totalTidÖppen = this.getTime();
        double totalMöjligKassaTid = totalTidÖppen * (double)this.maxAntalKassor;
        return (double)this.totalTidLedigaKassor / totalMöjligKassaTid;
    }

    public double getNästaAnkomstTid(double nuvarandeTid) {
        return this.tidBeräkningar.calculateAnkomst(nuvarandeTid);
    }

    public double getNästaPlockTid(double nuvarandeTid) {
        return this.tidBeräkningar.calculatePlock(nuvarandeTid);
    }

    public double getNästaBetalningsTid(double nuvarandeTid) {
        return this.tidBeräkningar.calculateBetalnings(nuvarandeTid);
    }

    public boolean simulationRunning() {
        return super.simulationRunning();
    }

    public void startSimulation() {
        super.startSimulation();
    }

    public void stopSimulation() {
        super.stopSimulation();
    }

    public void stängSnabbköp() {
        this.ärSnabbköpÖppet = false;
    }

    public void öppnaSnabbköp() {
        this.ärSnabbköpÖppet = true;
        this.startSimulation();
        this.setChanged();
        this.notifyObservers("Snabbköpet är öppet");
    }

    public boolean ärSnabbköpÖppet() {
        return this.ärSnabbköpÖppet;
    }

    public double getTidentSnabbköpetStänger() {
        return this.tidenSnabbköpetStänger;
    }
}
