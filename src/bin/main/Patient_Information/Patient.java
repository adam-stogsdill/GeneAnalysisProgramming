package bin.main.Patient_Information;

import bin.main.Gene_Main.ChromosomeData;
import bin.main.Gene_Main.Gene;
import bin.main.Gene_Main.GeneDatabase;

import java.util.Arrays;

/**
 * Storage of patient data, including their name and chromosome data.
 */
public class Patient {
    private String patient_name;
    private ChromosomeData patient_data;

    /**
     * Creates a patient with a given name and chromosome data.
     * @param name The name of the patient.
     * @param patient_data The chromosome data, including the chromosome and gene located.
     */
    public Patient(String name, ChromosomeData patient_data) {
        this.patient_name = name;
        this.patient_data = patient_data;
    }

    /**
     * Locates mutations within a given patient's data.
     *
     * Determines the mutation location and the gene name.
     */
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

    /**
     * Retrieves the patient name.
     * @return The patient's name.
     */
    public String getPatient_name() {return this.patient_name;}

    /**
     * Retrieves the patient data.
     * @return The patient's data.
     */
    public ChromosomeData getPatient_data(){return this.patient_data;}
}
