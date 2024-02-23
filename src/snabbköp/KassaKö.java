package snabbköp;

import java.util.ArrayList;
import java.util.List;

import snabbköp.händelser.övrigt.Kund;

public class KassaKö {
    private List<Kund> kö = new ArrayList<>();
    
    public void läggTillIKö(Kund kund) {
	    kö.add(kund);
	    System.out.println(kö);
	    //System.out.print(kö.toString());
	}    
    
   
    public Kund taNästaFrånKö() {
        return kö.isEmpty() ? null : kö.remove(0);
    }
    

    public boolean isEmpty() {
    	return kö.isEmpty();
    }
    
    // Tillhandahåller storleken på kön
    public int köStorlek() {
        return kö.size();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kassakö: [");
        for(int i = 0; i < kö.size(); i++) {
            sb.append(kö.get(i).toString());
            if (i < kö.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
}



/** 
 public void läggTillIKö(int kundID) {
     kö.add(kundID);
     System.out.println("tillagd i kassakö");
     System.out.print(kö);
 }

 // Tar bort och returnerar första kundID från kön, returnerar null om kön är tom
 public Integer taNästaFrånKö() {
     return kö.isEmpty() ? null : kö.remove(0);
 }
 */
 