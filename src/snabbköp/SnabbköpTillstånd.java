/**
 * @author Ludvig Lidén, Botan Guzel, Sergij Wennström
 */

package snabbköp;

import generellSim.SimState;
import java.util.LinkedList;

/**
 * Klassen representerar tillståndet för en snabbköpssimulering.
 * Den hanterar snabbköpets öppenstatus, kundflöden och köhantering vid kassorna.
 */
public class SnabbköpTillstånd extends SimState {

	private TimeCalculations tidBeräkningar;
    private int kundIDRäknare;
    
    private int antalLedigaKassor; //
    private int totalTidLedigaKassor;    
    
    private int totalTidIKassaKö;    
    private int totaltAntalKunderSomKöat;
    
    private int totaltAntalKunderSomFörsöktHandlat;

    private int antalKunderISnabbköpet = 0; //Används
    private int totaltAntalBetaldaKunder;
    private int totaltAntalMissadeKunder;
    private int antalKunderSomKöar;
    
    private boolean ärSnabbköpÖppet;// ÄNDRAT SÅ DEN INTE STARTAR TRUE
    
    private KassaKö kassaKö ;
    
    // Parametrar för snabbköpet
    private int maxAntalKassor;
    private int maxAntalKunder; 
    private double ankomstRate;
    private long frö;
    private double minKassaTid;
    private double maxKassaTid;
    private double minPlockTid;
    private double maxPlockTid;
	private double tidenSnabbköpetStänger;

    
    // Konstruktor
    public SnabbköpTillstånd(int antalKassor, int maxAntalKunder, double ankomstRate, long frö, 
                         double minKassaTid, double maxKassaTid, 
                         double minPlockTid, double maxPlockTid, double tidenSnabbköpetStänger) {
        
    	//this.ärSnabbköpÖppet = ärSnabbköpÖppet;
    	this.antalLedigaKassor = antalKassor; //När vi startar instansen snabbköptillstånd är alla kassorna i snabbköpet lediga. 
        this.maxAntalKunder = maxAntalKunder;
    	this.ankomstRate = ankomstRate;
        this.frö = frö;
        this.minKassaTid = minKassaTid;
        this.maxKassaTid = maxKassaTid;
        this.minPlockTid = minPlockTid;
        this.maxPlockTid = maxPlockTid;
        this.tidBeräkningar = new TimeCalculations(ankomstRate, frö, minPlockTid, maxPlockTid, minKassaTid, maxKassaTid);
        this.kundIDRäknare = 0;
    	this.maxAntalKassor = antalKassor; // Initialisera andel maxkassor
    	this.kassaKö = new KassaKö();
    	this.tidenSnabbköpetStänger = tidenSnabbköpetStänger;
    	//this.

    }

//  Har koll på kundnummer
    
    
	public int ökaKundIDRäknare() {
		    return ++kundIDRäknare;
		}
    
    public KassaKö getKassaKö(){
		return kassaKö;
    	
    }
    
    //Missade Kunder
    public int getTotaltAntalMissadeKunder() {
    	return totaltAntalMissadeKunder;
    }

//Metoder för kassor
    
    //Kassa
    public int getMaxAntalKassor() {
    	return maxAntalKassor;
    }    
    public int getAntalLedigaKassor() {
		return antalLedigaKassor;    
    }
    public void ökaAntalLedigaKassor() {
    	this.antalLedigaKassor++;
    }
    
	public void minskaAntalLedigaKassor() {
		this.antalLedigaKassor--;
		
	}
    public int getTotalTidLedigaKassor() {
		return totalTidLedigaKassor;
	}

	//Några värden för konstruktorn

//För att få fram satta värden på konstruktor
    public double getAnkomstRate() {
        return ankomstRate;
    }
    public double getMinKassaTid() {
        return minKassaTid;
    }
    public double getMaxKassaTid() {
        return maxKassaTid;
    }
    public double getMinPlockTid() {
        return minPlockTid;
    }
    public double getMaxPlockTid() {
        return maxPlockTid;
    }
    public long getFrö() {
        return frö;
    }
    
    //Kundtal
    public int getTotaltAntalBetaldaKunder() {
		return totaltAntalBetaldaKunder;
	}

	public void ökaTotaltAntalBetaldaKunder() {
		this.totaltAntalBetaldaKunder++;
	}

	
    
    //Starthändelse
    
//Metoder kring att ha koll på antal kunder som handlar, försökt handla, eller har handlat.    
    public int getTotaltAntalKunderSomFörsöktHandlat() {
		return totaltAntalKunderSomFörsöktHandlat;
	}
    public int ökaTotaltAntalKunderSomFörsöktHandlat() {
    	return totaltAntalKunderSomFörsöktHandlat++;
    }
	
	public int getAntalKunderISnabbköpet() {
        return antalKunderISnabbköpet;
    }   
    public void ökaAntalKunderISnabbköpet() {
        this.antalKunderISnabbköpet++;
    }
    public void minskaAntalKunderISnabbköpet() {
        this.antalKunderISnabbköpet--;
    }
    
    

//Max antal kunder i butik
    public int getMaxAntalKunder() {
        return maxAntalKunder;
    }

//Missadde kunder
    public void läggTillMissadKund() {
        this.totaltAntalMissadeKunder++;
    }
	

	public int getTotaltAntalKunderSomKöat() {
		return totaltAntalKunderSomKöat;
	}

	//Tiden kunder stått i kassakö  kassakö
	public int getTotalTidIKassaKö() {
		return totalTidIKassaKö;
	}
	
//Antal kunder som köar
	public int getAntalKunderSomKöar() {
		return antalKunderSomKöar;
	}
	public void ökaAntalKunderSomKöar() {
		this.antalKunderSomKöar++;
	}
	public void minskaAntalKunderSomKöar() {
		this.antalKunderSomKöar--;
	}
	
 // Metoder för att exponera tidberäkningar
	public double getGenomsnittligLedigKassatid() {
		double totalTidÖppen = getTime(); // Antag att detta ger den totala tiden snabbköpet var öppet
	    return (double) totalTidLedigaKassor / (totalTidÖppen * maxAntalKassor);
	}
	
	public double getGenomsnittligKöTid() {
	    if (totaltAntalKunderSomKöat > 0) {
	        return (double) totalTidIKassaKö / totaltAntalKunderSomKöat;
	    } else {
	        return 0;
	    }
	}
	
	public double getAndelTidLedigaKassor() {
	    double totalTidÖppen = getTime(); // Antag att detta ger den totala tiden snabbköpet var öppet
	    double totalMöjligKassaTid = totalTidÖppen * maxAntalKassor;
	    return (double) totalTidLedigaKassor / totalMöjligKassaTid;
	}
	
	
	public double getNästaAnkomstTid(double nuvarandeTid) {
        return tidBeräkningar.calculateAnkomst(nuvarandeTid);
    }
    public double getNästaPlockTid(double nuvarandeTid) {
        return tidBeräkningar.calculatePlock(nuvarandeTid);
    }
    public double getNästaBetalningsTid(double nuvarandeTid) {
        return tidBeräkningar.calculateBetalnings(nuvarandeTid);
    }
    
    
    //Simulatorns status
//Tid på när simulering startar, körs, och slutar
    public boolean simulationRunning() {
    	return super.simulationRunning();
    }
    @Override
    public void startSimulation() {
        super.startSimulation(); // Startar simuleringen med baslogiken
        // Lägg till eventuell specifik initialiseringslogik för SnabbköpTillstånd här
    }
    @Override
    public void stopSimulation() {
        super.stopSimulation(); // Stoppar simuleringen med baslogiken
        // Lägg till eventuell specifik upprensning eller avslutningslogik för SnabbköpTillstånd här
    }
   
    public void stängSnabbköp () {
    	this.ärSnabbköpÖppet = false; //OKLART OM DET SKA VARA THIS ELLER EJ
    	
    }
    
    public void öppnaSnabbköp() {
        ärSnabbköpÖppet = true;
        startSimulation(); // Anropa basmetoden för att starta simuleringen
        setChanged();
        notifyObservers("Snabbköpet är öppet");
    }
    
    public boolean ärSnabbköpÖppet() {
        return ärSnabbköpÖppet;
    }
    
    public double getTidentSnabbköpetStänger() {
    	return tidenSnabbköpetStänger;
    }
    
    
}
	

