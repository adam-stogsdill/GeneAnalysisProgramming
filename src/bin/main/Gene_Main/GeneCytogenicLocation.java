package bin.main.Gene_Main;

import bin.main.ErrorManagement.GENEERROR;
import bin.main.ErrorManagement.GeneCreationError;

public class GeneCytogenicLocation {
    /*
    https://ghr.nlm.nih.gov/primer/howgeneswork/genelocation
     */

    private int chromosome;
    private char arm;
    private int region;
    private int band;
    private int sub_band;


    private GeneCytogenicLocation(int chromosome, char arm, int region, int band) throws GeneCreationError {
        if (chromosome < 1 || chromosome > 23)
            throw new GeneCreationError(GENEERROR.INVALID_CHROMOSOME);
        if (arm != 'p' || arm != 'q')
            throw new GeneCreationError(GENEERROR.INVALID_ARM);
    }


}
