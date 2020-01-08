package test.java.sequence;

import static org.junit.Assert.*;

import main.java.data.NumData;
import main.java.sequence.NumDataSequence;
import main.java.sequence.NumSequenceGenerator;
import main.java.sort.simple.NumSimpleSorter;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NumDataSequenceTest {

    @Test public void unit_NumDataSequence_swapIfNeeded() {
        NumData[] arr = new NumData[3];
        arr[0] = new NumData(2);
        arr[1] = new NumData(1);
        NumDataSequence seq = new NumDataSequence(arr);

        seq.swapIfNeeded(0, 1);
        assertTrue(seq.get(0).value() == 1 && seq.get(1).value() == 2);
        seq.swapIfNeeded(0, 1);
        assertTrue(seq.get(0).value() == 1 && seq.get(1).value() == 2);

        arr[0] = new NumData(1000);
        arr[1] = new NumData(10000);
        arr[2] = new NumData(100);
        seq = new NumDataSequence(arr);

        seq.swapIfNeeded(1, 2);
        assertTrue(seq.get(0).value() == 1000 && seq.get(1).value() == 100 && seq.get(2).value() == 10000);
    }

    @Test public void unit_NumDataSequence_orderByLower()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        NumData[] arr = new NumData[3];
        arr[0] = new NumData(2);
        arr[1] = new NumData(1);
        NumDataSequence seq = new NumDataSequence(arr);

        Method method = seq.getClass().getDeclaredMethod("orderByLower", int.class, int.class);
        method.setAccessible(true);
        boolean actual = (boolean)method.invoke(seq, 0, 1);
        assertEquals(false, actual);

        arr[0] = new NumData(1000);
        arr[1] = new NumData(100);
        arr[2] = new NumData(10000);
        seq = new NumDataSequence(arr);

        actual = (boolean)method.invoke(seq, 1, 2);

        assertEquals(true, actual);
    }
}
