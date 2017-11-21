package test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import main.java.sequence.NumDataSequence;
import main.java.sequence.NumSequenceGenerator;
import main.java.sort.simple.NumSimpleSorter;

public class MainTest {

	@Test public void end2end_SimpleSorter_insert() {
		NumDataSequence seq = NumSequenceGenerator.generateByShuffle(100,0.05);
		NumSimpleSorter.insert(seq);
		assertTrue(seq.isSorted());
	}

	@Test public void end2end_SimpleSorter_gnome() {
		NumDataSequence seq = NumSequenceGenerator.generateByShuffle(100,0.05);
		NumSimpleSorter.gnome(seq);
		assertTrue(seq.isSorted());
	}
}
