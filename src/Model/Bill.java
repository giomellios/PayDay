package Model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bill extends MailCard{

	public Bill(int money, String icon, String message, String choice) {
		super(money, icon, message, choice);
	}

	public void action(Player p1,Player p2,MailCard mc,int who) {
		System.out.println("MPIKA bill");
		String[] yesno= {"Nai","Oxi"};
		int a=JOptionPane.showOptionDialog(null, mc.getMessage()+"\nThes na plhrwseis twra ta lefta? (an oxi tha prosthethoun stous logariasmous sou", "Plhrwse ton geitona", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(mc.getIcon()), yesno, 0);
		
		if(a==0) {
			if(who==1) {
				p1.setEuros(p1.getEuros()-mc.getMoney());
			}else {
				p2.setEuros(p2.getEuros()-mc.getMoney());
				//p2.setBills(p2.getBills()+mc.getMoney());
			}
		}else {
			if(who==1)
				p1.setBills(p1.getBills()+mc.getMoney());
			else
				p2.setBills(p2.getBills()+mc.getMoney());
		}
	}
}
