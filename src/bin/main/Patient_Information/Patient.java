package bin.main.Patient_Information;

import bin.main.Gene_Main.ChromosomeData;
import bin.main.Gene_Main.Gene;
import bin.main.Gene_Main.GeneDatabase;

import java.util.Arrays;

public class Patient {
    private String patient_name;
    private ChromosomeData patient_data;

    public Patient(String name, ChromosomeData patient_data) {
        this.patient_name = name;
        this.patient_data = patient_data;
    }

    public void Mutations(){
        for(Integer observing_chromosome: this.patient_data.getChromosome_information().keySet()){
            System.out.println("Observing: " + observing_chromosome + " chromosome");
            for(Gene nonmutated_gene: GeneDatabase.nonMutatedGenome.get(observing_chromosome)){
                int start = nonmutated_gene.getCytogenicLocation().getStart() - 1;
                int stop = nonmutated_gene.getCytogenicLocation().getStop() - 1;
                char[] gene_info = Arrays.copyOfRange(this.patient_data.getChromosome_information().get(observing_chromosome).getGene_information(), start, stop);
                if (!Arrays.equals(nonmutated_gene.getGene_information(), gene_info)){
                    System.out.println("Mutation Located at (" + nonmutated_gene.getCytogenicLocation().toString() + ") which is the (" + nonmutated_gene.getName() + ") gene.");
                }
            }
        }

    }

    public String getPatient_name() {return this.patient_name;}
    public ChromosomeData getPatient_data(){return this.patient_data;}
}
