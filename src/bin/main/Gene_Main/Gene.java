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

/**
 * Contains the sequence, location, and name of a specific gene.
 */
public class Gene {

    private char[] gene_information;
    private GeneCytogenicLocation loc;
    private String name;

    /**
     * Creates a Gene given only the gene sequence and the gene's cytogenic location.
     * To create a gene one must first feed the length of the gene sequence for further creation.
     *
     * @param sequence This is simply a sequence that you already have to feed into the information
     * @param loc This is the GeneCytogenicLocation of the sequence relative to a chromosome's information
     *
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

    public Gene(char[] a){
        this.gene_information = a;
    }

    /**
     * Creates a Gene given only the gene sequence.
     * @param sequence The sequence of the gene.
     */
    public Gene(String sequence) {
        try {
            GeneCreation.check_if_Possible(sequence.toCharArray());
        } catch (GeneCreationError e) {
            e.printStackTrace();
            return;
        }
        this.gene_information = sequence.toCharArray();
    }

    /**
     * Allows the program to make a Gene with a name. Primarily used for the Gene Database for the user to pursue more information
     * about the gene and its possible mutation effects.
     * @param sequence The specified sequence of the Gene with a String that will later be parsed into a char[]
     * @param name The name of the gene.
     */
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
            this.loc = new GeneCytogenicLocation(Integer.parseInt(parsed_sequence[0]), parsed_sequence[1].charAt(0),
                    Integer.parseInt(parsed_sequence[2]), Integer.parseInt(parsed_sequence[3]), Integer.parseInt(parsed_sequence[4]),
                    Integer.parseInt(parsed_sequence[5]), Integer.parseInt(parsed_sequence[6]));

            //System.out.println(this.loc);
        }catch(GeneCreationError e){
            e.printStackTrace();
        }catch (GenomeDatabaseError e){
            e.printStackTrace();
        }
        this.gene_information = parsed_sequence[7].toCharArray();
    }


    /**
     * Returns the number of pairs inside of the gene. (Size of the gene_information char[])
     *
     * @return Number of pairs in gene.
     */
    public int size() {
        return this.gene_information.length;
    }


    /**
     * Simply returns the gene's pairs inside of a String to be printed if chosen.
     *
     * @return Converted char[] to String.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (char c : this.gene_information) {
            str.append(c);
        }
        return str.toString();
    }


    /**
     * This returns the char array containing each individual pair inside of it.
     * @return The gene information.
     */
    public char[] getGene_information() {
        return gene_information;
    }

    /**
     * This returns the name of the gene.
     * @return The name of the gene.
     */
    public String getName(){return this.name;}

    /**
     * Returns the gene's cytogenic location.
     * @return The gene cytogenic location.
     */
    public GeneCytogenicLocation getCytogenicLocation() {
        return loc;
    }
}
