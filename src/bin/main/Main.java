package bin.main;

import bin.main.GUI.Window;
import bin.main.Gene_Main.Gene;
import bin.main.Gene_Main.GeneCreation;
import bin.main.GenomeDatabaseInformation.GenomeDatabaseMain;
import bin.main.ThreadManagement.ThreadManager;
import bin.main.pattern_analysis.PatternStatistics;

import javax.swing.*;

public class Main {

    private static int WIDTH = 700;
    private static int HEIGHT = 500;


    public static void main(String[] args) {
        JFrame j = new JFrame("Gene Ally");
        Window w = new Window(WIDTH, HEIGHT);

        j.setSize(WIDTH, HEIGHT);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setResizable(false);
        j.add(w);

        ThreadManager threadManager = new ThreadManager(w);

        j.setVisible(true);

        GenomeDatabaseMain.LoadDatabase();

        //Gene g = new Gene("RACTA");

        //Analytics.N_W_Algorithm(new Gene("GATC"), new Gene("TTACT"));
        //Gene g1 = new Gene(GeneCreation.randomGene(100));
        //PatternStatistics unrestricted_size = new PatternStatistics(g1);
        //System.out.println(unrestricted_size.toString());
    }

}
