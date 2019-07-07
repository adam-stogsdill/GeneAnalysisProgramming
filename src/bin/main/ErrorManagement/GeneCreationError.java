package bin.main.ErrorManagement;

public class GeneCreationError extends Exception {

    private int error_id = -1;
    private GENEERROR error;

    public GeneCreationError(GENEERROR error) {
        this.error = error;
        switch (error) {
            case INVALID_CHARACTER:
                error_id = 5;
                break;
        }
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.print("GENE CREATION ERROR: " + this.error);
        System.exit(-1);
    }
}
