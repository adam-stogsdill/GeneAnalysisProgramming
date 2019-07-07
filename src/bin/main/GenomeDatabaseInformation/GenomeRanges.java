package bin.main.GenomeDatabaseInformation;

import bin.main.ErrorManagement.GenomeDatabaseError;
import bin.main.ErrorManagement.GenomeError;

public class GenomeRanges {

    private int chromosome;
    private char arm;
    private int region;
    private int band;
    private int sub_band;

    private int upperBound;
    private int lowerBound;

    //https://www.ncbi.nlm.nih.gov/genome/gdv/browser/?context=genome&acc=GCF_000001405.39

    public GenomeRanges(int chromosome, int arm, int region, int band, int upperBound, int lowerBound) throws GenomeDatabaseError {
        if (chromosome < 1 || chromosome > 23)
            throw new GenomeDatabaseError(GenomeError.INVALID_CHROMOSOME_NUMBER);


    }
}
