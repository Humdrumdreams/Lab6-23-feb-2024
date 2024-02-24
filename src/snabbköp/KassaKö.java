//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package snabbköp;

import java.util.ArrayList;
import java.util.List;
import snabbköp.händelser.övrigt.Kund;

public class KassaKö {
    private List<Kund> kö = new ArrayList();

    public KassaKö() {
    }

    public void läggTillIKö(Kund kund) { this.kö.add(kund); }

    public Kund taNästaFrånKö() {
        return this.kö.isEmpty() ? null : (Kund)this.kö.remove(0);
    }

    public boolean isEmpty() {
        return this.kö.isEmpty();
    }

    public int köStorlek() {
        return this.kö.size();
    }

    public ArrayList SkapaTillfälligtKö() {
        ArrayList<Integer> tempKö = new ArrayList();

        for(int i = 0; i < this.kö.size(); ++i) {
            tempKö.add(((Kund)this.kö.get(i)).getKundID());
        }
        return tempKö;
    }
}
