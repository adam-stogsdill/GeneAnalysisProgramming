package bin.main.Patient_Information;

import bin.main.Gene_Main.ChromosomeData;

public class Patient {
    private String patient_name;
    private ChromosomeData patient_data;

    public Patient(String name, ChromosomeData patient_data) {
        this.patient_name = name;
        this.patient_data = patient_data;
    }

    public void Mutations(){


    }

    public String getPatient_name() {return this.patient_name;}
    public ChromosomeData getPatient_data(){return this.patient_data;}
}
