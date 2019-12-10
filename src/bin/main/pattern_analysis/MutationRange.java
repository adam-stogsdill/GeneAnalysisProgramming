package bin.main.pattern_analysis;

import bin.main.Gene_Main.Gene;
import bin.main.categorization.MutationCategory;

public class MutationRange {

    private int start;
    private int stop;
    private Gene expected_gene;
    private Gene unexpected_mutation;
    private int pair;
    private MutationCategory mg;

    public MutationRange(int start, int stop, int pair, Gene expected_gene, Gene unexpected_mutation, MutationCategory mg){
        this.start = start;
        this.stop = stop;
        this.pair = pair;
        this.expected_gene = expected_gene;
        this.unexpected_mutation = unexpected_mutation;
        this.mg = mg;
    }

    public MutationRange(int start, int stop, int pair, Gene expected_gene, Gene unexpected_mutation){
        this.start = start;
        this.stop = stop;
        this.pair = pair;
        this.expected_gene = expected_gene;
        this.unexpected_mutation = unexpected_mutation;
        if(unexpected_mutation.size() == 1){
            this.mg = MutationCategory.POINT_MUTATION;
        }
    }

    @Override
    public String toString(){
        return String.format("[%d,%d] Pair:%d Mutation: \n\tExpected: %s \n\tUnexpected: %s",
                this.start, this.stop, this.pair, this.expected_gene.toString(),
                this.unexpected_mutation.toString());
    }

    public int getStart() {
        return start;
    }

    public int getStop() {
        return stop;
    }

    public Gene getExpected_mutation() {
        return expected_gene;
    }

    public Gene getUnexpected_mutation() {
        return unexpected_mutation;
    }

    public int getPair() {
        return pair;
    }

    public MutationCategory getMg() {
        return mg;
    }
}
