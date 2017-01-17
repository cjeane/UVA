/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10142;

import java.io.*;

/**
 *
 * @author Cory
 */
public class Q10142 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(input.readLine());
        int numCandidates, numVoters;
        int[][] votes;
        String[] arrCandidates;
        String inputBuffer;
        String[] lineVote;
        
        input.readLine();
        for (int i = 1; i <= testCases; i++) {
            numCandidates = Integer.parseInt(input.readLine());
            arrCandidates = new String[numCandidates];
            for (int i2 = 0; i2 < numCandidates; i2++) {
                arrCandidates[i2] = input.readLine();
            }
            votes = new int[1000][numCandidates];
            numVoters = 0;
            while ((inputBuffer = input.readLine()) != null
                    && !inputBuffer.equals("")) {
                lineVote = inputBuffer.split(" ");
                for (int i3 = 0; i3 < numCandidates; i3++) {
                    votes[numVoters][i3] = Integer.parseInt(lineVote[i3]);
                }
                numVoters++;
            }
            
        }
    }

}
