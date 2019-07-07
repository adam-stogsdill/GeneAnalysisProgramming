package bin.main;


import bin.main.ErrorManagement.GENEERROR;
import bin.main.ErrorManagement.GeneCreationError;

import java.util.Random;

/*
Adenine(A)
Guanine(G)
Cytosine(C)
Thymine(T)
 */
public class GeneCreation {

    public static void check_if_Possible(char[] sequence) throws GeneCreationError {
        for(int i = 0; i < sequence.length; i++){
            if (sequence[i] != 'A' && sequence[i] != 'G' && sequence[i] != 'C' && sequence[i] != 'T') {
                System.out.println("This sequence is invalid at index " + i);
                System.out.println(sequence[i] + " is not a valid character");
                throw new GeneCreationError(GENEERROR.INVALID_CHARACTER);
            }
        }
    }

    public static String randomGene(int size) {
        Random random = new Random();
        char[] result = new char[size];
        for(int i = 0; i < size; i++){
            int guess = random.nextInt(4);
            if(guess == 0)
                result[i] = 'A';
            else if(guess == 1)
                result[i] = 'G';
            else if(guess == 2)
                result[i] = 'C';
            else if(guess == 3)
                result[i] = 'T';
        }
        return new String(result);
    }
}
