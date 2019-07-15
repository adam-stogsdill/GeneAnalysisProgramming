package bin.main.Gene_Main;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ChromosomeData {
    private static HashMap<Integer, ArrayList<Gene>> patient_chromosome_information;

    public ChromosomeData(File file) throws FileNotFoundException {
        if (file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
