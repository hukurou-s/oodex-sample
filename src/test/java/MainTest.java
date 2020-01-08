package test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import main.java.sequence.NumDataSequence;
import main.java.sequence.NumSequenceGenerator;
import main.java.sort.simple.NumSimpleSorter;

public class MainTest {

	@Test public void end2end_SimpleSorter_insert() {
		NumDataSequence seq = NumSequenceGenerator.generateByShuffle(100,0.5);
		NumSimpleSorter.insert(seq);
		assertTrue(seq.isSorted());
	}

	@Test public void end2end_SimpleSorter_gnome() {
		NumDataSequence seq = NumSequenceGenerator.generateByShuffle(100,0.5);
		NumSimpleSorter.gnome(seq);
		assertTrue(seq.isSorted());
	}

	@Test public void end2end_SimpleSorter_select() {
		NumDataSequence seq = NumSequenceGenerator.generateByShuffle(100,0.5);
		NumSimpleSorter.select(seq);
		assertTrue(seq.isSorted());
	}

	@Test public void end2end_SimpleSorter_shaker() {
		NumDataSequence seq = NumSequenceGenerator.generateByShuffle(100,0.5);
		NumSimpleSorter.shaker(seq);
		assertTrue(seq.isSorted());
	}

	@Test public void end2end_SimpleSorter_trans() {
		NumDataSequence seq = NumSequenceGenerator.generateByShuffle(100,0.5);
		NumSimpleSorter.trans(seq);
		assertTrue(seq.isSorted());
	}
}
