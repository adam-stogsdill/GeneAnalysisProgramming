package bin.main;

import bin.main.ErrorManagement.GeneCreationError;
import bin.main.Gene_Main.ChromosomeData;
import bin.main.Gene_Main.GeneCreation;
import bin.main.Gene_Main.GeneDatabase;
import bin.main.Patient_Information.Patient;

import java.io.IOException;

public class Main {

    private static int WIDTH = 700;
    private static int HEIGHT = 500;


    public static void main(String[] args) {
        /*JFrame j = new JFrame("Gene Ally");
        Window w = new Window(WIDTH, HEIGHT);

        j.setSize(WIDTH, HEIGHT);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setResizable(false);
        j.add(w);

        ThreadManager threadManager = new ThreadManager(w);

        j.setVisible(true);*/

        //GenomeDatabaseMain.LoadDatabase();

        //Gene g = new Gene("RACTA");

        //Analytics.N_W_Algorithm(new Gene("GATC"), new Gene("TTACT"));
        try{
            GeneDatabase.LoadDatabase();
        }catch(IOException | GeneCreationError e){
            e.printStackTrace();
        }
        GeneDatabase.printDatabase();


        ChromosomeData t_data = new ChromosomeData(2, GeneCreation.randomGene(215138626 + 215138626));
        Patient Tolmain = new Patient("Tolmain", t_data);
        Tolmain.Mutations();

        //PatternStatistics unrestricted_size = new PatternStatistics(g1);
        //System.out.println(unrestricted_size.toString());
    }

}
