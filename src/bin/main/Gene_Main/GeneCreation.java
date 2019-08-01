package bin.main.Gene_Main;
import bin.main.ErrorManagement.GENEERROR;
import bin.main.ErrorManagement.GeneCreationError;

import java.util.Random;

/*
Adenine(A)
Guanine(G)
Cytosine(C)
Thymine(T)
 */

/**
 * This class is used for testing purposes so you can test certain systems inside of the actual program.
 */
public class GeneCreation {

    public static void check_if_Possible(char[] sequence) throws GeneCreationError {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] != 'A' && sequence[i] != 'G' && sequence[i] != 'C' && sequence[i] != 'T') {
                System.out.println("This sequence is invalid at index " + i);
                System.out.println(sequence[i] + " is not a valid character");
                throw new GeneCreationError(GENEERROR.INVALID_CHARACTER);
            }
        }
    }

    public static String randomGene(int size) {
        System.out.println("Generating a random gene of " + size + " pairs!");
        Random random = new Random();
        char[] result = new char[size];
        for (int i = 0; i < size; i++) {
            int guess = random.nextInt(4);
            if (guess == 0)
                result[i] = 'A';
            else if (guess == 1)
                result[i] = 'G';
            else if (guess == 2)
                result[i] = 'C';
            else if (guess == 3)
                result[i] = 'T';
        }
        System.out.println("Gene has been created!");
        return new String(result);
    }
}
