package test.java.data;

import static org.junit.Assert.*;

import main.java.data.ComparedState;
import main.java.data.NumData;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NumDataTest {
    @Test public void unit_NumData_constructor() throws NoSuchFieldException, IllegalAccessException {
        int expect = 0;
        NumData data = new NumData(expect);
        Field field =  data.getClass().getDeclaredField("raw");
        field.setAccessible(true);

        int actual = (int)field.get(data);
        assertEquals(expect, actual);
    }

    @Test public void unit_NumData_value()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException
    {
        int hoge = 0;  // なんでもいい
        int expect = 1;
        NumData data = new NumData(hoge);

        Field field =  data.getClass().getDeclaredField("raw");
        field.setAccessible(true);
        field.set(data, expect);

        Method method = data.getClass().getDeclaredMethod("value");
        method.setAccessible(true);

        int actual = (int)method.invoke(data);

        assertEquals(expect, actual);

        expect = 2;
        field.set(data, expect);
        actual = (int)method.invoke(data);

        assertEquals(expect, actual);
    }

    @Test public void unit_NumData_compare() {
        NumData smallData = new NumData(1);
        NumData bigData = new NumData(10000);
        ComparedState expect;
        ComparedState actual;

        expect = ComparedState.GT;
        actual = bigData.compare(smallData);
        assertEquals(expect, actual);

        expect = ComparedState.LT;
        actual = smallData.compare(bigData);
        assertEquals(expect, actual);

        NumData sameData = new NumData(smallData.value());
        expect = ComparedState.EQ;
        actual = smallData.compare(sameData);
        assertEquals(expect, actual);
    }
}
