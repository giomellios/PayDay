package Model;

public class DealCard extends Card implements CardInterface{

	
	private int cost,value;
	private String message,icon;
	public DealCard(int cost,int value,String message,String icon){
		this.cost=cost;
		this.value=value;
		this.message=message;
		this.icon=icon;
	}
	public int getCost() {
		return this.cost;
	}
	public int getValue() {
		return this.value;
	}
	public String getMessage() {
		return this.message;
	}
	public String getIcon() {
		return this.icon;
	}
	
	public void action() {
		
	}

	public int money_of_the_card() {
		
		return 0;
	}
}


