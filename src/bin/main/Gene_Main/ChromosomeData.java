package bin.main.Gene_Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Stores the chromosome data and gene sequence provided.
 */
public class ChromosomeData {
    private HashMap<Integer, Gene> chromosome_information;


    //How to organize Chromosome Data File
    /*
    First part of the line is the chromosome that we are operating on
    Rest of that line is the next 200 pairs of that chromosome's information
     */

    /**
     * Takes in or creates a file and adds in chromosome data to the file.
     * @param file The file location.
     * @throws IOException Thrown if the file cannot be edited or created.
     */
    public ChromosomeData(File file) throws IOException {
        if (file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {

            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates a new instance with the chromosome number and attached gene sequence.  This information is stored in a {@code HashMap}.
     * @param chromosome The chromosome number.
     * @param sequence The gene sequence.
     */
    public ChromosomeData(Integer chromosome, String sequence) {
        this.chromosome_information = new HashMap<>();
        this.chromosome_information.put(chromosome, new Gene(sequence));
    }

    /**
     * Retrieves a {@code HashMap} of the stored chromosome information.
     * @return The chromosome information as a {@code HashMap}.
     */
    public HashMap<Integer, Gene> getChromosome_information() {
        return chromosome_information;
    }
}
