package bin.main;

public class Analytics {

    //Default scoring algorithm
    int MATCH = 1;        //Score given to the alignment matrix when the gene name matches
    int MISMATCH = -1;    //Score given to the alignment matrix when the gene name mismatches
    int INDEL = -1;       //Score given to the alignment matrix when the gene name is the same from that movement


    public int score_Algorithm(int top_right, int above, int left, Gene g1, Gene g2, int column, int row){


        return -255;
    }

    public void N_W_Algorithm(Gene g1, Gene g2){
        int columns = g1.size() + 1;
        int rows = g2.size() + 1;

        //Initializes the Alignment Matrix
        int[][] alightment_Matrix = new int[columns][rows];

        //Initializes the Pointer Matrix
        char[][] pointer_Matrix = new char[columns][rows];

        for(int i = 0; i < columns; i++)
            alightment_Matrix[i][0] = -i;

        for(int i = 0; i < rows; i++)
            alightment_Matrix[0][i] = -i;

        for(int y = 0; y < rows; y++){
            for(int x = 0; x < columns; x++){

            }
        }

    }

}
