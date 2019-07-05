package bin.main;

import java.util.Arrays;

public class Analytics {

    //Default scoring algorithm
    static int MATCH = 1;                   //Score given to the alignment matrix when the gene name matches
    static int MISMATCH_OR_INDEL = -1;      //Score given to the alignment matrix when the gene name mismatches
                                            //Score given to the alignment matrix when the gene name is the same from that movement


    public static int getHighestScore(int... a){
        Arrays.sort(a); 
        return a[a.length-1];
    }

    public static int score_Algorithm(int top_left, int above, int left, Gene g1, Gene g2, int column, int row){
        int score;
        if (g1.getGene_information()[column-1] == g2.getGene_information()[row-1]) {
            score = MATCH;
        }else
            score = MISMATCH_OR_INDEL;

        System.out.println("Column: " + g1.getGene_information()[column - 1] + " Row: " + g2.getGene_information()[row - 1] + " Index: " + (row-1) + "," + (column-1));
        System.out.println("Row: " + row + " Column: " + column + " "  + (top_left + score) + " " + (above + MISMATCH_OR_INDEL) + " " + (left + MISMATCH_OR_INDEL) + "\n");

        return getHighestScore(top_left + score, above + MISMATCH_OR_INDEL, left + MISMATCH_OR_INDEL);
    }

    public static void N_W_Algorithm(Gene g1, Gene g2){
        int columns = g1.size() + 1;
        int rows = g2.size() + 1;

        //Initializes the Alignment Matrix
        int[][] alignment_Matrix = new int[rows][columns];

        //Initializes the Pointer Matrix
        char[][] pointer_Matrix = new char[rows][columns];

        for(int i = 0; i < columns; i++)
            alignment_Matrix[i][0] = -i;

        for(int i = 0; i < rows; i++)
            alignment_Matrix[0][i] = -i;

        for(int y = 1; y < rows; y++){
            for(int x = 1; x < columns; x++){
                System.out.println("TopLeft: " + alignment_Matrix[y-1][x-1]);
                System.out.println("Above: " + alignment_Matrix[y-1][x]);
                System.out.println("Left: " + alignment_Matrix[y][x-1]);
                alignment_Matrix[y][x] = score_Algorithm(alignment_Matrix[y-1][x-1], alignment_Matrix[y-1][x], alignment_Matrix[y][x-1], g1, g2, x, y);
            }

        }

        for(int y = 0; y < rows; y++){
            for(int x = 0; x < columns; x++) {
                System.out.print(alignment_Matrix[y][x]);
            }
            System.out.println();
        }

    }

}
