package bin.main.pattern_analysis;

import bin.main.Gene_Main.Gene;
import bin.main.categorization.MutationCategory;

public class MutationRange {

    private int start;
    private int stop;
    private Gene expected_mutation;
    private Gene unexpected_mutation;
    private int pair;
    private MutationCategory mg;

    public MutationRange(int start, int stop, int pair, Gene expected_mutation, Gene unexpected_mutation, MutationCategory mg){
        this.start = start;
        this.stop = stop;
        this.pair = pair;
        this.expected_mutation = expected_mutation;
        this.unexpected_mutation = unexpected_mutation;
        this.mg = mg;
    }

    @Override
    public String toString(){
        return String.format("[%d,%d] Pair:%d Mutation: \nExpected: %s \nUnexpected: %s", this.start, this.stop, this.pair, this.expected_mutation.toString(), this.unexpected_mutation.toString());
    }
}
