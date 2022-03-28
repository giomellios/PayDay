package Model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PayTheNeighbor extends MailCard{

	public PayTheNeighbor(int money, String icon, String message, String choice) {
		super(money, icon, message, choice);
	}

	public void action(Player p1,Player p2,MailCard mc,int who) {
		String[] op= {mc.getChoice()};
		JOptionPane.showOptionDialog(null, mc.getMessage(), "Plhrwse ton geitona", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(mc.getIcon()), op,0);	
		if(who==1) {
			p1.setEuros(p1.getEuros()-mc.getMoney());
			p2.setEuros(p2.getEuros()+mc.getMoney());
		}else {
			p1.setEuros(p1.getEuros()+mc.getMoney());
			p2.setEuros(p2.getEuros()-mc.getMoney());
		}
	}
}
