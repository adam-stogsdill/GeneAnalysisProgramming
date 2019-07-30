package bin.main.Gene_Main;

import bin.main.ErrorManagement.GENEERROR;
import bin.main.ErrorManagement.GeneCreationError;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class GeneDatabase {
    private static HashMap<String, Gene> geneDatabase = new HashMap<>();

    public HashMap<String, Gene> getGeneDatabase() {
        return geneDatabase;
    }

    public static void LoadDatabase() throws IOException, GeneCreationError {
        File[] files = new File("resources/GeneDatabaseInformation").listFiles();
        for(File f: files){
            if (f.isFile()){
                if(!f.getName().substring(f.getName().indexOf(".")).equals(".fasta"))
                    throw new GeneCreationError(GENEERROR.INVALID_FILE_FORMAT);
                //System.out.printf("%s\n", f.getName());
                geneDatabase.put(f.getName().substring(0,f.getName().indexOf(".")), new Gene(GeneFileReader.getInformation(f.getPath())));
            }
        }
    }


    public static String printDatabase(){
        String[] list = geneDatabase.keySet().toArray(new String[geneDatabase.keySet().size()]);
        Arrays.sort(list);
        for(String s: list){
            System.out.printf("Gene_Name:%s\t%s\tRange: %s\n\t%s\n", s,geneDatabase.get(s).getCytogenicLocation().toString(), geneDatabase.get(s).getCytogenicLocation().getRange()
                    , geneDatabase.get(s));
        }
        return "";
    }
}
