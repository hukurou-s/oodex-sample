package main.java.sort.algo;

import main.java.data.ComparedState;
import main.java.data.NumData;
import main.java.sequence.NumDataSequence;
import main.java.sort.simple.NumSimpleSorter;

import java.util.ArrayList;

public class NumMergeSorter {

    public static void sort(final NumDataSequence seq) {
        NumMergeSorter sorter = new NumMergeSorter();
        sorter.mergeSort(seq);
    }

    private NumDataSequence mergeSort(final NumDataSequence seq) {
        if (seq.size() <= 1) return seq;
        int middle = seq.size() / 2;

        NumDataSequence left = seq.slice(0, middle - 1);
        NumDataSequence right = seq.slice(middle, seq.size());

        left = this.mergeSort(left);
        right = this.mergeSort(right);

        return merge(left, right);
    }

    private NumDataSequence merge(final NumDataSequence left, final NumDataSequence right) {
        ArrayList<NumData> dataSet = new ArrayList<NumData>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            ComparedState c = left.get(leftIndex).compare(right.get(rightIndex));
            if (c == ComparedState.EQ || c == ComparedState.LT) {
                dataSet.add(left.get(leftIndex));
                leftIndex++;
            } else {
                dataSet.add(right.get(leftIndex));
                rightIndex++;
            }

        }
        NumData[] numData = new NumData[dataSet.size()];
        return new NumDataSequence(dataSet.toArray(numData));
    }
}
