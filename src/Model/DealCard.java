package Model;

public class DealCard extends Card implements CardInterface{

	//kostos agoras kai pwlhshs
	public DealCard(){
		System.out.println(super.dealCards[1][2]);//swsto
	}

	public void action() {
		System.out.println();
	}

	public int money_of_the_card() {
		
		return 0;
	}
}


