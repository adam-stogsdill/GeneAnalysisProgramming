package bin.main.Gene_Main;

import bin.main.ErrorManagement.GENEERROR;
import bin.main.ErrorManagement.GeneCreationError;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GeneDatabase {
    private static HashMap<Integer, ArrayList<Gene>> nonMutatedGenome = new HashMap<>();

    public static void LoadDatabase() throws IOException, GeneCreationError {
        File[] files = new File("resources/GeneDatabaseInformation").listFiles();
        for(File f: files){
            if (f.isFile()){
                if(!f.getName().substring(f.getName().indexOf(".")).equals(".fasta"))
                    throw new GeneCreationError(GENEERROR.INVALID_FILE_FORMAT);
                //System.out.printf("%s\n", f.getName());
                String gene_name = f.getName().substring(0,f.getName().indexOf("."));
                Gene input = new Gene(GeneFileReader.getInformation(f.getPath()), gene_name);
                int CHROMOSOME = input.getCytogenicLocation().getChromosome();
                if(!nonMutatedGenome.containsKey(CHROMOSOME)){
                    nonMutatedGenome.put(CHROMOSOME, new ArrayList<>());
                }
                nonMutatedGenome.get(CHROMOSOME).add(input);
            }
        }
    }


    public static String printDatabase(){
        Integer[] list = nonMutatedGenome.keySet().toArray(new Integer[nonMutatedGenome.keySet().size()]);
        Arrays.sort(list);
        for(Integer s: list){
            for(Gene g: nonMutatedGenome.get(s)){
                System.out.printf("Gene_Name:%s\t%s\tRange: %s\n\t%s\n", g.getName(),g.getCytogenicLocation().toString(), g.getCytogenicLocation().getRange(),
                        g);
            }
        }
        return "";
    }


}
