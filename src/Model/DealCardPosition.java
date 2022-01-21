package Model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import View.View;

public class DealCardPosition extends Position{

	public DealCardPosition(int num, String day, String icon) {
		super(num, day, icon);
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
			//isws kanw gia to loan edw
		}else if(a==1){
			JOptionPane.showMessageDialog(null, "OK, agnohses thn karta symfwnias", "Karta Symfwnias", JOptionPane.INFORMATION_MESSAGE, i);
		}
	}
}
