package bin.main;

import bin.main.GUI.Window;
import bin.main.pattern_analysis.Pattern_Statistics;

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

        j.setVisible(true);


        Gene g = new Gene("RACTA");

        //Analytics.N_W_Algorithm(new Gene("GATC"), new Gene("TTACT"));
        Gene g1 = new Gene(GeneCreation.randomGene(100));
        Pattern_Statistics unrestricted_size = new Pattern_Statistics(g1);
        //System.out.println(unrestricted_size.toString());
    }

}
