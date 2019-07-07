package bin.main.GenomeDatabaseInformation;

import bin.main.ErrorManagement.GenomeDatabaseError;

import java.util.ArrayList;

public class GenomeDatabaseMain {

    private static ArrayList<GenomeRanges> ranges = new ArrayList<>();


    public static void LoadDatabase() {
        try {
            ranges.add(new GenomeRanges(1, 'p', 36, 3, 7100000, 1));
        } catch (GenomeDatabaseError genomeDatabaseError) {
            genomeDatabaseError.printStackTrace();
        }
    }

    public static void isRangePossible() {

    }
}
