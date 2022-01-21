package Model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Advertisement extends MailCard{

	public Advertisement(int money, String icon, String message,String choice) {
		super(money, icon, message,choice);
	}

	public void action(Player p1,Player p2,MailCard mc,int who) {
		String[] op= {mc.getChoice()};
		JOptionPane.showOptionDialog(null, mc.getMessage(), "Diafhmish", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(mc.getIcon()), op,0);
		if(who==1) {
			p1.setEuros(p1.getEuros()+mc.getMoney());
			System.out.println("LEFTA POU EXW"+p1.getEuros());
		}else {
			p2.setEuros(p2.getEuros()+mc.getMoney());
			System.out.println("LEFTA POU EXW"+p1.getEuros());
		}
	}
}
