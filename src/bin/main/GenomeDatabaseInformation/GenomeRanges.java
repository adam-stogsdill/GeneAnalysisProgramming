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

    public GenomeRanges(int chromosome, char arm, int region, int band, int sub_band, int lowerBound, int upperBound) throws GenomeDatabaseError {
        if (chromosome < 1 || chromosome > 23)
            throw new GenomeDatabaseError(GenomeError.INVALID_CHROMOSOME_NUMBER);
        if (arm != 'p' || arm != 'q')
            throw new GenomeDatabaseError(GenomeError.INVALID_ARM_CHARACTER);
        if (this.singleDigit(region) || this.singleDigit(band) || this.singleDigit(sub_band))
            throw new GenomeDatabaseError(GenomeError.INVALID_NUMBER_LENGTH);

        this.chromosome = chromosome;
        this.arm = arm;
        this.region = region;
        this.band = band;
        this.sub_band = sub_band;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;



    }

    private boolean singleDigit(int i) {
        return !(i % 10 == 0);
    }
}
