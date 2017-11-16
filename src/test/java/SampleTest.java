package test.java;

import static org.junit.Assert.*;
import org.junit.Test;

import main.java.Sample;

public class SampleTest {

	@Test
	public void test1() throws Exception {
	}

	@Test
	public void test2() {
		Sample sample = new Sample();
		assertEquals("aaa", 1, sample.returnOneValue());
	}
}
