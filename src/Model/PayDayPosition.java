package Model;

import javax.swing.JOptionPane;

public class PayDayPosition extends Position{

	public PayDayPosition(int num, String day, String icon) {
		super(num, day, icon);
	}
	public String getIcon() {
		return this.icon;
	}
	
	public void performAction(Player p1,int diceNumber) {
		if(p1.getBills()>0) {
			JOptionPane.showMessageDialog(null, "You have to pay your bills. Money will automatically be taken by tax authorities");
			p1.setEuros(p1.getEuros()-p1.getBills());
			p1.setBills(0);
		}
		int n;
		double fee=p1.getLoan()*0.1;
		if(p1.getLoan()>0) {
			do {
				n=Integer.parseInt(JOptionPane.showInputDialog("You have to pay your loan, how much of your loan do you want to pay?(This process wont complete if you don't enter a multiple of 1000"));
			}while(n>p1.getLoan()|| p1.getLoan()%1000!=0 );
			p1.setEuros(p1.getEuros()-n-(int)fee);
			p1.setLoan(p1.getLoan()-n);
		}
		p1.setEuros(p1.getEuros() + 3500);
		JOptionPane.showMessageDialog(null, "You get paid 3500 euros in PayDay Position");
		p1.setPawnPos(0);
		p1.setMonth(p1.getMonth() + 1);
		
	}
}
