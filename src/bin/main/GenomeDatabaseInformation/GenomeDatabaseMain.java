package bin.main.GenomeDatabaseInformation;

import bin.main.ErrorManagement.GenomeDatabaseError;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GenomeDatabaseMain {

    public static HashMap<Integer, ArrayList<GenomeRanges>> ranges = new HashMap<>();

    /*
    Obtaining information from
    https://www.ncbi.nlm.nih.gov/genome/gdv/browser/?context=genome&acc=GCF_000001405.39
    National Center for Biotechnology Information
     */
    public static void LoadDatabase() {
        //TODO FIX LOADING
        try {
            BufferedReader bf = new BufferedReader(new FileReader("resources/GenomeRanges"));
            String string;
            while ((string = bf.readLine()) != null) {
                String[] parsed = string.split(" ");
                if (ranges.containsKey(Integer.valueOf(parsed[0].substring(0, 1))))
                    ranges.get(Integer.valueOf(parsed[0].substring(0, 1))).add(new GenomeRanges(Integer.valueOf(parsed[0].substring(0, 1)), parsed[0].charAt(1), Integer.valueOf(parsed[0].substring(2, 3)), Integer.valueOf(parsed[0].substring(3, 4)), Integer.valueOf(parsed[0].substring(5)), Integer.valueOf(parsed[1]), Integer.valueOf(parsed[2])));
                else {
                    ArrayList<GenomeRanges> enter = new ArrayList<>();
                    enter.add(new GenomeRanges(Integer.valueOf(parsed[0].substring(0, 1)), parsed[0].charAt(1), Integer.valueOf(parsed[0].substring(2, 3)), Integer.valueOf(parsed[0].substring(3, 4)), Integer.valueOf(parsed[0].substring(5)), Integer.valueOf(parsed[1]), Integer.valueOf(parsed[2])));
                    ranges.put(Integer.valueOf(parsed[0].substring(0, 1)), enter);
                }
            }



            /*ranges.add(new GenomeRanges(1, 'p', 3, 6, 3, 1, 7100000));
            ranges.add(new GenomeRanges(1, 'p', 3, 6, 2, 7100001, 15900000));
            ranges.add(new GenomeRanges(1, 'p', 3, 6, 1, 15900001, 27600000));
            ranges.add(new GenomeRanges(1, 'p', 3, 5, 0, 27600001, 34300000));
            ranges.add(new GenomeRanges(1, 'p', 3, 4, 3, 34300001, 39600000));
            ranges.add(new GenomeRanges(1, 'p', 3, 4, 2, 39600001, 43700000));
            ranges.add(new GenomeRanges(1, 'P', 3, 4, 1, 43700001, 46300000));
            ranges.add(new GenomeRanges(1, 'p', 3, 3, 0, 46300001, 50200000));
            ranges.add(new GenomeRanges(1, 'p', 3, 2, 3, 50200000, 55600000));
            ranges.add(new GenomeRanges(1, 'p', 3, 2, 2, 55600001, 58500000));
            ranges.add(new GenomeRanges(1, 'p', 3, 2, 1, 58500001, 60800000));
            ranges.add(new GenomeRanges(1, 'p', 3, 1, 3, 60800001, 68500000));
            ranges.add(new GenomeRanges(1, 'p', 3, 1, 2, 68500001, 69300000));
            ranges.add(new GenomeRanges(1, 'p', 3, 1, 1, 69300001, 84400000));
            ranges.add(new GenomeRanges(1, 'p', 2, 2, 3, 84000001, 87900000));
            ranges.add(new GenomeRanges(1, 'p', 2, 2, 2, 87900001, 91500000));
            ranges.add(new GenomeRanges(1, 'p', 2, 2, 1, 91500001, 94300000));
            ranges.add(new GenomeRanges(1, 'p', 2, 1, 0, 94300001, 106700000));
            ranges.add(new GenomeRanges(1, 'p', 1, 3, 3, 106700001, 111200000));
            ranges.add(new GenomeRanges(1, 'p', 1, 3, 1, 111200001, 115500000));
            ranges.add(new GenomeRanges(1, ''))*/


        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GenomeDatabaseError genomeDatabaseError) {
            genomeDatabaseError.printStackTrace();
        }
    }


}
