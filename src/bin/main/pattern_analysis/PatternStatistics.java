package bin.main.pattern_analysis;

import bin.main.Gene_Main.Gene;

import java.util.HashMap;

/**
 * Methods to analyze patterns within genes.
 */
public class PatternStatistics {
    private HashMap<String, Integer> set = new HashMap<>();
    private int restricted_genome_size;

    /**
     * Adds a gene with a given restricted genome size.
     * @param size The restricted genome size.
     * @param g1 The genome to be added.
     */
    public PatternStatistics(int size, Gene... g1) {
        this.restricted_genome_size = size;
        this.constructHashMap(g1);
    }

    /**
     * Adds a gene without a restricted genome size.
     * @param g1 The gene to be added.
     */
    public PatternStatistics(Gene... g1) {
        this.restricted_genome_size = 0;
        this.constructHashMap(g1);
    }

    /**
     * Constructs a list of possible slices at a certain size and placed into a {@code HashMap}.
     * Usually run when creating the {@code PatternStatistics} object.
     *
     * @param gene_list List of genomes that will be added to the {@code HashMap}.
     */
    private void constructHashMap(Gene... gene_list) {
        if (this.restricted_genome_size == 0)
            System.out.println("BUILDING PATTERN SET THAT CONTAINS VARYING GENOME SIZE \n");
        else
            System.out.println("BUILDING PATTERN SET THAT CONTAINS RESTRICTED GENOME SIZE OF " + this.restricted_genome_size + "\n");

        for (Gene gene : gene_list) {
            redirect_gene(gene);
        }
    }

    /**
     * Analyzes a gene with unrestricted genome size.
     * @param gene The gene to be analyzed.
     */
    private void unrestrictedGenePatternLoop(Gene gene) {
        for (int j = 1; j < gene.size(); j++) {
            for (int i = 0; i <= gene.size() - j; i++) {
                String gene_String = gene.toString().substring(i, i + j);
                System.out.println("ANALYZING CURRENT GENE {" + gene.toString() + "} AND OBSERVING SLICE: " + gene_String);
                if (!set.containsKey(gene_String))
                    this.set.put(gene_String, 1);
                else
                    this.set.replace(gene_String, this.set.get(gene_String), this.set.get(gene_String) + 1);
            }
        }
    }

    /**
     * Method that uses the restraints given by the program for creating slices of the information.
     * @param gene The gene to be analyzed.
     */
    private void restrictedGenePatternLoop(Gene gene) {
        for (int i = 0; i <= gene.size() - this.restricted_genome_size; i++) {
            String gene_String = gene.toString().substring(i, i + this.restricted_genome_size);
            System.out.println("ANALYZING CURRENT GENE {" + gene.toString() + "} AND OBSERVING SLICE: " + gene_String);
            if (!set.containsKey(gene_String))
                this.set.put(gene_String, 1);
            else {

                this.set.replace(gene_String, this.set.get(gene_String) + 1);
            }
        }
    }

    /**
     * Adds a genome to the {@code HashMap}.
     * @param g The gene to be added.
     */
    private void redirect_gene(Gene g) {
        if (this.restricted_genome_size == 0)
            unrestrictedGenePatternLoop(g);
        else
            restrictedGenePatternLoop(g);
    }

    /**
     * Returns a string representation of the patterns built with genes.
     * @return A pattern string.
     */
    @Override
    public String toString() {
        System.out.println("\nBUILDING PATTERN STRING THAT CONTAINS RESTRICTED GENOME SIZE OF " + this.restricted_genome_size + "\n");
        StringBuilder s = new StringBuilder();
        for (String g : this.set.keySet()) {
            s.append(g).append(": ").append(this.set.get(g)).append("\n");
        }
        return s.toString();
    }

    public HashMap get_set(){
        return this.set;
    }
}
