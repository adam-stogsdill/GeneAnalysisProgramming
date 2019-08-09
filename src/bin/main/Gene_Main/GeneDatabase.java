package bin.main.Gene_Main;

import bin.main.ErrorManagement.GENEERROR;
import bin.main.ErrorManagement.GeneCreationError;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Management of the gene database to be used by the application.  Contains a HashMap which is eventually loaded with non-mutated genes.
 */
public class GeneDatabase {

    //This is the data structure that stores all of the database information. It is organized by Chromosome #.
    public static HashMap<Integer, ArrayList<Gene>> nonMutatedGenome = new HashMap<>();

    /**
     * Loads the gene database into a HashMap.  This must be called before starting gene analysis.
     * @throws IOException The file could not be found or loaded properly.
     * @throws GeneCreationError The gene could not be properly created.
     */
    public static void LoadDatabase() throws IOException, GeneCreationError {
        File[] files = new File("resources/GeneDatabaseInformation").listFiles();
        assert files != null;
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

    /**
     * Outputs the HashMap of the non-mutated genes into the console.
     */
    public static void printDatabase(){
        Integer[] list = nonMutatedGenome.keySet().toArray(new Integer[nonMutatedGenome.keySet().size()]);
        Arrays.sort(list);
        for(Integer s: list){
            for(Gene g: nonMutatedGenome.get(s)){
                //This print statment nullifys the printing of the actual Gene for cleaner terminal output
                System.out.printf("Gene_Name:%s\t%s\tRange: %s\n", g.getName(),g.getCytogenicLocation().toString(), g.getCytogenicLocation().getRange());
                //System.out.printf("Gene_Name:%s\t%s\tRange: %s\n\t%s\n", g.getName(),g.getCytogenicLocation().toString(), g.getCytogenicLocation().getRange(), g);
            }
        }
    }


}
