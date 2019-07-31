package bin.main.Gene_Main;


import bin.main.ErrorManagement.GeneCreationError;
import bin.main.ErrorManagement.GenomeDatabaseError;

/*
Adenine(A)
Guanine(G)
Cytosine(C)
Thymine(T)

Reference Material
https://towardsdatascience.com/dna-sequence-data-analysis-starting-off-in-bioinformatics-3dba4cea04f
 */
public class Gene {

    private char[] gene_information;
    private GeneCytogenicLocation loc;
    private String name;

    /**
     * To create a gene one must first feed the length of the gene sequence for further creation
     *
     * @param sequence This is simply a sequence that you already have to feed into the information
     */
    public Gene(String sequence, GeneCytogenicLocation loc) {
        try {
            GeneCreation.check_if_Possible(sequence.toCharArray());
        } catch (GeneCreationError e) {
            e.printStackTrace();
            return;
        }
        this.loc = loc;
        this.gene_information = sequence.toCharArray();
    }

    public Gene(String sequence, String name) {
        String[] parsed_sequence = sequence.split(",");
        this.name = name;
        try {
            GeneCreation.check_if_Possible(parsed_sequence[7].toCharArray());
        } catch (GeneCreationError e) {
            e.printStackTrace();
            return;
        }
        try {
            this.loc = new GeneCytogenicLocation(Integer.valueOf(parsed_sequence[0]), parsed_sequence[1].charAt(0),
                    Integer.valueOf(parsed_sequence[2]), Integer.valueOf(parsed_sequence[3]), Integer.valueOf(parsed_sequence[4]),
                    Integer.valueOf(parsed_sequence[5]), Integer.valueOf(parsed_sequence[6]));
            //System.out.println(this.loc);
        }catch(GeneCreationError e){
            e.printStackTrace();
        }catch (GenomeDatabaseError e){
            e.printStackTrace();
        }
        this.gene_information = parsed_sequence[7].toCharArray();
    }


    /**
     * Returns the number of pairs inside of the gene.
     *
     * @return Number of pairs in gene.
     */
    public int size() {
        return this.gene_information.length;
    }


    /**
     * Simply returns the gene's pairs inside of a String to be printed if chosen.
     *
     * @return Char[] into String
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.gene_information.length; i++) {
            str.append(this.gene_information[i]);
        }
        return str.toString();
    }


    /**
     * This returns the char array containing each individual pair inside of it.
     * @return Returns the gene information
     */
    public char[] getGene_information() {
        return gene_information;
    }

    public String getName(){return this.name;}

    public GeneCytogenicLocation getCytogenicLocation() {
        return loc;
    }
}
