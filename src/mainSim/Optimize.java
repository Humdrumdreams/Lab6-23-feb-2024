package mainSim;


public class Optimize {
    public static void main(String[] args) {
        int minKassor = 1;
        int maxKassor = 10;
        int optimalKassor = 0;
        int minMissadeKunder = Integer.MAX_VALUE;

        Main main = new Main();


        for (int kassor = minKassor; kassor <= maxKassor; kassor++) {
            int missadeKunder = 0;
            for (int i = 0; i < 100; i++) {
                int missadeKunderTemp = 0;
                // Run the simulation with kassor
                // ...
                // missadeKunderTemp = ...
                missadeKunder += missadeKunderTemp;
            }
            if (missadeKunder < minMissadeKunder) {
                minMissadeKunder = missadeKunder;
                optimalKassor = kassor;
            }
        }
        System.out.println("Optimalt antal kassor: " + optimalKassor);
        System.out.println("Antal missade kunder: " + minMissadeKunder);
    }
}
