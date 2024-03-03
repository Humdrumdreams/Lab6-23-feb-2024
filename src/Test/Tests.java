package Test;

import mainSim.Main;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Tests {

    @Test
    void testMainMethod() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the main method with given arguments
        String[] argumentsExampleOne = new String[]{"2", "5", "1", "1234", "2", "3", "0.5", "1", "10"}; //Example 1
        Main.main(argumentsExampleOne);
        // Get the actual output captured
        String actualOutput = outContent.toString().trim();

        // Expected output Example One
        String expectedOutputExampleOne = """
                PARAMETRAR
                ==========
                Antal kassor, N..........: 2
                Max som ryms, M..........: 5
                Ankomshastighet, lambda..: 1.0
                Plocktider, [P_min..Pmax]: [0.5..1.0]
                Betaltider, [K_min..Kmax]: [2.0..3.0]
                Frö, f...................: 1234
                FÖRLOPP
                =======
                 Tid Händelse Kund ? led ledT I $ :-( köat köT köar [Kassakö..]
                 0,00 Start
                 0,44 Ankomst 0 Ö 2 0,87 0 0 0 0 0,00 0 []
                 0,49 Ankomst 1 Ö 2 0,97 1 0 0 0 0,00 0 []
                 0,64 Ankomst 2 Ö 2 1,28 2 0 0 0 0,00 0 []
                 1,26 Plock 0 Ö 2 2,52 3 0 0 0 0,00 0 []
                 1,42 Ankomst 3 Ö 1 2,68 3 0 0 0 0,00 0 []
                 1,46 Plock 1 Ö 1 2,72 4 0 0 0 0,00 0 []
                 1,57 Plock 2 Ö 0 2,72 4 0 0 0 0,00 0 []
                 2,15 Plock 3 Ö 0 2,72 4 0 0 1 0,58 1 [2]
                 2,51 Ankomst 4 Ö 0 2,72 4 0 0 2 1,30 2 [2, 3]
                 3,18 Plock 4 Ö 0 2,72 5 0 0 2 2,64 2 [2, 3]
                 3,91 Betalning 0 Ö 0 2,72 5 0 0 3 4,82 3 [2, 3, 4]
                 4,10 Ankomst 5 Ö 0 2,72 4 1 0 3 5,21 2 [3, 4]
                 4,41 Betalning 1 Ö 0 2,72 5 1 0 3 5,84 2 [3, 4]
                 4,70 Plock 5 Ö 0 2,72 4 2 0 3 6,13 1 [4]
                 5,16 Ankomst 6 Ö 0 2,72 4 2 0 4 7,04 2 [4, 5]
                 5,64 Ankomst 7 Ö 0 2,72 5 2 0 4 8,00 2 [4, 5]
                 5,70 Ankomst 8 Ö 0 2,72 5 2 1 4 8,11 2 [4, 5]
                 5,83 Plock 6 Ö 0 2,72 5 2 2 4 8,39 2 [4, 5]
                 6,76 Betalning 2 Ö 0 2,72 5 2 2 5 11,18 3 [4, 5, 6]
                 6,87 Betalning 3 Ö 0 2,72 4 3 2 5 11,39 2 [5, 6]
                 9,08 Betalning 5 Ö 0 2,72 3 4 2 5 13,60 1 [6]
                 9,10 Betalning 4 Ö 0 2,72 2 5 2 5 13,60 0 []
                 9,84 Ankomst 9 Ö 1 3,46 1 6 2 5 13,60 0 []
                10,00 Stänger --- Ö 1 3,62 2 6 2 5 13,60 0 []
                10,65 Plock 9 S 1 4,27 2 6 2 5 13,60 0 []
                10,74 Ankomst 10 S 0 4,27 2 6 2 5 13,60 0 []
                11,42 Betalning 6 S 0 4,27 2 6 2 5 13,60 0 []
                13,26 Betalning 9 S 1 6,11 1 7 2 5 13,60 0 []
                999,00 Stop
                RESULTAT
                ========
                1) Av 10 kunder handlade 8 medan 2 missades.
                2) Total tid 2 kassor varit lediga: 6,11 te.
                 Genomsnittlig ledig kassatid: 3,06 te (dvs 23,03% av tiden från öppning tills sista kunden
                betalat).
                3) Total tid 5 kunder tvingats köa: 13,60 te.
                 Genomsnittlig kötid: 2,72 te.
                """;

        // Remove all whitespace characters from the actual output and the expected outputs
        expectedOutputExampleOne = expectedOutputExampleOne.replaceAll("\\s", "");
        actualOutput = actualOutput.replaceAll("\\s", "");

        assertEquals(expectedOutputExampleOne, actualOutput);

        outContent.reset();
        // Run the main method with given arguments for example two
        String[] argumentsExampleTwo = new String[]{"2", "7", "3", "13", "0.35", "0.6", "0.6", "0.9", "8"}; //Example 2
        Main.main(argumentsExampleTwo);
        // Get the actual output captured
        String actualOutputTwo = outContent.toString().trim();

        // Expected output Example Two
        String expectedOutputExampleTwo = """
                PARAMETRAR
                ==========
                Antal kassor, N..........: 2
                Max som ryms, M..........: 7
                Ankomshastighet, lambda..: 3.0
                Plocktider, [P_min..Pmax]: [0.6..0.9]
                Betaltider, [K_min..Kmax]: [0.35..0.6]
                Frö, f...................: 13
                FÖRLOPP
                =======
                 Tid Händelse Kund ? led ledT I $ :-( köat köT köar [Kassakö..]
                 0,00 Start
                 0,10 Ankomst 0 Ö 2 0,21 0 0 0 0 0,00 0 []
                 0,38 Ankomst 1 Ö 2 0,75 1 0 0 0 0,00 0 []
                 0,92 Plock 0 Ö 2 1,85 2 0 0 0 0,00 0 []
                 1,11 Plock 1 Ö 1 2,03 2 0 0 0 0,00 0 []
                 1,37 Ankomst 2 Ö 0 2,03 2 0 0 0 0,00 0 []
                 1,46 Betalning 0 Ö 0 2,03 3 0 0 0 0,00 0 []
                 1,47 Ankomst 3 Ö 1 2,05 2 1 0 0 0,00 0 []
                 1,57 Betalning 1 Ö 1 2,15 3 1 0 0 0,00 0 []
                 1,77 Ankomst 4 Ö 2 2,55 2 2 0 0 0,00 0 []
                 1,98 Plock 2 Ö 2 2,97 3 2 0 0 0,00 0 []
                 2,29 Plock 3 Ö 1 3,28 3 2 0 0 0,00 0 []
                 2,34 Betalning 2 Ö 0 3,28 3 2 0 0 0,00 0 []
                 2,49 Plock 4 Ö 1 3,43 2 3 0 0 0,00 0 []
                 2,61 Ankomst 5 Ö 0 3,43 2 3 0 0 0,00 0 []
                 2,64 Ankomst 6 Ö 0 3,43 3 3 0 0 0,00 0 []
                 2,82 Betalning 3 Ö 0 3,43 4 3 0 0 0,00 0 []
                 2,95 Betalning 4 Ö 1 3,56 3 4 0 0 0,00 0 []
                 2,95 Ankomst 7 Ö 2 3,56 2 5 0 0 0,00 0 []
                 3,04 Ankomst 8 Ö 2 3,74 3 5 0 0 0,00 0 []
                 3,08 Ankomst 9 Ö 2 3,82 4 5 0 0 0,00 0 []
                 3,13 Ankomst 10 Ö 2 3,91 5 5 0 0 0,00 0 []
                 3,14 Ankomst 11 Ö 2 3,93 6 5 0 0 0,00 0 []
                 3,23 Plock 5 Ö 2 4,13 7 5 0 0 0,00 0 []
                 3,51 Plock 6 Ö 1 4,41 7 5 0 0 0,00 0 []
                 3,60 Betalning 5 Ö 0 4,41 7 5 0 0 0,00 0 []
                 3,67 Plock 7 Ö 1 4,47 6 6 0 0 0,00 0 []
                 3,87 Plock 8 Ö 0 4,47 6 6 0 0 0,00 0 []
                 3,94 Plock 9 Ö 0 4,47 6 6 0 1 0,08 1 [8]
                 3,99 Plock 10 Ö 0 4,47 6 6 0 2 0,16 2 [8, 9]
                 4,03 Plock 11 Ö 0 4,47 6 6 0 3 0,29 3 [8, 9, 10]
                 4,06 Ankomst 12 Ö 0 4,47 6 6 0 4 0,40 4 [8, 9, 10, 11]
                 4,09 Betalning 6 Ö 0 4,47 7 6 0 4 0,54 4 [8, 9, 10, 11]
                 4,12 Betalning 7 Ö 0 4,47 6 7 0 4 0,62 3 [9, 10, 11]
                 4,45 Ankomst 13 Ö 0 4,47 5 8 0 4 1,29 2 [10, 11]
                 4,47 Ankomst 14 Ö 0 4,47 6 8 0 4 1,32 2 [10, 11]
                 4,63 Betalning 8 Ö 0 4,47 7 8 0 4 1,65 2 [10, 11]
                 4,67 Plock 12 Ö 0 4,47 6 9 0 4 1,69 1 [11]
                 4,69 Betalning 9 Ö 0 4,47 6 9 0 5 1,72 2 [11, 12]
                 4,74 Ankomst 15 Ö 0 4,47 5 10 0 5 1,77 1 [12]
                 5,12 Ankomst 16 Ö 0 4,47 6 10 0 5 2,15 1 [12]
                 5,14 Plock 13 Ö 0 4,47 7 10 0 5 2,17 1 [12]
                 5,20 Betalning 10 Ö 0 4,47 7 10 0 6 2,28 2 [12, 13]
                 5,28 Betalning 11 Ö 0 4,47 6 11 0 6 2,37 1 [13]
                 5,32 Ankomst 17 Ö 0 4,47 5 12 0 6 2,37 0 []
                 5,33 Ankomst 18 Ö 0 4,47 6 12 0 6 2,37 0 []
                 5,35 Plock 14 Ö 0 4,47 7 12 0 6 2,37 0 []
                 5,47 Plock 15 Ö 0 4,47 7 12 0 7 2,49 1 [14]
                 5,56 Ankomst 19 Ö 0 4,47 7 12 0 8 2,66 2 [14, 15]
                 5,56 Betalning 12 Ö 0 4,47 7 12 1 8 2,67 2 [14, 15]
                 5,71 Betalning 13 Ö 0 4,47 6 13 1 8 2,82 1 [15]
                 5,81 Plock 16 Ö 0 4,47 5 14 1 8 2,82 0 []
                 6,08 Plock 17 Ö 0 4,47 5 14 1 9 3,09 1 [16]
                 6,15 Betalning 14 Ö 0 4,47 5 14 1 10 3,22 2 [16, 17]
                 6,17 Betalning 15 Ö 0 4,47 4 15 1 10 3,24 1 [17]
                 6,20 Ankomst 20 Ö 0 4,47 3 16 1 10 3,24 0 []
                 6,22 Plock 18 Ö 0 4,47 4 16 1 10 3,24 0 []
                 6,36 Ankomst 21 Ö 0 4,47 4 16 1 11 3,37 1 [18]
                 6,58 Betalning 16 Ö 0 4,47 5 16 1 11 3,60 1 [18]
                 6,65 Betalning 17 Ö 0 4,47 4 17 1 11 3,60 0 []
                 6,95 Plock 20 Ö 1 4,77 3 18 1 11 3,60 0 []
                 7,00 Plock 21 Ö 0 4,77 3 18 1 11 3,60 0 []
                 7,09 Ankomst 22 Ö 0 4,77 3 18 1 12 3,69 1 [21]
                 7,18 Betalning 18 Ö 0 4,77 4 18 1 12 3,77 1 [21]
                 7,43 Betalning 20 Ö 0 4,77 3 19 1 12 3,77 0 []
                 7,56 Betalning 21 Ö 1 4,91 2 20 1 12 3,77 0 []
                 7,88 Plock 22 Ö 2 5,54 1 21 1 12 3,77 0 []
                 8,00 Stänger --- Ö 1 5,66 1 21 1 12 3,77 0 []
                 8,38 Betalning 22 S 1 6,04 1 21 1 12 3,77 0 []
                 9,04 Ankomst 23 S 2 6,04 0 22 1 12 3,77 0 []
                999,00 Stop
                RESULTAT
                ========
                1) Av 23 kunder handlade 22 medan 1 missades.
                2) Total tid 2 kassor varit lediga: 6,04 te.
                 Genomsnittlig ledig kassatid: 3,02 te (dvs 36,04% av tiden från öppning tills sista kunden
                betalat).
                3) Total tid 12 kunder tvingats köa: 3,77 te.
                 Genomsnittlig kötid: 0,31 te.
                """;

        // Remove all whitespace characters from the actual output and the expected outputs
        expectedOutputExampleTwo = expectedOutputExampleTwo.replaceAll("\\s", "");
        actualOutputTwo = actualOutputTwo.replaceAll("\\s", "");

        assertEquals(expectedOutputExampleTwo, actualOutputTwo);

        // Restore System.out
        System.setOut(System.out);
    }
}