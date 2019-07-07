package bin.main.bin.pattern_analysis;

import bin.main.Gene;

import java.util.HashMap;

public class Pattern_Statistics {
    HashMap<Gene, Integer> set = new HashMap<>();
    private int restricted_genome_size;

    public Pattern_Statistics(int size, Gene... g1) {
        this.restricted_genome_size = size;
        this.constructHashMap(g1);
    }

    public void constructHashMap(Gene... gene_list) {
        System.out.println("BUILDING PATTERN SET THAT CONTAINS RESTRICTED GENOME SIZE OF " + this.restricted_genome_size + "\n");
        for (Gene gene : gene_list) {
            for (int i = 0; i <= gene.size() - this.restricted_genome_size; i++) {
                System.out.println("ANALYZING CURRENT GENE {" + gene.toString() + "} AND OBSERVING SLICE: " + gene.toString().substring(i, i + this.restricted_genome_size));
                if (!set.containsKey(new Gene(gene.toString().substring(i, i + this.restricted_genome_size))))
                    this.set.put(new Gene(gene.toString().substring(i, i + this.restricted_genome_size)), 1);
                else
                    this.set.get(new Gene(gene.toString().substring(i, i + this.restricted_genome_size)));
            }
        }
    }

    @Override
    public String toString() {
        System.out.println("\nBUILDING PATTERN STRING THAT CONTAINS RESTRICTED GENOME SIZE OF " + this.restricted_genome_size + "\n");
        StringBuilder s = new StringBuilder();
        for (Gene g : this.set.keySet()) {
            s.append(g.toString() + ": " + this.set.get(g) + "\n");
        }
        return s.toString();
    }

}
