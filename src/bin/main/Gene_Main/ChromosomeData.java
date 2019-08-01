package bin.main.Gene_Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ChromosomeData {
    private HashMap<Integer, Gene> chromosome_information;


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

    public ChromosomeData(Integer chromosome, String sequence) {
        this.chromosome_information = new HashMap<>();
        this.chromosome_information.put(chromosome, new Gene(sequence));
    }

    public HashMap<Integer, Gene> getChromosome_information() {
        return chromosome_information;
    }
}
