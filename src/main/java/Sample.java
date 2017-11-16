package main.java;

public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
        System.out.println("hello, wolrd" + sample.returnOneValue());
    }

	public int returnOneValue() {
		return 1;
	}
}
