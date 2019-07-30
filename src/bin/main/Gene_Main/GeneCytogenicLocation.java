package bin.main.Gene_Main;

import bin.main.ErrorManagement.GENEERROR;
import bin.main.ErrorManagement.GeneCreationError;
import bin.main.ErrorManagement.GenomeDatabaseError;
import bin.main.ErrorManagement.GenomeError;
import bin.main.GenomeDatabaseInformation.GenomeRanges;

public class GeneCytogenicLocation {
    /*
    https://ghr.nlm.nih.gov/primer/howgeneswork/genelocation
     */

    private int chromosome;
    private char arm;
    private int region;
    private int band;
    private int sub_band;

    public GeneCytogenicLocation(int chromosome, char arm, int region, int band) throws GeneCreationError, GenomeDatabaseError {
        if (chromosome < 1 || chromosome > 23)
            throw new GeneCreationError(GENEERROR.INVALID_CHROMOSOME);
        if (arm != 'p' && arm != 'q')
            throw new GeneCreationError(GENEERROR.INVALID_ARM);
        if (!GenomeRanges.singleDigit(region) || !GenomeRanges.singleDigit(band))
            throw new GenomeDatabaseError(GenomeError.INVALID_NUMBER_LENGTH);
        Location(chromosome, arm, region, band, 0);
    }

    public GeneCytogenicLocation(int chromosome, char arm, int region, int band, int sub_band) throws GeneCreationError, GenomeDatabaseError {
        if (chromosome < 1 || chromosome > 23)
            throw new GeneCreationError(GENEERROR.INVALID_CHROMOSOME);
        if (arm != 'p' && arm != 'q')
            throw new GeneCreationError(GENEERROR.INVALID_ARM);
        if (!GenomeRanges.singleDigit(region) || !GenomeRanges.singleDigit(band) || !GenomeRanges.singleDigit(sub_band))
            throw new GenomeDatabaseError(GenomeError.INVALID_NUMBER_LENGTH);

        Location(chromosome, arm, region, band, sub_band);
    }

    private void Location(int chromosome, char arm, int region, int band, int sub_band){
        this.chromosome = chromosome;
        this.arm = arm;
        this.region = region;
        this.band = band;
        this.sub_band = sub_band;
    }

    @Override
    public String toString(){
        return "" + chromosome + arm + region + band + "." + sub_band;
    }
}
