package app;

public class Telle {
	
	public int i = 0;
	public double value = 100;
	
	public void counter() {
		while (i<200) {
			i++;
			value = value*1.1;
			System.out.println(i +"-"+ value);
		}
		
	}
	@Override
	public String toString() {
		return ""+value;
	}
	
	public static void main(String[] args) {
		Telle verdi = new Telle();
		verdi.counter();
		System.out.println(verdi);
	}

}
