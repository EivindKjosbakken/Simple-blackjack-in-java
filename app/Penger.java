package app;

public class Penger {
	
	private int penger;
	
	public Penger(int penger) {
		this.penger = penger;
		
		//kan legge til funksjon for hvor mye som skal startes med
	}
	
	
	public int getPenger() {
		return penger;
	}
	
	public String getPengerString() {
		return ""+penger;
	}


	public void setPenger(int penger) {
		this.penger = penger;
	}
	

	
	public void bet(int betSize) {
		penger -= betSize;
	}
	
	
	public void win(int betSize) {
		penger+= betSize;
	}
	
	public void loose(int betSize) {
		penger-= betSize;
	}
	

}
