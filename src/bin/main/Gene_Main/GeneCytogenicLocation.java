package bin.main.Gene_Main;

import bin.main.ErrorManagement.GENEERROR;
import bin.main.ErrorManagement.GeneCreationError;
import bin.main.ErrorManagement.GenomeDatabaseError;
import bin.main.ErrorManagement.GenomeError;
import bin.main.GenomeDatabaseInformation.GenomeRanges;

/**
 * Holds the cytogenic location of a gene on a chromosome.
 */
public class GeneCytogenicLocation {
    /*
    https://ghr.nlm.nih.gov/primer/howgeneswork/genelocation
     */

    private int chromosome;
    private char arm;
    private int region;
    private int band;
    private int sub_band;
    private int start;
    private int stop;

    /**
     * Creates a GeneCytogenicLocation without a specified sub-band.  The sub-band is defaulted to 0, marking it as non-important.
     *
     * @param chromosome The chromosome where the gene is located.
     * @param arm The arm position of the gene.  'P' is the short arm and "Q' is the long arm.
     * @param region The region of the gene.
     * @param band The band of the gene.
     * @param start The start range of the gene.
     * @param stop The stop range of the gene.
     * @throws GeneCreationError The gene could not be properly created.
     * @throws GenomeDatabaseError Thrown if the gene is not a valid gene.
     */
    public GeneCytogenicLocation(int chromosome, char arm, int region, int band, int start, int stop) throws GeneCreationError, GenomeDatabaseError {
        if (chromosome < 1 || chromosome > 23)
            throw new GeneCreationError(GENEERROR.INVALID_CHROMOSOME);
        if (arm != 'p' && arm != 'q')
            throw new GeneCreationError(GENEERROR.INVALID_ARM);
        if (!GenomeRanges.singleDigit(region) || !GenomeRanges.singleDigit(band))
            throw new GenomeDatabaseError(GenomeError.INVALID_NUMBER_LENGTH);
        Location(chromosome, arm, region, band, 0, start, stop);
    }

    /**
     * Creates a GeneCytogenicLocation with a specified sub-band.
     *
     * @param chromosome The chromosome where the gene is located.
     * @param arm The arm position of the gene.  'P' is the short arm and "Q' is the long arm.
     * @param region The region of the gene.
     * @param band The band of the gene.
     * @param start The start range of the gene.
     * @param stop The stop range of the gene.
     * @throws GeneCreationError The gene could not be properly created.
     * @throws GenomeDatabaseError Thrown if the gene is not a valid gene.
     */
    public GeneCytogenicLocation(int chromosome, char arm, int region, int band, int sub_band, int start, int stop) throws GeneCreationError, GenomeDatabaseError {
        if (chromosome < 1 || chromosome > 23)
            throw new GeneCreationError(GENEERROR.INVALID_CHROMOSOME);
        if (arm != 'p' && arm != 'q')
            throw new GeneCreationError(GENEERROR.INVALID_ARM);
        if (!GenomeRanges.singleDigit(region) || !GenomeRanges.singleDigit(band) || !GenomeRanges.singleDigit(sub_band))
            throw new GenomeDatabaseError(GenomeError.INVALID_NUMBER_LENGTH);

        Location(chromosome, arm, region, band, sub_band, start, stop);
    }

    /**
     * Stores the specific location of the gene, and its information
     * @param chromosome The chromosome where the gene is located.
     * @param arm The arm position of the gene.  'P' is the short arm and "Q' is the long arm.
     * @param region The region of the gene.
     * @param band The band of the gene.
     * @param sub_band The sub-band of the gene.
     * @param start The start range of the gene.
     * @param stop The stop range of the gene.
     */
    private void Location(int chromosome, char arm, int region, int band, int sub_band, int start, int stop){
        this.chromosome = chromosome;
        this.arm = arm;
        this.region = region;
        this.band = band;
        this.sub_band = sub_band;
        this.start = start;
        this.stop = stop;
    }

    @Override
    public String toString(){
        return "" + chromosome + arm + region + band + "." + sub_band;
    }

    /**
     * Retrieves the range of the gene.
     * @return The range of the gene.
     */
    public String getRange() {return "("+ this.start + "-" + this.stop+")";}

    /**
     * Retrieves the beginning of the range of the gene.
     * @return The start range of the gene.
     */
    public Integer getStart() {return this.start;}

    /**
     * Retrieves the end of the range of the gene.
     * @return The stop range of the gene.
     */
    public Integer getStop() {return this.stop;}

    /**
     * Returns the number of the chromosome where the gene is located.
     * @return The integer of the chromosome number.
     */
    public int getChromosome() {return this.chromosome;}
}
