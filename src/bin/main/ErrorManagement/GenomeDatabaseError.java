package bin.main.ErrorManagement;


public class GenomeDatabaseError extends Exception {

    private GenomeErrorType error;

    public GenomeDatabaseError(GenomeErrorType error) {
        this.error = error;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println("ERROR {" + this.error + "}");
        System.exit(-1);
    }
}

