//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package generellSim;

import java.util.Observable;
import java.util.Observer;

public abstract class SimView implements Observer {
    public SimView() {
    }

    public abstract void update(Observable var1, Object var2);
}
