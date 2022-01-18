package Model;

public class PayDayPosition extends Position{

	public PayDayPosition(int num, String day, String icon) {
		super(num, day, icon);
	}
	public String getIcon() {
		return this.icon;
	}
}
