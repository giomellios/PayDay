package Model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class YardSale extends DicePosition{

	public YardSale(int num, String day, String icon) {
		super(num, day, icon);
	}
	public String getIcon() {
		return this.icon;
	}
	public void performAction(Player p,int diceNumber) {
		p.setEuros(p.getEuros()-100*diceNumber);
		p.checkLoan(p.getEuros(), p);
	}
	
	public void performAction(Player p,DealCard dc) {
		String[] options= {"Agorase th symfwnia","Agnohse th symfwnia"};
		ImageIcon i=new ImageIcon(dc.getIcon());
		int a=JOptionPane.showOptionDialog(null,
				dc.getMessage()+"\n"+"Timh agoras: "+dc.getCost()+" Euro\n"+"Timh pwlhshs: "+dc.getValue()+" Euro",
				"Karta Symfwnias",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				i, 
				options, 
				0);
		if(a==0) {
			p.setDealCards(p.getDealCards()+1);
			p.getDeal().add(dc);
			p.setEuros(p.getEuros()-dc.getCost());
			p.checkLoan(p.getEuros(), p);
		}else if(a==1){
			JOptionPane.showMessageDialog(null, "OK, agnohses thn karta symfwnias", "Karta Symfwnias", JOptionPane.INFORMATION_MESSAGE, i);
		}
	}
}
