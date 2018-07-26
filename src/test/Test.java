package test;

public class Test {
	private double value1 = 0.0;
	private double value2 = 0.0;
	private double result;
	
	public void countVal1TimesVal2() {
		result = value1*value2;
		System.out.println("wynikiem mno¿enia jest: " + result);
	}
	
	public void countVal1PlusVal2() {
		result = value1+value2;
		System.out.println("wynikiem dodawania jest: " + result);
	}

	public double getResult() {
		return result;
	}

	public double getValue1() {
		return value1;
	}

	public void setValue1(double value1) {
		this.value1 = value1;
	}

	public double getValue2() {
		return value2;
	}

	public void setValue2(double value2) {
		this.value2 = value2;
	}
	
	
}
