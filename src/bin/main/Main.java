package bin.main;

import bin.main.ErrorManagement.GeneCreationError;
import bin.main.Gene_Main.ChromosomeData;
import bin.main.Gene_Main.GeneCreation;
import bin.main.Gene_Main.GeneDatabase;
import bin.main.Patient_Information.Patient;

import javax.swing.*;
import java.io.IOException;

import static bin.main.Gene_Main.GeneDatabase.printDatabase;
import static bin.main.pattern_analysis.Analytics.Mutations;

public class Main {


    // DEFAULT WIDTH AND HEIGHT
    private static int WIDTH = 700;
    private static int HEIGHT = 500;


    public static void main(String[] args) {
        JFrame j = new JFrame("Gene Ally");
        try{
            GeneDatabase.LoadDatabase();
        }catch(IOException | GeneCreationError e){
            e.printStackTrace();
        }
        printDatabase();

        ChromosomeData t_data = new ChromosomeData(2, GeneCreation.randomGene(215138626 + 215138626));
        Patient Tolmain = new Patient("Tolmain", t_data);
        Mutations(Tolmain, 1);


        //PatternStatistics unrestricted_size = new PatternStatistics(g1);
        //System.out.println(unrestricted_size.toString());
    }

}
