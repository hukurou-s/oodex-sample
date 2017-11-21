package main.java;

import main.java.out.NumDataOutput;
import main.java.sequence.NumDataSequence;
import main.java.sequence.NumSequenceGenerator;
import main.java.sort.algo.NumQuickSorter;

public class Main {
    public static void main(String args[]) {
        NumDataSequence seq = NumSequenceGenerator.generateByShuffle(100, 0.05);
        NumQuickSorter.sort(seq);
        NumDataOutput.puts(seq);
    }
}
