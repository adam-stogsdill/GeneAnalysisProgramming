package bin.main.GenomeDatabaseInformation;

import bin.main.ErrorManagement.GenomeDatabaseError;
import bin.main.ErrorManagement.GenomeError;
import org.jetbrains.annotations.Contract;

public class GenomeRanges {

    private int chromosome;
    private char arm;
    private int region;
    private int band;
    private int sub_band;

    private int upperBound;
    private int lowerBound;

    //https://www.ncbi.nlm.nih.gov/genome/gdv/browser/?context=genome&acc=GCF_000001405.39


    /**
     * This creates a physical range of genomes for reference when trying to create safety for users with less technical knowledge of the actual genome ranges.
     *
     * @param chromosome This is the chromosome that we are operating on
     * @param arm        This is the arm the range is on. 'P' is the short arm and "Q' is the long arm.
     * @param region     This is the region of the range. This is the first specification that pinpoints more information.
     * @param band       This is the band. This will be visually seen as black or white when looking at the databases for information.
     * @param sub_band   This sub band is the most specific measurement that we have to pinpoint our operating range. 0 means we have no use for the sub_band.
     * @param lowerBound This is the lower bound of the range.
     * @param upperBound This is the upper bound of the range.
     * @throws GenomeDatabaseError We throw an error for the safety of the user so that we only operate on valid ranges and information.
     */
    public GenomeRanges(int chromosome, char arm, int region, int band, int sub_band, int lowerBound, int upperBound) throws GenomeDatabaseError {
        if (chromosome < 1 || chromosome > 23)
            throw new GenomeDatabaseError(GenomeError.INVALID_CHROMOSOME_NUMBER);
        if (arm != 'p' && arm != 'q')
            throw new GenomeDatabaseError(GenomeError.INVALID_ARM_CHARACTER);
        if (!singleDigit(region) || !singleDigit(band) || !singleDigit(sub_band))
            throw new GenomeDatabaseError(GenomeError.INVALID_NUMBER_LENGTH);

        this.chromosome = chromosome;
        this.arm = arm;
        this.region = region;
        this.band = band;
        this.sub_band = sub_band;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;

    }

    /**
     * Single Digit checker effectively so that we make sure that we only have a single digit for some of our inputs.
     *
     * @param i The input.
     * @return If true then the input is a singular digit.
     */
    @Contract(pure = true)
    public static boolean singleDigit(int i) {
        return !(i % 10 == 0) || i == 0;
    }

    /**
     * Checks if the bounds that we give the information is possible.
     *
     * @param chromosome  The chromosome that we are operating on.
     * @param lowerBound  The lower bound we are testing.
     * @param higherBound The upper bound we are testing.
     * @return If TRUE then the range is possible on the chromosome.
     */
    public boolean isPossible(int chromosome, int lowerBound, int higherBound) {
        return GenomeDatabaseMain.ranges.get(chromosome).get(0).lowerBound >= lowerBound && GenomeDatabaseMain.ranges.get(chromosome).get(GenomeDatabaseMain.ranges.get(chromosome).size() - 1).upperBound <= higherBound;
    }
}
