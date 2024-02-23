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

    public void läggTillIKö(Kund kund) {
        this.kö.add(kund);
        System.out.println(this.kö);
    }

    public Kund taNästaFrånKö() {
        return this.kö.isEmpty() ? null : (Kund)this.kö.remove(0);
    }

    public boolean isEmpty() {
        return this.kö.isEmpty();
    }

    public int köStorlek() {
        return this.kö.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kassakö: [");

        for(int i = 0; i < this.kö.size(); ++i) {
            sb.append(((Kund)this.kö.get(i)).toString());
            if (i < this.kö.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
