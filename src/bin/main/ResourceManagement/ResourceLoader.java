package bin.main.ResourceManagement;

import bin.main.ErrorManagement.GeneCreationError;
import bin.main.Gene_Main.GeneDatabase;
import bin.main.pattern_analysis.GeneCodeHandler;

import java.io.IOException;

public class ResourceLoader {

    public static void INIT_LOADING(){
        try {
            GeneDatabase.load_database();
            GeneDatabase.print_database();
        }catch (GeneCreationError | IOException geneCreationError) {
            System.out.println("ERROR IN LOADING GENE DATABASE!");
        }
        try {
            GeneCodeHandler.load_gene_code_dictionary();
        } catch (IOException e) {
            System.out.println("ERROR IN LOADING GENE CODE DICTIONARY!");
        }
    }
}
