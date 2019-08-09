package bin.main.Gene_Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads the gene from a given file.
 */
public class GeneFileReader {
    /**
     * Reads the gene from a given file
     * @param f The string of the file name.
     * @return A string of the gene sequence from the file.
     * @throws IOException Thrown if the file cannot be found or read.
     */
    public static String getInformation(String f) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(f));
        String result = "";
        String s;
        while ((s = bf.readLine()) != null) {
            result += s;
        }
        //System.out.println(result);
        return result;
    }
}
