package Model;

/* ALLAGH TO JACKPOT DEN EINAI POSITION*/
public class Jackpot extends Board {

	private int available_euro;
	public Jackpot() {
		this.available_euro=1000;
	}

	public int getAvailableEuro() {
		return this.available_euro;
	}
	
	public void setAvailableEuro(int av) {
		this.available_euro=av;
	}

}
