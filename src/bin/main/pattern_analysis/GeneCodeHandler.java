package bin.main.pattern_analysis;

import bin.main.Gene_Main.Gene;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class GeneCodeHandler {

    public static HashMap<String, String> code_dictionary = new HashMap<>();


    // Algorithms that will encode the input_gene and reduces the size of the gene by a factor of 3
    // Can be used for finding mutations
    public static String convert_gene_to_code(Gene input_gene){
        StringBuilder result = new StringBuilder();
        for(int x = 0; x < input_gene.get_gene_information().length - 3; x+=3){
            result.append(code_dictionary.get("" + input_gene.get_gene_information()[x] + input_gene.get_gene_information()[x + 1] + input_gene.get_gene_information()[x + 3]));
        }
        return result.toString();
    }

    // Loads the Gene -> Code conversion guide. This needs to be run before anything else can.
    public static void load_gene_code_dictionary() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("resources/Standard Genetic Code"));
        String input;
        while((input = bf.readLine()) != null){
            String[] parsed_input = input.split(" ");
            code_dictionary.put(parsed_input[0], parsed_input[1]);
        }
    }

    @Override
    public String toString(){
        return code_dictionary.toString();
    }

}
