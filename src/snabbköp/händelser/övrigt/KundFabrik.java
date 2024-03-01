package snabbköp.händelser.övrigt;

public class KundFabrik {
    private int senasteKundID = -1;

    public Kund skapaNyKund() {
        senasteKundID++;
        return new Kund(senasteKundID);
    }
}
