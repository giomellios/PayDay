package Model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Charity extends MailCard{

	public Charity(int money, String icon, String message, String choice) {
		super(money, icon, message, choice);
	}
	

	public void action(Player p,MailCard mc,Jackpot j) {
		System.out.println("MPIKA CHARITY");
		String[] op= {mc.getChoice()};
		JOptionPane.showOptionDialog(null, mc.getMessage(), "Filanthrwpia", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(mc.getIcon()), op,0);
		p.setEuros(p.getEuros()-mc.getMoney());
		j.setAvailableEuro(j.getAvailableEuro()+mc.getMoney());
	}
}
