package bin.main.Gene_Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ChromosomeData {
    private HashMap<Integer, Gene> chromosome_information_1;
    private HashMap<Integer, Gene> chromosome_information_2;

    //How to organize Chromosome Data File
    /*
    First part of the line is the chromosome that we are operating on
    Rest of that line is the next 200 pairs of that chromosome's information
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
     *
     * @param chromosome
     * @param sequence
     */
    public ChromosomeData(Integer chromosome, String sequence) {
        this.chromosome_information_1 = new HashMap<>();
        this.chromosome_information_1.put(chromosome, new Gene(sequence));
        this.chromosome_information_2 = new HashMap<>();
        this.chromosome_information_2.put(chromosome, new Gene(sequence));

    }

    public Pair<HashMap<Integer, Gene>> getChromosome_information() {
        return new Pair<HashMap<Integer, Gene>>(chromosome_information_1, chromosome_information_2);
    }
}
