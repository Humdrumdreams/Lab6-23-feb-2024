package snabbköp;

import generellSim.EventQueue;
import generellSim.Sim;
import generellSim.SimView;

/**
 * Specifik implementation av Sim-klassen för snabbköpssimulatorn.
 * Hanterar skapandet av snabbköpsspecifika händelser och tillstånd.
 * 
 * @author Botzan Güzel, Sergij Wennströmm, Ludvig Lidén
 */
public class SnabbköpSim extends Sim {

    /**
     * Skapar en ny instans av snabbköpssimulatorn.
     * Anropar superklassens konstruktor med en händelsekö och ett specifikt tillstånd för snabbköpet.
     * Det är nödvändigt att använda super() för att kunna skapa en eventkö 
     * och att kunna skapa en instans för tillståndet. 
     * 
     * @param eQ Händelsekö för snabbköpssimulatorn.
     * @param tillstånd Tillståndet för snabbköpssimulatorn.
     */
    public SnabbköpSim(EventQueue eQ, SnabbköpTillstånd tillstånd, boolean optimize) {
        super(eQ, tillstånd, optimize);
    }
    public SnabbköpSim(EventQueue eQ, SnabbköpTillstånd tillstånd) {
        super(eQ, tillstånd, false);
    }
    
    /**
     * Skapar och returnerar en vy för snabbköpssimulatorn.
     * Denna metod är en konkret implementering av den abstrakta metoden i superklassen Sim.
     * 
     * @return SimView Visuell representation av snabbköpssimulatorn.
     */
    @Override
    protected SimView createView() { return new SnabbköpVy((SnabbköpTillstånd)this.state); }
}
