package bin.main.Gene_Main;


import bin.main.ErrorManagement.GeneCreationError;

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

    /**
     * To create a gene one must first feed the length of the gene sequence for further creation
     * @param sequence This is simply a sequence that you already have to feed into the information
     */
    public Gene(String sequence){
        try {
            GeneCreation.check_if_Possible(sequence.toCharArray());
        } catch (GeneCreationError e) {
            e.printStackTrace();
            return;
        }
        this.gene_information = sequence.toCharArray();
    }


    public int size(){ return this.gene_information.length; }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.gene_information.length; i++) {
            str.append(this.gene_information[i]);
        }
        return str.toString();
    }

    public char[] getGene_information() {
        return gene_information;
    }
}
