package bin.main.pattern_analysis;

import bin.main.Gene_Main.Gene;

import java.util.HashMap;

public class Pattern_Statistics {
    private HashMap<String, Integer> set = new HashMap<>();
    private int restricted_genome_size;

    public Pattern_Statistics(int size, Gene... g1) {
        this.restricted_genome_size = size;
        this.constructHashMap(g1);
    }

    public Pattern_Statistics(Gene... g1) {
        this.restricted_genome_size = 0;
        this.constructHashMap(g1);
    }

    /**
     * Construct Hash Map method is usually run when creating the Pattern_Statistics Object that creates a list of possible slices at a certain size
     *
     * @param gene_list List of genomes that will be added to the HashMap
     */
    private void constructHashMap(Gene... gene_list) {
        if (this.restricted_genome_size == 0)
            System.out.println("BUILDING PATTERN SET THAT CONTAINS VARYING GENOME SIZE \n");
        else
            System.out.println("BUILDING PATTERN SET THAT CONTAINS RESTRICTED GENOME SIZE OF " + this.restricted_genome_size + "\n");

        for (Gene gene : gene_list) {
            if (this.restricted_genome_size == 0)
                unrestrictedGenePatternLoop(gene);
            else
                restrictedGenePatternLoop(gene);
        }
    }

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

    public void addGenomeToSet(Gene g) {
        if (this.restricted_genome_size == 0)
            unrestrictedGenePatternLoop(g);
        else
            restrictedGenePatternLoop(g);
    }

    @Override
    public String toString() {
        System.out.println("\nBUILDING PATTERN STRING THAT CONTAINS RESTRICTED GENOME SIZE OF " + this.restricted_genome_size + "\n");
        StringBuilder s = new StringBuilder();
        for (String g : this.set.keySet()) {
            s.append(g + ": " + this.set.get(g) + "\n");
        }
        return s.toString();
    }

}
