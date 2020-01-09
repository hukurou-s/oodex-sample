package test.java.sequence;

import static org.junit.Assert.*;

import main.java.sequence.NumDataSequence;
import main.java.sequence.NumSequenceGenerator;
import org.junit.Test;

public class NumSequenceGeneratorTest {
    @Test public void unit_NumSequenceGenerator_generateOfSorted() {
        int size = 10;
        int k;
        boolean flag = false;

        NumDataSequence seq = NumSequenceGenerator.generateOfSorted(size);
        // sizeの確認
        assertEquals(size, seq.length());

        // sizeが1以下の配列のsort済みかどうかの確認
        if ( seq.length() <= 1 ) {
            flag = true;
        }

        // sizeが2以上の配列のsort済みかどうかの確認
        for ( k = 1; k < seq.length(); k++ ) {
            if ( seq.get(k-1).value() > seq.get(k).value() ) {
                flag = false;
                break;
            }
            flag = true;
        }
        assertTrue(flag);
    }
}
