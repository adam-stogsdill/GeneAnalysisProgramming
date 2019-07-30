package bin.main.Gene_Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GeneFileReader {
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
