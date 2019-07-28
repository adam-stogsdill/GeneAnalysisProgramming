package bin.main.Gene_Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ChromosomeData {
    private static HashMap<Integer, ArrayList<Gene>> patient_chromosome_information;


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


}
