package bin.main.GenomeDatabaseInformation;

import bin.main.ErrorManagement.GenomeDatabaseError;

import java.util.ArrayList;

public class GenomeDatabaseMain {

    private static ArrayList<GenomeRanges> ranges = new ArrayList<>();

    /*
    Obtaining information from
    https://www.ncbi.nlm.nih.gov/genome/gdv/browser/?context=genome&acc=GCF_000001405.39
    National Center for Biotechnology Information
     */
    public static void LoadDatabase() {
        try {
            ranges.add(new GenomeRanges(1, 'p', 3, 6, 3, 1, 7100000));
            ranges.add(new GenomeRanges(1, 'p', 3, 6, 2, 7100001, 15900000));
            ranges.add(new GenomeRanges(1, 'p', 3, 6, 1, 15900001, 27600000));
            ranges.add(new GenomeRanges())
        } catch (GenomeDatabaseError genomeDatabaseError) {
            genomeDatabaseError.printStackTrace();
        }
    }

    public static void isRangePossible() {

    }
}
